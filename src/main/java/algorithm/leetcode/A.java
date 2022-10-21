package algorithm.leetcode;

import scala.reflect.internal.Symbols;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @program: basicjavareleation
 * @description:
 * @author: jiyao
 * @create: 2022-09-18 15:58
 **/
public class A {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(1,3);
        list.add(1,4);
        list.add(1,5);
        System.out.println(list);


//        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int n1 = Integer.valueOf(o1.split("_")[0]);
//                int n2 = Integer.valueOf(o2.split("_")[0]);
//                if(n1>n2){
//                    System.out.println(1);
//                    return 1;
//                }else if(n1<n2){
//                    System.out.println(-1);
//                    return -1;
//                }else {
//                    System.out.println(0);
//                    return 0;
//                }
//
//            }
//        });
//
//        set.add("1_w");
//        set.add("3_a");
//        set.add("2_c");
//        System.out.println(set);
//        boolean b = set.remove("2_c");
//        System.out.println(b);
//        System.out.println(set);
    }
}
