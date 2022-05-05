package code;


import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class TreeGalleryApplication extends ResourceConfig {

    public TreeGalleryApplication(){
        packages("ch.bzz.treegallery").register(MultiPartFeature.class);
    }
}
