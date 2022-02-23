import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_10026 {
    static char[][] map;
    static boolean visited[][];
    static int dx[] = { -1, 0, 0, 1 };
    static int dy[] = { 0, 1, -1, 0 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        // 입력
        for (int n = 0; n < N; n++) {
            map[n] = br.readLine().toCharArray();
        }

        // 정상 방문하지 않았다면 dfs실행
        int ncnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    ncnt++;
                }
            }
        }

        int cnt = 0;
        visited = new boolean[N][N];

        // G -> R로 바꾼다.
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 'G'){
                    map[i][j] = 'R';
                }
            }
        }

        // 적록색약 dfs
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(ncnt + " " + cnt);
    }

    // dfs
    private static void dfs(int i, int j) {
        visited[i][j] = true;
        char temp = map[i][j];

        for(int k = 0; k < 4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx < 0 || ny < 0 || nx >= map.length || ny >= map.length){
                continue;
            }

            if(!visited[nx][ny] && map[nx][ny] == temp){
                dfs(nx, ny);
            }
        }
    }
}