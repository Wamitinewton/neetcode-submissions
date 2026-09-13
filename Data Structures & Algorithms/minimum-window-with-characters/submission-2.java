class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> required = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int have = 0;
        int need = required.size();
        int bestLength = Integer.MAX_VALUE;
        int bestLeft = 0;

        // Start with creating the window
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Add to Window frequency
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (required.containsKey(c) && window.get(c).equals(required.get(c))) {
                have++;
            }

            // If window is Valid
            while (have == need) {
                int currentLength = right - left + 1;
                if (currentLength < bestLength) {
                    bestLength = currentLength;
                    bestLeft = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (required.containsKey(leftChar)
                    && window.get(leftChar) < required.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }
        if (bestLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(bestLeft, bestLeft + bestLength);
    }
}
