package project5;

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
public class ChangePiComputeTest {

    public ChangePiComputeTest() {
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
     * Test of changePi method, of class ChangePiCompute.
     */
    @Test
    public void testChangePi() {
        System.out.println("changePi");
        String str2 = "xpix";
        ChangePiCompute instance = new ChangePiCompute();
        String expResult = "x3.14x";
        String result = instance.changePi(str2);
        assertEquals(expResult, result);

    }
    /**
     * Test of changePi2 method, of class ChangePiCompute.
     */
    @Test
    public void testChangePi2() {
        System.out.println("changePi2");
        String str2 = "pipi";
        ChangePiCompute instance = new ChangePiCompute();
        String expResult = "3.143.14";
        String result = instance.changePi(str2);
        assertEquals(expResult, result);

    }
    /**
     * Test of changePi3 method, of class ChangePiCompute.
     */
    @Test
    public void testChangePi3() {
        System.out.println("changePi3");
        String str2 = "pip";
        ChangePiCompute instance = new ChangePiCompute();
        String expResult = "3.14p";
        String result = instance.changePi(str2);
        assertEquals(expResult, result);

    }
    /**
     * Test of changePi4 method, of class ChangePiCompute.
     */
    @Test
    public void testChangePi4() {
        System.out.println("changePi4");
        String str2 = "";
        ChangePiCompute instance = new ChangePiCompute();
        String expResult = "";
        String result = instance.changePi(str2);
        assertEquals(expResult, result);

    }
}
