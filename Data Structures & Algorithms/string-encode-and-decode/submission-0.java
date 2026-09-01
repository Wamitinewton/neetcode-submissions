class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str: strs) {
            encoded.append(str.length());
            encoded.append("#");
            encoded.append(str);
        }

        return encoded.toString();

    }

    public List<String> decode(String str) {

        ArrayList<String> result = new ArrayList<>();

        int i = 0;
        int n = str.length();

        while (i < n) {
            
            int len = 0;

            while (str.charAt(i) != '#') {
                len = len * 10 + (str.charAt(i) - '0');
                i++;
            }

            i++; //Skipping '#' and going to the String

            // Reading the actual String
            String temp = str.substring(i, i + len);
            result.add(temp);
            i += len;
        }

        // Convert Java ArrayList to an Array

        return result;
    }
}
