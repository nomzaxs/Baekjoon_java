/***************************************************************************************************
20299번 3대 측정

limit_time : 3s, limit_memory : 1024MB

문제
웨이트 트레이닝에서의 3대 측정은 스쿼트, 벤치프레스, 데드리프트의 중량을 측정하는 것이다. 하지만 세 명이 한 팀을 이루어 출전하는 전국 대학생 프로그래밍 대회(ICPC)의 참가자들은 다소 독특한 방법으로 3대를 측정하는데, 바로 팀원 각각의 실력을 수치로 나타내 주는 ‘코드포스 레이팅’을 비교하는 것이다.

웨이트 트레이닝계에는 3대 중량을 합쳐 500kg를 넘지 못하는 사람은 ‘언더아머’ 브랜드의 옷을 입지 못한다는 암묵적인 룰이 있으며. 이들을 단속하는 ‘언더아머 단속반’이 존재한다는 소문도 있다. Sogang ICPC Team은 이를 벤치마킹해 팀원 3명의 코드포스 레이팅의 합이 $K$ 미만인 팀은 가입할 수 없는 VIP 클럽을 만들고자 한다.

하지만 이런 조건에서는 세 명 중 한 명의 레이팅이 현저히 낮더라도 나머지 두 명의 레이팅이 충분히 높다면 세 명이 모두 VIP 클럽에 가입할 수 있게 된다. 클럽에 가입하는 사람들은 모두 일정 수준 이상이어야겠다고 판단한 학회장 임지환은 모든 팀원의 레이팅이 $\boldsymbol{L}$ 이상이고, 팀원 세 명의 레이팅의 합이 $\boldsymbol{K}$ 이상인 팀만이 가입할 수 있게 하였다.

학회 일과 연합 일에 치여 사는 지환이는 VIP 클럽의 회원 관리까지 할 시간이 없다. 지환이를 위해 지원자 중 VIP 클럽에 가입할 수 있는 팀의 수를 구하고, VIP 회원들의 레이팅을 출력해 보자.

입력
첫째 줄에 정수 $N$, $K$, $L$이 주어진다. $N$은 팀의 수, $K$는 팀원 $3$명의 레이팅 합에 대한 클럽 가입 조건, $L$은 개인 레이팅에 대한 클럽 가입 조건이다. ($1 \leq N \leq 500\ 000$, $0 \leq K \leq 12\ 000$, $0 \leq L \leq 4\ 000$)

둘째 줄부터 $N$개 줄에 VIP 클럽에 신청한 팀의 팀원들의 레이팅 정보를 나타내는 정수 $x_1$, $x_2$, $x_3$이 한 줄에 한 팀씩 주어진다. ($0 \leq x_1,x_2,x_3 \leq 4\ 000$)

출력
첫째 줄에 VIP 클럽에 가입이 가능한 팀의 수를 출력한다.

둘째 줄에 VIP 회원들의 레이팅을 입력받은 순서대로 공백으로 구분해 하나씩 출력한다.

예제 입력 1 
5 5000 1600
1621 1928 1809
2300 2300 1499
1805 1211 1699
1600 1700 1800
1792 1617 1830
예제 출력 1 
3
1621 1928 1809 1600 1700 1800 1792 1617 1830
***************************************************************************************************/

package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_20299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());

            if (x1 >= M && x2 >= M && x3 >= M && (x1 + x2 + x3) >= S) {
                cnt++;
                sb.append(x1 + " " + x2 + " " + x3 + " ");
            }
        }
        System.out.println(cnt);

        if (cnt > 0) {
            sb.setLength(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}