import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_16236 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        int sharkx = 0;
        int sharky = 0;

        // 입력 받기
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[n][i] = Integer.parseInt(st.nextToken());
                
                if(arr[n][i] == 9){
                    sharkx = i;
                    sharky = n;
                }
            }
        }



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}