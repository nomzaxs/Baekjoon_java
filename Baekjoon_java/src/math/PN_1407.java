/***************************************************************************************************
1407번 2로 몇 번 나누어질까

limit_time : 2s, limit_memory : 128MB

문제
자연수 N이 주어지면, 자연수를 유지하면서 N을 2로 몇 번까지 나눌 수 있는지를 생각해 볼 수 있다. 즉, N의 모든 약수 중 2의 거듭제곱 꼴이면서 가장 큰 약수를 생각하는 것이다. 예를 들어 15의 경우는 2로 한 번도 나눌 수 없으므로 2^0 = 1이 해당되고, 40의 경우는 2로 세 번까지 나눌 수 있으므로 2^3 = 8이 해당된다. 이러한 약수를 함수값으로 가지는 함수 f(x)를 정의하자. 즉, f(15) = 1이고, f(40) = 8이다.

두 자연수 A, B(A≤B)가 주어지면, A 이상 B 이하의 모든 자연수에 대해서, 그 자연수의 모든 약수 중 2의 거듭제곱 꼴이면서 가장 큰 약수들의 총 합을 구하는 프로그램을 작성하시오. 즉 아래와 같은 수식의 값을 구해야 한다.

f(A) + f(A+1) + ... + f(B-1) + f(B)

입력
첫째 줄에 자연수 A와 B가 빈 칸을 사이에 두고 주어진다. (1≤A≤B≤10^15)

출력
첫째 줄에 구하고자 하는 수를 출력한다.

예제 입력 1 
176 177
예제 출력 1 
17
예제 입력 2 
5 9
예제 출력 2 
13
예제 입력 3 
25 28
예제 출력 3 
8
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_1407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(f(B) - f(A - 1));
    }

    private static long f(long a) {
        long r = a;
        for (long i = 2; i <= a; i *= 2) {
            r += (a / i) * (i / 2);
        }

        return r;
    }
}