//Allyn Vo
//April 12, 2017
//CS 301

package project3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cs301001_17
 */
public class DemoBigOTest {
    
    public DemoBigOTest() {
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
     * Test of throwDivideException method, of class DemoBigO.
     */
    @Test
    public void testThrowDivideException() {
        System.out.println("throwDivideException");
        DemoBigO instance = new DemoBigO();
        boolean expResult = true;
        boolean result = instance.throwDivideException();
        assertEquals(expResult, result);

    }

    /**
     * Test of throwAnException method, of class DemoBigO.
     */
    @Test
    public void testThrowAnException() {
        System.out.println("throwAnException");
        DemoBigO instance = new DemoBigO();
        instance.throwAnException();

    }

    /**
     * Test of demoBigO1 method, of class DemoBigO.
     */
    @Test
    public void testDemoBigO1() {
        System.out.println("demoBigO1");
        long n = 0L;
        DemoBigO instance = new DemoBigO();
        instance.demoBigO1(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of demoBigOLogN method, of class DemoBigO.
     */
    @Test
    public void testDemoBigOLogN() {
        System.out.println("demoBigOLogN");
        long n = 0L;
        DemoBigO instance = new DemoBigO();
        instance.demoBigOLogN(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of demoBigOn method, of class DemoBigO.
     */
    @Test
    public void testDemoBigOn() {
        System.out.println("demoBigOn");
        long n = 0L;
        DemoBigO instance = new DemoBigO();
        instance.demoBigOn(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of demoBigONLogNInit method, of class DemoBigO.
     */
    @Test
    public void testDemoBigONLogNInit() {
        System.out.println("demoBigONLogNInit");
        long n = 0L;
        DemoBigO instance = new DemoBigO();
        instance.demoBigONLogNInit(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of demoBigONLogN method, of class DemoBigO.
     */
    @Test
    public void testDemoBigONLogN() {
        System.out.println("demoBigONLogN");
        long n = 0L;
        DemoBigO instance = new DemoBigO();
        instance.demoBigONLogN(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of demoBigOnn method, of class DemoBigO.
     */
    @Test
    public void testDemoBigOnn() {
        System.out.println("demoBigOnn");
        long n = 0L;
        DemoBigO instance = new DemoBigO();
        instance.demoBigOnn(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
