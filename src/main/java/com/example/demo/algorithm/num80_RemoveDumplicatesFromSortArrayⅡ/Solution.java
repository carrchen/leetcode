package com.example.demo.algorithm.num80_RemoveDumplicatesFromSortArrayⅡ;

public class Solution {
    public static int removeDuplicates(int[] nums) {

        // 2,2,2,2,2,3,3,3,4,4,4,4,4
        // 2,2,3,2,2,2,3,3,4,4,4,4,4
        int k = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                if (count < 2) {
                    count++;
                    nums[k++] = nums[i];
                }
            }else {
                nums[k++] = nums[i];
                count = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        return k;
    }

    private static int swap(int[] nums, int k, int i) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
        return k;
    }


    /**
     * nice solution
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 3 || n > nums[i - 3])
                nums[i++] = n;

        System.out.println();
        for (int num : nums) {
            System.out.print(num + " ");
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,2,2,2,2,3,3,3,3,4,4,4,5,6,6,7,7,7,7,7};
        //removeDuplicates(nums);
        removeDuplicates2(nums);
    }
}
