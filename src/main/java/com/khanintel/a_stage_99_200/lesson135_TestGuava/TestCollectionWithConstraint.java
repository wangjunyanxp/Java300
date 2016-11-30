package com.khanintel.a_stage_99_200.lesson135_TestGuava;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 这里，仅仅使用了 Preconditions， Guava 的一个常用语判断输入是否正确的好工具
 *
 * 一旦不匹配，则 Exception
 *
 * 教程里面，用到了 Constraint，这个已经被 Guava 新版本干掉了
 *      Constraint
         0. 创建自己的 set （和之前一样）
         1. 创建 Constraint 对象
         2. 在 Constraint 对象里面，写入多条 Preconditions
         3. 把 Constraint 对象 与 set对象绑定在一起
         未来，在set里面添加数据的时候，如果参数不满足条件，直接报  不合法参数Exception
 *
 *
 */
public class TestCollectionWithConstraint {

    public static void main(String[] args) {

        Set<String> stringSet = Sets.newHashSet();

        //myAdd(stringSet, null);
        //myAdd(stringSet, "abc");
        myAdd(stringSet, "abcde");
        myAdd(stringSet, "aaaaabbbbbccccc");
        //myAdd(stringSet, "abcdeabcdeabcdeA");
        System.out.println(stringSet);

    }

    public static void myAdd(Set<String> set, String s) {
        Preconditions.checkNotNull(s);
        Preconditions.checkArgument(s.length() >= 5 && s.length() <= 15);
        set.add(s);
    }
}
