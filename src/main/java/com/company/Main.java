package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[args.length - 1];

        HeapSort heapSort = new HeapSort(arr);
        HeapSort.Statistic statistics = new HeapSort.Statistic();

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
