class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char str[] = s.toCharArray();
        int count = 0;

        while (left < right) {

            if (str[left] != str[right] && count == 0) {
                count++;

                // Try skipping left
                if (check(str, left + 1, right)) {
                    return true;
                }

                // Try skipping right
                if (check(str, left, right - 1)) {
                    return true;
                }

                return false;
            }

            else if (str[left] == str[right]) {
                left++;
                right--;
            }

            else {
                return false;
            }
        }

        return true;
    }

    public boolean check(char str[], int left, int right) {
        while (left < right) {
            if (str[left] != str[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}