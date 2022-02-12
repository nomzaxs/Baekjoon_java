/***************************************************************************************************
2751번 수 정렬하기 2

limit_time : 2s, limit_memory : 256MB

문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

예제 입력 1 
5
5
4
3
2
1
예제 출력 1 
1
2
3
4
5
***************************************************************************************************/

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_2751 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int n = 0;
        boolean[] check = new boolean[2000001];

        for(int i = 0; i < N; i++){
            n = Integer.parseInt(br.readLine()) + 1000000;
            check[n] = true;
        }

        int count = 0;

        for(int i = 0; i < 2000001; i++){
            if(count == N){
                break;
            }
            if(check[i]){
                sb.append((i - 1000000)).append("\n");
                count++;
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}