/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.rest;

import com.sinec.entity.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fgonzalez
 */
@Stateless(mappedName = "ejb/EJBViaticos")
@Path("/viaticos")
public class RestViaticos {
    @PersistenceContext(unitName="SimpleRESTwebPU")  private EntityManager em;
    @Resource(name = "jdbc/_sinec")             private DataSource dataSource;
    private String PATH_AVATAR = "C:\\xampp\\htdocs\\sigi\\files\\avatars\\";
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    private EntityManager getEm(){return this.em;}    
    //------------------------------------------------------------------------------------------------------------    

    @GET
    //@Path("/allenabled")
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
    
}
