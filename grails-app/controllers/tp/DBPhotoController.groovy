package tp


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DBPhotoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DBPhoto.list(params), model:[DBPhotoInstanceCount: DBPhoto.count()]
    }


    def show(DBPhoto DBPhotoInstance) {
        [DBPhotoInstance: DBPhotoInstance]
    }


    def showPayload(DBPhoto DBPhotoInstance) {
        response.outputStream << DBPhotoInstance.payload // write the image to the output stream
        response.outputStream.flush()
    }


    def create() {
        respond new DBPhoto(params)
    }



    @Transactional
    def save(DBPhoto DBPhotoInstance) {

        if (DBPhotoInstance == null) {
            notFound()
            return
        }

        def uploadedFile = request.getFile('payload')
        DBPhotoInstance.payload = uploadedFile.getBytes() //converting the file to bytes
        DBPhotoInstance.name = uploadedFile.originalFilename //getting the file name from the uploaded file
        DBPhotoInstance.type = uploadedFile.contentType//getting and storing the file type
        DBPhotoInstance.save flush:true //Create the record in DB by sending the needed Select command
        redirect(action: "index")
    }



    def edit(DBPhoto DBPhotoInstance) {
        respond DBPhotoInstance
    }


    def update(DBPhoto DBPhotoInstance) {

        if (DBPhotoInstance == null) {
            notFound()
            return
        }

        def uploadedFile = request.getFile('payload')

        if (uploadedFile.empty){//If File was not defined/updated
            notFound()
            return
        }
        else
            DBPhotoInstance.name = uploadedFile.originalFilename //getting the file name from the uploaded file
        DBPhotoInstance.type = uploadedFile.contentType//getting and storing the file type
        DBPhotoInstance.payload = uploadedFile.getBytes()
        DBPhotoInstance.save(flush: true)

        redirect(action: "index")
    }


    @Transactional
    def delete(DBPhoto DBPhotoInstance) {
        if (DBPhotoInstance == null) {
            notFound()
            return
        }

        DBPhotoInstance.delete(flush: true) //flush:true �>flushes the persistence context, persisting the object immediately
        redirect(action: "index")
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'DBPhoto.label', default: 'DBPhoto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
