package org.lanqiao.algo.elementary.datastructure;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 有效的括号 {
    public boolean isValid(String s) {
        if (s == null) {
            // 如果输入字符为空没有必要继续下去，直接返回false
            return false;
        }
        int len = s.length();
        if (len % 2 != 0) {
            // 如果长度为奇数，必然至少有一个括号没有匹配
            return false;
        }
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char current = s.charAt(i);
            if (pairs.containsKey(current)) {
                // 如果栈已经为空了，说明右括号比左括号多，不匹配，直接返回false
                // 当第一次出现右括号的时候， 栈顶元素必然为左括号，不然不匹配，直接返回false
                if (stack.isEmpty() || stack.peek() != pairs.get(current)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(current);
            }
        }
        // 如果最后栈不为空，说明左括号多于右括号，不匹配，返回false
        return stack.isEmpty();
    }
}
