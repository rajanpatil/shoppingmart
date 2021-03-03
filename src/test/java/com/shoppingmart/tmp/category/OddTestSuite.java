package com.shoppingmart.tmp.category;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@Categories.IncludeCategory({Odd.class})
@SuiteClasses({CategoriesExampleTest.class})
public class OddTestSuite {

}
