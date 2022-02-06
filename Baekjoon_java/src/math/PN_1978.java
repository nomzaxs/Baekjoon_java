/***************************************************************************************************
1978번 소수 찾기

limit_time : 2s, limit_memory : 256MB

문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.

예제 입력 1 
4
1 3 5 7
예제 출력 1 
3
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_1978 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int count = N;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int t = 0; t < N; t++){
            arr[t] = Integer.parseInt(st.nextToken());

            if(arr[t] == 1){
                count--;
            }

            // 소수가 아닐 경우를 판별
            for(int i = 2; i < arr[t]; i++){
                if(arr[t] % i == 0){
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}