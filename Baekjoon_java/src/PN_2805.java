import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Integer[] wood = new Integer[N];
        int max = 0;
        int min = 0;

        st = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            wood[n] = Integer.parseInt(st.nextToken());
            max = Math.max(max, wood[n]);
        }

        while (min <= max) {
            int mid = (min + max) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (wood[i] - mid > 0) {
                    sum += wood[i] - mid;
                }
            }

            if (sum >= M) {
                min = mid + 1;
            } else if (sum < M) {
                max = mid - 1;
            } else if (sum == M) {
                break;
            }
        }
        System.out.println(max);
    }
}