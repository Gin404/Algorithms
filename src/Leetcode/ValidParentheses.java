package Leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。*/
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.length() == 0){
            return true;
        }

        for (int i = 0; i < s.length(); i++){
            if (stack.empty()){
                stack.push(s.charAt(i));
            }else if (stack.peek() == '{' && s.charAt(i) == '}' ||
                      stack.peek() == '[' && s.charAt(i) == ']' ||
                      stack.peek() == '(' && s.charAt(i) == ')' ){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }

        return stack.empty();
    }
}
