package algorithm.leetcode.medium;

import java.util.*;

public class TopKFrequentWords692 {
    public static void main(String[] args) {
        TopKFrequentWords692 test = new TopKFrequentWords692();
//        String [] sts = {"i","love","leetcode","i","love","coding"};
        String [] sts = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        List<String> list = test.topKFrequent(sts, 4);
//        List<String> list = test.topKFrequent(sts, 2);
        System.out.println(list);
    }

    //这个顺序有问题，需要的是谁先出现按什么顺序并不是字母顺序 输出
    public List<String> topKFrequentS(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (String s : words) {
            int num =1;
            if (map.containsKey(s)) {
                num = map.get(s) + 1;
                String sts = map.get(s) + "_" + s;
                 set.remove(sts);
            }
            map.put(s,num);
            String ss = num + "_" + s;
            set.add(ss);
        }
        TreeSet<Map.Entry<String,Integer>> tset = new TreeSet<>(
                (a,b)-> a.getValue() == b.getValue() ? b.getValue() - a.getValue() : a.getValue() - b.getValue()
        );
//        Iterator<String> iterator = set.iterator();
//        while (iterator.hasNext()) tset.add(iterator.next());
//        LinkedList<String> list = new LinkedList<>();
//        while(k-->0) list.add(tset.pollLast().split("_")[1]);
//        Collections.sort(list);
        return null;
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }

        System.out.println(map);
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
//                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
                (a,b) -> a.getValue()==b.getValue() ?  b.getValue()-a.getValue():a.getValue()-b.getValue()
        );

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }
        System.out.println(pq);
        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }
}
