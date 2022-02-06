/***************************************************************************************************
10757번 큰 수 A+B

limit_time : 1s, limit_memory : 256MB

문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. (0 < A,B < 10^10000)

출력
첫째 줄에 A+B를 출력한다.

예제 입력 1 
9223372036854775807 9223372036854775808
예제 출력 1 
18446744073709551615
***************************************************************************************************/

// 22.01.23 미해결 수정 필요
package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // 수가 10^10000 까지의 큰 수는 자료형으로 표현이 불가하다.
        // 따라서 배열로 하거나, 진수 변환을 통해서 해야 할 것 같다.
        // 또한 빠른 속도를 위해서 수를 끊어서 계산하는 방법도 괜찮을 것 같다.

        // A와 B를 입력 받아 char배열로 만들어 준다.
        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();

        // 큰 수를 기준으로 잡아준다.
        if(A.length >= B.length){
            big(A, B);
        } else {
            big(B, A);
        }
    }

    private static void big(char[] a, char[] b) {
        char[] result = new char[a.length];

        for(int i = a.length - 1, j = b.length - 1; i >= 0; i--){

            // 작은 수의 자릿수가 더 작을 경우 큰 수의 값만 배열에 넣어준다.
            if(j >= 0){
                // 중복된 0의 아스키 값을 빼서 넣어준다.
                result[i] += (char) (a[i] + b[j] - '0');

                // 더한 값이 10을 넘을 경우 올림 해준다. 가장 큰 자릿수는 올림을 하지 않는다.
                if(result[i] > '9' && i > 0){
                    result[i] -= 10;
                    result[i - 1] += 1;
                }
            
            // 작은 수의 자릿수가 더 작을 경우 큰 수의 값만 배열에 넣어준다.
            } else {
                result[i] += a[i];

                // 더한 값이 10을 넘을 경우 올림 해준다. 가장 큰 자릿수는 올림을 하지 않는다.
                if(result[i] > '9' && i > 0){
                    result[i] -= 10;
                    result[i - 1] += 1;
                }
            }

            j--;
        }

        // 가장 큰 수의 올림이 필요한 경우
        if(result[0] > '9'){
            System.out.print(result[0] - '0');

            for(int i = 1; i < result.length; i++){

                System.out.print((result[i]));
            }
        } else {
            for(int i = 0; i < result.length; i++){

                System.out.print((result[i]));
            }
        }
    }
}