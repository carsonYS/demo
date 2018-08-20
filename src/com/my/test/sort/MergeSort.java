package com.my.test.sort;

import java.util.Arrays;

public class MergeSort {
	public static void Merge(int[] a, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];// ������ʱ���飬�����洢���������й鲢�������Ԫ��
		int s0 = low;// ��������е���ʼԪ�ؽű�
		int s1 = mid + 1;// �ұ������е���ʼԪ�ؽű�
		int k = 0;// temp������ʼԪ�ؽű�

		while (s0 <= mid && s1 <= high)// �Ƚ������������е�Ԫ�أ�����С��Ԫ�ط���temp�������
		{
			if (a[s0] < a[s1]) {
				temp[k++] = a[s0++];
			} else {
				temp[k++] = a[s1++];
			}
		}

		/**
		 * ����������ѭ���������ǽ�ʣ���Ԫ��ֱ�Ӽ���temp������棬��Ϊ���������п���Ԫ�ز�һ���ֻ࣬��ִ��һ��ѭ��
		 */
		while (s0 <= mid) {
			temp[k++] = a[s0++];
		}

		while (s1 <= high) {
			temp[k++] = a[s1++];
		}

		// ��temp�е�Ԫ�ض�Ӧ����ԭ����
		for (int i = 0; i < temp.length; i++) {
			a[low + i] = temp[i];
		}
	}

	public static void mergeSort(int[] a, int low, int high) {
		if (low >= high)// �ݹ���ֹ����
			return;
		int mid = (low + high) / 2;
		mergeSort(a, low, mid);// ϸ�����������
		mergeSort(a, mid + 1, high);// ϸ���ұ�������
		Merge(a, low, mid, high);// ���Ϲ鲢
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 5, 7, 4, 5, 3, 9, 0 };
		System.out.println(Arrays.toString(a));
		mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
	}
}
