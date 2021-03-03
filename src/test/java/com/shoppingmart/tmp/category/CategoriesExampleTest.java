package com.shoppingmart.tmp.category;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CategoriesExampleTest {

  @Category(Odd.class)
  @Test
  public void testOne(){
    Assert.assertTrue(true);
  }

  @Category(Even.class)
  @Test
  public void testTwo(){
    Assert.assertTrue(true);
  }

  @Category(Odd.class)
  @Test
  public void testThree(){
    Assert.assertTrue(true);
  }

  @Category(Even.class)
  @Test
  public void testFour(){
    Assert.assertTrue(true);
  }
  @Category(Odd.class)
  @Test
  public void testFive(){
    Assert.assertTrue(true);
  }

  @Category(Even.class)
  @Test
  public void testSix(){
    Assert.assertTrue(true);
  }
}

interface Odd {

}

interface Even{

}
