package code;

import jdk.jfr.Name;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.util.Set;

@Entity(name = "image_table")
public class Image {

    @Id
    @NotBlank(message = "id_cannot_be_blank")
    @NotNull(message = "id_cannot_be_null")
    private int id;

    @Name("image")
    private Blob image;

    @Name("creator")
    private String creator;

    @Name("filename")
    private String filename;

    @Name("filesize")
    private String filesize;

    @Name("filetype")
    private String filetype;

    @Name("copyright")
    private String copyright;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
