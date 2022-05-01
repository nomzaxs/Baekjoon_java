/***************************************************************************************************
25044번 에어컨

limit_time : 1s, limit_memory : 1024MB

문제
대부분의 DGIST 기초학부 학생들은 기숙사에서 생활하고 있습니다. 여름이 다가옴에 따라 자유롭게 온도를 설정할 수 있는 시원한 에어컨을 사용하게 될 예정입니다. 안타깝게도 에어컨은 매일 15, 18, 21시 정각에 자동으로 꺼지게 설계되어 있습니다. 더군다나 에어컨의 내장 시계가 고장이 나서 세 번째로 꺼질 때마다 에어컨의 시계는 $K$분간 멈추게 됩니다.

편안한 낮잠을 위해 정시에 맞춰 에어컨을 켜주는 기계를 만들어 둔 정디지 양은 정확한 시간에 에어컨이 켜지지 않자 화가 나기 시작했습니다. 정디지양이 회로이론 과제를 내주기 전에 여러분이 $N$일째의 에어컨이 꺼지는 시각을 예측해 전원을 켜는 기계를 만들어 정디지양이 화를 내지 않도록 잘 다독여줍시다. (날짜는 0일 00시 00분부터 시작되며 에어컨은 켜져있는 상태입니다.)

입력
날짜를 의미하는 정수 $N$과 지연되는 분을 의미하는 정수 $K$가 공백을 사이에 두고 주어집니다. $(0 \le N \le 1,000, 0\le K < 60)$ 

출력
첫 줄에 $N$일째에 에어컨이 켜진 횟수 $M$을 출력합니다.

둘째 줄부터 $M$개의 줄에 걸쳐 에어컨이 꺼지는 시간을 $hh:mm$ 형식으로 오름차순으로 출력합니다.

예제 입력 1 
0 0
예제 출력 1 
3
15:00
18:00
21:00
예제 입력 2 
1000 59
예제 출력 2 
3
02:00
05:00
23:59
***************************************************************************************************/

package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class PN_25044 {
    static int[] time = { 18, 3, 3 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int hour = -3;
        int minute = 0;
        int day = 0;
        int tcnt = 0;
        int rcnt = 0;

        int[][] result = new int[3][2];

        while (day < N) {
            if (tcnt == 3) {
                tcnt %= 3;
                minute += K;

                if (minute >= 60) {
                    minute %= 60;
                    hour++;
                }
            }

            hour += time[tcnt];
            tcnt++;

            if (hour >= 24) {
                day++;
                hour %= 24;
            }
        }

        if (hour >= 0) {

            result[rcnt][0] = hour;
            result[rcnt][1] = minute;

            rcnt++;
        }

        while (day == N) {
            if (tcnt == 3) {
                tcnt %= 3;
                minute += K;

                if (minute >= 60) {
                    minute %= 60;
                    hour++;
                }
            }

            hour += time[tcnt];
            tcnt++;

            if (hour >= 24) {
                break;
            }

            result[rcnt][0] = hour;
            result[rcnt][1] = minute;

            rcnt++;
        }

        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        sb.append(rcnt + "\n");

        for (int i = 3 - rcnt; i < 3; i++) {
            if (result[i][0] < 10) {
                if (result[i][1] < 10) {
                    sb.append("0" + result[i][0] + ":" + "0" + result[i][1] + "\n");
                } else {
                    sb.append("0" + result[i][0] + ":" + result[i][1] + "\n");
                }
            } else {
                if (result[i][1] < 10) {
                    sb.append(result[i][0] + ":" + "0" + result[i][1] + "\n");
                } else {
                    sb.append(result[i][0] + ":" + result[i][1] + "\n");
                }
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}