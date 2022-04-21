/***************************************************************************************************
18116번 로봇 조립

limit_time : 4s, limit_memory : 1024MB

문제
성규는 로봇을 조립해야 한다. 상자 안에는 여러 로봇의 부품들이 섞여 있다. 그런데 어떤 부품이 어느 로봇의 부품인지 표시가 되어있지 않다. 호재는 전자과라서 두 부품을 보면 같은 로봇의 부품인지 알 수 있다. 그래서 성규는 호재의 지시에 따라 부품들을 정리하기로 하였다.

부품들은 1부터 106까지의 정수로 표현된다. 그리고 부품 i가 속한 로봇은 robot(i)라고도 표현한다. 예를 들어, 부품 11과 부품 22가 로봇 A의 부품이라고 알고 있는 경우, robot(11)은 로봇 A를 의미하고, robot(22)도 로봇 A를 의미한다.

서로 다른 로봇은 공통 부품을 가지지 않는다. 즉 어떤 부품이 로봇 A의 부품이라면, 로봇 B의 부품은 될 수 없다.

호재는 2가지 지시를 한다.

서로 다른 부품 2개를 말해주며, 두 부품은 같은 로봇의 부품이라는 정보를 알려준다.
부품 i에 대해서, 지금까지 알아낸 robot(i)의 부품이 몇 개냐고 물어본다.
초기에는 부품에 대한 정보가 존재하지 않는다.

입력
첫 번째 줄에 호재의 지시 횟수 N이 들어온다. (1 ≤ N ≤ 106)

다음 줄부터 N개의 지시가 들어온다.

부품 2개가 같은 로봇의 부품인지 알려줄 때에는 \(I\)  a b 의 형태로 들어온다. 부품 a와 부품 b는 같은 로봇의 부품이라는 의미이다. (1 ≤ a, b ≤ 106, a ≠ b, a, b는 정수)

어떤 로봇의 부품이 몇 개인지 물어볼 때에는 Q c 의 형태로 들어온다. 지금까지 알아낸 robot(c)의 부품이 몇 개냐는 의미이다. (1 ≤ c ≤ 106, c는 정수)

입력으로 Q c의 형태가 적어도 한 번 들어온다.

출력
Q로 시작하는 입력에 대해서 한 줄에 하나씩, 지금까지 알아낸 해당 로봇의 부품 개수를 출력한다.

예제 입력 1 
4
I 1 2
I 3 2
Q 1
Q 4
예제 출력 1 
3
1
***************************************************************************************************/

package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_18116 {
    static int[] arr, rank, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        arr = new int[1000001];
        rank = new int[1000001];
        size = new int[1000001];

        for (int i = 0; i < 1000001; i++) {
            arr[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            char Q = st.nextToken().charAt(0);

            if (Q == 'I') {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            } else if (Q == 'Q') {
                int c = Integer.parseInt(st.nextToken());

                sb.append(size[find(c)] + "\n");
            }
        }

        sb.setLength(sb.length() - 1);
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
            size[b] += size[a];
        } else if (rank[a] > rank[b]) {
            arr[b] = a;
            size[a] += size[b];
        } else {
            arr[a] = b;
            rank[b] += 1;
            size[b] += size[a];
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