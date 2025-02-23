package com.vogella.junit.first;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyClassTest {

  @Test(expected = IllegalArgumentException.class)
  public void testExceptionIsThrown() {
    MyClass tester = new MyClass();
    tester.multiply(1000, 5);
  }

  @Test
  public void testMultiply() {
    MyClass tester = new MyClass();
    assertEquals("10 x 5 must be 50", 50, tester.multiply(10, 5));
  }
  
  @Test
  public void multiplyTest2() {
	  MyClass urWelcomeTony = new MyClass();
	  assertEquals("Tony, your an Inter so this test will fail ofc", 25, urWelcomeTony.multiply(5, 2));
  }
}