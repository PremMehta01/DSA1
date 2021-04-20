package practice;

import java.util.ArrayList;
import java.util.List;

public class UnderScorify_Algoexpert {

    public static void main(String[] args) {
        String str = "testthis is a testtest to see if testestest it works";
        String sub = "test";

        String res = underscorifySubstring(str, sub);
        System.out.println(res);
    }

    public static String underscorifySubstring(String str, String substring) {
        return put_Underscore(str,substring);
    }

    public static String put_Underscore(String main , String search){

        List<Integer[]> pair = getPair(main,search);
        List<Integer[]> merge = merge(pair);

        return putUnderscore(merge,main);

    }

    public static String putUnderscore(List<Integer[]> merge , String main){

        String final1 = main;
        int index = 0;

        for(Integer[] pair:merge){

            int x = pair[0]+index;
            int y = pair[1]+index;

            String s = final1.substring(x,y+1);

            final1 = final1.substring(0,x)+"_"+s+"_"+final1.substring(y+1,final1.length());
            index +=2;

        }

        return final1;

    }

    public static List<Integer[]> getPair(String main , String search){

        int index = 0;
        List<Integer[]> list = new ArrayList<>();

        while(index < main.length()){

            int	currindex = main.indexOf(search,index);
            if(currindex != -1){
                list.add(new Integer[]{currindex,currindex+search.length()-1});
                index = currindex+1;
            }else break;

        }

        return list;

    }

    public static  List<Integer[]> merge ( List<Integer[]> pair){

        int start = pair.get(0)[0];
        int end = pair.get(0)[1];

        List<Integer[]> merged = new ArrayList<>();
        merged.add(new Integer[]{start, end});

        for(int i = 1; i < pair.size() ; i++){
            int x = pair.get(i)[0];
            int y = pair.get(i)[1];

            if(end >= x || end + 1 == x){
                merged.remove(merged.size()-1);
                merged.add(new Integer[]{start,y});
            }else {
                merged.add(new Integer[]{x,y});
                start = x;
            }


            end = y;

        }
        return merged;
    }
}

