package com.example.demo.algorithm.num912_SortArray;

import java.util.Arrays;

/**
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length -1);
        return nums;
    }

    private void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l+(r-l)/2;
        sort(nums, l , mid);
        sort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] tmp = Arrays.copyOf(nums,r+1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = tmp[j];
                j++;
            } else if (j > r) {
                nums[k] = tmp[i];
                i++;
            } else if (tmp[i] > tmp[j]) {
                nums[k] = tmp[j];
                j++;
            } else {
                nums[k] = tmp[i];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};

        int[] ints = new Solution().sortArray(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
