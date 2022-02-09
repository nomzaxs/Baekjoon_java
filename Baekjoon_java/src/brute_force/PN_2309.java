/***************************************************************************************************
2309번 일곱 난쟁이

limit_time : 2s, limit_memory : 128MB

문제
왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.

아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

입력
아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.

출력
일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.

예제 입력 1 
20
7
23
19
10
15
25
8
13
예제 출력 1 
7
8
10
13
19
20
23
***************************************************************************************************/

package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PN_2309 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] nan = new int[9];
        int sum = 0;

        for(int i = 0; i < nan.length; i++){
            nan[i] = Integer.parseInt(br.readLine());
            sum += nan[i];
        }

        Arrays.sort(nan);

        int a = 0;
        int b = 0;

        for(int i = 0; i < nan.length - 1; i++){
            for(int j = i + 1; j < nan.length; j++){
                if(sum - nan[i] - nan[j] == 100){
                    a = i;
                    b = j;
                }
            }
        }

        for(int i = 0; i < nan.length; i++){
            if(i != a && i != b){
                sb.append(nan[i]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}