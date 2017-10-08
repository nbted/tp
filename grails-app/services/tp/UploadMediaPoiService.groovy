package tp

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import groovy.transform.CompileStatic

@SuppressWarnings('GrailsStatelessService')
@CompileStatic
class UploadMediaPoiService implements GrailsConfigurationAware {

    MediaPoiService mediaPoiService

    String local
    String localurl

    @Override
    void setConfiguration(Config co) {
        local = co.getRequiredProperty('grails.guides.local')
        localurl = co.getRequiredProperty('grails.guides.localurl')
    }

    @SuppressWarnings('JavaIoPackageAccess')
    MediaPoi uploadFeatureImage(FeaturedImageCommand cmd) {

        String filename = cmd.featuredImageFile.name
        def folderPath = "${local}/tppoi/${cmd.id}" as String
        def folder = new File(folderPath)
        if ( !folder.exists() ) {
            folder.mkdirs()
        }
        def path = "${folderPath}/${filename}" as String
        cmd.featuredImageFile.transferTo(new File(path))

        String featuredImageUrl = "${localurl}//tppoi/${cmd.id}/${filename}"

        def media = mediaPoiService.updateFeaturedImageUrl(cmd.id, cmd.version, featuredImageUrl)

        if ( !media || media.hasErrors() ) {
            def f = new File(path)
            f.delete()
        }
        media
    }
}
