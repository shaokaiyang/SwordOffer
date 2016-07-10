package com.nowcoder.offer.problem38;

import java.util.Arrays;

public class GetNumberOfSortedArray {
	public int getNumberOfK(int[] a, int k) {
		int res = 0;
		if (null == a || a.length <= 0) {
			return 0;
		}
		if (a.length == 1) {
			if (a[0] == k) {
				return 1;
			} else {
				return 0;
			}
		}
		 
		if (k < a[a.length/2]) {
			res += getNumberOfK(Arrays.copyOfRange(a, 0, a.length/2), k);
		} else if (k > a[a.length/2]) {
			res += getNumberOfK(Arrays.copyOfRange(a, a.length/2, a.length), k);
		} else {
			res += getCount(a, a.length/2);
		}
		
		return res;
	}
	
	private int getCount(int[] a, int index) {
		int k = a[index];
		int res = 0;
		
		for (int i = index; i < a.length; i++) {
			if (a[i] == k) {
				res++;
			} else {
				break;
			}
		}
		
		for (int i = index - 1; i >= 0; i--) {
			if (a[i] == k) {
				res++;
			} else {
				break;
			}
		}
		
		return res;
	}
}
