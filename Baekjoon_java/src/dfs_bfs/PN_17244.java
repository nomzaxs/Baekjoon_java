/***************************************************************************************************
17244번 아맞다우산

limit_time : 1s, limit_memory : 256MB

문제


경재씨는 저녁 약속을 가기 전 챙기지 않은 물건들이 있는 지 확인하고 있다. 필요한 물건은 전부 챙긴 것 같았고 외출 후 돌아오는 길에 경재씨는 외쳤다.

"아 맞다 우산!!!"

경재 씨는 매번 외출하고 나서야 어떤 물건을 집에 놓고 왔다는 것을 떠올릴 때마다 자책감에 시달리는 것이 너무 싫었다.

외출이 잦은 경재 씨는 반복되는 일을 근절하기 위해 꼭 챙겨야 할 물건들을 정리해보았다. 하지만 지갑, 스마트폰, 우산, 차 키, 이어폰, 시계, 보조 배터리 등 종류와 개수가 너무 많았다.

평소 불필요한 움직임을 아주 싫어하는 경재 씨는 이 물건들을 최대한 빠르게 챙겨서 외출하는 이동 경로를 알고 싶었다.

경재 씨는 한 걸음에 상하좌우에 인접한 칸으로만 움직일 수 있다.

경재 씨를 위해 집을 위에서 바라본 모습과 챙겨야 할 물건들의 위치들을 알고 있을 때, 물건을 모두 챙겨서 외출하기까지 최소 몇 걸음이 필요한지 구하는 프로그램을 작성하자.

입력
첫 번째 줄에는 집의 가로 길이 N과 세로 길이 M이 입력된다. (3 ≤ N, M ≤ 50)

두 번째 줄부터는 집의 구조가 예제 입력과 같이 주어진다.

비어있는 곳은 '.'로 벽은 '#'로 입력된다. 경재 씨의 현재 위치는 S, 나가는 문의 위치는 E, 챙겨야 하는 물건은 종류에 상관없이 X로 입력된다.

챙겨야 하는 물건은 최대 5개까지 있을 수 있다. 집은 언제나 벽으로 둘러싸여 있고, 나가는 문은 언제나 하나이다.

출력
S에서 출발하여 모든 물건을 챙겨서 E까지 도착할 수 있는 최소 시간을 출력한다. 모든 물건을 챙길 수 없는 경우는 주어지지 않는다.

예제 입력 1 
7 6
#######
#SX..X#
#..####
#..X..#
#...X.#
#####E#
예제 출력 1 
14
***************************************************************************************************/

package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PN_17244 {
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] map = new int[51][51];
    static boolean[][][] visit = new boolean[51][51][(1 << 6)];
    static int sx, sy, ex, ey, num;

    static class Point {
        int x, y, m, i;

        public Point(int x, int y, int m, int i) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.i = i;
        }
    }

    static int BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visit[y][x][0] = true;

        queue.add(new Point(x, y, 0, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.y == ey && p.x == ex && p.i == ((1 << num) - 1)) {
                return p.m;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int ni = 0;

                if (nx < 0 || ny < 0 || visit[ny][nx][p.i] || map[ny][nx] == 5) {
                    continue;
                }

                if (map[ny][nx] >= 0 && map[ny][nx] < 5) {
                    int cnt = map[ny][nx];

                    if ((p.i & (1 << cnt)) == 0) {
                        ni = p.i | (1 << cnt);

                        visit[ny][nx][ni] = true;
                        queue.add(new Point(nx, ny, p.m + 1, ni));
                        continue;
                    }
                }

                visit[ny][nx][p.i] = true;
                queue.add(new Point(nx, ny, p.m + 1, p.i));
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        num = 0;

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                char ch = str.charAt(j);

                if (ch == 'X') {
                    map[i][j] = num++;
                } else if (ch == '#') {
                    map[i][j] = 5;
                } else if (ch == 'S') {
                    sy = i;
                    sx = j;
                    map[i][j] = -1;
                } else if (ch == 'E') {
                    ey = i;
                    ex = j;
                    map[i][j] = -1;
                } else {
                    map[i][j] = -1;
                }
            }
        }

        System.out.println(BFS(sx, sy));
    }
}
