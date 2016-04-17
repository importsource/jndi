# jndi
A  service locator



###sample code
```java
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
```
output
```log
[Sun Apr 17 22:02:04 CST 2016][INFO] (com.importsource.jndi.ServiceLocatorSample.java: Line 13)importsource.jndi.service.scope=com.importsource.jndi.service
Executing Service1
[Sun Apr 17 22:02:04 CST 2016][INFO] (com.importsource.jndi.ServiceLocatorSample.java: Line 15)importsource.jndi.service.scope=com.importsource.jndi.service
Executing Service2
[Sun Apr 17 22:02:04 CST 2016][INFO] (com.importsource.jndi.ServiceLocatorSample.java: Line 17)Returning cached  Service1 object
Executing Service1
[Sun Apr 17 22:02:04 CST 2016][INFO] (com.importsource.jndi.ServiceLocatorSample.java: Line 19)Returning cached  Service2 object
Executing Service2
```


###create a new  service 
```java
public class Service1 implements Service {
   public void execute(){
      System.out.println("Executing Service1");
   }

   public String getName() {
      return "Service1";
   }
}
```


### config the service package in the xml file
```xml
 <property>
        <name>importsource.jndi.service.scope</name>
        <value>com.importsource.jndi.service</value>
 </property>
```

###maven
```xml
<dependency>
	<groupId>com.importsource.jndi</groupId>
	<artifactId>importsource-jndi</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```


