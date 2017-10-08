package tp

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {
    SpringSecurityService springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userCount: User.count()]

    }
    def getId(User user){
        return user.id
    }
    @Secured(['ROLE_ADMIN','ROLE_ANNOUNCER','ROLE_USER'])
    def show(User user) {
        respond user

    }

    @Secured(['ROLE_ADMIN','ROLE_ANNOUNCER'])
    def create() {
        User current =springSecurityService.currentUser
        def user = new User(params)
        if (current.getAuthorities()== ['ROLE_ADMIN']  ){
            respond user
        }
        else if (current.getAuthorities()== ['ROLE_ANNOUNCER']){
            if(user.getAuthorities()==['ROLE_USER']){
                respond(user)
            }
            else render 'no droit'
        }
        else
        respond user
    }

    @Transactional
    @Secured(['ROLE_ADMIN','ROLE_ANNOUNCER'])
    def save(User user) {
        if (user == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (user.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond user.errors, view:'create'
            return
        }

        user.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*' { respond user, [status: CREATED] }
        }
    }
    @Secured(['ROLE_ADMIN','ROLE_ANNOUNCER','ROLE_USER'])
    def edit(User user) {

        User current = springSecurityService.currentUser

        def autorite1 = current.getAuthorities().authority
        def autorite2 = user.getAuthorities().authority
        if (current != user){
            if (autorite1 == '[ROLE_ADMIN]'){
                respond(user)
            }
            else if (autorite1 =='[ROLE_ANNOUNCER]'){
                if(autorite2 =='[ROLE_ANNOUNCER]' || autorite2=='[ROLE_USER]' ) {
                    respond(user)
                }
                else render  'mon role ' + current.getAuthorities().authority +' no droit'
            }
            else
                render  'mon role ' + current.getAuthorities().authority +' no droit'

        }
        else  respond(user)
    }

    @Transactional
    @Secured(['ROLE_ADMIN','ROLE_ANNOUNCER','ROLE_USER'])
    def update(User user) {
        if (user == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (user.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond user.errors, view:'edit'
            return
        }

        User current = springSecurityService.currentUser
        def autorite1 = current.getAuthorities().authority
        def autorite2 = user.getAuthorities().authority
        if (current != user){
            if (autorite1.contains('ROLE_ADMIN')){
                user.save  flush:true
            }
            else if (autorite1.contains('ROLE_ANNOUNCER')){
                if(autorite2.contains('ROLE_ANNOUNCER') || autorite2.contains('ROLE_USE') ) {
                    user.save  flush:true
                }
                else render  'mon role ' + current.getAuthorities().authority +' no droit'
             }
            else
                render  'mon role ' + current.getAuthorities().authority +' no droit'

        }
        else  user.save flush:true


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*'{ respond user, [status: OK] }
        }
    }

    @Transactional
    @Secured(['ROLE_ADMIN','ROLE_ANNOUNCER'])
    def delete(User user) {

        if (user == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }
        User current = springSecurityService.currentUser
        def authorite1 = current.getAuthorities().authority
        def authorite2 = current.getAuthorities().authority
        if(authorite1 == '[ROLE_ADMIN]'){
            Collection<UserRole> userRoles = UserRole.findAllByUser(user);
            userRoles*.delete();
            user.delete flush:true
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
