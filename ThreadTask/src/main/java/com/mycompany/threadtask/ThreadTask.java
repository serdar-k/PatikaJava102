/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.threadtask;

import java.util.ArrayList;

/**
 *
 * @author serdar
 */
public class ThreadTask {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> numberList = new ArrayList<>();
        ArrayList<Integer> firstQuarterList = new ArrayList<>();
        ArrayList<Integer> secondQuarterList = new ArrayList<>();
        ArrayList<Integer> thirdQuarterList = new ArrayList<>();
        ArrayList<Integer> fourthQuaterList = new ArrayList<>();
        
        int firstLimit = 0, secondLimit = 0, thirdLimit = 0, fourthLimit = 0;

        for (int i = 1; i <= 10000; i++) {
            if (i <= 2500) {
                firstQuarterList.add(i);
            } else if (i > 2500 && i <= 5000) {
                secondQuarterList.add(i);
            } else if (i > 5000 && i <= 7500) {
                thirdQuarterList.add(i);
            } else if (i > 7500 && i <= 10000) {
                firstQuarterList.add(i);
            }
        }

        MyTask myTask1 = new MyTask(firstQuarterList);
        MyTask myTask2 = new MyTask(secondQuarterList);
        MyTask myTask3 = new MyTask(thirdQuarterList);
        MyTask myTask4 = new MyTask(fourthQuaterList);

        myTask1.start();

        myTask2.start();

        myTask3.start();

        myTask4.start();

        try {
            myTask1.join();
            myTask2.join();
            myTask3.join();
            myTask4.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println(myTask1.getEvenNumberList().size());
        System.out.println(myTask1.getOddNumberList().size());
        
        System.out.println(myTask1.getOddNumberList());


    }
}
