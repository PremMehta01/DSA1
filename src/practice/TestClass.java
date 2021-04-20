package practice;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        int[][] matrix = new int[vertices + 1][vertices + 1];
        int[] connections = new int[vertices + 1];

        while(edges-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();

            connections[x]++;
            connections[y]++;

            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }

        int result = 0;
        for(int i = 1; i <= vertices; i++){
            int headCon = connections[i];
            if(headCon >= 4){
                for(int j = 1; j <= vertices; j++){
                    if(matrix[i][j] == 1 && connections[j] >= 3){
                        result++;
                        result %= 1000000007;
                    }
                }
            }
        }

        System.out.println("- " + result);

    }
}
