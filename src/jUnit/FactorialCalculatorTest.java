package jUnit;

import org.junit.Assert;
import org.junit.Test;

public class FactorialCalculatorTest {

    FactorialCalculator fc = new FactorialCalculator();

    @Test
    public void negativeTest() {
        Assert.assertEquals(-1, fc.get(-1));
    }

    @Test
    public void testGet0(){
        Assert.assertEquals(1, fc.get(0));
    }

    @Test
    public void testGet1(){
        Assert.assertEquals(1, fc.get(1));
    }

    @Test
    public void testGet2(){
        Assert.assertEquals(2, fc.get(2));
    }

    @Test
    public void testGet3(){
        Assert.assertEquals(6, fc.get(3));
    }

    @Test
    public void testGet4(){
        Assert.assertEquals(24, fc.get(4));
    }

    @Test
    public void testGet5(){
        Assert.assertEquals(120, fc.get(5));
    }
}