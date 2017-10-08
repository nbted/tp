package tp

class MediaPoi implements Serializable {
    private static final long serialVersionUID = 1
    String name
    String featuredImageUrl
     static  hasOne = [poi:Poi ]

    static constraints = {
        featuredImageUrl nullable: true
        name nullable: false
    }



}
