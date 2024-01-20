package AdvTask2;

public class SumCalculator {

//    public static void zeroValue(int value) throws IllegalArgumentException {
//        if (value == 0) {
//            throw new IllegalArgumentException("Значение должно быть больше нуля");
//        }
//    }

    public int sum(int n) {
        if (n == 0) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException iae) {
                throw new IllegalArgumentException();
            }
        }
            int result = 0;
            int count = 0;
            while (count < n+1) {
                result += count;
                count++;
        }
        return result;
    }
}



