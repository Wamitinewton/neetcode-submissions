class Solution {
    public int characterReplacement(String s, int k) {
        // Naive Approach
        int n = s.length();

        int maxLength = 0;

        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                // We now want to count the frequency
                // Of each element in the current substring
                int[] count = new int[26];
                // We have 26 Uppercase letters from A-Z
                // So we initialize an empty array of size 26
                // With Initial values of count[0, 0, 0, .......0]

                for (int i = left; i <= right; i++) {
                    // For a substring eg AAABA, left starts at A = index 0
                    // And right is A = index 4, so at B we need to add +1
                    // To reach total 5 elements, hence i<=right...
                    count[s.charAt(i) - 'A']++;
                }

                for (int frequency : count) {
                    // Storing the maxFrequency of elements in current substring.
                    // Eg in AAABA, A = 4 and B = 1.
                    // So max frequency becomes 4
                    int maxFrequency = 0;
                    maxFrequency = Math.max(maxFrequency, frequency);

                    // To note.... Max number of replacements is
                    // current window length - maxFrequency.
                    // Eg in AAABA, we need to replace B to get all A's
                    // So = windowLength(right - left + 1) - maxFrequency
                    int windowLength = right - left + 1;
                    int replacements = windowLength - maxFrequency;
                    if (replacements <= k) {
                        maxLength = Math.max(maxLength, windowLength);
                    }
                }
            }
        }

        return maxLength;
    }
}
