import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class PN_2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int num = Integer.parseInt(br.readLine());

        ArrayList<Integer> cutx = new ArrayList<>();
        ArrayList<Integer> cuty = new ArrayList<>();

        cutx.add(0);
        cutx.add(x);
        cuty.add(0);
        cuty.add(y);

        int maxx = 0;
        int maxy = 0;

        for (int c = 0; c < num; c++) {
            st = new StringTokenizer(br.readLine());

            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());

            if (cx == 0) {
                cuty.add(cy);
            } else{
                cutx.add(cy);
            }
        }

        Collections.sort(cutx);
        Collections.sort(cuty);

        for(int i = 1; i < cutx.size(); i++){
            maxx = Math.max(maxx, cutx.get(i) - cutx.get(i - 1));
        }

        for(int i = 1; i < cuty.size(); i++){
            maxy = Math.max(maxy, cuty.get(i) - cuty.get(i - 1));
        }

        System.out.println(maxx * maxy);
    }
}