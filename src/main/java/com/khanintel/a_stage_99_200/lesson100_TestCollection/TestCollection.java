package com.khanintel.a_stage_99_200.lesson100_TestCollection;

/**
 *
 * Collection

     1. 可以看作是一个框架，用于处理集合的框架
     2. Collection函数库，不是一个包，而是位于java.util包下的一些接口与类
     3. 类，是用来产生对象存放数据用的；接口，是访问数据的方式【其实这句话普适于所有的类、接口】【很棒的一句话】
     4. Collection接口，是Collection层次结构中的根接口，定义了一些最基本的访问方法，让我们用统一的方式通过Collection或其子接口来访问数据。
     5. JDK 不提供此接口的任何直接 实现：它提供更具体的子接口（如 Set 和 List）实现。
     6. 此接口通常用来传递 collection，并在需要最大普遍性的地方操作这些 collection。

 * Collection 的几重含义，可以代表：
     1. 一组对象
     2. Collection函数库
     3. Collection接口

 *  接口

         Iterable
         |--Collection

         Collection
         |--Set
         |--HashSet
         |--SortedSet，有序Set
         |--List

         Map
         |--HashMap
         |--SortedMap


 * Collection在增删查改某个元素的时候，会大量的用到 equals(),  hashCode() 这两个函数
     这样有一个情况，即使两个元素不一样，但是hashCode一样的时候，删除元素2的时候，其实也删除了元素1（因为hashCode一样）
 *
 */
public class TestCollection {
}
