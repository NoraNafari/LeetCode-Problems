package fizzBuzz412;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        //test
        List<String> strings01 = fizzBuzz(3);
        for (String s : strings01) {
            System.out.println(s);
        }
    }

    //We should check from 1 to n+1 to see if the number is divisible by 3 and/or 5
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    result.add("FizzBuzz");
                } else {
                    result.add("Fizz");
                }
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add((String.valueOf(i)));
            }
        }
        return result;
    }
}
