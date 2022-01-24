/***************************************************************************************************
1978번 소수 구하기

limit_time : 2s, limit_memory : 256MB

문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

예제 입력 1 
3 16
예제 출력 1 
3
5
7
11
13
***************************************************************************************************/

// 시간 초과됨 n^2을 줄여야 함

package simple_math_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int check;

        for(int i = M; i < N + 1; i++){
            check = 0;

            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    check++;
                    break;
                }
            }

            if(check == 0){
                System.out.println(i);
            }
        }
    }
}