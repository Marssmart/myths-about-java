start "Java 8 Google Juice memory benchmark - Minimal" "%JAVA8_HOME%\bin\java" -jar -Xms1m -Xmx2m -XX:-UseCompressedClassPointers -XX:MaxMetaspaceSize=9m -XX:+UseSerialGC -XX:+UseStringDeduplication  ..\..\..\..\target\memory-benchmark.jar