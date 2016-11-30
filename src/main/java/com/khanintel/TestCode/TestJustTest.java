package com.khanintel.TestCode;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 */
public class TestJustTest {

    public static void main(String[] args) {

        TreeMap<String, String> treeMap = new TreeMap<>();

        TreeSet<String> treeSet = new TreeSet<>();

        HashMap<String, String> hashMap = new HashMap<>();

        String string = new String();

        ArrayList<String> stringArrayList = new ArrayList<>();

        LinkedList<Integer> integerLinkedList = new LinkedList<>();

        Collections.sort(integerLinkedList);


        try {
            BufferedInputStream bIS = new BufferedInputStream(new FileInputStream("someFile.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
