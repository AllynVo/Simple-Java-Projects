//Allyn Vo
//April 25, 2017
//CS 301
//Project4 test
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
public class Project4Test {
    
    public Project4Test() {
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
     * Test of main method, of class Project4.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Project4.main(args);

    }

    /**
     * Test of run method, of class Project4.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Project4 instance = new Project4();
        instance.run();

    }
    
}
