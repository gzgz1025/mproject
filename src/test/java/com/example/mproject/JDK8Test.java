package com.example.mproject;

import com.example.mproject.domain.People;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: JDK8Test
 * @Description:
 * @Author: pzl
 * @CreateDate: 2020/11/13 14:29
 * @Version: 1.0
 */
public class JDK8Test {
    public static List<People> getPeople(){
        Date dNow = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dNow);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date p1 = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        Date p2 = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        Date p3 = calendar.getTime();

        List<People> people = Arrays.asList(
                new People("张三", 10, p1),
                new People("李四", 20, p2),
                new People("老王", 30, p3),
                new People("老王", 30, p3)
        );
        return people;
    }

    public static String appendString(String str){
        return str+"0000";
    }
    @Test
    public void test(){
        //循环
        List<People> people = getPeople();
        //people.forEach(p-> System.out.println(p.getName()));
        //people.stream().forEach(p-> System.out.println(p.getAge()));

        //过滤
        //people.stream().filter(p->p.getName().equals("张三")).forEach(p-> System.out.println(p));

        //踢重
        //Stream<String> stream= Stream.of("I", "love", "you", "too");
        //stream.distinct().forEach(p-> System.out.println(p));
        //自然排序
        //stream.sorted().forEach(s -> System.out.println(s));
        //自定义排序
        //stream.sorted((str,s)->str.length()-s.length()).forEach(str1-> System.out.println(str1));

        //将流的元素映射成另一个类型 两种写法 冒号 函数式写法
        //stream.map(String::toUpperCase).forEach(s -> System.out.println(s));
        //stream.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        //stream.map(s->appendString(s)).forEach(s-> System.out.println(s));

        //flatMap() flatMap()的作用就相当于把原stream中的所有元素都”摊平”之后组成的Stream，转换前后元素的个数和类型都可能会改变
        //Stream<List<Object>> stream = Stream.of(Arrays.asList(1,2), Arrays.asList("3", "4", "5"));
        //stream.flatMap(list -> list.stream()).forEach(i -> System.out.println(i));

        /**
         * reduce
         */
        //查找字符长度最大的
        //Optional<String> longest=stream.max((s1, s2)->s1.length()-s2.length());
        //System.out.println("1:"+longest.get());

        //Optional<String> longest2=stream.reduce((s1,s2)->s1.length()>=s2.length()?s1:s2);
        //System.out.println("2:"+longest2);

        //求单词长度之和
        //Integer length=stream.reduce(0,(sum,str)->sum+str.length(),(a,b)->a+b);
        //System.out.println(length);
        //Integer length2=stream.mapToInt(str->str.length()).sum();
        //System.out.println(length2);

        /**
         *collect()
         *
         */

        //String 转换成List
        //List<String> list = stream.collect(Collectors.toList());

        //stream.collect(Collectors.toSet());
        //stream.collect(Collectors.toMap(Function.identity(),String::length));
        //按名称分组
        Map<String, List<People>> listMap=people.stream().collect(Collectors.groupingBy(People::getName));
        System.out.println(listMap);

        // 使用下游收集器统计每个部门的人数(先按部门分组，然后按部门统计任书)
        /*Map<Department, Integer> totalByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.counting()));// 下游收集器*/

        // 按照部门对员工分布组，并只保留员工的名字
        /*Map<Department, List<String>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName,// 下游收集器
                                Collectors.toList())));// 更下游的收集器*/


    }
}
