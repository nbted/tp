package tp

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PoiController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Poi.list(params), model:[poiCount: Poi.count()]
    }

    def show(Poi poi) {
        respond poi
    }

    @Secured(['ROLE_ADMIN','ROLE_ANNOUNCER'])
    def create() {
        respond new Poi(params)
    }

    @Transactional
    @Secured(['ROLE_ADMIN','ROLE_ANNOUNCER'])
    def save(Poi poi) {
        if (poi == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (poi.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond poi.errors, view:'create'
            return
        }

        poi.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'poi.label', default: 'Poi'), poi.id])
                redirect poi
            }
            '*' { respond poi, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN','ROLE_ANNOUNCER'])
    def edit(Poi poi) {
        respond poi
    }

    @Transactional
    @Secured(['ROLE_ADMIN','ROLE_ANNOUNCER'])
    def update(Poi poi) {
        if (poi == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (poi.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond poi.errors, view:'edit'
            return
        }

        poi.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'poi.label', default: 'Poi'), poi.id])
                redirect poi
            }
            '*'{ respond poi, [status: OK] }
        }
    }

    @Transactional
    @Secured(['ROLE_ADMIN','ROLE_ANNOUNCER'])
    def delete(Poi poief) {

        if (poief == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }




        GroupePoi.findAll().each {groupePoi->
            if (groupePoi.poi.contains(poief)){
                groupePoi.removeFromPoi(poief)
                groupePoi.save(flush : true , failOnError: true)
            }
        }

        poief.delete flush:true


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'poi.label', default: 'Poi'), poief.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'poi.label', default: 'Poi'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
