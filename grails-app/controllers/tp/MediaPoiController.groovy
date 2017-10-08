package tp

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@SuppressWarnings('LineLength')
class MediaPoiController {

    static allowedMethods = [
            save: 'POST',
            update: 'PUT',
            uploadFeaturedImage: 'POST',
            delete: 'DELETE',
    ]

    def UploadMediaPoiService

    def MediaPoiService

    // tag::index[]
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def (l, total) = MediaPoiService.list(params)
        respond l, model:[mediaPoiCount: total]
    }
    // end::index[]

    // tag::editFeaturedImage[]
    @Transactional(readOnly = true)
    def editFeaturedImage(MediaPoi mediaPoi) {
        respond mediaPoi
    }
    // end::editFeaturedImage[]

    // tag::show[]
    @Transactional(readOnly = true)
    def show(MediaPoi mediaPoi) {

        respond mediaPoi
    }
    // end::show[]

    // tag::create[]
    @SuppressWarnings(['GrailsMassAssignment', 'FactoryMethodName'])

    def create() {
        respond new MediaPoi(params)
    }
    // end::create[]

    // tag::edit[]
    @Transactional(readOnly = true)
    def edit(MediaPoi mediaPoi) {
        respond mediaPoi
    }
    // end::edit[]

    // tag::uploadFeaturedImage[]
    def uploadFeaturedImage(FeaturedImageCommand cmd) {

        if (cmd.hasErrors()) {
            respond(cmd, model: [mediaPoiCount: cmd], view: 'editFeaturedImage')
            return
        }

        def mediaPoi = UploadMediaPoiService.uploadFeatureImage(cmd)
        if (mediaPoi == null) {
            notFound()
            return
        }

        if (mediaPoi.hasErrors()) {
            respond(pointOfInterest, model: [mediaPoi: mediaPoi], view: 'editFeaturedImage')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mediaPoi.label', default: 'Point of Interest'), mediaPoi.id])
                redirect mediaPoi
            }
            '*' { respond mediaPoi, [status: OK] }
        }
    }
    // end::uploadFeaturedImage[]

    // tag::save[]
    def save(NameCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, model: [mediaPoi: cmd], view: 'create'
            return
        }

        def mediaPoi = MediaPoiService.save(cmd)

        if (mediaPoi == null) {
            notFound()
            return
        }

        if (mediaPoi.hasErrors()) {
            respond mediaPoi.errors, model: [mediaPoi: mediaPoi], view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mediaPoi.label', default: 'mediaPoi'), mediaPoi.id])
                redirect mediaPoi
            }
            '*' { respond mediaPoi, [status: CREATED] }
        }
    }
    // end::save[]

    // tag::update[]
    def update(NameUpdateCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, model: [mediaPoi: cmd], view:'edit'
            return
        }

        def mediaPoi = MediaPoiService.update(cmd)
        if ( !mediaPoi ) {
            notFound()
            return
        }
        if (mediaPoi.hasErrors()) {
            respond mediaPoi, model: [mediaPoi: mediaPoi], view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mediaPoi.label', default: 'mediaPoi'), mediaPoi.id])
                redirect mediaPoi
            }
            '*' { respond mediaPoi, [status: OK] }
        }
    }
    // end::update[]

    // tag::delete[]
    def delete() {
        Long mediaPoiId = params.long('id')
        if ( mediaPoiId == null) {
            notFound()
            return
        }

        MediaPoiService.deleteById(mediaPoiId)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mediaPoi.label', default: 'mediaPoi'), mediaPoiId])
                redirect action: 'index', method: 'GET'
            }
            '*' { render status: NO_CONTENT }
        }
    }
    // end::delete[]

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mediaPoi.label', default: 'mediaPoi'), params.id])
                redirect action: 'index', method: 'GET'
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
