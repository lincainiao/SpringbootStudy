package com.lin;

import org.junit.Test;

import java.io.File;

public class MyTest {
    @Test
    public void test(){
        File file = new File("B:\\FreeTool\\图片\\idea background\\half");
        File[] files = file.listFiles();
        int[] arr = new int[files.length+1];
        int t;
        for (int i = 0; i < files.length * 10000; i++) {
            t = (int) (Math.random()*files.length+1);
            arr[t]++;
        }
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex])
                maxIndex = i;
        }
        System.out.println(files[maxIndex]);
    }
}
