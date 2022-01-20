/***************************************************************************************************
1316번 그룹 단어 체커

limit_time : 2s, limit_memory : 128MB

문제
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

출력
첫째 줄에 그룹 단어의 개수를 출력한다.

예제 입력 1 
3
happy
new
year

예제 출력 1 
3

예제 입력 2 
4
aba
abab
abcabc
a

예제 출력 2 
1

예제 입력 3 
5
ab
aa
aca
ba
bb
예제 출력 3 
4

예제 입력 4 
2
yzyzy
zyzyz

예제 출력 4 
0

예제 입력 5 
1
z

예제 출력 5 
1
***************************************************************************************************/

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_1316 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());      // 총 단어 갯수
        int count = 0;      // 그룹 단어 갯수


        for(int i = 0; i < num; i ++){
            char[] word = br.readLine().toCharArray();
            char prev = 0;      // 앞선 문자 저장
            boolean[] check = new boolean[26];      // 알파벳 중복 체크 배열


            for(int j = 0; j < word.length; j++){
                char now = word[j];     // 현재 문자 저장

                if(prev != now){        // 현재 문자와 앞선 문자가 다를 경우

                    if(!check[now - 'a']){  // 현재 문자가 처음 나온 경우
                        check[now - 'a'] = true;    // 나온 문자라고 check
                        prev = now;         // 앞선 문자를 현재 문자로 치환
                    } else{
                        count--;        // 앞선 문자일 경우 갯수를 빼준다
                        break;
                    }
                }
            }
            count++;
        }
        System.out.println(count);
    }
}