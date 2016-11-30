package com.khanintel.a_stage_99_200.lesson138_TestCommonsCollections;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.SwitchTransformer;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 函数式编程
 *
 *  Java 8
 *  Guava
 *  Apache Commons Collections
 *  三种实现
 *
 *
 *
 */
public class TestTransformer {

    public static void main(String[] args) {



        List<Long> list = new ArrayList<>();
        list.add(1000000000000L);
        list.add(2000000000000L);
        list.add(3000000000000L);

        // Java 8
        List<String> dates1 = list.stream().map(ele -> new SimpleDateFormat("yyyy-MM-dd").format(ele)).collect(Collectors.toList());

        // Guava
        Collection<String> dates2 = Collections2.transform(list, ele -> new SimpleDateFormat("yyyy-MM-dd").format(ele));

        // Apache Commons Collection
        Transformer<Long, String> transformer = new Transformer<Long, String>() {
            @Override
            public String transform(Long input) {
                return new SimpleDateFormat("yyyy-MM-dd").format(input);
            }
        };
        Collection<String> dates3 = CollectionUtils.collect(list, transformer);

        System.out.println(dates1);
        System.out.println(dates2);
        System.out.println(dates3);

        // 再补充一下，为什么 Java8 的例子里，就可以存到 List 里面，但 Guava \ CommonsCollection 却不能
        // 因为 Java 8 的例子里，输入的类型都确定了，那么输出类型就好确认了
        // Guava/CommonsCollection的例子，都是用的公共的 CollectionXX.XXXX 之类，都是给所有 Collection 用的
        ///////////////////////////////////////////////////////////////////////////////////////


        /**
         *  类型的转换
         *  结合 Predicate，Transformer在一起，揉合出一个新的Transformer
         */
        //做到类型的转换了，一个比较精致的方案
        List<Employee> employees = Lists.newArrayList(new Employee("Justin", 20000), new Employee("Keli", 18000));

        Predicate<Employee> predicateBelow19 = input -> input.getSalary() < 19000;
        Predicate<Employee> predicateAbove19 = input -> input.getSalary() > 19000;
        Predicate[] predicates = {predicateBelow19, predicateAbove19};

        Transformer<Employee, Level> transformerBelow19 = input -> new Level(input.getName(), "Below 19K");
        Transformer<Employee, Level> transformerAbove19 = input -> new Level(input.getName(), "Above 19K");
        Transformer[] transformers = {transformerBelow19, transformerAbove19};

        //这个，就是简单的匹配，predicates数组的第一个，对应于transformers的第一个，就是这样简单的对应关系
        Transformer switchTransformer = new SwitchTransformer(predicates, transformers, null);

        Collection<Level> levels = CollectionUtils.collect(employees, switchTransformer);
        System.out.println(levels);

        Iterator<Level> levelIterator = levels.iterator();
        while (levelIterator.hasNext()) {
            System.out.println(levelIterator.next());
        }

        System.out.println("--------------------------------------------------------------------------");

        // Java 8 实现版
        List<Level> above19K = employees.stream().filter(ele -> ele.getSalary()>19000).map(ele -> new Level(ele.getName(), "Above 19K")).collect(Collectors.toList());
        List<Level> below19K = employees.stream().filter(ele -> ele.getSalary()<19000).map(ele -> new Level(ele.getName(), "Below 19K")).collect(Collectors.toList());

        List<Level> summary = new ArrayList<Level>(Arrays.asList(new Level[above19K.size()]));
        Collections.copy(summary, above19K);
        summary.addAll(below19K);
        System.out.println(summary);
        System.out.println("--------------------------------------------------------------------------");

        ///////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////


        /**
         * 一个比较简单的类型转换，用  Java 8  Guava  ApacheCommons 各自实现了一把
         */
        // Java 8
        List<Level> levelList = employees.stream().map(ele -> {
            String level;
            if (ele.getSalary() > 18000) {
                level = "Good";
            } else if (ele.getSalary() == 18000){
                level = "OK";
            } else {
                level = "Work Harder";
            }
            return new Level(ele.getName(), level);
        }).collect(Collectors.toList());

        levelList.stream().forEach(System.out::println);

        // Guava
        // Collections2.transform + Function
        Function<Employee, Level> functionGuava = new Function<Employee, Level>() {
            @Override
            public Level apply(Employee ele) {
                String level;
                if (ele.getSalary() > 18000) {
                    level = "Good";
                } else if (ele.getSalary() == 18000){
                    level = "OK";
                } else {
                    level = "Work Harder";
                }
                return new Level(ele.getName(), level);
            }
        };
        Collection<Level> levels1 = Collections2.transform(employees, functionGuava);
        System.out.println(levels1);


        // Apache Commons Collections
        Transformer<Employee, Level> transformer2 = new Transformer<Employee, Level>() {
            @Override
            public Level transform(Employee ele) {
                String level;
                if (ele.getSalary() > 18000) {
                    level = "Good";
                } else if (ele.getSalary() == 18000){
                    level = "OK";
                } else {
                    level = "Work Harder";
                }
                return new Level(ele.getName(), level);
            }
        };
        Collection<Level> levels2 = CollectionUtils.collect(employees, transformer2);
        System.out.println(levels2);

    }

}


class Employee{
    String name;
    double salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class Level {
    String name;
    String level;

    public Level() {
    }

    public Level(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Level{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}