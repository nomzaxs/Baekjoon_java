/***************************************************************************************************
2292번 벌집

limit_time : 2s, limit_memory : 128MB

문제


위의 그림과 같이 육각형으로 이루어진 벌집이 있다. 그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다. 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오. 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.

출력
입력으로 주어진 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나는지 출력한다.

예제 입력 1 
13
예제 출력 1 
3
***************************************************************************************************/

package simple_math_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_2292 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int room = Integer.parseInt(br.readLine());

        // 방 개수
        int i = 0;

        // 등차
        int r = 1;

        while(room / r != 0){

            if(room == r){

                break;
            } else if(room > 1){

                i++;
                // 6의 배수만큼 늘어난다
                r += 6 * i;
            }
        }
        
        System.out.println(i + 1);
    }
}