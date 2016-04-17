package com.importsource.jndi.service;

import com.importsource.jndi.Service;

public class Service2 implements Service {
   public void execute(){
      System.out.println("Executing Service2");
   }

   public String getName() {
      return "Service2";
   }
}