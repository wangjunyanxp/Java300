package com.khanintel.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 */
public class StringFormat {
    /**
     * 字符串处理
     * 1. 去掉各种符号、去掉首尾空格
     * 2. 将多个空格换成一个空格
     *
     * @param string
     * @return
     */
    public static String stringFormat (String string) {

        String firstStep = string.toLowerCase();

        String regEx = "[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(firstStep);
        String stringSimply = m.replaceAll("").trim();


        /**
         * 在下面这3行里，也把回车给干掉了
         *  \s    空白字符：[ \t\n\x0B\f\r]
         *
                     \t    制表符 ('\u0009')
                     \n    新行（换行）符 ('\u000A')
                     \r    回车符 ('\u000D')
                     \f    换页符 ('\u000C')
                     \x0B    空格
                     \xhh    带有十六进制值 0x的字符 hh

         */
        Pattern p2 = Pattern.compile("\\s+");
        Matcher m2 = p2.matcher(stringSimply);
        stringSimply = m2.replaceAll(" ");


        return stringSimply;


//        String firstStep = string.toLowerCase();
//        char[] firstStepArray = firstStep.toCharArray();
//
//        for (int i=0; i<firstStepArray.length; i++) {
//            if (firstStepArray[i] <'a' || firstStepArray[i] > 'z') {
//                firstStepArray[i] = ' ';
//            }
//        }
//        return new String(firstStepArray);
    }
}
