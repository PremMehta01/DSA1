package practice.Algoexpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubsequece {
    public static void main(String[] args) {
        int[] apples = {3, 0, 0, 0, 0, 2};
        int[] days = {3, 0, 0, 0, 0, 2};

        System.out.println(longestCommonSubsequence("ZVVYZW", "XYKZPW"));
    }

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        List<Character>[][] cache = new List[str1.length()][str2.length()];
        List<Character> resultReverse = findLongestCommonSubsequence(str1, str2, 0, 0, cache);
        Collections.reverse(resultReverse);
        return resultReverse;
    }

    private static List<Character> findLongestCommonSubsequence(String str1, String str2, int idx1, int idx2, List<Character>[][] cache) {
        if (idx1 == str1.length() || idx2 == str2.length())
            return new ArrayList<Character>();
        if (cache[idx1][idx2] != null)
            return cache[idx1][idx2];

        if (str1.charAt(idx1) == str2.charAt(idx2)) {
            List<Character> furtherSubsequences = findLongestCommonSubsequence(str1, str2, idx1 + 1, idx2 + 1, cache);
            furtherSubsequences.add(str1.charAt(idx1));
            cache[idx1][idx2] = furtherSubsequences;
            return furtherSubsequences;
        } else {
            List<Character> firstList = findLongestCommonSubsequence(str1, str2, idx1, idx2 + 1, cache);
            List<Character> secondList = findLongestCommonSubsequence(str1, str2, idx1 + 1, idx2, cache);

            cache[idx1][idx2] = firstList.size() > secondList.size() ? firstList : secondList;
            return cache[idx1][idx2];
        }
    }
}

