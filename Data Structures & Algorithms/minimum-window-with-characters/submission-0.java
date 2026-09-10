class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        // What Characters are required?
        // Store them in a Map

        Map<Character, Integer> required = new HashMap<>();
        // Count the frequency of chars
        for (char c : t.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }

        String best = "";

               // Try Every possible Starting position....
               // Basically creating every possible substring
            for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                // Create Substring using right and Left Indices
                String candidate = s.substring(left, right + 1);

                // Does this candidate meet requirements?
                // Every character in required must be equal or greater in the current
                // Substring frequency to be eligible

                // Using our helper fx
                if (isEligible(candidate, required)) {
                    if (best.isEmpty() || candidate.length() < best.length()) {
                        best = candidate;
                    }
                }
            }
        }

        return best;
    }
}

// Helper Function to check eligibility --  return boolean

private boolean isEligible(String candidate, Map<Character, Integer> required) {
    // Count frequency of each character
    // In Current Substring
    Map<Character, Integer> current = new HashMap<>();

    // Count the frequencies
    for (char c : candidate.toCharArray()) {
        current.put(c, current.getOrDefault(c, 0) + 1);
    }

    // Check if our substring candidate meets requirements

    for (Map.Entry<Character, Integer> entry : required.entrySet()) {
        // Get each character of required substring
        char character = entry.getKey();
        // Get character frequency of required substring
        int requiredCount = entry.getValue();
        // Current substring character freq
        int currentCount = current.getOrDefault(character, 0);

        // If current count is less than required....Its out
        if (currentCount < requiredCount) {
            return false;
        }
    }

    // Otherwise return true
    return true;
}
