package com.atguigu.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by acer on 2018/10/14.
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User implements Comparable<User> {

    private String id;
    private String sex;
    private Integer age;
    private Date birthday;
    private String job;
    private BigDecimal price;

    public static <T> T kkkkk(qqqq q, Long a, Long b) {
        return (T) q.add(a, b);
    }

    private  static  Stream <Character>  tttt(String str){

        List<Character>  list=new ArrayList<>();
        for(Character  st: str.toCharArray()){

            list.add(st);
        }
        return  list.stream();
    }

    public static void main(String[] args) {

        Function<String,Stream<Character>> kkkkkk=(data) ->User.tttt(data);



        List<String>  list2=Arrays.asList("aaa","bbc");
        Stream<Stream<Character>>  dddddd=list2.stream().map(User::tttt);
        System.out.println();//山东省DVD是
        list2.stream().flatMap(User::tttt) .forEach(System.out::print);

        System.out.println("-------------------------------------------------------------------------------------------");



        List<User> list = new ArrayList<>();
        list.add(new User("11111", "男", 12, new Date(), "歌手", new BigDecimal("100000.01")));
        list.add(new User("22222", "男", 20, new Date(), "歌手", new BigDecimal("200000.02")));
        list.add(new User("33333", "女", 20, new Date(), "歌手", new BigDecimal("300000.03")));
        list.add(new User("44444", "男", 6, new Date(), "歌手", new BigDecimal("400000.04")));
        System.out.println(list.stream().max((x, y) -> x.getPrice().compareTo(y.getPrice())).get());
        //  list.stream().forEach(data ->data.setPrice(data.getPrice().add(new BigDecimal("1000000"))));
        System.out.println(list);
        System.out.println(list.stream().map(User::getPrice).reduce((x, y) -> x.add(y)).get());
        Function<User, BigDecimal> pppp = (data) -> data.getPrice();
        System.out.println(list.stream().map(pppp).reduce(BigDecimal::add).get());


        Stream<User> nnn = list.stream();
      //  System.out.println(list.stream().flatMap(nnn).forEach());


        Comparator<User> aaa = (x, y) -> Integer.compare(x.getAge(), y.getAge());

        Function<User, Integer> ccc = (x) -> x.getAge().compareTo(x.getAge());

        Collections.sort(list, aaa);

        fffff hhhh = (x) -> x.toUpperCase();
        System.out.println(hhhh.getValue("abc"));
        fffff hhhhh = (x) -> x.substring(2, 4);

        BiFunction<Long, Long, Long> kkkk = (x, y) -> x + y;
        System.out.println(kkkk.apply(66666L, 88888L));

        qqqq<Long, Long> llll = (x, y) -> x + y;
        Long dddd = kkkkk(llll, 6666L, 8888L);
        System.out.println(dddd);


        List<User> zz = new ArrayList<>();
        list.stream().filter(data -> !data.getId().equals("11111") &&
                !data.getId().equals("22222")).forEach((data) -> {
            data.setPrice(new BigDecimal("0.8"));
            zz.add(data);
            //method();
        });

        System.out.println(list);


        Object obj1 = new Integer(12);
        Object obj2 = new Integer(12);
        System.out.println(obj1.equals(obj2));


        Comparator<User> value = (x, y) -> {

            Integer i = Integer.compare(x.getAge(), y.getAge());
            if (i == 0) {
                return -(x.getPrice().compareTo(y.getPrice()));
            }
            return i;
        };

        Collections.sort(list, value);


        ////     list.forEach((data) -> System.out.println(data));
        User hhh = new User();
        hhh.setPrice(new BigDecimal("1000"));
        Function<User, User> bbb = (x) -> {
            return x.setPrice(x.getPrice().add(new BigDecimal(("5000"))));
        };

        Consumer<User> ll = (x) -> {
            x.setPrice(new BigDecimal("888889999.006"));
        };
        ll.accept(hhh);
        System.out.println(hhh);

        Predicate<String> flag = (m) -> {
            return m.contains("12");

        };
        flag.test("123456789");

        Supplier<User> kk = () -> {
            return new User();

        };

        Supplier<List<Integer>> pp = () -> {
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list1.add((int) (Math.random() * 100));
            }
            return list1;
        };
        List<Integer> tt = pp.get();
        System.out.println(tt);
        //System.out.println(list.stream().filter(data ->"11111".equals(data.getId())).collect(Collectors.toList()));
        System.out.println(list.stream().map(data -> data.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::max));
        System.out.println(list.stream().map(data -> data.getAge()).reduce(0, (a, b) -> a + b));


        Double aa = 0.02;
        Double bb = 0.03;
        Double cc = null;
        Double hh = Optional.ofNullable(cc).orElseGet(() -> 8.8);
        System.out.println(hh);
        System.out.println(BigDecimal.valueOf(bb).subtract(BigDecimal.valueOf(aa)));

        System.out.println(new BigDecimal("2").divide(new BigDecimal("3"), BigDecimal.ROUND_CEILING, BigDecimal.ROUND_HALF_UP));

        BigDecimal mm = (BigDecimal) Optional.ofNullable(null).orElseGet(() ->
                new BigDecimal("0.08")
        );
        System.out.println(mm);

        String ee = "";
        Object kkk = Optional.ofNullable(null).orElseGet(() -> "");
    }

    @Override
    public int compareTo(User o) {
        if (o instanceof User) {
            return -(o.getAge() - this.getAge());
        }
        return 0;
    }


}

interface fffff {

    public String getValue(String string);
}

interface qqqq<T, R> {

    public R add(T t1, T t2);
}