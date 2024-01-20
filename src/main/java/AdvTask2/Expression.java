package AdvTask2;

public class Expression {
    private int a;
    private int b;
    private Operator operator;
    public enum Operator {
        plus("+"),
        minus("-"),
        multiple("*"),
        divide("/");
        private String decodeForHuman;
        Operator(String decodeForHuman) {
            this.decodeForHuman = decodeForHuman;
        }

        @Override
        public String toString() {
            return decodeForHuman;
        }
        //Т.к. оператор-это у нас 1 символ - String decodeForHuman("+" и т.д.);
        public char toChar(){
            return toString().charAt(0);
        }
    }

    public Expression() {
    }

    public Expression(int a, int b, Operator operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Expression{" +
                "a=" + a +
                ", b=" + b +
                ", operator=" + operator +
                '}';
    }
}
