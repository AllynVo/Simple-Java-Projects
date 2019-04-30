/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daysalivebetweendates;

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
public class DaysAliveBetweenDatesFinderTest {

    public DaysAliveBetweenDatesFinderTest() {
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
     * Test of getsDaysBetweenDates method, of class
     * DaysAliveBetweenDatesFinder.
     */
    @Test
    public void testGetsDaysBetweenDates() {
        System.out.println("getsDaysBetweenDates");
        int birthMonth = 4;
        int birthDay = 3;
        int birthYear = 2017;
        int todayMonth = 4;
        int todayDay = 4;
        int todayYear = 2017;
        DaysAliveBetweenDatesFinder instance = new DaysAliveBetweenDatesFinder();
        int expResult = 1;
        int result = instance.getsDaysBetweenDates(birthMonth, birthDay, birthYear, todayMonth, todayDay, todayYear);
        assertEquals(expResult, result);
    }

}
