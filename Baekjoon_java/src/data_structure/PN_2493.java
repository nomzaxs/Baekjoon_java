package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class PN_2493 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> building = new Stack<>();
        
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());

            while(!building.isEmpty()){
                if(building.peek()[0] < n){
                    building.pop();
                } else{
                    sb.append(building.peek()[1]).append(" ");
                    break;
                }
            }

            if(building.empty()){
                sb.append("0 ");
            }
            building.push(new int[] {n, i+1});
        }

        System.out.println(sb.toString());
    }
}