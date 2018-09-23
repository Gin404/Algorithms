package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * */
public class Roman2Int {
    public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length(); i++){
            int val = map.get(s.charAt(i));
            if (i == s.length() - 1 || map.get(s.charAt(i+1)) <= map.get(s.charAt(i))) res += val;
            else res -= val;
        }
    return res;
    }
}
