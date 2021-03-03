package com.shoppingmart.tmp;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {
  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void testTwoPlusTwoIsFour() {
    assertEquals("2 + 2 = 4", 4, 2 + 2);
  }

  @Test
  public void testMultipleCalculationFailures() {
    assertEquals(4, 2 + 2);
    assertEquals(4, 2 + 1);
    assertEquals(4, 2 + 6);
    assertEquals(4, 2 + 2);
  }

  @Test
  @Ignore("Not implemented yet!")
  public void testNoImplementedYet() {
    // ignore example
  }

  @Test(expected = NumberFormatException.class)
  public void testNumberFormatExceptionThrown() {
    Integer.valueOf("foo");
  }

  @Test
  public void testAnotherWayToHandleException() {
    expectedException.expect(NumberFormatException.class);
    expectedException.expectMessage("For input string");

    Integer.valueOf("foo");
  }
}
