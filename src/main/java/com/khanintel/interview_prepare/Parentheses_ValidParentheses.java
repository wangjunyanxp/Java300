package com.khanintel.interview_prepare;

/**
 * 问题
 *      https://leetcode.com/problems/valid-parentheses/
 *      Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
        The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
        Subscribe to see which companies asked this question
 *
 *
 * 解决方法
 * 用 stack
 *
 * 遇到左半拉括号，压栈，遇到右半拉括号，和栈顶对比下，如果和栈顶不是一对，那么直接终止程序。如果是一对，则把栈顶 pop 出来
 * 一直到把所有括号都压到栈里进行处理，最后检查栈的长度，如果不是0，还是有问题。
 *
 * 代码先不写了 :)
 *
 */
public class Parentheses_ValidParentheses {
}
