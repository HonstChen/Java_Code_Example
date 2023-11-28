package com.ithema.tcpdemo1;

import java.util.ArrayList;

public class LeetCode {
    class NumArray {
        int[] list;
        int[] presum;

        public NumArray(int[] nums) {
            list = nums;
            //定义前缀和，方便计算区间内的和
            presum = new int[nums.length + 2];
            presum[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                presum[i] = presum[i - 1] + nums[i - 1];
            }
            presum[list.length+1]=0;//计算偏差值
        }

        public void update(int index, int val) {
            int dis=list[index]-val;
            list[index] = val;
            for (int i = index + 1; i <= list.length; i++) {
                presum[i] = presum[i - 1] + list[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return presum[right+1] - presum[left];
        }
    }
    class NumArray1 {
        int[] nums; // 原始数组
        int[] bit;  // 树状数组

        public NumArray1(int[] nums) {
            this.nums = nums; // 初始化原始数组
            bit = new int[nums.length + 1]; // 初始化树状数组
            for (int i = 0; i < nums.length; i++) {
                init(i, nums[i]); // 使用原始数组初始化树状数组
            }
        }

        // 初始化树状数组
        public void init(int i, int val) {
            i++;
            while (i < bit.length) {
                bit[i] += val; // 更新树状数组中对应位置的值
                i += i & -i; // 更新下一个需要更新的位置
            }
        }

        // 更新原始数组中的值
        public void update(int index, int val) {
            int diff = val - nums[index]; // 计算值的变化量
            nums[index] = val; // 更新原始数组中的值
            init(index, diff); // 更新树状数组中对应位置及其后续位置的值
        }

        // 查询树状数组中指定位置的前缀和
        public int query(int i) {
            i++;
            int sum = 0;
            while (i > 0) {
                sum += bit[i]; // 累加前缀和
                i -= i & -i; // 移动到前一个需要查询的位置
            }
            return sum;
        }

        // 计算原始数组中指定区间的和
        public int sumRange(int left, int right) {
            return query(right) - query(left - 1); // 通过查询树状数组实现区间和的计算
        }
    }
}
