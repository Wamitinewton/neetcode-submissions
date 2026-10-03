class Solution {
    public int search(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // If Left half is sorted
            if (nums[low] <= nums[mid]) {
                // If Target belongs anywhere within
                // Left Sorted Half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    // Belongs to right sorted half
                    low = mid + 1;
                }
            } else {
                // If Right Half is sorted
                // Target is within the sorted
                // Right half

                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
