package com.khanintel.interview_prepare;

/**
 * 字符串的shift
 *
 *
 * 如果想做数字的shift，这个就比较简单了
 *  12345 --> 34512
 *      一个是对10的n次方取余数，然后再乘以10的 length-n 次方、一个是取除法结果
 *      然后再加起来
 *      就做完啦~
 *
 *
 *
 */
public class StringShift {

    public static void main(String[] args) {

        String string = "0123456789";
        System.out.println(stringLeftShift(string, 9));
        System.out.println(stringLeftShift(string, 10));
        System.out.println(stringLeftShift(string, 11));
        System.out.println(stringLeftShift(string, 100));
        System.out.println(stringLeftShift(string, 1000));

        System.out.println();
        System.out.println(stringLeftShift2(string, 9));
        System.out.println(stringLeftShift2(string, 10));
        System.out.println(stringLeftShift2(string, 11));
        System.out.println(stringLeftShift2(string, 100));
        System.out.println(stringLeftShift2(string, 1000));

        System.out.println();
        System.out.println(stringRightShift(string, 9));
        System.out.println(stringRightShift(string, 10));
        System.out.println(stringRightShift(string, 11));
        System.out.println(stringRightShift(string, 100));
        System.out.println(stringRightShift(string, 1000));


    }

    public static String stringLeftShift(String string, int shift) {

        char[] chars = string.toCharArray();

        int shiftInside = shift % string.length();

        char[] tempChars = new char[shiftInside];

        for (int i=0; i < shiftInside; i++) {
            tempChars[i] = chars[i];
        }

        for (int i=0; i < string.length() - shiftInside; i++) {
            chars[i] = chars[i+shiftInside];
        }
        for (int i = string.length()-shiftInside; i<string.length(); i++) {
            chars[i] = tempChars[(i + shift)%string.length()];
        }

        return new String(chars);

    }

    public static String stringLeftShift2(String string, int shift){
        char[] sourceChar = string.toCharArray();
        char[] destChar = new char[string.length()];

        for (int i=0; i<string.length(); i++) {
            destChar[i] = sourceChar[(i+shift)%string.length()];
        }
        return new String(destChar);
    }

    /**
     * 这个其实是自己又找了一种实现方法来做
     *
     * 其实，在实现了 leftShift 的时候，rightShift 是非常容易做的，因为你可以直接调用leftShift呀
     * 一个是挪动 n 次，一个是挪动 length - n 次
     *
     *
     * @param string
     * @param shift
     * @return
     */
    public static String stringRightShift(String string, int shift) {

        int shiftInside = shift % string.length();

        char[] stringArray = string.toCharArray();

        char[] tempArray = new char[shiftInside];

        System.arraycopy(stringArray, stringArray.length-shiftInside, tempArray, 0, shiftInside);
        System.arraycopy(stringArray, 0, stringArray, shiftInside, stringArray.length-shiftInside);
        System.arraycopy(tempArray, 0, stringArray, 0, shiftInside);

        String result = new String(stringArray);

        return result;
    }





}
