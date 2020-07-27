package com.stan.practice.leetcode.sumoftownumbers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 陈云龙
 * @date: 2020/7/27
 * @description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */

public class Solution {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15,};
        int target = 9;

        long startTime = System.currentTimeMillis();   //获取开始时间

        int[] resutl = twoSum(nums, target);
        //伪代码
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        for (int num : resutl) {
            System.out.println(num + ":" + nums[num]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target - nums[i], i);
        }
        // // 双重循环 循环极限为(n^2-n)/2
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = nums.length - 1; j > i; j --){
        //         if(nums[i]+nums[j] == target){
        //            indexs[0] = i;
        //            indexs[1] = j;
        //            return indexs;
        //         }
        //     }
        // }
        return indexs;
    }
}
