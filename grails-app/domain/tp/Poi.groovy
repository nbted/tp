package tp

class Poi {

    String nom
    Emplacement emplacement
    String description

    //static hasOne = [emplacement : Emplacement]
    static  belongsTo = GroupePoi
    static  hasMany = [groupePoi: GroupePoi , mediaPoi:MediaPoi ]

    static constraints = {
        nom blank : false ,nullable : false , size : 5..50
        description blank: false , nullable : false , size : 5..10000
    }

    Set<MediaPoi> getMedias(){

        (MediaPoi.findAllByPoi(this) as List<MediaPoi>)*.mediaPoi as Set<MediaPoi>
    }
}
