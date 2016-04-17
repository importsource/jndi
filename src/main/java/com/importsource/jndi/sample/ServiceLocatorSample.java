package com.importsource.jndi.sample;

import com.importsource.jndi.Service;
import com.importsource.jndi.ServiceLocator;

/**
 * 你可以通过定制自己的服务。然后配置好以后，就可以查找这些服务
 * @author Hezf
 *
 */
public class ServiceLocatorSample {
   public static void main(String[] args) {
      Service service = ServiceLocator.getService("Service1");
      service.execute();
      service = ServiceLocator.getService("Service2");
      service.execute();
      service = ServiceLocator.getService("Service1");
      service.execute();
      service = ServiceLocator.getService("Service2");
      service.execute();		
   }
}