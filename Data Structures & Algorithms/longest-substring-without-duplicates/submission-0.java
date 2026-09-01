class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Naive Solution

        int n = s.length();
        int res = 0;

        if (n == 0 || n == 1) {
            return s.length();
        }

        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[26];

            for (int j = i; j < n; j++) {
                // If Current Character has been seen
                // Break the loop

                if (vis[s.charAt(j) - 'a'] == true) {
                    break;
                } else {
                    res = Math.max(res, j - i + 1);
                    vis[s.charAt(j) - 'a'] = true;
                }
            }
        }

        return res;
    }
}
