package com.importsource.jndi;
import java.util.ArrayList;
import java.util.List;

import com.importsource.log.client.LogManager;
import com.importsource.log.core.Logger;

/**
 * cache the services
 * @author Hezf
 *
 */
public class Cache {
   Logger logger = LogManager.getLogger(InitialContext.class);
   private List<Service> services;

   public Cache(){
      services = new ArrayList<Service>();
   }

   public Service getService(String serviceName){
   
      for (Service service : services) {
         if(service.getName().equalsIgnoreCase(serviceName)){
        	logger.i("Returning cached  " + serviceName + " object");
            return service;
         }
      }
      return null;
   }

   public void addService(Service newService){
      boolean exists = false;
      
      for (Service service : services) {
         if(service.getName().equalsIgnoreCase(newService.getName())){
            exists = true;
         }
      }
      if(!exists){
         services.add(newService);
      }
   }
}