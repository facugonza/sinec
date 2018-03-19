/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.rest;

import com.sinec.entity.Usuarios;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import javax.annotation.Resource;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

/**
 *
 * @author fgonzalez
 */
@Stateless(mappedName = "ejb/EJBUsuarios")
@Path("/usuarios")
public class RestUsuarios {
    @PersistenceContext(unitName="SimpleRESTwebPU")  private EntityManager em;
    @Resource(name = "jdbc/_sinec")             private DataSource dataSource;
    private String PATH_AVATAR = "C:\\xampp\\htdocs\\sigi\\files\\avatars\\";
    
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    private EntityManager getEm(){return this.em;}    
    //------------------------------------------------------------------------------------------------------------    
    @GET
    @Path("/{username}/find")
    @Produces(MediaType.APPLICATION_JSON)
    public String findUsuario(@PathParam("username") String userName,@QueryParam("identificador") String identificador){
        String result="";
        try{
            System.out.println("identificador "+ identificador);
            if (userName!=null){
                JsonbConfig config = new JsonbConfig()                                                     
                                                    .withFormatting(Boolean.TRUE)    //salidas con formato
                                                    .withDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()) //como manejar las fechas                                                    
                                                    .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES); //otra forma de manipular las propiedades                                
                Jsonb jsonb = JsonbBuilder.create(config);
                Usuarios user = (Usuarios) getEm().createNamedQuery("Usuarios.findByUsuario")
                                              .setParameter("usuario", userName)
                                              .getSingleResult();
                if (user!=null) {                    
                    result = jsonb.toJson(user); //"<email>"+user.getEmail()+"</email>";
                    File file   = new File(PATH_AVATAR+user.getIdUsuario()+".jpg");
                    String avatarBase64= "";
                    if (file.exists()){                        
                        byte []byteArray = Files.readAllBytes(file.toPath());
                        avatarBase64=  Base64.getEncoder().encodeToString(byteArray);
                    }else{
                        file   = new File(PATH_AVATAR+"nobody.png");
                        byte []byteArray = Files.readAllBytes(file.toPath());
                        avatarBase64=  Base64.getEncoder().encodeToString(byteArray);
                    }
                    result = result.replace("}", "\n, \"avatar\": \"" + avatarBase64 + "\"" + "\n } ");                    
                }else result = "<result>NO SE ENCONTRO USUARIO ...</result>";
            }else result = "<result>DEBE INGRESAR UN VALOR</result>";
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return result;
        }
    }
    //------------------------------------------------------------------------------------------------------------        
    @Path("/{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String authenticate (@PathParam("username") String userName, @QueryParam("email") String email){
        String result="";
        try{
            System.out.println("username  >>> " + userName  );
            System.out.println("email     >>> " + email     );
            if (email!=null){
                Usuarios user = (Usuarios) getEm().createNamedQuery("Usuarios.findByUserAndEmail")
                                              .setParameter("usuario", userName)
                                              .setParameter("email", email)
                                              .getSingleResult();
                JsonbConfig config = new JsonbConfig()                                                     
                                                    .withFormatting(Boolean.TRUE)    //salidas con formato
                                                    .withDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()) //como manejar las fechas                                                    
                                                    .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES); //otra forma de manipular las propiedades                                
                Jsonb jsonb = JsonbBuilder.create(config);
                
                if (user!=null) {                    
                    result = jsonb.toJson(user); //"<email>"+user.getEmail()+"</email>";
                    File file   = new File(PATH_AVATAR+user.getIdUsuario()+".jpg");
                    String avatarBase64= "";
                    if (file.exists()){                        
                        byte []byteArray = Files.readAllBytes(file.toPath());
                        avatarBase64=  Base64.getEncoder().encodeToString(byteArray);
                    }else{
                        file   = new File(PATH_AVATAR+"nobody.png");
                        byte []byteArray = Files.readAllBytes(file.toPath());
                        avatarBase64=  Base64.getEncoder().encodeToString(byteArray);
                    }
                    result = result.replace("}", "\n ,\"avatar\": \"" + avatarBase64 + "\"" + "\n } ");
                    
                }else result = "<result>NO SE ENCONTRO USUARIO ...</result>";
            }else result = "<result>DEBE INGRESAR UN VALOR</result>";
        }catch(Exception e){
            e.printStackTrace();            
        }finally{
            System.out.println("result >>>  "+ result);
            return result;
        }
    }    
    //------------------------------------------------------------------------------------------------------------    
    @GET    
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Usuarios> findAllEnabled (){
        List<Usuarios> listaUsuarios = new ArrayList<>();
        try{
           listaUsuarios = getEm().createNamedQuery("Usuarios.findAll")
                                  .getResultList();
        }catch(Exception e){
            e.printStackTrace();            
        }finally{
            System.out.println("result >>>  "+ listaUsuarios.size());
            return listaUsuarios;
        }
    }        
    //------------------------------------------------------------------------------------------------
    @POST
    @Path("/create")
    public String insertarUsuario(String usuarioString){
        String result="";
        try{
            Jsonb jsonb = JsonbBuilder.create();
            //Json userJson= Json.createParser(new StringReader(usuarioString));
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return result;
        }
    }
    //------------------------------------------------------------------------------------------------------------
    
    
}
