package com.lin;

import org.junit.jupiter.api.Test;

import java.io.File;

public class MyTest {
    @Test
    public void getPic(){
        File file = new File("B:\\FreeTool\\Pic\\idea background\\half");
        File[] files = file.listFiles();
        int[] arr = new int[files.length+1];
        int t = 0;
        for (int i = 0; i < files.length * 1000; i++) {
            t = (int) (Math.random()*files.length+1);
            arr[t]++;
        }
        int maxIndex = 1;
        for (int i = 2; i < arr.length; i++) {
            maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
        }
        System.out.println(files[maxIndex].getName());
    }
}
