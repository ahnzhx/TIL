package com.java.effectiveJava.lamdaAndStream.item46;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamParadigm {

    void bad_example_of_stream(){
        Map<String, Long> freq = new HashMap<>();
        try(Stream<String> words = new Scanner(file).tokens()){
            words.forEach(word ->{
                freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
        }
    }

    void good_example_of_stream(){
        Map<String, Long> freq;
        try(Stream<String> words = new Scanner(file).tokens()){
            freq = words.collect(groupingBy(String::toLowerCase, counting()));
        }

        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    List<String> frequently_used_words(){

    }
}
