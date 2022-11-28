/***************************************************************************************************
26070번 곰곰이와 학식

limit_time : 2s, limit_memory : 1024MB

문제
지금 곰곰대학교 학생식당에는 시험기간에 밤을 새, 굶주려 있는 곰곰이들이 기다리고 있다.



정확히는 치킨을 먹고 싶은 곰곰이가 $A$마리, 피자를 먹고 싶은 곰곰이가 $B$마리, 햄버거를 먹고 싶은 곰곰이가 $C$마리 있다.

총총선배는 사비를 털어 곰곰이들에게 맛있는 밥을 사주려 한다!

총총선배는 학생식당에서 사용할 수 있는 치킨 식권 $X$장, 피자 식권 $Y$장, 햄버거 식권 $Z$장을 가지고 있다. 식권 한장을 내면, 해당 음식 1인분으로 교환받을 수 있다.

또, 식당에서는 치킨 식권 3장을 피자 식권 1장으로, 피자 식권 3장을 햄버거 식권 1장으로, 햄버거 식권 3장을 치킨 식권 1장으로 교환해주는 이벤트도 하고 있다.

곰곰이들을 최대한 배불리 먹이고 싶은 총총선배는 당신에게 도움을 요청하고 있다!

굶주린 곰곰이들을 위해, 식권과 이벤트를 적절히 활용했을 때 배불리 먹일 수 있는 곰곰이의 최대 마릿수를 구해주자.



입력
첫 번째 줄에 치킨을 먹고 싶은 곰곰이의 마릿수 $A$, 피자를 먹고 싶은 곰곰이의 마릿수 $B$, 햄버거를 먹고 싶은 곰곰이의 마릿수 $C$가 공백으로 구분되어 주어진다. $(0\le A,B,C\le 10^{9})$ 

두 번째 줄에 총총이가 가지고 있는 치킨 식권 장수 $X$, 피자 식권 장수 $Y$, 햄버거 식권 장수 $Z$가 공백으로 구분되어 주어진다. $(0\le X,Y,Z\le 10^{9})$ 

입력은 모두 정수로 주어진다.

출력
주어진 식권과 이벤트를 적절히 활용해, 배불리 먹일 수 있는 곰곰이의 최대 마릿수를 출력하자.

예제 입력 1 
10 30 20
6 100 1
예제 출력 1 
57
***************************************************************************************************/

package grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_26070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        long cnt = 0;

        while (X >= 3 || Y >= 3 || Z >= 3) {
            if (A >= X) {
                cnt += X;
                A -= X;
                X = 0;
            } else {
                cnt += A;
                X -= A;
                A = 0;
            }

            if (X > 3) {
                Y += X / 3;
                X %= 3;
            }

            if (B >= Y) {
                cnt += Y;
                B -= Y;
                Y = 0;
            } else {
                cnt += B;
                Y -= B;
                B = 0;
            }

            if (Y > 3) {
                Z += Y / 3;
                Y %= 3;
            }

            if (C >= Z) {
                cnt += Z;
                C -= Z;
                Z = 0;
            } else {
                cnt += C;
                Z -= C;
                C = 0;
            }

            if (Z > 3) {
                X += Z / 3;
                Z %= 3;
            }

            if (A == 0 && B == 0 && C == 0) {
                break;
            }
        }

        if (A >= X) {
            cnt += X;
            A -= X;
            X = 0;
        } else {
            cnt += A;
            X -= A;
            A = 0;
        }

        if (B >= Y) {
            cnt += Y;
            B -= Y;
            Y = 0;
        } else {
            cnt += B;
            Y -= B;
            B = 0;
        }

        if (C >= Z) {
            cnt += Z;
            C -= Z;
            Z = 0;
        } else {
            cnt += C;
            Z -= C;
            C = 0;
        }

        System.out.println(cnt);
    }
}
