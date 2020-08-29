package com.java.effectiveJava.lamdaAndStream.item42;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MethodReferenceExample {
    Map<Integer, Integer> map = new HashMap<>();
    public void multisetExample(){
        //map.merge(key, 1, (count, incr) -> count+ incr);
    }

    public void test(){
        String strVal = "123";
        Function<String, Integer> toInt = val -> Integer.parseInt(val);
        int result = toInt.apply(strVal);
        System.out.println(result);


        Function<String, String> toLowerCase = str -> str.toLowerCase();
        String lowerCaseResult = toLowerCase.apply("QAQAWE");
        System.out.println(lowerCaseResult);

        Instant then = Instant.now();
        Function<Instant, Boolean> instantIsAfter = t ->then.isAfter(t);
        System.out.println(instantIsAfter.apply(Instant.MIN));

        // method reference test
        Function<String, Integer> toInteger_Method_Reference = Integer::parseInt;
        System.out.println( toInteger_Method_Reference.apply(strVal));

        Function<String, String> toLowerCase_method_reference = String::toLowerCase;
        System.out.println(toLowerCase_method_reference.apply("QAQAWE"));

        Function<Instant, Boolean> instantIsAfter_method_reference = Instant.now()::isAfter;
        System.out.println(instantIsAfter_method_reference.apply(Instant.MIN));
    }

    public static void main(String[] args) {
        new MethodReferenceExample().test();
    }
}
