package Leetcode;

public class AddBinary {
    public String addBinary(String a, String b){
        String res = "";
        int m = a.length() - 1, n = b.length() - 1, carry = 0;
        while (m >= 0 || n >= 0) {
            int p = m >= 0 ? a.charAt(m--) - '0' : 0;
            int q = n >= 0 ? b.charAt(n--) - '0' : 0;
            int sum = p + q + carry;
            res = Integer.toString(sum % 2) + res;
            carry = sum / 2;
        }
        return carry == 1 ? "1" + res : res;
    }
}
