class Solution {
    public boolean isValid(String s) {
        // Using Brute Force Approach

        StringBuilder str = new StringBuilder(s);

        while (str.length() > 0) {
            boolean found = false;

            for (int i = 0; i < str.length() - 1; i++) {
                char firstChar = str.charAt(i);
                char secondChar = str.charAt(i + 1);

                if ((firstChar == '(' && secondChar == ')')
                    || (firstChar == '{' && secondChar == '}')
                    || (firstChar == '[' && secondChar == ']')) {
                        str.delete(i, i+2);
                        found = true;
                        break;
                    }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }
}
