package tp

import grails.gorm.transactions.Transactional

@Transactional
class MediaService {



    def serviceMethod() {

    }

    // tag::list[]
    @Transactional(readOnly = true)
    List list(Map params) {
        [Media.list(params), Media.count()]
    }
    // end::list[]

    // tag::updateRestaurantFeaturedImage[]
    @Transactional
    Media updateMedia(Long mediaId, byte[] bytes) {
        Media media = Media.get(mediaId)
        if ( !media ) {
            return null
        }

        media.mediaByte = bytes

        media.save()
        media
    }



}
