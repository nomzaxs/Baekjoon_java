/***************************************************************************************************
14568번 2017 연세대학교 프로그래밍 경시대회

limit_time : 1s, limit_memory : 128MB

문제
2015, 2016년에 이어 2017년에도 연세대학교 교내 프로그래밍 경시대회가 열린다.

택희, 영훈이, 남규는 열심히 문제를 만들었고, 이에 대한 보상으로 과사로부터 사탕 N개를 받았다.

N개의 사탕을 적절히 나눠 가지기 위해 토론한 결과, 아래와 같은 방식으로 사탕을 나누기로 결정하였다.

남는 사탕은 없어야 한다.
남규는 영훈이보다 2개 이상 많은 사탕을 가져야 한다.
셋 중 사탕을 0개 받는 사람은 없어야 한다.
택희가 받는 사탕의 수는 홀수개가 되어서는 안 된다.
이제 사탕을 적절히 나누어 집에 돌아가던 중, 택희는 위와 같은 규칙을 만족하도록 세 명에게 사탕을 나누어 주는 방법의 수가 궁금해졌다.

사탕의 개수 N이 주어지면, 사탕을 세 사람에게 분배하는 서로 다른 경우의 수를 세 보자.

입력
첫째 줄에 사탕의 총 개수 N이 주어진다. (1 ≤ N ≤ 100)

출력
규칙에 맞게 사탕을 분배하는 경우의 수를 출력한다. 택희, 영훈이, 남규가 받은 사탕의 수를 각각 A, B, C개라고 할 때, 서로 다른 (A, B, C) 순서쌍의 수를 세면 된다.

만일 규칙에 맞게 사탕을 분배하는 방법이 없다면 0을 출력한다.



예제 입력 1 
6
예제 출력 1 
1
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_14568 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i = 2; i <= n - 2; i += 2) {
            result += (n - i - 2) / 2;
        }

        System.out.println(result);
    }
}