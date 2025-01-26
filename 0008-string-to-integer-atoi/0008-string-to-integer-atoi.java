class Solution {
    public int myAtoi(String s) {
        s = s.trim(); // Remove leading/trailing spaces

        int index = 0;
        int sign = 1; // Initialize sign as positive
        long result = 0; // Use long to handle overflow during computation

        // Handle sign
        if (index < s.length() && s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (index < s.length() && s.charAt(index) == '+') {
            sign = 1;
            index++;
        }

        // Process digits
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            result = result * 10 + (s.charAt(index) - '0');

            // Check for overflow/underflow
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            index++;
        }

        return (int) (result * sign);
    }
}
