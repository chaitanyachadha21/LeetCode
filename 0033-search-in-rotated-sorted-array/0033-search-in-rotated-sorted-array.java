class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2; // Avoids overflow

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1; // Search in the left half
                } else {
                    l = mid + 1; // Search in the right half
                }
            } 
            // Right half must be sorted
            else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1; // Search in the right half
                } else {
                    r = mid - 1; // Search in the left half
                }
            }
        }

        return -1; // Element not found
    }
}
