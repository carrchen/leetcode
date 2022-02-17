package com.example.demo.algorithm.num215_KthLargestElementInAnArray;


/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 */
public class Solution {
    public static int findKthLargest(int[] nums, int k) {
        int i = 0;
        for (int i1 = 0; i1 < nums.length; i1++) {
            for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                if (nums[i2] > nums[i1]) {
                    int tmp = nums[i1];
                    nums[i1] = nums[i2];
                    nums[i2] = tmp;
                }
            }
            i++;
            if (i == k) {
                break;
            }
        }
        return nums[k-1];
    }


    public static int findKthLargest2(int[] nums, int k) {
        qSort(nums, 0, nums.length - 1);
        return nums[nums.length - k + 1];
    }

    private static void qSort(int[] nums, int start, int end) {
        //(0, nums.length-1]
        int index = start;
        while (start < end) {
            while (start < end && nums[start] < nums[index]) {
                start++;
            }
            while (start < end && nums[end] > nums[index]) {
                end--;
            }
            swap(nums, start, end);
        }
        if (start < end) {
            swap(nums, index, end);
        }
        qSort(nums, 0, end -1);
        qSort(nums, end + 1, nums.length - 1);
    }

    public int findKthLargest3(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partion(nums, start, end);
            if (pivot < index) start = pivot + 1;
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }

    private int partion(int[] nums, int start, int end) {
        int pivot = start, temp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }

    public static int findKthLargest4(int[] A, int k) {
        k = A.length - k; // convert to index of k largest
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int i = l; // partition [l,r] by A[l]: [l,i]<A[l], [i+1,j)>=A[l]
            for (int j = l + 1; j <= r; j++)
                if (A[j] < A[l]) swap(A, j, ++i);
            swap(A, l, i);

            if (k < i) r = i - 1;
            else if (k > i) l = i + 1;
            else return A[i];
        }
        return -1; // k is invalid
    }

    private static void swap(int[] a, int j, int i) {
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,2,9,1,2,4,5,1,2,7};
        int kthLargest = findKthLargest2(nums1, 2);
        System.out.println(kthLargest);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
