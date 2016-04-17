package com.importsource.jndi;

import java.util.Iterator;
import java.util.Set;

import com.importsource.common.io.ScannerUtil;
import com.importsource.conf.Properties;
import com.importsource.conf.PropertiesTools;
import com.importsource.log.client.LogManager;
import com.importsource.log.core.Logger;

/**
 * initial services
 * @author Hezf
 *
 */
public class InitialContext {
   Logger logger = LogManager.getLogger(InitialContext.class);
   public Object lookup(String jndiName){
	   Properties p = com.importsource.conf.Properties.newInstance("conf.xml");
	   String scope = PropertiesTools.get(p, "importsource.jndi.service.scope", null);
	   logger.i("importsource.jndi.service.scope="+scope);
	   Set<Class<?>> set = ScannerUtil.getClasses(scope);
       for (Iterator iterator = set.iterator(); iterator.hasNext();) {
		  Class<?> class1 = (  Class<?>) iterator.next();
		  if(class1.getSimpleName().equals(jndiName)){
			  try {
				return class1.newInstance();
			} catch (InstantiationException e) {
				logger.e(e.getMessage());
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				logger.e(e.getMessage());
				throw new RuntimeException(e);
			}
		  }
		
	}
      return null;		
   }
}