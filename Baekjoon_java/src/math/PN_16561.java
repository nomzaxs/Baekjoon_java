/***************************************************************************************************
16561번 3의 배수

limit_time : 0.1s, limit_memory : 128MB

문제
윤영이는 3의 배수 마니아이다. 그는 모든 자연수를 3개의 3의 배수의 자연수로 분해하는 것을 취미로 가지고 있다. 문득 그는 자신에게 주어진 수를 3개의 3의 배수로 분리하는 경우의 수가 몇 개인지 궁금해졌다. 하지만 윤영이는 마지막 학기이기 때문에 이런 계산을 하기에는 너무 게을러졌다. 그래서 당신에게 이 계산을 부탁했다.

즉, 임의의 3의 배수 자연수 n이 주어졌을 때, 해당 수를 3의 배수의 자연수 3개로 분리하는 방법의 개수를 출력해라. 단 분해한 수의 순서가 다르면 다른 방법으로 간주한다. 예를 들어 12 = 3 + 6 + 3 과 12 = 3 + 3 + 6 은 다른 방법이다.

입력
임의의 3의 배수 자연수 n이 주어진다. (3 ≤ n ≤ 3000)

출력
자연수 n을 분해하는 방법의 개수를 출력하라.

예제 입력 1 
9
예제 출력 1 
1
예제 입력 2 
12
예제 출력 2 
3
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_16561 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sum = 1;

        for (int i = 9; i < n; i += 3) {
            sum += ((i / 3) - 1);
        }

        System.out.println(sum);
    }
}