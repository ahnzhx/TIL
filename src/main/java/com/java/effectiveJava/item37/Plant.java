package com.java.effectiveJava.item37;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle){
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    private static Plant[] garden = getPlants();

    @Override
    public String toString() {
        return name;
    }

    static void using_ordinal_as_array_index(){
        Plant[] garden = getPlants();
        Set<Plant>[] plantsByLifeCycle =
                (Set<Plant>[]) new Set[LifeCycle.values().length];

        for(int i =0; i < plantsByLifeCycle.length; i++)
            plantsByLifeCycle[i] = new HashSet<>();

        for(Plant p : garden)
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);

        //결과 출력 (이렇게 나오는 것도 신기함)
        for(int i =0; i<plantsByLifeCycle.length; i++)
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);

    }

    static void enumMapTest(){

        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);

        for(Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());

        for(Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);

        System.out.println(plantsByLifeCycle);
    }

    static void using_stream_to_make_map(){

        Map<LifeCycle, List<Plant>> collect =
                Arrays.stream(garden).collect(groupingBy(p -> p.lifeCycle));
    }

    static void using_stream_to_make_enumMap(){
        EnumMap<LifeCycle, Set<Plant>> collect =
                Arrays.stream(garden).collect(
                        groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(LifeCycle.class),
                        toSet()));

    }

    private static Plant[] getPlants() {
        return new Plant[]{
                    new Plant("A", LifeCycle.ANNUAL),
                    new Plant("B", LifeCycle.BIENNIAL),
                    new Plant("C", LifeCycle.PERENNIAL),
                    new Plant("D", LifeCycle.BIENNIAL),
                    new Plant("E", LifeCycle.PERENNIAL)
            };
    }

    public static void main(String[] args) {
        //enumMapTest();
        //using_ordinal_as_array_index();
        using_stream_to_make_map();
    }
}
