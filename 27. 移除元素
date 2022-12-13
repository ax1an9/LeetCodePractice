// https://leetcode.cn/problems/remove-element/
class Solution {
    public int removeElement(int[] nums, int val) {
        int size=nums.length;
        int slow=0;//慢指针，对应新数组的下标
        for(int i=0;i<nums.length;i++){//i 快指针，对应当前数组遍历的位置
            if(nums[i]!=val){//如果不是val，那么直接替换到结果数组的对应位置
                nums[slow]=nums[i];
                slow++;
            }else{//是val ，结果数组size-1
                size--;
            }
        }
        return size;
    }
}
// 时间复杂度 O（n）
// 空间复杂度 O（1）
// 执行用时：
// 0 ms
// , 在所有 Java 提交中击败了
// 100.00%
// 的用户
// 内存消耗：
// 40.6 MB
// , 在所有 Java 提交中击败了
// 5.02%
// 的用户
