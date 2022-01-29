/***************************************************************************************************
4153번 직각삼각형

limit_time : 1s, limit_memory : 128MB

문제
과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.

입력
입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.

출력
각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.

예제 입력 1 
6 8 10
25 52 60
5 12 13
0 0 0
예제 출력 1 
right
wrong
right
***************************************************************************************************/

package simple_math_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int x, y, z;

        while(true){
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            if(z > x && z > y){
                if(x * x + y * y == z * z){
                    System.out.println("right");
                } else{
                    System.out.println("wrong");
                }
            } else if(y > x && y > z){
                if(x * x + z * z == y * y){
                    System.out.println("right");
                } else{
                    System.out.println("wrong");
                }
            } else if(x > y && x > z){
                if(y * y + z * z == x * x){
                    System.out.println("right");
                } else{
                    System.out.println("wrong");
                }
            }

            if(x == 0 && y == 0 && z == 0){
                break;
            }
        }
    }
}