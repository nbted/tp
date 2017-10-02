package tp

class BootStrap {

    def   springSecurityService

    def init = { servletContext ->



        def roleUtilisateur = new Role(authority: "ROLE_USER").save(flush :true , failOnError : true)
        def roleModelateur = new Role(authority: "ROLE_ANNOUNCER").save(flush : true , failOnError : true)
        def roleAdministrateur = new Role(authority: "ROLE_ADMIN").save(flush : true , failOnError : true)

        def utilisateur = new User(username: "teddy", password: ("teddy")).save(flush : true , failOnError :true)
        def modelateur = new User(username: "hugues" , password: ("hugues")).save(flush : true , failOnError : true)
        def adminstrateur = new User(username: "kwizera", password: ("kwizera")).save(flush : true , failOnError : true)

        UserRole.create(utilisateur , roleUtilisateur , true)
        UserRole.create(modelateur , roleModelateur , true)
        UserRole.create(adminstrateur , roleAdministrateur , true)

        def restaurants = new GroupePoi(nomGroupe:"RESTAURANT" ).save(flush : true , failOnError : true)
        def loc1 = new Emplacement(latitude: 43.697833 , longitude: 7.267896999999948)
        def resto1 = new Poi( nom: "La Villa d'Este" ,emplacement: loc1 , description: "Bright pick offering laid-back rooms, a 24/7 lounge bar, an elegant restaurant & an outdoor pool.")
        restaurants.addToPoi(resto1)
        restaurants.save(flush : true , failOnError : true)

        def loc2 = new Emplacement(latitude: 43.6961903 , longitude: 7.26997259999996)
        def resto2 = new Poi( nom: "LA HAVANE" ,emplacement: loc2 , description: "Beach property offering bright rooms & suites with free Wi-Fi, plus 2 restaurants, a spa & a pool.")
        restaurants.addToPoi(resto2)
        restaurants.save(flush : true , failOnError : true)

        def loc3 = new Emplacement(latitude: 43.695967 , longitude: 7.261056000000053)
        def resto3 = new Poi( nom: "Buffalo Grill Nice" ,emplacement: loc3 , description: "Vegetarian")
        restaurants.addToPoi(resto3)
        restaurants.save(flush : true , failOnError : true)

        def l1 = new Emplacement(latitude: 43.6997761 , longitude: 7.284809999999993)
        def resto4 = new Poi( nom: "Restaurant JAN" ,emplacement: l1 , description: "Vegetarian")
        restaurants.addToPoi(resto4)
        restaurants.save(flush : true , failOnError : true)

        def l2 = new Emplacement(latitude: 43.6954331 , longitude: 7.254003499999953)
        def resto5 = new Poi( nom: "Meat Bar" ,emplacement: l2 , description: "Vegetarian")
        restaurants.addToPoi(resto5)
        restaurants.save(flush : true , failOnError : true)

        def hopitaux  = new GroupePoi(nomGroupe:"Restauran" ).save(flush : true , failOnError : true)
        def loc4 = new Emplacement(latitude: 43.6745612 , longitude: 7.208153100000004)
        def hopi1 = new Poi( nom: "Fondation Lenval" ,emplacement: loc4 , description: "Children's hospital in Nice, France")
        hopitaux.addToPoi(hopi1)
        hopitaux.save(flush : true , failOnError : true)

        def loc5 = new Emplacement(latitude: 43.697218 , longitude: 7.227078000000006)
        def hopi2 = new Poi( nom: "Service De Dermatologie" ,emplacement: loc5 , description: "Dermatologist in Nice, France")
        hopitaux.addToPoi(hopi2)
        hopitaux.save(flush : true , failOnError : true)

        def loc6 = new Emplacement(latitude: 43.67656769999999 , longitude: 7.200986100000023)
        def hopi3 = new Poi( nom: "Métropole Nice Côte d'Azur" ,emplacement: loc6 , description: "hopital bien amenagé pour toutes les maladies")
        hopitaux.addToPoi(hopi3)
        hopitaux.save(flush : true , failOnError : true)

        def loc7 = new Emplacement(latitude: 12.26644 , longitude: 4.5236)
        def hopi4 = new Poi( nom: "Restau" ,emplacement: loc7 , description: "babababbabbabbabb")
        hopitaux.addToPoi(hopi4)
        hopitaux.save(flush : true , failOnError : true)

        def loc8 = new Emplacement(latitude: 12.26644 , longitude: 4.5236)
        def hopi5 = new Poi( nom: "Restau" ,emplacement: loc8 , description: "babababbabbabbabb")
        hopitaux.addToPoi(hopi5)
        hopitaux.save(flush : true , failOnError : true)



        def parcs = new GroupePoi(nomGroupe:"PARCS" ).save(flush : true , failOnError : true)

        def loc9 = new Emplacement(latitude: 43.68819999999999 , longitude: 7.230526699999928)
        def parc1 = new Poi( nom: "Mini Golf Park Carol of Romania" ,emplacement: loc9 , description: "babababbabbabbabb")
        parcs.addToPoi(parc1)
        parcs.save(flush : true , failOnError : true)

        def lo1 = new Emplacement(latitude: 43.6946849 , longitude: 43.6946849)
        def parc2 = new Poi( nom: "Colline du Château" ,emplacement: lo1 , description: "This historic hilltop park offers dramatic city & ocean views, a manmade waterfall & a cafe.")
        parcs.addToPoi(parc2)
        parcs.save(flush : true , failOnError : true)

        def lo2 = new Emplacement(latitude: 43.6848962 , longitude: 7.209523600000011)
        def parc3 = new Poi( nom: "Jardin botanique de la Ville de Nice" ,emplacement: lo2 , description: "The Jardin botanique de la Ville de Nice, also known as the Jardin botanique de Nice, ")
        parcs.addToPoi(parc3)
        parcs.save(flush : true , failOnError : true)

        def lo3 = new Emplacement(latitude: 43.69595959999999 , longitude: 7.268229099999985)
        def parc4 = new Poi( nom: "Jardin Albert I" ,emplacement: lo3 , description: "19th-century public park with mature trees, lawns, pools, a bandstand & summer open-air theater.")
        parcs.addToPoi(parc4)
        parcs.save(flush : true , failOnError : true)

        def lo4 = new Emplacement(latitude: 43.698289 , longitude: 7.299226800000042)
        def parc5 = new Poi( nom: "Parc du Mont Boron" ,emplacement: lo4 , description: "Picturesque elevated park offering walking trails amid sea, mountain & city views.")
        parcs.addToPoi(parc5)
        parcs.save(flush : true , failOnError : true)

    }
    def destroy = {
    }
}
