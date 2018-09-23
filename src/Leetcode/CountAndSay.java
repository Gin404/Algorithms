package Leetcode;

public class CountAndSay {
    public String countAndSay(int n) {
        StringBuffer current = new StringBuffer("1");
        StringBuffer result = new StringBuffer();
        if (n == 1){
            return current.toString();
        }
        for (int i = 1; i < n; i++){
            for (int j = 0; j < current.length();){
                int count = 1;
                char dup = current.charAt(j);
                while (j+1 < current.length() && current.charAt(j+1) == dup){
                    j++;
                    count++;
                }

                result.append(count);
                result.append(dup);
                j++;
            }

            current = new StringBuffer(result);
            result.delete(0, result.length());
        }
        return current.toString();
    }
}
