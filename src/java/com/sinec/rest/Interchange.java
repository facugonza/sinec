/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;



/**
 *
 * @author fgonzalez
 */

@Stateless(mappedName = "ejb/EJBInterchange")
@Path("/interchange")
public class Interchange {
    @PersistenceContext(unitName="SimpleRESTwebPU")  private EntityManager em;
    @Resource(name = "jdbc/_sinec")             private DataSource dataSource;
    private String PATH_IMAGE_COMPROBANTE = "C:\\xampp\\htdocs\\sigi\\files\\avatars\\";
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    private EntityManager getEm(){return this.em;}    
    //------------------------------------------------------------------------------------------------------------    
    /*@POST
    @Produces(MediaType.APPLICATION_JSON)
    public String receviceImage(@PathParam("picture") String picture, @QueryParam("filename") String filename){
        StringBuilder builder= new StringBuilder();
        try{
            System.out.println("LLAMADA  >>  " + picture ); 
            System.out.println("PICTURE  >>  "  + filename); 
            System.out.println("FILENAME >>  " ); 
            JsonbConfig config = new JsonbConfig()                                                     
                                                .withFormatting(Boolean.TRUE)    //salidas con formato
                                                .withDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()) //como manejar las fechas                                                    
                                                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES); //otra forma de manipular las propiedades                                
            Jsonb jsonb = JsonbBuilder.create(config);        
            
        }catch(Exception e ){
            e.printStackTrace();
        }finally{
            return "{}";
        }
        
    }*/
    //------------------------------------------------------------------------------------------------------------    
    
 
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile( @FormDataParam("picture") InputStream uploadedInputStream,
                                @FormDataParam("file") FormDataContentDisposition fileDetail,
                                @FormDataParam("fileName") String fileName) {
        System.out.println("LLAMADA  >>  " ); 
        System.out.println("PICTURE  >>  " + fileDetail.getName()); 
        System.out.println("FILENAME >>  " + fileDetail.getFileName());             
        // check if all form parameters are provided
        if (uploadedInputStream == null || fileDetail == null)
                return Response.status(400).entity("Invalid form data").build();
        // create our destination folder, if it not exists
        try {
                createFolderIfNotExists(PATH_IMAGE_COMPROBANTE);
        } catch (SecurityException se) {
                return Response.status(500)
                                .entity("Can not create destination folder on server")
                                .build();
        }
        String uploadedFileLocation = PATH_IMAGE_COMPROBANTE + fileName ;//fileDetail.getFileName();
        try {
                saveToFile(uploadedInputStream, uploadedFileLocation);
        } catch (IOException e) {
                return Response.status(500).entity("Can not save file").build();
        }
        return Response.status(200)
                        .entity("File saved to " + uploadedFileLocation).build();
	}
        
    private void saveToFile(InputStream inStream, String target)throws IOException {
        OutputStream out = null;
        int read = 0;
        byte[] bytes = new byte[1024];
        out = new FileOutputStream(new File(target));
        while ((read = inStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
        }
        out.flush();
        out.close();
    }
                
    private void createFolderIfNotExists(String dirName)throws SecurityException {
        File theDir = new File(dirName);
        if (!theDir.exists()) {
                theDir.mkdir();
        }
    }        
    
    
    //----------------------------------------------------------------------------------------------
    
}
