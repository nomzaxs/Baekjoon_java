/***************************************************************************************************
2564번 경비원

limit_time : 1s, limit_memory : 128MB

문제
동근이는 무인 경비 회사 경비원으로 항상 대기하고 있다가 호출이 들어오면 경비차를 몰고 그 곳으로 달려가야 한다. 동근이가 담당하고 있는 곳은 직사각형 모양의 블록으로 블록 중간을 가로질러 차가 통과할만한 길이 없다. 이 블록 경계에 무인 경비를 의뢰한 상점들이 있다.

예를 들어 가로의 길이가 10, 세로의 길이가 5인 블록의 경계에 무인 경비를 의뢰한 3개의 상점이 있다고 하자. <그림 1>과 같이 이들은 1, 2, 3으로 표시되어 있고, 동근이는 X로 표시한 위치에 있다.



< 그림 1 >

1번 상점에서 호출이 들어 왔을 때 동근이가 블록을 시계방향으로 돌아 이동하면 이동 거리가 12가 된다. 반면 반시계방향으로 돌아 이동하면 이동 거리는 18이 된다. 따라서 동근이가 1번 상점으로 가는 최단 거리는 12가 된다. 마찬가지로 동근이의 위치에서 2번 상점까지의 최단 거리는 6, 3번 상점까지의 최단 거리는 5가 된다.

블록의 크기와 상점의 개수 및 위치 그리고 동근이의 위치가 주어질 때 동근이의 위치와 각 상점 사이의 최단 거리의 합을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 블록의 가로의 길이와 세로의 길이가 차례로 주어진다. 둘째 줄에 상점의 개수가 주어진다. 블록의 가로의 길이와 세로의 길이, 상점의 개수는 모두 100이하의 자연수이다. 이어 한 줄에 하나씩 상점의 위치가 주어진다. 상점의 위치는 두 개의 자연수로 표시된다. 첫째 수는 상점이 위치한 방향을 나타내는데, 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽에 상점이 있음을 의미한다. 둘째 수는 상점이 블록의 북쪽 또는 남쪽에 위치한 경우 블록의 왼쪽 경계로부터의 거리를 나타내고, 상점이 블록의 동쪽 또는 서쪽에 위치한 경우 블록의 위쪽 경계로부터의 거리를 나타낸다. 마지막 줄에는 동근이의 위치가 상점의 위치와 같은 방식으로 주어진다. 상점의 위치나 동근이의 위치는 블록의 꼭짓점이 될 수 없다.

출력
첫째 줄에 동근이의 위치와 각 상점 사이의 최단 거리의 합을 출력한다.

예제 입력 1 
10 5
3
1 4
3 2
2 8
2 3
예제 출력 1 
23
***************************************************************************************************/

package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int cntstore = Integer.parseInt(br.readLine());

        int[][] store = new int[cntstore][2];

        for(int i = 0; i < cntstore; i++){
            st = new StringTokenizer(br.readLine());

            store[i][0] = Integer.parseInt(st.nextToken());
            store[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int dir = Integer.parseInt(st.nextToken());
        int reach = Integer.parseInt(st.nextToken());

        int sum = 0;

        for(int i = 0; i < cntstore; i++){
            if(dir == store[i][0]){
                sum += Math.abs(reach - store[i][1]);
            } else if(dir < 3){
                if(store[i][0] < 3){
                    sum += Math.min(c + reach + store[i][1], c + r - reach + r - store[i][1]);
                } else if(store[i][0] > 2){
                    if(dir == 1 && store[i][0] == 3){
                        sum += reach + store[i][1];
                    } else if(dir == 1 && store[i][0] == 4){
                        sum += r - reach + store[i][1];
                    } else if(dir == 2 && store[i][0] == 3){
                        sum += reach + c - store[i][1];
                    } else{
                        sum += r - reach + c - store[i][1];
                    }
                }
            } else{
                if(store[i][0] > 2){
                    sum += Math.min(r + reach + store[i][1], r + c - reach + c - store[i][1]);
                } else if(store[i][0] < 3){
                    if(dir == 3 && store[i][0] == 1){
                        sum += reach + store[i][1];
                    } else if(dir == 3 && store[i][0] == 2){
                        sum += c - reach + store[i][1];
                    } else if(dir == 4 && store[i][0] == 1){
                        sum += reach + r - store[i][1];
                    } else{
                        sum += c - reach + r - store[i][1];
                    }
                }
            }
        }

        System.out.println(sum);
    }
}