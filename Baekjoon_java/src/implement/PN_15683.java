/***************************************************************************************************
15683번 음계

limit_time : 1s, limit_memory : 512MB

문제
스타트링크의 사무실은 1×1크기의 정사각형으로 나누어져 있는 N×M 크기의 직사각형으로 나타낼 수 있다. 사무실에는 총 K개의 CCTV가 설치되어져 있는데, CCTV는 5가지 종류가 있다. 각 CCTV가 감시할 수 있는 방법은 다음과 같다.

				
1번	2번	3번	4번	5번
1번 CCTV는 한 쪽 방향만 감시할 수 있다. 2번과 3번은 두 방향을 감시할 수 있는데, 2번은 감시하는 방향이 서로 반대방향이어야 하고, 3번은 직각 방향이어야 한다. 4번은 세 방향, 5번은 네 방향을 감시할 수 있다.

CCTV는 감시할 수 있는 방향에 있는 칸 전체를 감시할 수 있다. 사무실에는 벽이 있는데, CCTV는 벽을 통과할 수 없다. CCTV가 감시할 수 없는 영역은 사각지대라고 한다.

CCTV는 회전시킬 수 있는데, 회전은 항상 90도 방향으로 해야 하며, 감시하려고 하는 방향이 가로 또는 세로 방향이어야 한다.

0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
지도에서 0은 빈 칸, 6은 벽, 1~5는 CCTV의 번호이다. 위의 예시에서 1번의 방향에 따라 감시할 수 있는 영역을 '#'로 나타내면 아래와 같다.

0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 # 6 0
0 0 0 0 0 0
→
0 0 0 0 0 0
0 0 0 0 0 0
# # 1 0 6 0
0 0 0 0 0 0
←
0 0 # 0 0 0
0 0 # 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
↑
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 # 0 0 0
↓
CCTV는 벽을 통과할 수 없기 때문에, 1번이 → 방향을 감시하고 있을 때는 6의 오른쪽에 있는 칸을 감시할 수 없다.

0 0 0 0 0 0
0 2 0 0 0 0
0 0 0 0 6 0
0 6 0 0 2 0
0 0 0 0 0 0
0 0 0 0 0 5
위의 예시에서 감시할 수 있는 방향을 알아보면 아래와 같다.

0 0 0 0 0 #
# 2 # # # #
0 0 0 0 6 #
0 6 # # 2 #
0 0 0 0 0 #
# # # # # 5
0 0 0 0 0 #
# 2 # # # #
0 0 0 0 6 #
0 6 0 0 2 #
0 0 0 0 # #
# # # # # 5
0 # 0 0 0 #
0 2 0 0 0 #
0 # 0 0 6 #
0 6 # # 2 #
0 0 0 0 0 #
# # # # # 5
0 # 0 0 0 #
0 2 0 0 0 #
0 # 0 0 6 #
0 6 0 0 2 #
0 0 0 0 # #
# # # # # 5
왼쪽 상단 2: ↔, 오른쪽 하단 2: ↔	왼쪽 상단 2: ↔, 오른쪽 하단 2: ↕	왼쪽 상단 2: ↕, 오른쪽 하단 2: ↔	왼쪽 상단 2: ↕, 오른쪽 하단 2: ↕
CCTV는 CCTV를 통과할 수 있다. 아래 예시를 보자.

0 0 2 0 3
0 6 0 0 0
0 0 6 6 0
0 0 0 0 0
위와 같은 경우에 2의 방향이 ↕ 3의 방향이 ←와 ↓인 경우 감시받는 영역은 다음과 같다.

# # 2 # 3
0 6 # 0 #
0 0 6 6 #
0 0 0 0 #
사무실의 크기와 상태, 그리고 CCTV의 정보가 주어졌을 때, CCTV의 방향을 적절히 정해서, 사각 지대의 최소 크기를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 사무실의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 8)

둘째 줄부터 N개의 줄에는 사무실 각 칸의 정보가 주어진다. 0은 빈 칸, 6은 벽, 1~5는 CCTV를 나타내고, 문제에서 설명한 CCTV의 종류이다. 

CCTV의 최대 개수는 8개를 넘지 않는다.

출력
첫째 줄에 사각 지대의 최소 크기를 출력한다.

예제 입력 1 
4 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
예제 출력 1 
20
예제 입력 2 
6 6
0 0 0 0 0 0
0 2 0 0 0 0
0 0 0 0 6 0
0 6 0 0 2 0
0 0 0 0 0 0
0 0 0 0 0 5
예제 출력 2 
15
예제 입력 3 
6 6
1 0 0 0 0 0
0 1 0 0 0 0
0 0 1 0 0 0
0 0 0 1 0 0
0 0 0 0 1 0
0 0 0 0 0 1
예제 출력 3 
6
예제 입력 4 
6 6
1 0 0 0 0 0
0 1 0 0 0 0
0 0 1 5 0 0
0 0 5 1 0 0
0 0 0 0 1 0
0 0 0 0 0 1
예제 출력 4 
2
예제 입력 5 
1 7
0 1 2 3 4 5 6
예제 출력 5 
0
예제 입력 6 
3 7
4 0 0 0 0 0 0
0 0 0 2 0 0 0
0 0 0 0 0 0 4
예제 출력 6 
0
***************************************************************************************************/

package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class PN_15683 {
    static int[] dir = {1, -1};
    static int min;
    static List<CCTV> list;

    static class CCTV {
        int type = 0;
        public int x;
        public int y;

        CCTV(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }

    private static int count(int[][] arr) {
        int num = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 0){
                    num++;
                }
            }
        }

        return num;
    }

    private static void pill(int[][] arr, int y, int x, int r){
        int sx = -1;
        int sy = -1;
        if(r == 0){
            sx = x;
            sy = y + 1;
            if (sy > arr.length - 1 || arr[sy][sx] == '6'){
                    return;
            }
            if (!(arr[sy][sx] == '1' || arr[sy][sx] == '2' || arr[sy][sx] == '3' || arr[sy][sx] == '4' || arr[sy][sx] == '5')){
                arr[sy][sx] -= 1;
            }
            pill(arr, sy, sx, r);
        }
        if(r == 1){
            sx = x;
            sy = y - 1;
            if (sy < 0 || arr[sy][sx] == '6'){
                    return;
            }
            if (!(arr[sy][sx] == '1' || arr[sy][sx] == '2' || arr[sy][sx] == '3' || arr[sy][sx] == '4' || arr[sy][sx] == '5')){
                arr[sy][sx] -= 1;
            }
            pill(arr, sy, sx, r);
        }
        if(r == 2){
            sx = x + 1;
            sy = y;
            if (sx > arr[0].length - 1 || arr[sy][sx] == '6'){
                    return;
            }
            if (!(arr[sy][sx] == '1' || arr[sy][sx] == '2' || arr[sy][sx] == '3' || arr[sy][sx] == '4' || arr[sy][sx] == '5')){
                arr[sy][sx] -= 1;
            }
            pill(arr, sy, sx, r);
        }
        if(r == 3){
            sx = x - 1;
            sy = y;
            if (sx < 0 || arr[sy][sx] == '6'){
                    return;
            }
            if (!(arr[sy][sx] == '1' || arr[sy][sx] == '2' || arr[sy][sx] == '3' || arr[sy][sx] == '4' || arr[sy][sx] == '5')){
                arr[sy][sx] -= 1;
            }
            pill(arr, sy, sx, r);
        }
    }

    private static void remove(int[][] arr, int y, int x, int r){
        int sx = -1;
        int sy = -1;
        if(r == 0){
            sx = x;
            sy = y + 1;
            if (sy > arr.length - 1 || arr[sy][sx] == '6'){
                    return;
            }
            if (!(arr[sy][sx] == '1' || arr[sy][sx] == '2' || arr[sy][sx] == '3' || arr[sy][sx] == '4' || arr[sy][sx] == '5')){
                arr[sy][sx] += 1;
            }
            remove(arr, sy, sx, r);
        }
        if(r == 1){
            sx = x;
            sy = y - 1;
            if (sy < 0 || arr[sy][sx] == '6'){
                    return;
            }
            if (!(arr[sy][sx] == '1' || arr[sy][sx] == '2' || arr[sy][sx] == '3' || arr[sy][sx] == '4' || arr[sy][sx] == '5')){
                arr[sy][sx] += 1;
            }
            remove(arr, sy, sx, r);
        }
        if(r == 2){
            sx = x + 1;
            sy = y;
            if (sx > arr[0].length - 1 || arr[sy][sx] == '6'){
                    return;
            }
            if (!(arr[sy][sx] == '1' || arr[sy][sx] == '2' || arr[sy][sx] == '3' || arr[sy][sx] == '4' || arr[sy][sx] == '5')){
                arr[sy][sx] += 1;
            }
            remove(arr, sy, sx, r);
        }
        if(r == 3){
            sx = x - 1;
            sy = y;
            if (sx < 0 || arr[sy][sx] == '6'){
                    return;
            }
            if (!(arr[sy][sx] == '1' || arr[sy][sx] == '2' || arr[sy][sx] == '3' || arr[sy][sx] == '4' || arr[sy][sx] == '5')){
                arr[sy][sx] += 1;
            }
            remove(arr, sy, sx, r);
        }
    }

    private static void recur(int[][] arr, int i, int j) {
        if(i == arr.length - 1 && j == arr[0].length - 1){
            min = Math.min(min, count(arr));
            return;
        }

        for(int y = i; y < arr.length; y++){
            for(int x = j; x < arr[0].length; x++){
                if(arr[y][x] <= 0 || arr[y][x] > 5){
                    continue;
                }

                switch(arr[y][x]){
                    case 1:
                    for(int r = 0; r < 4; r++){
                        pill(arr, y, x, r);
                        recur(arr, y, x);
                        remove(arr, y, x, r);
                    }
                    break;
                    case 2:
                    for(int r = 0; r < 2; r++){
                        pill(arr, y, x, r + r);
                        pill(arr, y, x, r + r + 1);
                        recur(arr, y, x);
                        remove(arr, y, x, r + r);
                        remove(arr, y, x, r + r + 1);
                    }
                    break;
                    case 3:
                        pill(arr, y, x, 0);
                        pill(arr, y, x, 2);
                        recur(arr, y, x);
                        remove(arr, y, x, 0);
                        remove(arr, y, x, 2);

                        pill(arr, y, x, 0);
                        pill(arr, y, x, 3);
                        recur(arr, y, x);
                        remove(arr, y, x, 0);
                        remove(arr, y, x, 3);

                        pill(arr, y, x, 1);
                        pill(arr, y, x, 2);
                        recur(arr, y, x);
                        remove(arr, y, x, 1);
                        remove(arr, y, x, 2);

                        pill(arr, y, x, 1);
                        pill(arr, y, x, 3);
                        recur(arr, y, x);
                        remove(arr, y, x, 1);
                        remove(arr, y, x, 3);
                    break;
                    case 4:
                    for(int r = 0; r < 4; r++){
                        pill(arr, y, x, r);
                        pill(arr, y, x, (r + 1) % 4);
                        pill(arr, y, x, (r + 2) % 4);
                        recur(arr, y, x);
                        remove(arr, y, x, r);
                        remove(arr, y, x, (r + 1) % 4);
                        remove(arr, y, x, (r + 2) % 4);
                    }
                    break;
                    case 5:
                        pill(arr, y, x, 0);
                        pill(arr, y, x, 1);
                        pill(arr, y, x, 2);
                        pill(arr, y, x, 3);
                        recur(arr, y, x);
                        remove(arr, y, x, 0);
                        remove(arr, y, x, 1);
                        remove(arr, y, x, 2);
                        remove(arr, y, x, 3);
                    break;
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        min = N * M;

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
                if (arr[n][m] != '0' && arr[n][m] != '6')
                list.add(new CCTV(arr[n][m] - '0', n, m));
            }
        }

        recur(arr, 0, 0);
    }
}