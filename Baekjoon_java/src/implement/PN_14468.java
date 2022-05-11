/***************************************************************************************************
14468번 소가 길을 건너간 이유 2

limit_time : 2s, limit_memory : 512MB

문제
존의 농장에는 원형 목초지가 있고, 그 둘레에 길이 둘러져 있다. 존의 소는 매일 아침 이 길을 건너가 풀을 먹고 저녁에 다시 길을 건너가 헛간으로 돌아간다.

이 소들은 자신의 습관대로 매일 똑같은 방법으로 길을 건넌다. 각각의 소는 원형 길의 정해진 한 점을 지나 들어오고, 다른 점을 지나 나간다. 어떤 두 소도 길 위의 같은 점을 지나가지 않는다. 이걸 지켜본 존은 이 점들을 분석해 보기로 했다. 소는 총 26마리고, A, B, ... Z라는 이름이 붙는다. 존은 52개의 점을 시계방향으로 보면서 각 점을 어떤 소가 지나가는지 기록했다. 이렇게 만들어 낸 52글자의 문자열에는 각 알파벳이 두 번씩 나타날 것이다.

어떤 두 소는 어떤 방법으로 걷든 그 경로가 어딘가에서 만나야 될 수도 있다. 그런 소가 총 몇 쌍인지 구해 보자.

입력
첫 줄에 52글자의 문자열이 주어진다. 각 글자는 알파벳 대문자이며, 각 알파벳이 정확히 두 번씩 나타난다.

출력
경로가 무조건 만나는 소가 몇 쌍인지 출력한다.

예제 입력 1 
ABCCABDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZ
예제 출력 1 
1
***************************************************************************************************/

package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_14468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int pos1[] = new int[26];
        int pos2[] = new int[26];
        int cnt = 0;

        for (int i = 0; i < 52; i++) {
            int idx = str.charAt(i) - 'A';
            if (pos1[idx] == 0)
                pos1[idx] = i + 1;
            else
                pos2[idx] = i + 1;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (pos1[i] < pos1[j] && pos1[j] < pos2[i] && pos2[i] < pos2[j])
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}