package com.khanintel.a_stage_99_200.lesson135_TestGuava;

import com.google.common.base.Function;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

import java.util.Map;
import java.util.Set;

/**
 * Table
 *      一个类似于真实世界的表
 *      行Key，列Key，值
 *
 *      实际上，它的底层结构（我没看，应应该是）是“行Key-->Map”，这个 Map 里面，“列Key --> Value”
 *      因此，非常建议用 行Key 来检索数据，支持的方法更多，性能会好（用 列Key 检索的性能会很差）
 *
 *      从 Table 获取出来的 Collection，最好仅用于 Read。
 *
 *      A collection that associates an ordered pair of keys, called a row key and a column key, with a single value.
 *      A table may be sparse, with only a small fraction of row key / column key pairs possessing a corresponding value.
 *
 *      The mappings corresponding to a given row key may be viewed as a Map whose keys are the columns. --数据结构，以及为什么用 Row Key(行Key)
 *      The reverse is also available, associating a column with a row key / value map.
 *      Note that, in some implementations, data access by column key may have fewer supported operations or worse performance than data access by row key.
 *
 *      The methods returning collections or maps always return views of the underlying table. -- 返回的是 View，与原数据相通，一改大家都跟着变
 *      Updating the table can change the contents of those collections, and updating the collections will change the table.
 *
 *      All methods that modify the table are optional, and the views returned by the table may or may not be modifiable. --- 返回的 View，还不一定支持修改，可能会吐Exception
 *      When modification isn't supported, those methods will throw an UnsupportedOperationException.
 *
 *
 */
public class TestTable {

    /**
     * column(C columnKey)
     * columnKeySet()
     * columnMap()
     *
     * put(R rowKey, C columnKey, V value)  Associates the specified value with the specified keys.
     * remove(Object rowKey, Object columnKey)  Removes the mapping, if any, associated with the given keys.
     *
     * row(R rowKey)
     * rowKeySet()
     * rowMap()
     *
     * values()
     *
     * 查找某一行的数据
     *      方法1：    .rowMap().get(row_key)
     *      方法2：    .row(row_key) //推荐
     *
     * 查找某一列的数据
     *      方法1：    .columnMap().get(column_key)
     *      方法2：    .column(column_key) //推荐
     *
     */

    public static void main(String[] args) {
        Table<String, String, Integer> examResult = HashBasedTable.create();
        examResult.put("Justin", "CCNP", 98);
        examResult.put("Justin", "JavaSE", 99);
        examResult.put("Keli", "C++", 100);
        examResult.put("Keli", "Python", 97);
        examResult.put("Keli", "JavaSE", 66);
        examResult.put("CEO", "MakeMoney", 10000);
        System.out.println(examResult);


        Map<String, Map<String, Integer>> examResultMap = examResult.rowMap();
        Set<String> students =  examResult.rowKeySet();
        Set<String> courses = examResult.columnKeySet();

        System.out.print("Student" + "\t" );
        for(String s:courses) {
            System.out.print(s + "\t");
        }
        System.out.println();


        for(String s: students) {
            Map<String, Integer> courseScore = examResultMap.get(s);
            System.out.print(s + "\t");
            for (String s1 : courses) {
                //System.out.print(courseScore.get(s1) + "\t");     //这个快一点
                System.out.print(examResult.get(s, s1) + "\t");     //这个也行啊
            }
            System.out.println();
        }


        /**
         * 把 行、列进行调换的函数
         *
         * Tables.transpose(XXX);
         *
         */
        Table<String, String, Integer> tableTransposed = Tables.transpose(examResult);
        System.out.println(tableTransposed);


        /**
         * 又一个函数式编程，哇咔咔
         */
        Function<Integer, Integer> f1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer input) {
                return input+1;
            }
        };
        Table<String, String, Integer> table3 = Tables.transformValues(examResult, f1);
        System.out.println(table3);



    }



}
