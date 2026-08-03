class Solution {

    private void reverse(char[] c, int start, int end) {
        while (start < end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }

    public String reverseWords(String s) {

        char[] c = s.toCharArray();
        int n = c.length;

        // Step 1: Reverse complete string
        reverse(c, 0, n - 1);

        int i = 0;
        int left = 0;
        int right = 0;

        while (i < n) {

            // Skip extra spaces
            while (i < n && c[i] == ' ')
                i++;

            // Copy current word
            while (i < n && c[i] != ' ')
                c[right++] = c[i++];

            // Reverse copied word
            if (left < right) {

                reverse(c, left, right - 1);

                // Add one space only if there are more words
                if (right < n) {
                    c[right++] = ' ';
                }

                left = right;
            }
        }

        // Remove trailing space if present
        if (right > 0 && c[right - 1] == ' ')
            right--;

        return new String(c, 0, right);
    }
}