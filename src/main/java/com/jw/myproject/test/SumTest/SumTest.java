package com.jw.myproject.test.SumTest;

public class SumTest {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 0, -3, -4, 5, -6, -7};
//        int max = maxSubArray(nums);
//        System.out.println(max);


    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int frist, second, max;
        max = frist = nums[0];
        for (int i = 1; i < nums.length; i++) {
            second = (nums[i] + frist > nums[i] ? nums[i] + frist : nums[i]);
            max = Math.max(max, second);
            frist = second;
        }
        return max;
    }


}
