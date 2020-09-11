package com.java.effectiveJava.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolExample extends RecursiveAction {

    private long workLoad = 0;

    public ForkJoinPoolExample(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {
        if(this.workLoad > 16){
            System.out.println("splitting workLoad : " + this.workLoad);

            List<ForkJoinPoolExample> subtasks = new ArrayList<>();
            subtasks.addAll(createSubtasks());

            for (ForkJoinPoolExample subtask: subtasks){
                subtask.fork();
            }
        }else{
            System.out.println("doing workLoad myself : " + this.workLoad);
        }
    }

    private List<ForkJoinPoolExample> createSubtasks() {
        List<ForkJoinPoolExample> subtasks = new ArrayList<>();
        ForkJoinPoolExample subtask1 = new ForkJoinPoolExample(this.workLoad/2);
        ForkJoinPoolExample subtask2 = new ForkJoinPoolExample(this.workLoad/2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }
}
