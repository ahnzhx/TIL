package com.java.effectiveJava.lamdaAndStream.item47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class AdapterMethod {
    public static <E> Iterable<E> iterableOf(Stream<E> stream){
        return stream::iterator;
    }

    public static <E> Stream<E> streamOf(Iterable<E> iterable){
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    public static void main(String[] args) {
        for(ProcessHandle p : iterableOf(ProcessHandle.allProcesses())){
            //프로세스를 처리한다.
        }
    }
}
