package com.company;

import java.util.Arrays;

public class HeapSort {
    private final int[] arr;
    private SortOrder order = SortOrder.ASCENDING;
    private double exTime;
    private long swaps = 0;
    private long comparisons = 0;
    private int[] arrSorted;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    public void setOrder(SortOrder order) {
        this.order = order;
    }

    public int[] getArrSorted() {
        return arrSorted;
    }

    public int[] check () {

        if (order == SortOrder.ASCENDING) {
            for (int i = 1; i < arr.length; i++)
            {
                if (arr[i - 1] > arr[i]) {
                    heapSort();
                    break;
                }
                comparisons++;
            }

        } else {
            for (int i = 1; i < arr.length; i++)
            {
                if (arr[i - 1] < arr[i]) {
                    heapSort();
                    break;
                }
                comparisons++;
            }

        }
        return arr;
    }

    private void heapSort() {
        long startTime = System.nanoTime();
        down(0, arr.length);

        for (int i = arr.length / 2 - 1 ; i >= 0; i--) {
            down(i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            swap(0, i);
            down(0, i);
        }
        long endTime = System.nanoTime();
        comparisons -= arr.length;
        exTime = (endTime - startTime) / (double) 1000000;
    }

    private void down(int root, int size) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int x = root;

        if (order == SortOrder.ASCENDING) {
            if (left < size && arr[x] < arr[left]) {
                x = left;
                comparisons++;
            }

            if (right < size && arr[x] < arr[right]) {
                x = right;
                comparisons++;
            }
        } else {
            if (left < size && arr[x] > arr[left]){
                x = left;
                comparisons++;
            }
            if (right < size && arr[x] > arr[right]) {
                x = right;
                comparisons++;
            }
        }

        if (x == root)
            return;
        comparisons++;
        swap(x, root);
        down(x, size);
    }

    private void swap(int a, int b) {
        int x = arr[a];
        arr[a] = arr[b];
        arr[b] = x;
        swaps++;
    }

    @Override
    public String toString() {
        return "HeapSort: \n" +
                "Execution time: " + exTime + "\n" +
                "Comparisons " + comparisons + "\n" +
                "Swaps " + swaps + "\n" +
                "Result " + Arrays.toString(arr);
    }

    public static void main(String[] args) {
        int[] arr = new int[args.length - 1];

        HeapSort heapSort = new HeapSort(arr);

        for (int i = 1; i < args.length; i++) {
            arr[i - 1] = Integer.parseInt(args[i]);
        }

        if (args[0].equals("ASC")) {
            heapSort.setOrder(SortOrder.ASCENDING);
        }

        heapSort.check();

        System.out.println(heapSort);
    }
}

