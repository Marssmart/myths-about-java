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
