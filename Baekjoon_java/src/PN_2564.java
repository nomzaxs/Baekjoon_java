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