import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_2491 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int result = 1;

        for(int i = 0; i < N - 1; i++){
            if(arr[i] > arr[i + 1]){
                result = Math.max(result, seq(arr, i, 1));
            } else if(arr[i] == arr[i + 1]){
                result = Math.max(result, seq(arr, i, 2));
            } else {
                result = Math.max(result, seq(arr, i, 0));
            }
        }

        System.out.println(result);

    }

    private static int seq(int[] arr, int i, int dir) {
        int cnt = 1;

        if(dir == 2){
            for(int j = i; j < arr.length - 1; j++){
                if(arr[j] >= arr[j + 1]){
                    cnt++;
                } else{
                    break;
                }
            }

            int cnt2 = 1;
            for(int j = i; j < arr.length - 1; j++){
                if(arr[j] <= arr[j + 1]){
                    cnt2++;
                } else{
                    break;
                }
            }
            return Math.max(cnt, cnt2);
        }

        if(dir == 1){
            for(int j = i; j < arr.length - 1; j++){
                if(arr[j] >= arr[j + 1]){
                    cnt++;
                } else{
                    return cnt;
                }
            }
        } else{
            for(int j = i; j < arr.length - 1; j++){
                if(arr[j] <= arr[j + 1]){
                    cnt++;
                } else{
                    return cnt;
                }
            }
        }

        return cnt;
    }
}
