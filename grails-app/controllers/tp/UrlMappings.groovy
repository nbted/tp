package tp

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

        "/pages/google"(view: "/pages/google")
        "/pages/services"(view: "/pages/services")
        "/user/show"(view:"/user/show" )
        "/pages/infoperso"(view: "/pages/infoperso")

    }
}
