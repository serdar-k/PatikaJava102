/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.threadtask;

import java.util.ArrayList;

/**
 *
 * @author serdar
 */
public class MyTask extends Thread {

    private ArrayList<Integer> oddNumberList = new ArrayList<>();
    private ArrayList<Integer> evenNumberList = new ArrayList<>();
    private ArrayList<Integer> arrayList;

    public MyTask(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayList<Integer> getOddNumberList() {
        return oddNumberList;
    }

    public void setOddNumberList(ArrayList<Integer> oddNumberList) {
        this.oddNumberList = oddNumberList;
    }

    public ArrayList<Integer> getEvenNumberList() {
        return evenNumberList;
    }

    public void setEvenNumberList(ArrayList<Integer> evenNumberList) {
        this.evenNumberList = evenNumberList;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int number : arrayList) {
                if (number % 2 == 0) {
                    this.evenNumberList.add(number);
                } else {
                    this.oddNumberList.add(number);
                }
            }
        }

    }

}
