package practice.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        List<List<Integer>> result = powerset(Arrays.asList(1, 2, 3));
        int i = 1;
        for (List<Integer> res : result) {
            System.out.println(i++ + "- " + res.toString());
        }
    }

    private static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> sets = new ArrayList<>();
        findSets(array, 0, sets, new ArrayList<>());
        return sets;
    }

    private static void findSets(List<Integer> array, int idx, List<List<Integer>> sets, List<Integer> runningSet) {
        if (idx == array.size()) sets.add(new ArrayList<>(runningSet));
        else {
            findSets(array, idx + 1, sets, runningSet);
            runningSet.add(array.get(idx));
            findSets(array, idx + 1, sets, runningSet);
            runningSet.remove(runningSet.size() - 1);
        }
    }
}
