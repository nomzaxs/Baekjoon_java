/***************************************************************************************************
15736번 청기 백기

limit_time : 1s, limit_memory : 128MB

문제
소프트웨어융합대학 학생회에서 주최한 소융체전에서 청기 백기 뒤집기 게임이 한창이다. 소프트웨어학부, ICT융합학부가 번갈아가면서 게임을 진행하는 중이다. 게임의 규칙은 간단하다. 게임을 진행할 차례인 학부에서 출전한 선수들 N명이 존재한다. 학생들의 앞 탁자에는 N개의 깃발이 청색이 위로 백색이 아래로 보이도록 놓여있다. 이때 출전한 선수 중 첫 번째 선수는 N개의 깃발 중 1의 배수에 해당하는 번호의 깃발을 뒤집어 놓는다. 다음 두 번째 선수는 N개의 깃발 중 2의 배수에 해당하는 번호의 깃발을 뒤집어 놓는다. i 번째 선수는 i의 배수에 해당하는 번호의 깃발을 뒤집고, N 번째 선수까지 진행하면 끝이 난다. 그렇다면 이 게임에서 N 명의 선수가 참가하고 N개의 깃발이 존재할 때, N 번째 선수까지 진행하여 완료된 상태에서 백색이 위로 놓여있는 깃발의 수가 몇 개인지 알아보자.

입력
첫 번째 줄에 출전한 학생의 수이자, 깃발의 개수인 N(1 ≤ N ≤ 2,100,000,000)이 주어진다.

출력
첫 번째 줄에 N 번째 선수까지 진행한 후의 상태의 깃발 중 백색이 위로 놓여있는 깃발의 수를 출력한다.

예제 입력 1 
3
예제 출력 1 
1
예제 입력 2 
24
예제 출력 2 
4
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_15736 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long res = 1;

        while (true) {
            if (res * res > N) {
                break;
            }

            res++;
        }

        System.out.println(res - 1);
    }
}