# myths-about-java
This project was started out of the frustration with "native" developers bitching about Java

## Memory consumption
### Plain Java

Consist out of one "dumb" main class that blocks for 2 minutes

```java
package org.deer.java8.memory.consumption;

import java.util.concurrent.TimeUnit;

public class Java8Runner {

  public static void main(String[] args) throws InterruptedException {
    System.out.println("Benchmark runner successfully started");
    TimeUnit.MINUTES.sleep(2);
  }
}
```

#### Java 8

Default start params 

![alt ](https://raw.githubusercontent.com/Marssmart/myths-about-java/master/myths/memory-consumption/java-8/src/main/resources/images/footprint_base.jpg "")

Minimal params(-Xms1m -Xmx2m  -XX:MaxMetaspaceSize=9m -XX:+UseSerialGC -XX:+UseStringDeduplication)

![alt ](https://raw.githubusercontent.com/Marssmart/myths-about-java/master/myths/memory-consumption/java-8/src/main/resources/images/footprint_minimal.jpg "")

Sustainable params(-XX:+AggressiveOpts -Xms1m -Xmx18m -XX:-UseCompressedClassPointers -XX:MaxMetaspaceSize=38m -XX:+ScavengeBeforeFullGC -XX:+UseSerialGC -XX:+UseStringDeduplication)

This is more realistic use case where the running application can withstand permanent load from
10 threads like so:

```java

private static class LoadSimulator extends Thread {

    @Override
    public void run() {
      final String threadName = Thread.currentThread().getName();
      while (true) {
        try {
          Unirest.post("http://localhost:9548/greeting").asJson();
        } catch (Exception e) {
          System.out.println(format("%s - request failed", threadName));
        }
      }
    }
  }

```

![alt ](https://raw.githubusercontent.com/Marssmart/myths-about-java/master/myths/memory-consumption/java-8/src/main/resources/images/footprint_sustainable.jpg "")

### Spring Rest

Runs spring boot application with simple handler 

```java
package org.deer.java8.spring.rest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/greeting")
  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    return new Greeting(counter.incrementAndGet(),
        String.format(template, name));
  }
}
```

#### Java 8

Default start params 

![alt ](https://raw.githubusercontent.com/Marssmart/myths-about-java/master/myths/memory-consumption/java-8-spring-rest-only/src/main/resources/images/footprint_base.jpg "")

Minimal params(-XX:+AggressiveOpts -Xms1m -Xmx18m -XX:-UseCompressedClassPointers -XX:MaxMetaspaceSize=36m -XX:+ScavengeBeforeFullGC -XX:+UseSerialGC -XX:+UseStringDeduplication)

![alt ](https://raw.githubusercontent.com/Marssmart/myths-about-java/master/myths/memory-consumption/java-8-spring-rest-only/src/main/resources/images/footprint_minimal.jpg "")

### Google Juice

Runs Google juice DI in simplistic example

 ```java
 
 package org.deer.java8.google.guice.memory.consumption;
 
 import com.google.inject.Guice;
 import com.google.inject.Injector;
 
 public class GuiceRunner {
 
   public static void main(String[] args) throws InterruptedException {
     final Injector injector = Guice.createInjector(new TestModule());
     final TestService instance = injector.getInstance(TestService.class);
     instance.doNothing();
     System.out.println("Google Guice running !");
     Thread.currentThread().join();
   }
 }
 ```
 
 #### Java 8
 
 Default start params 
 
 ![alt ](https://raw.githubusercontent.com/Marssmart/myths-about-java/master/myths/memory-consumption/java-8-google-juice/src/main/resources/images/footprint_base.jpg "")
 
 Minimal params(-XX:+AggressiveOpts -Xms1m -Xmx18m -XX:-UseCompressedClassPointers -XX:MaxMetaspaceSize=36m -XX:+ScavengeBeforeFullGC -XX:+UseSerialGC -XX:+UseStringDeduplication)
 
 ![alt ](https://raw.githubusercontent.com/Marssmart/myths-about-java/master/myths/memory-consumption/java-8-google-juice/src/main/resources/images/footprint_minimal.jpg "")