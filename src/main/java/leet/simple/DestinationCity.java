package leet.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        List<String> path1 = List.of("B","C");
        List<String> path2 = List.of("D","B");
        List<String> path3 = List.of("C","A");
        paths.add(path1); paths.add(path2); paths.add(path3);
        System.out.println(destCity(paths));
     }
    public static String destCity(List<List<String>> paths) {
        Map<String, Integer> count = new HashMap<>();
        for(List<String> path : paths) {
            String city1 = path.get(0);
            String city2 = path.get(1);
            count.put(city1, count.getOrDefault(city1, 0) + 1);
            count.put(city2, count.getOrDefault(city2, 0) + 1);
        }
        for(String key : count.keySet()) {
            if(count.get(key) == 1) {
                for(List<String> path : paths) {
                    if(path.get(1) == key) {
                        return key;
                    }
                }
            }
        }
        return "";
    }
}

/*
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
Example 1:
Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo"
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
Example 2:
Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are:
"D" -> "B" -> "C" -> "A".
"B" -> "C" -> "A".
"C" -> "A".
"A".
Clearly the destination city is "A".
Example 3:
Input: paths = [["A","Z"]]
Output: "Z"
Constraints:
1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
All strings consist of lowercase and uppercase English letters and the space character.
 */