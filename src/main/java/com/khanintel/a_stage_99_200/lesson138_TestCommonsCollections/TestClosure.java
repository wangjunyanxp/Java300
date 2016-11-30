package com.khanintel.a_stage_99_200.lesson138_TestCommonsCollections;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.*;
import org.apache.commons.collections4.functors.*;

import java.util.List;

/**
 * 闭包， 封装特定功能

    Transformer VS Closure
    区别
        一个返回一个新的（有返回值）
        一个不返回新的，可以直接把传入参数改了，或做其他的动作（无返回值）

    CollectionUtils.forAllDo(collection, closure); (已经 deprecated )
    IterableUtils.forEach(collection, closure);

 1. Closure
    Closure
        @override
        void execute

 2. IfClosure
    Closure<E> ifClosure = IfClosure.ifClosure（predicate, trueClosure, falseClosure）

 3. WhileClosure
    Closure<E> whileClosure = WhileClosure.whileClosure(collection, trueClosure, do_loop_boolean)    //do_loop_boolean，若true，则是do-while，若false，则是while-do

 4. ChainedClosure
    1. do something, all 90% discount----closure1
    2. then do something else----closure2 (有关执行sth的条件，可以自己在closure里面写，或者做成一个 IfClosure
    Closure<E> chainClosure = ChainedClosure.chainedClosure(closure1, closure2)

  *
 */
public class TestClosure {

    public static void main(String[] args) {
        List<Employee> employeeList = Lists.newArrayList(new Employee("Justin", 20000), new Employee("Wang", 22000), new Employee("Keli", 24000));
        System.out.println(employeeList);

        closure();
        ifClosure();
        whileClosure();
        chainClosure();
        forClosure();
        switchClosure();
        transformerClosure();


    }

    public static void closure(){
        List<Employee> employeeList = Lists.newArrayList(new Employee("Justin", 20000), new Employee("Wang", 22000), new Employee("Keli", 24000));
        Closure<Employee> closure = new Closure<Employee>() {
            @Override
            public void execute(Employee input) {
                input.setSalary(input.getSalary()*1.2);
            }
        };
        IterableUtils.forEach(employeeList, closure);
        System.out.println(employeeList);
        System.out.println("TestClosure.closure");
        //可以 Java 8 实现，就是一个简单的 map
        //暂不提供 Java 8 的实现了
    }

    public static void ifClosure(){
        List<Employee> employeeList = Lists.newArrayList(new Employee("Justin", 20000), new Employee("Wang", 22000), new Employee("Keli", 24000));
        Closure<Employee> closure1 = input -> input.setSalary(input.getSalary()*1.2);
        Closure<Employee> closure2 = input -> input.setSalary(input.getSalary() + 1);
        Predicate<Employee> predicate = new Predicate<Employee>() {
            @Override
            public boolean evaluate(Employee object) {
                return object.getSalary()<22000;
            }
        };
        IfClosure<Employee> ifClosure_true = new IfClosure<Employee>(predicate, closure1);
        IfClosure<Employee> ifClosure_true_false = new IfClosure<Employee>(predicate, closure1, closure2);
        Closure<Employee> closure = IfClosure.ifClosure(predicate, closure1, closure2);

        IterableUtils.forEach(employeeList, ifClosure_true);
        System.out.println(employeeList);

        employeeList = Lists.newArrayList(new Employee("Justin", 20000), new Employee("Wang", 22000), new Employee("Keli", 24000));
        IterableUtils.forEach(employeeList, ifClosure_true_false);
        System.out.println(employeeList);

        System.out.println("TestClosure.ifClosure");
        //可以 Java 8 实现， 一个 filter， 加一个 map
        //暂不提供 Java 8 的实现了
    }

    public static void whileClosure(){
        List<Employee> employeeList = Lists.newArrayList(new Employee("Justin", 20000), new Employee("Wang", 22000), new Employee("Keli", 24000));
        Closure<Employee> closure = input -> input.setSalary(input.getSalary()*1.01);
        Predicate<Employee> predicate = input -> input.getSalary()<22000;
        WhileClosure<Employee> whileClosure_WhileDo = new WhileClosure<>(predicate, closure, false);
        WhileClosure<Employee> whileClosure_DoWhile = new WhileClosure<>(predicate, closure, true);
        Closure<Employee> whileClosure= WhileClosure.whileClosure(predicate, closure, false);

        IterableUtils.forEach(employeeList, whileClosure_DoWhile);
        System.out.println(employeeList);

        employeeList = Lists.newArrayList(new Employee("Justin", 20000), new Employee("Wang", 22000), new Employee("Keli", 24000));
        IterableUtils.forEach(employeeList, whileClosure_WhileDo);
        System.out.println(employeeList);
        System.out.println("TestClosure.whileClosure");
        //在 Java 8 的 map 里面，增加 while 来实现
        //暂不提供 Java 8 的实现了
    }

    public static void chainClosure(){
        List<Employee> employeeList = Lists.newArrayList(new Employee("Justin", 20000), new Employee("Wang", 22000), new Employee("Keli", 24000));
        Closure<Employee> closure1 = input -> input.setSalary(input.getSalary()*1.2);
        Closure<Employee> closure2 = input -> input.setName(input.getName() + " can do better!");
        Closure<Employee> closure3 = input -> input.setSalary(input.getSalary() + 1);
        ChainedClosure<Employee> chainedClosure = new ChainedClosure<>(closure1, closure2, closure3);
        Closure<Employee> closure = ChainedClosure.chainedClosure(closure1, closure2, closure3);

        IterableUtils.forEach(employeeList, chainedClosure);
        System.out.println(employeeList);
        System.out.println("TestClosure.chainClosure");
        //可以 Java 8 实现，多套几个 map 就好
        //暂不提供 Java 8 的实现了
    }

    public static void forClosure(){
        List<Employee> employeeList = Lists.newArrayList(new Employee("Justin", 20000), new Employee("Wang", 22000), new Employee("Keli", 24000));
        Closure<Employee> closure = input -> input.setSalary(input.getSalary() + 100);
        ForClosure<Employee> forClosure = new ForClosure<>(100, closure);

        IterableUtils.forEach(employeeList, forClosure);
        System.out.println(employeeList);
        System.out.println("TestClosure.forClosure");
        //在 Java 8 的 map 里面，增加 for 来实现
        //暂不提供 Java 8 的实现了
    }

    public static void switchClosure(){
        List<Employee> employeeList = Lists.newArrayList(new Employee("Justin", 20000), new Employee("Wang", 22000), new Employee("Keli", 24000));
        Predicate<Employee> predicate1 = input -> input.getSalary()<22000;
        Predicate<Employee> predicate2 = input -> input.getName().length() > 1;
        Predicate<Employee> predicate3 = input -> input.getName().equals("Keli");
        Closure<Employee> closure1 = input -> input.setSalary(input.getSalary()*1.2);
        Closure<Employee> closure2 = input -> input.setSalary(input.getSalary() + 500);
        Closure<Employee> closure3 = input -> input.setSalary(input.getSalary() + 50000);
        Predicate[] predicates = {predicate1, predicate2, predicate3};
        Closure[] closures = {closure1, closure2, closure3};
        SwitchClosure<Employee> switchClosure = new SwitchClosure<>(predicates, closures, null);
        IterableUtils.forEach(employeeList, switchClosure);

        System.out.println(employeeList);
        System.out.println("TestClosure.switchClosure");

        // SwitchClosure 的属性我还是不太理解，在满足了多条Predicate的时候，对数据都做修改，可能会有些问题。
        // 我这种 SwitchClosure 本身就不是很推荐，没有互斥性，存在多线程同时访问
        // 但即使我把数据丢进了 synchronized 里面，还是会有问题

        //在 Java 8 的 map 里面，增加 if判断 来实现，可以有多种 ( a < X1 <= b < X2 <= c )，更加全面，而且不会同时修改，避免不应该出现的一些问题
        //暂不提供 Java 8 的实现了
    }

    public static void transformerClosure(){
        List<Employee> employeeList = Lists.newArrayList(new Employee("Justin", 20000), new Employee("Wang", 22000), new Employee("Keli", 24000));
        Transformer<Employee, Level> transformer = new Transformer<Employee, Level>() {
            @Override
            public Level transform(Employee input) {
                return new Level(input.getName(), "Good");
            }
        };
        TransformerClosure<Employee> transformerClosure = new TransformerClosure<>(transformer);

        IterableUtils.forEach(employeeList, transformerClosure);
        System.out.println(employeeList);
        System.out.println("TestClosure.transformerClosure");
        //不太明白这个 TransformerClosure 有什么用
        //因为我没找到接收结果的地方
    }



}
