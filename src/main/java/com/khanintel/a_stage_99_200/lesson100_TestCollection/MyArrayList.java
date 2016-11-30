package com.khanintel.a_stage_99_200.lesson100_TestCollection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArrayList 之 自己实现
 *   1. size, add, get, indexOf, remove, iterator
 *   2. 支持泛型
 *   3. 支持了迭代器 Iterator
 *      a. public class MyArrayList<T> implements Iterable<T>
 *      b. private class Iter implements java.util.Iterator<T>
 *
 *   4. 关于优化
 *      clear()，其实就是简单粗暴的把 size = 0，目前看来没有问题，但其实可以将 list 里面的所有元素设置为 null --> 这个已经做了, yeah
 *      不仅如此，关于 remove ，被 remove 掉的坑位，应该也作为 null --> 这个已经做了, yeah
 *
 *   5. 本篇，也花了比较大的功夫，去讲解 迭代器

 */
public class MyArrayList<T> implements Iterable<T> {

    private int size;
    private Object[] list;

    public MyArrayList() {
        this(16);
        size = 0;
    }

    public MyArrayList(int initSize) {
        if (initSize<=0) {
            try {
                throw new Exception("At least the length should bigger than 0");
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
        size = 0;
        list = new Object[initSize];
    }

    public int size(){
        return size;
    }

    public void add(T object) {
        if (size >= list.length) {
            int newLength = list.length*2 +2;
            Object[] newList = new Object[newLength];
            System.arraycopy(list, 0, newList, 0, size);
            list = newList;
        }
        list[size ++] = object;
    }

    public T get(int i) {
        indexCheck(i);
        return (T)list[i];
    }

    public int indexOf(T t){
        for (int i=0; i<size; i++) {
            if ( ((T)list[i]).equals(t) ) {
                return i;
            }
        }
        return -1;
    }

    public T remove(T t) {
        int index = indexOf(t);
        if (index > -1) {
            return remove(index);
        } else {
            return null;
        }
    }

    /**
     * 用 System.arraycopy 的方法，来做删除，是一个非常聪明的办法
     * 来自于 ArrayList 的源码
     *
     * 这种自己拷贝到自己的算法，是一种比较有趣的，类似于数组子块平移的实现
     *
     * @param index
     * @return
     */
    public T remove(int index){

        indexCheck(index);

        T t = get(index); //其实这里又重复做了1遍index的检查
        System.arraycopy(list, index+1, list, index, size-index-1);
        list[size] = null;
        size--;

        return t;
    }

    /**
     * 这个 index 检查，以及其他其他遇到异常的时候，我的处理想法（参考Java自身实现的想法来看）
     * 如果发生了问题，则通常会丢异常；不会试图用其他办法来在console口丢信息等做出其他行为
     * @param i
     */
    private void indexCheck(int i) {
        if (i<0 || i>=size) {
            try {
                throw new Exception("Index out of range");
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<size; i++) {
            sb.append(list[i] + "\t");
        }
        return sb.toString();
    }

    public void clear() {
        for (int i =0; i<size; i++) {
            list[i] = null;
        }
        size = 0;
    }


    /**
     * 迭代器，是Collection类的一个内部类，而且不是静态的，是一个动态属性。
     * 迭代器的产生，需要一个Collection的实例才能产生。
     *
     * 为什么必须要装在一个类里面？
     *      如果不把迭代器作为内部类的话，就需要一个修改、操作类对象的属性（cursor等），
     *      那么如果要重新迭代，则会修改对象的属性，影响该对象的全部的迭代器，也就是说这个对象永远只能拥有一个迭代器
     *      就是一句话，迭代器的数据，需要和Collection的数据分开，互相不影响。
     *
     *
     * 为什么必须是内部类？
     *      因为要直接访问外部类Collection的一些属性，比如 size 以及直接访问外部类对象的函数、数据等等，
     *      而且因为外部类对象还可能变化（增删元素，size变化等等），所以需要一直与外部类对象保持同步。
     *      但，话都说到这个份上了，其实用外部类也行啊，只要传一个外部类Collection对象的引用就好了啊。
     *      结论：用一个类就行，具体用内部类、外部类，无所谓。
     *
     * 迭代器，用完了之后，如果还要迭代，怎么办？
     *      答：创建新的迭代器，
     *
     * 迭代器，先判断，后获取。
     *      hasNext(), next()
     *
     */

    /**
     * Iterable，可迭代的
     * 与 Iterator 的区别：一个是属性 Iterable，一个是一个对象 Iterator
     * 就像 Comparable Comparator 的区别似的
     *
     * 我们的类，MyArrayList，是可迭代的，Iterable。
     * 要变成 Iterable，类自己需要implement Iterable<T>, 且类内部就必须有 iterator() 函数
     *
     * 注意，在 Java 8 里面，Iterable里面有了2个 default 的 method，即自带实现的method
     *
     *
     */

    /**
     * 有关 迭代器Iterator 的创建，有几种选择
             a. 创建类内部的内部类，创建函数返回内部类
             b. 创建函数，创建函数内的内部类，函数返回内部类
             c. 返回匿名内部类
     *
     */

    /**
     * 用 匿名内部类 实现的 Iterator
     * @return
     */
    /*
    @Override
    public Iterator<T> iterator() {

        return new java.util.Iterator<T>() {
            int cursor = 0;       // index of next element to return
            int lastRet = -1;      // index of last element returned; -1 if no such

            //干掉了构造函数，类都是匿名的了，就没有与类名一致的构造函数了
            //即使是匿名内部类，也是可以有自己的变量的

            //public Iter() {
            //    lastRet = -1;
            //    cursor = 0;
            //}

            @Override
            public boolean hasNext() {
                return cursor != size ;
            }

            @Override
            public T next() {
                if (cursor == size) {
                    throw new NoSuchElementException();
                }
                lastRet=cursor;
                cursor++;
                return (T)list[lastRet];
            }

            @Override
            public void remove() {
                if (lastRet < 0){
                    throw new IllegalStateException();
                }
                MyArrayList.this.remove(lastRet);
                lastRet = -1;
                cursor --;
            }
        };
    }
    */

    /**
     * 用 函数内部类 实现的 Iterator
     */
    /*
    @Override
    public Iterator<T> iterator() {

        class Iter implements java.util.Iterator<T> {
            int cursor;       // index of next element to return
            int lastRet;      // index of last element returned; -1 if no such

            public Iter() {
                lastRet = -1;
                cursor = 0;
            }

            @Override
            public boolean hasNext() {
                return cursor != size ;
            }

            @Override
            public T next() {
                if (cursor == size) {
                    throw new NoSuchElementException();
                }
                lastRet=cursor;
                cursor++;
                return (T)list[lastRet];
            }

            @Override
            public void remove() {
                if (lastRet < 0){
                    throw new IllegalStateException();
                }
                MyArrayList.this.remove(lastRet);
                lastRet = -1;
                cursor --;
            }
        }

        return new Iter();
    }
    */

    /**
     * 用 内部类 + iterator()，实现的迭代器
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements java.util.Iterator<T> {
        int cursor;       // index of next element to return
        int lastRet;      // index of last element returned; -1 if no such

        public Iter() {
            lastRet = -1;
            cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor != size ;
        }

        @Override
        public T next() {
            if (cursor == size) {
                throw new NoSuchElementException();
            }
            lastRet=cursor;
            cursor++;
            return (T)list[lastRet];
        }

        @Override
        public void remove() {
            if (lastRet < 0){
                throw new IllegalStateException();
            }
            MyArrayList.this.remove(lastRet);
            lastRet = -1;
            cursor --;
        }
    }


    /**
     * 迭代器的学习
             1. 实现一个 MyArrayList 的 Iterator
             2. 用上述的3种方法，创建并返回迭代器对象
                     几种选择
                     a. 创建类内部的内部类，创建函数返回内部类
                     b. 创建函数，创建函数内的内部类，函数返回内部类
                     c. 返回匿名内部类
             3. 了解 for-each 的需求，实现 Iterable 接口
             3.5 查看 Iterable 接口的源码，发现由 default 代码
             4. 把 MyArrayList 变成泛型的实现
        All Done !
     */

}
