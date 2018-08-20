package com.my.test.sort;

import java.util.Arrays;

public class MergeSort {
	public static void Merge(int[] a, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];// 开辟临时数组，用来存储两个子序列归并后的所有元素
		int s0 = low;// 左边子序列的起始元素脚标
		int s1 = mid + 1;// 右边子序列的起始元素脚标
		int k = 0;// temp数组起始元素脚标

		while (s0 <= mid && s1 <= high)// 比较两个子序列中的元素，将较小的元素放在temp数组左侧
		{
			if (a[s0] < a[s1]) {
				temp[k++] = a[s0++];
			} else {
				temp[k++] = a[s1++];
			}
		}

		/**
		 * 接下来两个循环的作用是将剩余的元素直接加在temp数组后面，因为连个子序列可能元素不一样多，只会执行一个循环
		 */
		while (s0 <= mid) {
			temp[k++] = a[s0++];
		}

		while (s1 <= high) {
			temp[k++] = a[s1++];
		}

		// 将temp中的元素对应赋予原数组
		for (int i = 0; i < temp.length; i++) {
			a[low + i] = temp[i];
		}
	}

	public static void mergeSort(int[] a, int low, int high) {
		if (low >= high)// 递归终止条件
			return;
		int mid = (low + high) / 2;
		mergeSort(a, low, mid);// 细分左边子序列
		mergeSort(a, mid + 1, high);// 细分右边子序列
		Merge(a, low, mid, high);// 向上归并
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 5, 7, 4, 5, 3, 9, 0 };
		System.out.println(Arrays.toString(a));
		mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
	}
}
