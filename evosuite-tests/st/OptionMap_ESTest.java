/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 06 07:53:36 GMT 2021
 */

package st;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import st.OptionMap;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class OptionMap_ESTest extends OptionMap_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      OptionMap.Option optionMap_Option0 = optionMap0.new Option("d-d>Mj4Ld1&", (Integer) 4);
      OptionMap.Option optionMap_Option1 = optionMap0.new Option("[a-zA-Z][a-zA-Z]*", (Integer) 1);
      boolean boolean0 = optionMap_Option0.equals(optionMap_Option1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      OptionMap.Option optionMap_Option0 = optionMap0.new Option((String) null, (String) null, (Integer) optionMap0.INTEGER);
      OptionMap.Option optionMap_Option1 = optionMap0.new Option((String) null, (Integer) optionMap0.BOOLEAN);
      boolean boolean0 = optionMap_Option0.equals(optionMap_Option1);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      OptionMap optionMap1 = new OptionMap();
      OptionMap.Option optionMap_Option0 = optionMap1.new Option("e", ":*CF@-5Dh2jyS", (Integer) 2);
      OptionMap.Option optionMap_Option1 = optionMap0.new Option("", "Tz28WhgVs`Hed+w`bg", (Integer) 3);
      boolean boolean0 = optionMap_Option0.equals(optionMap_Option1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      OptionMap.Option optionMap_Option0 = optionMap0.new Option("OptionMap [options=\n]", "OptionMap [options=\n]", (Integer) 1);
      boolean boolean0 = optionMap_Option0.equals(optionMap0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      OptionMap.Option optionMap_Option0 = optionMap0.new Option((String) null, (Integer) 3);
      boolean boolean0 = optionMap_Option0.equals((Object) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      OptionMap.Option optionMap_Option0 = optionMap0.new Option("e", "e", (Integer) 2);
      boolean boolean0 = optionMap_Option0.equals(optionMap_Option0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("PG", "", 3);
      String string0 = optionMap0.toString();
      assertEquals("OptionMap [options=\n\t{name=PG, shortcut=, type=3, value=}\n]", string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      // Undeclared exception!
      try { 
        optionMap0.store("A", "", 2882);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("st.OptionMap", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      // Undeclared exception!
      try { 
        optionMap0.store("A", "H", (-1));
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("st.OptionMap", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      // Undeclared exception!
      try { 
        optionMap0.store("A", "3", 3);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("st.OptionMap", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      // Undeclared exception!
      try { 
        optionMap0.store("BUG NUMBER 10 IS FOUNDED: -- <3 points>", (String) null, 2);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("st.OptionMap", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      // Undeclared exception!
      try { 
        optionMap0.store("", "iM>/32`bMRDBr?CP|", 2);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("st.OptionMap", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("EG", "", 2);
      // Undeclared exception!
      try { 
        optionMap0.setValueWithOptioShortcut("", "~9Ix+,6_");
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("st.OptionMap", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("EG", "", 3);
      optionMap0.setValueWithOptioShortcut("EG", "");
      assertEquals(1, OptionMap.INTEGER);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("A", "H", 3);
      // Undeclared exception!
      try { 
        optionMap0.setValueWithOptioShortcut("H", "K^^Hwy5vVL");
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("st.OptionMap", e);
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("fvG", "", 3);
      optionMap0.setValueWithOptioShortcut("", "-fDX8a=^(]3dM53C>");
      // Undeclared exception!
      try { 
        optionMap0.setValueWithOptionName("fvG", "9%K@u(8sJ$GH<vFX");
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("st.OptionMap", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("KEG", "", 3);
      optionMap0.setValueWithOptionName("", "");
      assertEquals(2, OptionMap.BOOLEAN);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("EG", "", 3);
      // Undeclared exception!
      try { 
        optionMap0.setValueWithOptionName("", "");
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("st.OptionMap", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("A", "H", 3);
      // Undeclared exception!
      try { 
        optionMap0.setValueWithOptionName("H", "H");
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("st.OptionMap", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("G", "", 3);
      int int0 = optionMap0.getType("");
      assertEquals(3, int0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("EG", "", 3);
      int int0 = optionMap0.getType("EG");
      assertEquals(3, int0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("u", "", 3);
      int int0 = optionMap0.getType((String) null);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      String string0 = optionMap0.getValue("fvG");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("u", "", 3);
      String string0 = optionMap0.getValue("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("fvG", "", 3);
      String string0 = optionMap0.getValue("fvG");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("EG", "", 3);
      optionMap0.store("EG", "", 2);
      assertEquals(4, OptionMap.CHAR);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      // Undeclared exception!
      try { 
        optionMap0.store("EG", (String) null, (-610));
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("st.OptionMap", e);
      }
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      // Undeclared exception!
      try { 
        optionMap0.store("OptionMap [options=\n", "OptionMap [options=\n", 4);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("st.OptionMap", e);
      }
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      OptionMap.Option optionMap_Option0 = optionMap0.new Option("BUG NUMBER 13 IS FOUNDED: -- <2 points>", (Integer) 1);
      optionMap_Option0.setShortcut("BUG NUMBER 13 IS FOUNDED: -- <2 points>");
      assertEquals("", optionMap_Option0.getValue());
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      OptionMap.Option optionMap_Option0 = optionMap0.new Option("3", (Integer) 3);
      optionMap_Option0.setName((String) null);
      OptionMap.Option optionMap_Option1 = optionMap0.new Option("3", "3", (Integer) 1);
      boolean boolean0 = optionMap_Option0.equals(optionMap_Option1);
      assertFalse(boolean0);
      assertFalse(optionMap_Option1.equals((Object)optionMap_Option0));
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      optionMap0.store("fvG", "", 3);
      optionMap0.setValueWithOptionName("fvG", "");
      assertEquals(3, OptionMap.STRING);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      OptionMap optionMap0 = new OptionMap();
      OptionMap.Option optionMap_Option0 = optionMap0.new Option("zS'=mM=9*:rc", (Integer) 4);
      optionMap_Option0.setType((Integer) 1);
      assertEquals("", optionMap_Option0.getValue());
  }
}
