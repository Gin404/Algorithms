package Leetcode;
/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。*/
public class LgestComPref {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }

        if (strs.length == 1){
            return strs[0];
        }

        int p = 0;
        boolean find = false;
        while (true) {
            //abc, abcd, abc
            for (int i = 0; i < strs.length - 1; i++) {

                if (p >= strs[i].length() ||
                        p >= strs[i + 1].length() ||
                        strs[i].charAt(p) != strs[i + 1].charAt(p)) {
                    find = true;
                    break;
                }
            }
            if (find == true){
                break;
            }
            p++;
        }

        if (p == 0){
            return "";
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int j = 0; j < p; j++){
            stringBuffer.append(strs[0].charAt(j));
        }

        return stringBuffer.toString();
    }
}
