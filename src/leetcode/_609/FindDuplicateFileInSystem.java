package leetcode._609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {
                String[] nameCount = values[i].split("\\(");
                nameCount[1] = nameCount[1].replace(")", "");
                List<String> list = map.getOrDefault(nameCount[1], new ArrayList<>());
                list.add(values[0]+ "/"+nameCount[0]);
                map.put(nameCount[1], list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if(map.get(key).size() > 1){
                result.add(map.get(key));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindDuplicateFileInSystem findDuplicateFileInSystem = new FindDuplicateFileInSystem();
        System.out.println(findDuplicateFileInSystem.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"}));//Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
        System.out.println(findDuplicateFileInSystem.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"}));//Output: [["root/a/2.txt","root/c/d/4.txt"],["root/a/1.txt","root/c/3.txt"]]
    }
}
