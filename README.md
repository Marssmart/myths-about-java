# myths-about-java
This project was started out of the frustration with "native" developers bitching about Java

## Memory consumption
### Plain Java
#### Java 8

Default start params 

![alt ](https://raw.githubusercontent.com/Marssmart/myths-about-java/master/myths/memory-consumption/java-8/src/main/resources/images/footprint_base.jpg "")

Minimal params(-Xms1m -Xmx2m  -XX:MaxMetaspaceSize=9m -XX:+UseSerialGC -XX:+UseStringDeduplication)

![alt ](https://raw.githubusercontent.com/Marssmart/myths-about-java/master/myths/memory-consumption/java-8/src/main/resources/images/footprint_minimal.jpg "")

#### Java 10

