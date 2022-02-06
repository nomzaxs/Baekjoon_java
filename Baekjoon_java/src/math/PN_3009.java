/***************************************************************************************************
3009번 네 번째 점

limit_time : 1s, limit_memory : 128MB

문제
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

입력
세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

출력
직사각형의 네 번째 점의 좌표를 출력한다.

예제 입력 1 
5 5
5 7
7 5
예제 출력 1 
7 7
예제 입력 2 
30 20
10 10
10 20
예제 출력 2 
30 10
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dot1 = new int[2];
        int[] dot2 = new int[2];
        int[] dot3 = new int[2];
        
        st = new StringTokenizer(br.readLine()," ");
        dot1[0] = Integer.parseInt(st.nextToken());
        dot1[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        dot2[0] = Integer.parseInt(st.nextToken());
        dot2[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        dot3[0] = Integer.parseInt(st.nextToken());
        dot3[1] = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;

        if(dot1[0] == dot2[0]){
            x = dot3[0];
        } else if(dot2[0] == dot3[0]){
            x = dot1[0];
        } else{
            x = dot2[0];
        }

        if(dot1[1] == dot2[1]){
            y = dot3[1];
        } else if(dot2[1] == dot3[1]){
            y = dot1[1];
        } else{
            y = dot2[1];
        }

        System.out.print(x + " " + y);
    }
}