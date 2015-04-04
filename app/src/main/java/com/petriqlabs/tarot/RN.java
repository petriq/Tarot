package com.petriqlabs.tarot;

/**
 * Roman numbers converter.
 * Created by Peter on 4. 4. 2015.
 */
public class RN {

    enum Numeral {
        I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);
        int weight;

        Numeral(int weight) {
            this.weight = weight;
        }
    };

    /**
     * Converts natural number to Roman number representation
     * @param n Arabic natural number to be converted to Roman number. Non negative number, accepts 0 (zero).
     * @return String. Roman representation of Arabic natural number. When input is 0 (zero), result is "0".
     * @throws IllegalArgumentException when input argument is negative number.
     */
    public static String toRoman(long n) {
        if(n == 0)
        {
            return "0";
        }
        else if( n < 0) {
            throw new IllegalArgumentException();
        }

        StringBuilder buf = new StringBuilder();
        final Numeral[] values = Numeral.values();

        for (int i = values.length - 1; i >= 0; i--) {
            while (n >= values[i].weight) {
                buf.append(values[i]);
                n -= values[i].weight;
            }
        }
        return buf.toString();
    }
}
