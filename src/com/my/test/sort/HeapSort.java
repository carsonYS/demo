package com.my.test.sort;

import java.util.Arrays;

public class HeapSort {
	
	/**
     * 这个函数完成堆排序
     * 先构建一个最大堆
     * 将数组中第一个元素和最后一个交换，
     * 堆的长度减一
     * 在从第一个位置开始保证堆的性质调用Max_heapify()函数。
     * 这样保证目前最大的元素在数组的最后位置。
     * 以此类推，直到最后一个元素。
     */
	public static void heapSort(int[] a) {
        buildMaxHeap(a);
        for (int i = a.length - 1; i >= 1; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            maxHeapify(a, 0, i);
        }
    }

	/**
     * 这个函数用来构建堆
     * A:待排序的数组
     * （for循环中i的值从数组长度的一般开始取，是因为完全二叉树的性质，
     * 一半的节点叶根节点所以从叶节点开始向上遍历来保证堆的性质）
     */
    public static void buildMaxHeap(int[] a) {
        for (int i = a.length/2; i >= 0; i--) {
        	maxHeapify(a, i, a.length);
        }
    }

    /**这个函数用来维护堆的性质，
     * 保证以序号为i的元素为根节点的子树中，父节点的值大于其孩子节点的值。
     * A:待排序数组
     * i：在数组A中的序号
     * heap_size:堆的大小
     */
    public static void maxHeapify(int[] a, int i, int heapSize) {
        int largest = i;
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        if (l < heapSize && a[l] > a[i]) largest = l;
        if (r < heapSize && a[r] > a[largest]) largest = r;
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            maxHeapify(a, largest, heapSize);
        }
    }

    public static void main(String[] args) throws Exception {
    	int[] a = { 1, 2, 4, 5, 7, 4, 5, 3, 9, 0 };
		System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
