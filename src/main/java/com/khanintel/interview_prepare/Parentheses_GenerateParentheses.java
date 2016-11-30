package com.khanintel.interview_prepare;

/**
 * 问题
 *       https://leetcode.com/problems/generate-parentheses/
         Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

         For example, given n = 3, a solution set is:

         [
         "((()))",
         "(()())",
         "(())()",
         "()(())",
         "()()()"
         ]
 *
 *
 * 思路
 *      1. 我们已经知道如何判断一堆括号是否是有效的了
 *      2. 换成简单的办法，生成所有可能的排列组合，然后用之前的 ValidParentheses 工具来筛选
 *      3. 那么，就是生成一堆喽
 *          思路1：左括号 0 ，右括号 1，把一个 2n 位的所有二进制数进行筛选，找到有 n 个 0，n 个 1 的。
 *              （对数字不停的做移位，然后获取最后一位，然后相加，就是有几个 1 的意思了。）（或者采用其他的方法，来数有几个 1 就行）
 *          思路2：一次放一个括号，求出所有排列组合。这个用到了迭代
 *
 * 另一套处理方法（这个用到了迭代）
 *      就是一次放一对括号，左半拉的在左边，右半拉的在右边，一次放一对括号，直到放完。
 *      这个思路有一个好处，就是如果我既要放（），又要放【】，甚至放{}，都可以用这套方法。
 *      但是，可能会出现重复，那么要用 set 来把最后的结果进行 unique
 *      Done
 *
 * 还有一套处理办法（这个用到了迭代）
 *      就是认认真真的放
 *
 *      1. 检查，如果用完了 ），则终止
 *      2. 检查，如果用完了（，则剩下的就是放 ），那么把剩下的 ）放进来，本次运算结束
 *      3. 检查栈的大小
 *          3.1 如果是 0， 则必须放 （
 *          3.2 如果大于 0，则可以放 （，也可以放 ）。
 *          每次放完，记录当前放的所有状态，以及剩余的（、）数量，丢给自己，进行迭代。
 *
 * 写了一对思路，先不写代码了 :)
 *
 *
 */
public class Parentheses_GenerateParentheses {
}
