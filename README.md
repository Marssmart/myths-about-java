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

