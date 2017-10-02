package tp

class DBPhoto {

    String name
    String type
    byte[] payload
    Date lastUpdated // Predefined names by Grails will be filled automatically
    Date dateCreated // Predefined names by Grails will be filled automatically
    Date uploadDate = new Date()

    static  hasOne = [poi:Poi , groupePoi : GroupePoi]

    static constraints = {

        payload(nullable:false, maxSize:1073741824) // max of 4GB file for example
        type(blank:true, nullable:true)
        name(blank:true, nullable:true)

    }

    String toString() {
        return name
    }
}
