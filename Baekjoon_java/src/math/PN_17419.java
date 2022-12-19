/***************************************************************************************************
17419번 비트가 넘쳐흘러

limit_time : 1s, limit_memory : 512MB

문제
🎶 DJ욱제는 비트에 몸을 맡기는 중이다. 🎶

DJ욱제는 비트에 심취한 나머지, 비트를 비틀어 제껴버리는 문제를 내 버렸다!

N자리 이진수 K가 주어진다. K가 0이 아닐 때까지 아래의 연산을 적용했을 때, 연산이 일어나는 횟수를 구하시오.

K = K-(K&((~K)+1))
아래는 위의 연산에 사용된 연산자에 대한 설명이다.

'+'는 산술 더하기 연산이다. (5 + 2 = 7)
'-'는 산술 빼기 연산이다. (5 - 2 = 3)
'&'는 비트 AND 연산이다. (1101 & 0111 = 0101)
'~'는 비트 NOT 연산이다. 켜진 비트를 끄고, 꺼진 비트를 켜는 연산이다. (~1101 = 0010)
입력
첫째 줄에 N이 주어진다.

둘째 줄에 N자리 이진수 K가 주어진다. K는 0으로 시작하지 않는다. 즉, leading zero는 없다.

출력
연산이 일어나는 횟수를 출력한다.

제한
1 ≤ N ≤ 1,000,000
서브태스크 1 (51점)
이 서브태스크는 다음의 조건을 만족한다.

1 ≤ N ≤ 30
서브태스크 2 (49점)
이 서브태스크는 추가 제한 조건이 없다.

예제 입력 1 
5
10110
예제 출력 1 
3
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_17419 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int cnt = 0;

        for (int i : arr) {
            if (i == '1') {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
