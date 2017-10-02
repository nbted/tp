package tp

import grails.gorm.transactions.Transactional

@Transactional
class UploadMediaService {


    def mediaService

    Media uploadFeatureImage(ImageValidation cmd) {
        byte[] bytes = cmd.featuredImageFile.bytes
        String contentType = cmd.featuredImageFile.contentType
        mediaService.updateMedia(cmd.id, bytes)

    }
    def serviceMethod() {

    }
}
