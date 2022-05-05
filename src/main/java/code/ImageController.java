package code;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("image")
public class ImageController {

    @Inject
    private ImageService imageService;

    @POST
    @Path("upload")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upload(@Valid Image image){
        int httpStatus = 200;
        try{
            image = imageService.upload(image.getImage(), image.getCreator(), image.getFilename(),
                    image.getFilesize(), image.getFiletype(), image.getCopyright());
        } catch (Exception e) {
            httpStatus = 400;
            image = null;
        }

        return Response
                .status(httpStatus)
                .entity(image)
                .build();

    }

    @GET
    @Path("download")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response download(int id){
        try{
            imageService.download(id);
        } catch (Exception e){
            e.getMessage();
        }

        return Response
                .status(Response.Status.OK)
                .entity(id)
                .build();

    }

}
