package org.deer.java8.google.guice.memory.consumption;

import com.google.inject.AbstractModule;

public class TestModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(TestService.class).toInstance(new TestService());
  }
}
