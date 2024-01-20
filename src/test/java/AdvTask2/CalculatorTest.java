package AdvTask2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Expression expression;
    private Calculator calculator;

    @BeforeEach
    public void beforeEach() {
        expression = new Expression();
        calculator=new Calculator();
    }

    @Test
    public void testPlusCorrect() {
        expression = new Expression(5, 5, Expression.Operator.plus);
        Assertions.assertEquals(10, calculator.calculate(expression));
    }
    @Test
    public void testMinusCorrect() {
        expression = new Expression(5, 5, Expression.Operator.minus);
        Assertions.assertEquals(0, calculator.calculate(expression));
    }
    @Test
    public void testMultiCorrect() {
        expression = new Expression(5, 5, Expression.Operator.multiple);
        Assertions.assertEquals(25, calculator.calculate(expression));
    }
    @Test
    public void testDivideCorrect() {
        expression = new Expression(5, 5, Expression.Operator.divide);
        Assertions.assertEquals(1, calculator.calculate(expression));
    }
    @Test
    public void testInvalidInput() {
        Expression[] initInput = {null,new Expression(),new Expression(6,0, Expression.Operator.divide)};

        for (Expression invalidInput : initInput) {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> calculator.calculate(invalidInput),invalidInput+""
            );
        }
    }

}