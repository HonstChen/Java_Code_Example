package com.ithema.SortDemo1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class QuickSortDemo1 {
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        /*for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }*/
        //quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }

    }

    public static void quicksort(int[] arr, int i, int j) {
        //两个变量记录要查找的范围
        int start = i;
        int end = j;
        if (start > end) {
            return;
        }
        //记录基准数
        int baseNumeber = arr[i];

        while (start != end) {
            //利用end，从后往前开始找，找到比基准数小的数字
            while (true) {
                if (end <= start || arr[end] < baseNumeber) {
                    break;
                }
                end--;
            }
            //利用start，从前往后找，找比基准数大的数字
            while (true) {
                if (end <= start || arr[start] > baseNumeber) {
                    break;
                }
                start++;
            }
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        int temp = arr[i];
        arr[i] = arr[start];
        arr[start] = temp;
        quicksort(arr, i, start - 1);
        quicksort(arr, start + 1, j);
    }

    public static void quickSort(int[] arr, int i, int j) {
        int start = i;
        int end = j;
        int baseNumber = arr[i];
        if (start > end) {
            return;
        }
        while (start != end) {
            while (true) {
                if (start >= end || arr[end] < baseNumber) {
                    break;
                }
                end--;
            }
            while (true) {
                if (start >= end || arr[start] > baseNumber) {
                    break;
                }
                start++;
            }
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        int temp = arr[i];
        arr[i] = arr[start];
        arr[start] = temp;
        quicksort(arr, i, start - 1);
        quicksort(arr, start + 1, j);
    }
}
