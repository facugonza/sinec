/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinec.rest;

import com.sinec.entity.checkvehicular.ChkVehicular;
import com.sinec.entity.checkvehicular.ChkVehicularDetalle;
import com.sinec.entity.checkvehicular.ChkVehicularItem;
import com.sinec.entity.parser.ChkVehicularDetalleParser;
import com.sinec.entity.parser.ChkVehicularItemParser;
import com.sinec.entity.parser.ChkVehicularParser;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.config.PropertyNamingStrategy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fgonzalez
 */
@Stateless(mappedName = "ejb/EJBChkVehicular")
@Path("/chkvehicular")
public class RestChkVehicular {
    @PersistenceContext(unitName="SimpleRESTwebPU")  private EntityManager em;
    @Resource(name = "jdbc/_sinec")             private DataSource dataSource;
    private String PATH_AVATAR = "C:\\xampp\\htdocs\\sigi\\files\\avatars\\";
    
    //------------------------------------------------------------------------------------------------
        private EntityManager getEm(){return this.em;}    
    //------------------------------------------------------------------------------------------------
    @POST
    @Path("/create")
    @Produces({ MediaType.APPLICATION_JSON})
    public ChkVehicularParser insertarCheckVehicular(@QueryParam("chkvehicularparser") String chkvehicularparser){
         ChkVehicular chkVehicular=null;
         ChkVehicularParser chkVehicularParserReturn  =  null;
        try{
            //
            System.out.println("JsonbDateFormat.DEFAULT_FORMAT >>> "+JsonbDateFormat.DEFAULT_FORMAT);
            System.out.println("JsonbDateFormat.DEFAULT_LOCALE >>> "+JsonbDateFormat.DEFAULT_LOCALE);
            System.out.println("JsonbDateFormat.TIME_IN_MILLIS >>> "+JsonbDateFormat.TIME_IN_MILLIS);
            System.out.println("chkvehicularparser >>> "+ chkvehicularparser);
            
            JsonbConfig config = new JsonbConfig()                                                     
                                                .withFormatting(Boolean.TRUE)    //salidas con formato
                                                .withDateFormat("yyyy-MM-dd", Locale.getDefault()) //como manejar las fechas                                                    
                                                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES); //otra forma de manipular las propiedades                                            
                        
            
            
            Jsonb jsonb = JsonbBuilder.create(config);
            
            
            
            ChkVehicularParser chkVehicularParser  = jsonb.fromJson(new StringReader(chkvehicularparser), ChkVehicularParser.class);
            System.out.println("chkvehicularjson>>> " + chkVehicularParser.getObservacion());
            
            
            chkVehicular = new ChkVehicular();                
                chkVehicular.setIdUsuario(chkVehicularParser.getIdusuario());
                chkVehicular.setKilometraje(chkVehicularParser.getKilometraje());
                chkVehicular.setNivelCombustible(chkVehicularParser.getNivelcombustible());
                chkVehicular.setObservacion(chkVehicularParser.getObservacion());
                chkVehicular.setPatente(chkVehicularParser.getPatente());                
            getEm().persist(chkVehicular);
            
            List<ChkVehicularDetalle> detalleList= new ArrayList<>();
            
            for (ChkVehicularDetalleParser detalleParser : chkVehicularParser.getListdetalleitems()){            
                ChkVehicularItem item = getEm().find(ChkVehicularItem.class, detalleParser.getItem());
                ChkVehicularDetalle  detalle  = new ChkVehicularDetalle();
                    detalle.setChkVehicular(chkVehicular);
                    detalle.setItem(item);
                    detalle.setChkSI(detalleParser.getChksi());
                    detalle.setChkNO(detalleParser.getChkno());
                    detalle.setChkNA(detalleParser.getChkna());
                    detalle.setObservacion(detalleParser.getObservacion());
                getEm().persist(detalle);
                detalleList.add(detalle);
            }           
            chkVehicular.setListDetalleItems(detalleList);
            getEm().merge(chkVehicular);
            chkVehicularParserReturn = chkVehicularParser;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return chkVehicularParserReturn;
        }
    }    
    //------------------------------------------------------------------------------------------------
    @GET
    @Path("/{idcheckvehicular}")
    @Produces({ MediaType.APPLICATION_JSON})    
     public ChkVehicular findCheckVehicular(@PathParam("idcheckvehicular") String idcheckvehicular){
         try{
             System.out.println("idcheckvehicular");
         }catch(Exception e){
             e.printStackTrace();
         }finally{  
             return null;
         }
     }    
//------------------------------------------------------------------------------------------------    
    @GET
    //@Path("/allenabled")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<ChkVehicular> findAllEnabled (){     
         try{
             System.out.println("LLAMADA A findAllEnabled");
         }catch(Exception e){
             e.printStackTrace();
         }finally{  
             return new ArrayList<>();
         }
    }
//------------------------------------------------------------------------------------------------    
    @GET
    @Path("/items/allenabled")    
    @Produces({ MediaType.APPLICATION_JSON})
    public List<ChkVehicularItemParser>  findAllItemsEnabled (){     
    //public Response  findAllItemsEnabled (){     
        //Response response  = Response.status(Response.Status.BAD_REQUEST).build();
        List<ChkVehicularItem> listaItems = new ArrayList<>();
        
        List<ChkVehicularItemParser> lista = new ArrayList<>();
        try{
            System.out.println("PETICION zzzzz");
            listaItems = getEm().createNamedQuery("ChkVehicularItem.findAllenabled")
                                .getResultList();
            for (ChkVehicularItem item : listaItems){
                ChkVehicularItemParser chkVehicularItemParser = new ChkVehicularItemParser();
                    chkVehicularItemParser.setIdItem(item.getIdItem());
                    chkVehicularItemParser.setDescripcion(String.valueOf(item.getIdItem())+"-"+item.getDescripcion());
                lista.add(chkVehicularItemParser);
            }
            
            //List<String> list = new ArrayList<String>();
            //GenericEntity<List<ChkVehicularItem>> entity = new GenericEntity<List<ChkVehicularItem>>(listaItems) {};
            //response = Response.status(Response.Status.CREATED).entity(entity).build();            
            
            //return Response.ok(this, MediaType.APPLICATION_JSON);
        }catch(Exception e){
             e.printStackTrace();
             //response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }finally{              
             return lista;
        }
    }    
//------------------------------------------------------------------------------------------------    
    
}
