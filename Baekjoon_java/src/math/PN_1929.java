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
// 에라토스테네시의 체 라는 소수를 찾는 알고리즘.
// 소수의 곱을 구하려는 수의 제곱근의 배수들만 지워도 충분하다는 알고리즘이다.

package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PN_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Boolean> primeList;

        primeList = new ArrayList<Boolean>(N + 1);

        // 0, 1번째를 소수 아님으로 처리
        primeList.add(false);
        primeList.add(false);

        // 2부터 소수로 설정
        for(int i = 2; i < N + 1; i++){
            primeList.add(i, true);
        }

        // 소수 판별
        for(int i = 2; i < primeList.size(); i++){
            if(primeList.get(i)){
                for(int j = i * 2; j < N + 1; j += i){
                    primeList.set(j, false);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 소수일 시 출력
        for(int i = M; i < primeList.size(); i++){
            if(primeList.get(i)){
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}