import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_2477 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int[][] arr = new int[6][2];
        int maxgaro = 0;
        int maxsero = 0;
        int garo = 0;
        int sero = 0;

        for(int i = 0; i < 6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if(arr[i][0] > 2){
                if(maxgaro < arr[i][1]){
                    maxgaro = arr[i][1];
                    garo = i;
                }
            } else{
                if(maxsero < arr[i][1]){
                    maxsero = arr[i][1];
                    sero = i;
                }
            }
        }

        int minsero = Math.min(arr[(garo + 7) % 6][1], arr[(garo + 5) % 6][1]);
        int mingaro = Math.min(arr[(sero + 7) % 6][1], arr[(sero + 5) % 6][1]);

        int area = minsero * maxgaro + mingaro * maxsero - mingaro * minsero;

        System.out.println(area * K);
    }
}
