package practice.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> result = getPermutaions(Arrays.asList(1,2,3));
        int i = 1;
        for(List<Integer> res : result){
            System.out.println(i++ + "- " + res.toString());
        }
    }

    private static List<List<Integer>> getPermutaions(List<Integer> array){
        List<List<Integer>> permutations = new ArrayList<>();
        findPermutations(array, 0, permutations);
        return permutations;
    }

    private static void findPermutations(List<Integer> array, int idx, List<List<Integer>> permutations){
        if(idx == array.size()) permutations.add(new ArrayList<>(array));
        else{
            for(int i = idx; i < array.size(); i++){
                swap(idx, i, array);
                findPermutations(array, idx + 1, permutations);
                swap(idx, i, array);
            }
        }
    }

    private static void swap(int i, int j, List<Integer> array){
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
