package org.deer.java8.simulator.spring.rest;

import static java.lang.String.format;

import com.mashape.unirest.http.Unirest;
import java.util.concurrent.TimeUnit;

public class SpringRestLoadSimulatorRunner {

  private static final int NR_OF_LOAD_SIMULATORS = 10;

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < NR_OF_LOAD_SIMULATORS; i++) {
      new LoadSimulator().start();
    }
    TimeUnit.MINUTES.sleep(2);
    System.out.println("Load simulator ended");
  }

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
}
