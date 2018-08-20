package com.my.test.sort;

import java.util.Arrays;

public class HeapSort {
	
	/**
     * ���������ɶ�����
     * �ȹ���һ������
     * �������е�һ��Ԫ�غ����һ��������
     * �ѵĳ��ȼ�һ
     * �ڴӵ�һ��λ�ÿ�ʼ��֤�ѵ����ʵ���Max_heapify()������
     * ������֤Ŀǰ����Ԫ������������λ�á�
     * �Դ����ƣ�ֱ�����һ��Ԫ�ء�
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
     * �����������������
     * A:�����������
     * ��forѭ����i��ֵ�����鳤�ȵ�һ�㿪ʼȡ������Ϊ��ȫ�����������ʣ�
     * һ��Ľڵ�Ҷ���ڵ����Դ�Ҷ�ڵ㿪ʼ���ϱ�������֤�ѵ����ʣ�
     */
    public static void buildMaxHeap(int[] a) {
        for (int i = a.length/2; i >= 0; i--) {
        	maxHeapify(a, i, a.length);
        }
    }

    /**�����������ά���ѵ����ʣ�
     * ��֤�����Ϊi��Ԫ��Ϊ���ڵ�������У����ڵ��ֵ�����亢�ӽڵ��ֵ��
     * A:����������
     * i��������A�е����
     * heap_size:�ѵĴ�С
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
