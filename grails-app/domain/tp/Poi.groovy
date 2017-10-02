package tp

class Poi {

    String nom
    Emplacement emplacement
    String description

    //static hasOne = [emplacement : Emplacement]
    static  belongsTo = GroupePoi
    static  hasMany = [groupePoi: GroupePoi , media : Media, dbphoto :DBPhoto]

    static constraints = {
        nom blank : false ,nullable : false , size : 5..50
        description blank: false , nullable : false , size : 5..10000
    }

    Set<Media> getMedias(){

        (Media.findAllByPoi(this) as List<Media>)*.media as Set<Media>
    }
}
