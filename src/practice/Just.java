package practice;


import java.util.Random;
import java.util.Scanner;

class Just {

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);

        String V = sc.next();
        int N = sc.nextInt();

        String[] B = new String[N];

        for(int i = 0; i < N; i++)
            B[i] = sc.next();

        for(int i = 0; i < N; i++)
            System.out.println(test(B[i], V));
    }

    private static String test(String comp, String V){
        int j = 0;

        for(int i = 0; i < V.length(); i++){
            char c = comp.charAt(j);
            char v = V.charAt(i);
            if(v == c) j++;

            if(j >= comp.length()) return "POSITIVE";
        }

        return "NEGATIVE";
    }

}
