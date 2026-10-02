class Solution {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int smallest = 0;

        for (int i = 0; i<n; i++) {
            if(i == 0) {
                smallest = nums[i];
            }
            if (nums[i] < smallest) {
                smallest = nums[i];
            }
        }

        return smallest;
        
    }
}
