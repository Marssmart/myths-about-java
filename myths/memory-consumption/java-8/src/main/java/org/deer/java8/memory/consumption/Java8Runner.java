package org.deer.java8.memory.consumption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Java8Runner {

  public static void main(String[] args) throws InterruptedException, IOException {
    TimeUnit.SECONDS.sleep(2);
    Runtime runtime = Runtime.getRuntime();
    //yeah, i know, its not totally accurate, bla bla
    long usedMemory = runtime.totalMemory() - runtime.freeMemory();

    Files.write(Paths.get("./java-8-memory-out"), Collections.singleton(Long.toString(usedMemory)));
  }
}
