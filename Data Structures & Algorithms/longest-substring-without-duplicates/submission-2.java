class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        boolean[] vis = new boolean[128];
        int right = 0, left = 0;

        if (n == 0 || n == 1) {
            return n;
        }

        while (right < n) {

            // If the character is repeated
            // Move the left pointer to right until
            // All repeating chsr no longer appears

            while (vis[s.charAt(right)] == true) {
                vis[s.charAt(left)] = false;
                left++;
            }

            vis[s.charAt(right)] = true;
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
