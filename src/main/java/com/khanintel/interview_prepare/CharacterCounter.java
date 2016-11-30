package com.khanintel.interview_prepare;

import java.util.ArrayList;

/**
 * 就是计数的
 * 一篇文章里面，各个字母出现了多少次
 *
 * 代码之前写的，有些差，哈哈
 * 正确处理的思路，还是看 WordCounter 吧，思路清晰
 */
public class CharacterCounter {


    public static void main(String[] args) {
        String stringForCounter = "abccccbba";
        System.out.println(mostFirstChar(stringForCounter));

    }



    /**
     * 后期回顾这片代码，还是太伤心了
     * 采用集合的分拣处理办法
     * 创建一个类，包含字符本身、出现次数、第一次出现的时间
     * 然后用基于 Map 的分拣处理办法来计数吧，啊哈哈
     * @param str
     * @return
     */
    public static char mostFirstChar(String str) {
        /**
         * Step 1, 记录各个字母出现的次数（不分大小写）,存在特定的数据结构里
         * charCounter，记录一个字母出现了多少次
         * firstTime，记录一个字母第一次出现的index
         */
        String string = str.toLowerCase();
        char[] chars = string.toCharArray();
        int[] charCounter = new int[26];
        int[] firstTime = new int[26];
        for (int i=0;i<chars.length;i++) {
            int index = chars[i] - 'a';
            if (charCounter[index]==0) {
                firstTime[index] = i;
            }
            charCounter[index]++;

        }
        /**
         * Step 2, 寻找出现最多的字母
         * recorder，记录出现最多的字母（们）在charCounter的index
         */
        int biggest = charCounter[0];
        for (int i : charCounter) {
            if (i > biggest) {
                biggest = i;
            }
        }
        ArrayList<Integer> recorder = new ArrayList<>();
        for (int i = 0; i<charCounter.length; i++) {
            if (charCounter[i] == biggest) {
                recorder.add(i);
            }
        }
        /**
         * Step 3, 寻找哪个字母最先出现
         */
        int firstIndex = recorder.get(0);
        int smallestFirstTime = firstTime[recorder.get(0)];
        for(int i : recorder) {
            if (firstTime[i] < smallestFirstTime) {
                smallestFirstTime = firstTime[i];
                firstIndex = recorder.get(i);
            }
        }
        char returnValue = (char)('a' + firstIndex);
        return returnValue;
    }


}
