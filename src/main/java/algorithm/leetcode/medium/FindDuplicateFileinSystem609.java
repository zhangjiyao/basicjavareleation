package algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem609 {
    public static void main(String[] args) {

    }

    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] strings = path.split(" ");
            for (int i = 1; i < strings.length; i++) {
                if (strings[i].contains("(") && strings[i].contains(")")) {
                    String key = strings[i].substring(strings[i].indexOf('(') + 1, strings[i].indexOf(')'));
                    String value = strings[0] + "/" + strings[i].substring(0, strings[i].indexOf('('));
                    List<String> list;
                    if (map.containsKey(key)) {
                        list = map.get(key);
                    } else {
                        list = new LinkedList<>();
                        map.put(key, list);
                    }
                    list.add(value);
                }
            }
        }
        LinkedList<List<String>> result = new LinkedList<List<String>>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getValue());
            }
        }

        return result;
    }
}
