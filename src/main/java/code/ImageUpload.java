package code;

import java.sql.*;
import java.io.*;
public class ImageUpload
{
    public static void main(String[] args)
    {
        //URL to Connect to the database
        String url = "jdbc:mysql://localhost:3306/treegallery/test?autoReconnect=true&useSSL=false";
        //User
        String user = "root";
        //Password
        String password = "1234";
        try{
            //create the database connection string
            Connection con = DriverManager.getConnection(url, user, password);
            //object to create the request
            Statement st = con.createStatement();
            //the image to insert
            File file = new File("test.png");
            FileInputStream input = new FileInputStream(file);

            //create the request
            PreparedStatement ps =
                    con.prepareStatement("insert into image_table values(?,?,?,?,?,?)");

            //image itself
            ps.setBinaryStream(1,(InputStream)input,(int)file.length());
            // creator
            ps.setString(2,"Anastasia Spasojevic");
            //filename
            ps.setString(3,"testfile.png");
            //size
            ps.setString(4,"99");
            //filetype
            ps.setString(5,"PNG");
            // creator
            ps.setString(6,"Creative Commons");
            //execute the request
            ps.executeUpdate();
            System.out.println("Image successfully inserted!");
            //close the preparedStatement
            ps.close();
            //close the connection
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
