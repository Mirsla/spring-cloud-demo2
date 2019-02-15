package com.mirsla.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Mirsla
 * @descripTion:
 * @date: Created in  9:46 2019/2/15
 * @modified By:
 */
public class Test1 {
    static class Inner {
        static int paramOne = 5;
        static final int paramTwo = 5;
        static final int paramThree = new Integer(5);
    }

    public static void main(String[] args) {
//        System.out.println(Inner.paramOne);
//        System.out.println(Inner.paramTwo);
//        System.out.println(Inner.paramThree);


//        int j = 0;
//        for(int i=0; i< 100; i++) {
//            j = j++;
//        }
//        System.out.println(j);

        // 数组
        int[] test =  new int[]{1,2,3,4};
        List<int[]> ints = Arrays.asList(test);
        System.out.println(ints.size());

    }
}
