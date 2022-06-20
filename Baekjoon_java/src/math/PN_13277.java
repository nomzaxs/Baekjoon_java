/***************************************************************************************************
13277번 큰 수 곱셈

limit_time : 3s, limit_memory : 512MB

문제
두 정수 A와 B가 주어졌을 때, 두 수의 곱을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 A와 B가 주어진다. 두 정수는 0보다 크거나 같은 정수이며, 0을 제외한 정수는 0으로 시작하지 않으며, 수의 앞에 불필요한 0이 있는 경우도 없다. 또한, 수의 길이는 300,000자리를 넘지 않는다.

출력
두 수의 곱을 출력한다.

예제 입력 1 
1 2
예제 출력 1 
2
예제 입력 2 
3 4
예제 출력 2 
12
예제 입력 3 
893724358493284 238947328947329
예제 출력 3 
213553048277135320552236238436
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class PN_13277 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    BigInteger A = new BigInteger(st.nextToken());
    BigInteger B = new BigInteger(st.nextToken());

    System.out.println(A.multiply(B));
  }
}