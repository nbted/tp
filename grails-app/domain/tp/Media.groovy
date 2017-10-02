package tp

class Media   {

    private static final long serialVersionUID = 1
    String name
    byte[] mediaByte

    static  hasOne = [poi:Poi , groupePoi : GroupePoi]
    static constraints = {
        mediaByte blank : true
        name(blank:true, nullable:true)
    }

    static mapping = {
        mediaByte column: 'media_byte', sqlType: 'longblob'
    }
}
