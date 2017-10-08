package tp

class GroupePoi {

    String nomGroupe
    static hasMany = [ poi :Poi , mediaPoi:MediaPoi ]

    static constraints = {
        nomGroupe nullable: false , unique: true , size: 5..30
    }
}
