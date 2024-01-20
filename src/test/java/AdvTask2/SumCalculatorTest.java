package AdvTask2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumCalculatorTest {
    private SumCalculator sumCalculator;
    int result;
    @BeforeEach
    public void beforeEach(){
        sumCalculator=new SumCalculator();
    }
    @Test
    public void sum1(){
        result=sumCalculator.sum(1);
        Assertions.assertEquals(1,result);
    }
    @Test
    public void sum3(){
        result=sumCalculator.sum(3);
        Assertions.assertEquals(6,result);
    }
    @Test
    public void sum0(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->sumCalculator.sum(0));
    }

}