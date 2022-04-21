/***************************************************************************************************
17352번 여러분의 다리가 되어 드리겠습니다!

limit_time : 1s, limit_memory : 512MB

문제
선린월드에는 N개의 섬이 있다. 섬에는 1, 2, ..., N의 번호가 하나씩 붙어 있다. 그 섬들을 N - 1개의 다리가 잇고 있으며, 어떤 두 섬 사이든 다리로 왕복할 수 있다.

어제까지는 그랬다.

"왜 다리가 N - 1개밖에 없냐, 통행하기 불편하다"며 선린월드에 불만을 갖던 욱제가 다리 하나를 무너뜨렸다! 안 그래도 불편한 통행이 더 불편해졌다. 서로 왕복할 수 없는 섬들이 생겼기 때문이다. 일단 급한 대로 정부는 선린월드의 건축가를 고용해, 서로 다른 두 섬을 다리로 이어서 다시 어떤 두 섬 사이든 왕복할 수 있게 하라는 지시를 내렸다.

그런데 그 건축가가 당신이다! 안 그래도 천하제일 코딩대회에 참가하느라 바쁜데...

입력
첫 줄에 정수 N이 주어진다. (2 ≤ N ≤ 300,000)

그 다음 N - 2개의 줄에는 욱제가 무너뜨리지 않은 다리들이 잇는 두 섬의 번호가 주어진다.

출력
다리로 이을 두 섬의 번호를 출력한다. 여러 가지 방법이 있을 경우 그 중 아무거나 한 방법만 출력한다.

예제 입력 1 
4
1 2
1 3
예제 출력 1 
1 4
"4 1"이나 "2 4", "4 3" 등 가능한 정답은 많이 있지만, 아무거나 하나만 출력해야 한다.

예제 입력 2 
2
예제 출력 2 
1 2
예제 입력 3 
5
1 2
2 3
4 5
예제 출력 3 
3 4
***************************************************************************************************/

package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_17352 {
    static int[] arr, rank, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < n - 2; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        for (int i = 2; i < n + 1; i++) {
            if (find(1) == find(i)) {
                continue;
            } else {
                sb.append(1 + " " + i);
                break;
            }
        }

        System.out.println(sb.toString());

    }

    // union by rank
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }

        if (rank[a] < rank[b]) {
            arr[a] = b;
        } else if (rank[a] > rank[b]) {
            arr[b] = a;
        } else {
            arr[a] = b;
            rank[b] += 1;
        }
    }

    // 경로 압축
    private static int find(int a) {
        if (arr[a] == a) {
            return a;
        } else {
            arr[a] = find(arr[a]);
            return arr[a];
        }
    }
}