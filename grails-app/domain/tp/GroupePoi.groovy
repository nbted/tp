package tp

class GroupePoi {

    String nomGroupe
    static hasMany = [ poi :Poi , media : Media , dbphoto :DBPhoto]

    static constraints = {
        nomGroupe nullable: false , unique: true , size: 5..30
    }
}
