package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_10974 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = i + 1;
        }

        permutation(arr, 0, arr.length);
    }

    private static void permutation(int[] arr, int s, int e) {
        int[] per = new int[e];

        if(s == e){
            for(int i : arr){
                
            }
        }
    }
}
