package AdvTask2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Positive cases:
//-259 -  -445     |a=-259 b=-445
//+3   +   5       |a=3    b=5
//2    *  -3       |a=2    b=-3
//-5   -  -4       |a=-5   b=-4
//Negative cases:
//Illegal...

class ParserTest {
    private Parser parser;
    private Expression actualExpression;
    private int expectA;
    private int expectB;
    private String expectOperator;

    @BeforeEach
    public void beforeEach() {
        parser = new Parser();
        actualExpression = new Expression();
    }

    @Test
    public void testMi2Mi4() {
        actualExpression = parser.parse("-259 - -445", actualExpression);
        expectA = actualExpression.getA();
        expectB = actualExpression.getB();
        expectOperator = actualExpression.getOperator().toString();
        Assertions.assertEquals(-259, expectA);
        Assertions.assertEquals(-445, expectB);
        Assertions.assertEquals("-", expectOperator);
    }

    @Test
    public void test3plus5() {
        actualExpression = parser.parse("33 + 5", actualExpression);
        expectA = actualExpression.getA();
        expectB = actualExpression.getB();
        expectOperator = actualExpression.getOperator().toString();
        Assertions.assertEquals(33, expectA);
        Assertions.assertEquals(5, expectB);
        Assertions.assertEquals("+", expectOperator);
    }

    @Test
    public void test4Multiply6() {
        actualExpression = parser.parse("-2 * -3", actualExpression);
        expectA = actualExpression.getA();
        expectB = actualExpression.getB();
        expectOperator = actualExpression.getOperator().toString();
        Assertions.assertEquals(-2, expectA);
        Assertions.assertEquals(-3, expectB);
        Assertions.assertEquals("*", expectOperator);
    }

    @Test
    public void test4Divide6() {
        actualExpression = parser.parse("2 / -3", actualExpression);
        expectA = actualExpression.getA();
        expectB = actualExpression.getB();
        expectOperator = actualExpression.getOperator().toString();
        Assertions.assertEquals(2, expectA);
        Assertions.assertEquals(-3, expectB);
        Assertions.assertEquals("/", expectOperator);
    }

    @Test
    public void testInvalidInput() {
        String[] initInput = {null, "", " ", "8", "8 4", "-", "5+xx", "1---2"};

        for (String invalidInput : initInput) {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> parser.parse(invalidInput,actualExpression),invalidInput
            );
        }
    }
}