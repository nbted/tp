package tp

class Emplacement {

    Double latitude , longitude

    static belongsTo = Poi
    static constraints = {
        latitude nullable: false
        longitude nullable: false
    }
}
