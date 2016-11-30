package com.khanintel.a_stage_99_200.lesson100_TestCollection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 自己实现链表
 * 这里是双向链表，bidirection
 *
 * LinkedList 之 自己实现, 双向链表版
 *   1. size, add, get, indexOf, remove, iterator
 *   2. 支持泛型
 *   3. 支持了迭代器 Iterator
 *      a. public class MyLinkedListBD<T> implements Iterable<T>
 *      b. private class Iter implements java.util.Iterator<T>
 *
 *   4. 关于优化
 *      clear()，其实就是简单粗暴的把 size = 0，目前看来没有问题，但其实可以将 collection 里面的所有元素设置为 null --> 这个已经做了, yeah
 *      不仅如此，关于 remove ，被 remove 掉的坑位，应该也作为 null --> 这个已经做了, yeah
 *
 */
public class MyLinkedListBD<T> implements Iterable<T> {

    Node first;
    Node last;
    int size;

    public MyLinkedListBD() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void add(T t){
        Node node = new Node(t);

        // 如果LinkedList为空
        if (0==size) {
            first = node;
            node.setPrevious(null);
            node.setNext(null);
            last = node;
        } else {
            last.setNext(node);
            node.setPrevious(last);
            last = node;
        }
        size++;
    }

    public T get(int index) {
        indexCheck(index);
        Node result = first;
        for (int i=0; i<index; i++) {
            result = result.getNext();
        }
        return result.getCurrent();
    }

    public T remove (int index) {
        indexCheck(index);
        Node result = first;
        for (int i=0; i<index; i++) {
            result = result.getNext();
        }
        Node previous = result.getPrevious();
        Node next = result.getNext();

        if (previous == null && next == null) {
            first = null;
            last = null;
        } else if (previous == null && next != null){
            next.setPrevious(null);
            first = next;
        } else if (previous != null && next == null) {
            previous.setNext(null);
            last = previous;
        } else if (previous != null && next != null){
            previous.setNext(next);
            next.setPrevious(previous);
        }
        T resultT = result.getCurrent();
        result = null;
        size--;
        return resultT;
    }

    public T remove (T t) {
        int index = indexOf(t);
        if (index != -1) {
            return remove(index);
        } else {
            return null;
        }
    }

    public int indexOf (T t) {
        int index = -1;
        Node temp = first;

        for (int i=0; i<size; i++) {
            if (temp.getCurrent().equals(t)) {
                index = i;
                break;
            }
            temp = temp.getNext();
        }
        return index;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<size; i++) {
            sb.append(get(i) + "\t");
        }
        return sb.toString();
    }

    public void clear() {
        Node beErased = null;
        Node toBeErase = first;
        for(int i=0; i<size;i++) {
            beErased = toBeErase;
            toBeErase = toBeErase.getNext();
            beErased = null;
        }
        //this.first = null;
        //this.last = null;
        this.size = 0;
    }

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
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Node {
        Node previous;
        T current;
        Node next;

        public Node() {
            previous = null;
            current = null;
            next = null;
        }

        public Node(T current){
            this();
            this.current = current;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public T getCurrent() {
            return current;
        }

        public void setCurrent(T current) {
            this.current = current;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private class Iter implements Iterator<T> {
        Node cursorNode;
        int lastRet;

        public Iter() {
            cursorNode = first;
            lastRet = -1;
        }

        @Override
        public boolean hasNext() {
            return (cursorNode!=null);
            // 不能基于 lastRet 来判断，因为删除过一次之后，就会被重置值了
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = cursorNode.getCurrent();
            cursorNode = cursorNode.getNext();
            lastRet++;
            return t;
        }

        /**
         * 按照规矩，我们还是按照只能 remove 一次来
         */
        @Override
        public void remove() {
            if (-1 == lastRet) {
                throw new IllegalStateException();
            }
            /**
             * 如果当前节点有previous，那么 cursorNode 就设置成 前一节点
             * 如果当前节点的previous是null，即 first 节点，那么 cursorNode 设置成 null，其实也是 cursorNode.getPrevious()
             */
            //cursorNode = cursorNode.getPrevious();
            MyLinkedListBD.this.remove(lastRet);
            lastRet = -1;
        }
    }


}


