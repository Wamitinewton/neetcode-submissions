class Solution {
    public int characterReplacement(String s, int k) {
        
        int n = s.length();
        int[] count = new int[26];
        int maxLength = 0;
        int maxFrequency = 0;
        int left = 0;

        for (int right = 0; right<n; right++) {
            int index = s.charAt(right) - 'A';
            count[index]++;

            maxFrequency = Math.max(maxFrequency, count[index]);
            int windowLength = right - left + 1;

            while (windowLength - maxFrequency > k) {
                int leftIndex = s.charAt(left) - 'A';
                count[leftIndex]--;
                left++;

                windowLength = right - left + 1;
            }

            maxLength = Math.max(maxLength, windowLength);
        }

        return maxLength;
    }
}
