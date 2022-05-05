package code;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Blob;

@Stateless
public class ImageService {

    @PersistenceContext
    private EntityManager em;

    public Image upload(Blob image, String creator, String filename, String filesize, String filetype, String copyright){
        Image image1 = new Image();

        image1.setImage(image);
        image1.setCreator(creator);
        image1.setFilename(filename);
        image1.setFilesize(filesize);
        image1.setFiletype(filetype);
        image1.setCopyright(copyright);

        em.persist(image1);

        return image1;
    }

    public Image download(int id){
        Image image = em.find(Image.class, id);

        if (image == null){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return image;
    }
}
