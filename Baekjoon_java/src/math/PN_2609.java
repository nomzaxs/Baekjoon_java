/***************************************************************************************************
2609번 최대공약수와 최소공배수

limit_time : 1s, limit_memory : 128MB

문제
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

출력
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

예제 입력 1 
24 18
예제 출력 1 
6
72
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        // 최대공약수
        int GCD = gcd(num1, num2);
        // 최소공배수
        int LCM = lcm(GCD, num1, num2);

        System.out.println(GCD);
        System.out.println(LCM);
    }

    // 최소공배수
    private static int lcm(int gcd, int num1, int num2) {
        num1 /= gcd;
        num2 /= gcd;

        return gcd * num1 * num2;
    }

    // 최대공약수
    private static int gcd(int num1, int num2) {
        while(num1 != 0 && num2 != 0){
            if(num1 > num2){
                num1 %= num2;
            } else{
                num2 %= num1;
            }
        }
        return num1 + num2;
    }
}