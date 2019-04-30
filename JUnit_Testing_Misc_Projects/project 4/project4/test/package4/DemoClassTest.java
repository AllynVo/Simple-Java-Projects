//Allyn Vo
//April 25, 2017
//CS 301
//DemoClass test
package package4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Allyn Vo
 */
public class DemoClassTest {
    
    public DemoClassTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }





    /**
     * Test of getSizeOfList method, of class DemoClass.
     */
    @Test
    public void testGetSizeOfList() {
        System.out.println("getSizeOfList");
        DemoClass instance = new DemoClass();
        int expResult = 0;
        int result = instance.getSizeOfList();
        assertEquals(expResult, result);
    }
    
}
