package com.example.demo.algorithm.num88_MergeSortedArray;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 *
 * Constraints:
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexM = 0;
        int indexN = 0;
        int index = 0;

        int[] result = new int[nums1.length];
        if (n == 0) {
            return;
        }

        while (index < nums1.length) {
            if (indexN >= n) {
                result[index] = nums1[indexM];
                indexM++;
            } else if (nums2[indexN] <= nums1[indexM] || (nums1[indexM] == 0 && indexM >= m)) {
               result[index] = nums2[indexN];
               indexN++;
            } else {
                result[index] = nums1[indexM];
                if (indexM < m){
                    indexM++;
                }
            }
            index++;
        }
        System.arraycopy(result, 0, nums1, 0, nums1.length);
    }


    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m-1;
        int tail2 = n-1;
        int index = nums1.length - 1;

        while (tail2 != -1 || tail1 != -1) {
            if (tail1 == -1) {
                nums1[index--] = nums2[tail2--];
            }else if (tail2 == -1) {
                nums1[index--] = nums1[tail1--];
            }else {
                nums1[index--] = nums2[tail2] > nums1[tail1] ? nums2[tail2--] : nums1[tail1--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{4,5,6};
        //merge(nums1, 1, nums2, 1);
        merge2(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
