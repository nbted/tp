package tp

import grails.transaction.Transactional

class MediaPoiService {

    @Transactional(readOnly = true)
    List list(Map params) {
        [MediaPoi.list(params), MediaPoi.count()]
    }

    // tag::updateFeaturedImageUrl[]
    @Transactional
    MediaPoi updateFeaturedImageUrl(Long mediaPoiId, Integer version, String featuredImageUrl) {
        MediaPoi mediaPoi = MediaPoi.get(mediaPoiId)
        if ( !mediaPoi ) {
            return null
        }
        mediaPoi.version = version
        mediaPoi.featuredImageUrl = featuredImageUrl
        mediaPoi.save()
    }
    // end::updateFeaturedImageUrl[]

    @Transactional
    MediaPoi save(NameCommand cmd) {
        MediaPoi mediaPoi = new MediaPoi()
        mediaPoi.properties = cmd.properties
        mediaPoi.save()
    }

    @Transactional
    void deleteById(Long mediaPoiId) {
        MediaPoi mediaPoi = MediaPoi.get(mediaPoiId)
        mediaPoi?.delete()
    }

    @Transactional
    MediaPoi update(NameUpdateCommand cmd) {
        def mediaPoi = MediaPoi.get(cmd.id)
        if ( !mediaPoi ) {
            return null
        }
        mediaPoi.properties = cmd.properties
        mediaPoi.save()
    }
}
