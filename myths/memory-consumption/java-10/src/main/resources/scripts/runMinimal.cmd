start "Java 10 memory benchmark - Minimal" "%JAVA10_HOME%\bin\java" -jar -Xms1m -Xmx2m  -XX:MaxMetaspaceSize=9m -XX:+UseSerialGC -XX:+UseStringDeduplication  ..\..\..\..\target\memory-benchmark.jar
