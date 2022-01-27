/***************************************************************************************************
4948번 베르트랑 공준

limit_time : 1s, limit_memory : 256MB

문제
베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.

이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.

예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)

자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오. 

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다.

입력의 마지막에는 0이 주어진다.

출력
각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.

제한
1 ≤ n ≤ 123,456

예제 입력 1 
1
10
13
100
1000
10000
100000
0
예제 출력 1 
1
4
3
21
135
1033
8392
***************************************************************************************************/

package simple_math_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PN_4948 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int lastNum = 2;
        int count = 0;

        ArrayList<Boolean> primeList = new ArrayList<Boolean>();

        // 0, 1 소수가 아님 처리
        primeList.add(false);
        primeList.add(false);

        while(n != 0){
            
            // 전에 입력한 수보다 작은 경우
            if(n < lastNum){
                for(int i = 2; i < n * 2 + 1; i++){
                    primeList.add(true);
                }

                for(int i = 2; i < n * 2 + 1; i++){
                    if(primeList.get(i)){
                        for(int j = i * 2; j < n * 2 + 1; j += i){
                            primeList.set(j, false);
                        }
                    }
                }
            } else {    // 전에 입력한 수보다 큰 경우 큰 수만큼 사용
                for(int i = lastNum; i < n * 2 + 1; i++){
                    primeList.add(true);
                }

                for(int i = 2; i < n * 2 + 1; i++){
                    if(primeList.get(i)){
                        for(int j = i * 2; j < n * 2 + 1; j += i){
                            primeList.set(j, false);
                        }
                    }
                }
            }

            for(int i = n + 1; i < n * 2 + 1; i++){
                
                if(primeList.get(i)){
                    count++;
                }
            }

            System.out.println(count);

            count = 0;
            lastNum = n;

            n = Integer.parseInt(br.readLine());
        }
    }
}
