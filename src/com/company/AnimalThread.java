package com.company;

public class AnimalThread extends Thread {
    String person_Name;
    int priority_Thread;
    final int distance = 11;


    AnimalThread(String person_Name, int priority_Thread) {
        this.person_Name = person_Name;
        this.priority_Thread = priority_Thread;
    }
    public void run() {

        Thread.currentThread().setPriority(priority_Thread);
        Thread.currentThread().setName(person_Name);
        int timeToStep = 1000 / (Thread.currentThread().getPriority());

        for (int i = 0; i < distance; i++) {
            try {
                Thread.sleep(timeToStep);
                System.out.println(getName() + (" - ") + (i * 100) + " м ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == distance / 2) {

                if (Thread.currentThread().getPriority() == 1) {
                    Thread.currentThread().setPriority(10);
                } else {
                    Thread.currentThread().setPriority(1);
                }
                timeToStep = 1000 / (Thread.currentThread().getPriority());
            }



        }
    }
}
