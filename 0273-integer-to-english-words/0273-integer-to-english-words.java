class Solution {

    private static final String[] BELOW_20 = {
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] TENS = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] SCALES = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();
        int scale = 0;

        while (num > 0) {

            int group = num % 1000;

            if (group != 0) {
                String part = convert(group);

                if (scale > 0) {
                    part += " " + SCALES[scale];
                }

                result.insert(0, part + " ");
            }

            num /= 1000;
            scale++;
        }

        return result.toString().trim();
    }

    private String convert(int num) {

        if (num < 20) {
            return BELOW_20[num];
        }

        if (num < 100) {
            return TENS[num / 10]
                    + (num % 10 == 0 ? "" : " " + BELOW_20[num % 10]);
        }

        return BELOW_20[num / 100]
                + " Hundred"
                + (num % 100 == 0 ? "" : " " + convert(num % 100));
    }
}

