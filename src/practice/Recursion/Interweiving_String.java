package practice.Recursion;

public class Interweiving_String {
    public static void main(String[] args) {
        String one = "algoexpert";
        String three = "your-algodream-expertjob1";
        String two = "your-dream-job";

        System.out.println(interweivingStrings(one, two, three));
    }

    private static boolean interweivingStrings(String one, String two, String three){
        if(one.length() + two.length() != three.length()) return false;

        // RECURSIVE APPROACH
        // return isInterweiving(one, two, three, 0, 0);

        //  USING MEMOIZATION
        Boolean[][] cache = new Boolean[one.length() + 1][two.length() + 1];
        cache[one.length()][two.length()] = true;
        return isInterweivingStrings(one, two, three, cache, 0, 0);
    }

    ///  RECURSIVE APPROACH
    private static boolean isInterweiving(String one, String two, String three, int idx1, int idx2){
        if(idx1 == one.length() && idx2 == two.length()) return true;

        if(idx1 < one.length() && one.charAt(idx1) == three.charAt(idx1 + idx2))
            if(isInterweiving(one, two, three, idx1 + 1, idx2)) return true;

        if(idx2 < two.length() && two.charAt(idx2) == three.charAt(idx1 + idx2))
            return isInterweiving(one, two, three, idx1, idx2 + 1);

        return false;
    }

    //  USING MEMOIZATION
    private static boolean isInterweivingStrings(String one, String two, String three, Boolean[][] cache, int idx1, int idx2){
        if(cache[idx1][idx2] != null) return cache[idx1][idx2];

        char third = three.charAt(idx1 + idx2);
        if(idx1 < one.length() && one.charAt(idx1) == third){
            cache[idx1][idx2] = isInterweivingStrings(one, two, three, cache, idx1 + 1, idx2);
            if(cache[idx1][idx2]) return true;
        }

        if(idx2 < two.length() && two.charAt(idx2) == third){
            cache[idx1][idx2] = isInterweivingStrings(one, two, three, cache, idx1, idx2 + 1);
            if(cache[idx1][idx2]) return true;
        }

        cache[idx1][idx2] = false;
        return cache[idx1][idx2];
    }
}
