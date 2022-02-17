/***************************************************************************************************
1987번 알파벳

limit_time : 2s, limit_memory : 256MB

문제
세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.

입력
첫째 줄에 R과 C가 빈칸을 사이에 두고 주어진다. (1 ≤ R,C ≤ 20) 둘째 줄부터 R개의 줄에 걸쳐서 보드에 적혀 있는 C개의 대문자 알파벳들이 빈칸 없이 주어진다.

출력
첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다.

예제 입력 1 
2 4
CAAB
ADCB
예제 출력 1 
3
예제 입력 2 
3 6
HFDFFB
AJHGDH
DGAGEH
예제 출력 2 
6
예제 입력 3 
5 5
IEFCJ
FHFKC
FFALF
HFGCF
HMCHH
예제 출력 3 
10
***************************************************************************************************/

package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_1987 {
    static int[] deltx = {0, 1, 0, -1};
    static int[] delty = {1, 0, -1, 0};
    static boolean[] use = new boolean['Z' - 'A' + 1];
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        char[][] arr = new char[R][C];

        for(int i = 0; i < R; i++){
            arr[i] = br.readLine().toCharArray();
        }

        recur(arr, 0, 0, 0);

        System.out.println(max);
    }

    private static void recur(char[][] arr, int i, int j, int cnt) {
        // 사용된 알파벳이면 이동한 칸 수를 비교해 최대값을 갱신한다.
        if(use[arr[i][j] - 'A']){
            max = Math.max(max, cnt);
            return;
        }

        // 알파벳 사용중
        use[arr[i][j] - 'A'] = true;
        for(int r = 0; r < 4; r++){
            int ni = i + delty[r];
            int nj = j + deltx[r];

            if(ni < 0 || ni >= arr.length || nj <0 || nj >= arr[0].length){
                continue;
            }
            recur(arr, ni, nj, cnt + 1);
        }
        // 알파벳 반납
        use[arr[i][j] - 'A'] = false;
    }
}