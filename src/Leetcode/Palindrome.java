package Leetcode;

public class Palindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()){
            return true;
        }
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) > 47 && s.charAt(i) < 58){
                str.append(s.charAt(i));
            }else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                char c = (char) (s.charAt(i) + 32);
                str.append(c);
            }
        }

        for (int i = 0; i < str.length()/2; i++){
            if (str.charAt(i) != str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
