package AdvTask2;

import java.util.Arrays;
import java.util.Optional;

public class Parser {
    private int a;
    private int b;
    private Expression expressionObj;
    private Expression.Operator operatorO;

    public Expression parse(String expression, Expression expressionObj) {
        try {
            //Character.isWhitespace () – определяет в Java, является
            // ли указанное значение типа char пустым пространством, которое
            // включает в себя пробел, табуляцию или новую строку.
            //Проходимся по выражению и оставляем все кроме пробелов
            StringBuilder cleanExpression = new StringBuilder();

            for (char c : expression.toCharArray()) {
                if (Character.isWhitespace(c)) {
                    continue;
                }
                cleanExpression.append(c);
            }

            expression = cleanExpression.toString();//выражение без пробелов

            char[] charsOfexpression = expression.toCharArray();

            for (int i = 1; i < charsOfexpression.length; i++) {
                char c = charsOfexpression[i];

                Optional<Expression.Operator> operator = getOperator(c);

                //если c-этьо оператор
                if (operator.isPresent()) {
                    operatorO = operator.get();
                    a = Integer.parseInt(expression.substring(0, i));
                    b = Integer.parseInt(expression.substring(i + 1));
                    return expressionObj = new Expression(a, b, operatorO);
                }
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid:" + expression);
        }
        throw new IllegalArgumentException("Invalid:" + expression);
    }

    //Search for Operator. Если символьное представление оператора(values()) совпадает с char c-значит это оператор
    private Optional<Expression.Operator> getOperator(char c) {
        return Arrays.stream(Expression.Operator.values())  //проходим стримом по всем операторам
                .filter(it -> it.toChar() == c)             //сравниваем с нашим аргументом метода
                .findFirst();
    }
}
