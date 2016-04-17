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


