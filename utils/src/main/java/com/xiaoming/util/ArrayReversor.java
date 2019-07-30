package com.xiaoming.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Xiaoming.
 * Created with IntelliJ IDEA on 2018/02/21 23:46.
 * Description :
 */
public class ArrayReversor {
    public static int[] reverse(int[] a){
        if (a == null){
            throw new NullPointerException();
        }

        ArrayList<Integer> list = new ArrayList<>(a.length);
        for(Integer e: a){
            list.add(e);
        }
        Collections.reverse(list);
        //list.toArray(a);
        Object[] t = list.toArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (int)t[i];
        }
        return a;
    }

    public static int[] sortAndReverse(int[] a){
        Arrays.sort(a);
        return reverse(a);
    }
}
