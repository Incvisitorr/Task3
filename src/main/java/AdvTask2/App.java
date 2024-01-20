package AdvTask2;

public class App {
    public static void main(String[] args) {
        Expression expression = new Expression();
        Calculator calculator = new Calculator();
        SumCalculator sumCalculator=new SumCalculator();

        String numOfFinish = "10+15";
        Expression parsedExpression = new Parser().parse(numOfFinish, expression);
        System.out.println(parsedExpression);

        int n = calculator.calculate(parsedExpression);
        System.out.println("N number: "+n);

        int sum=sumCalculator.sum(n);
        System.out.println(sum);
    }
}
