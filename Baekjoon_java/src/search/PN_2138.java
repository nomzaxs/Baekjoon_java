/***************************************************************************************************
2138번 전구와 스위치

limit_time : 2s, limit_memory : 128MB

문제
N개의 스위치와 N개의 전구가 있다. 각각의 전구는 켜져 있는 상태와 꺼져 있는 상태 중 하나의 상태를 가진다. i(1 < i < N)번 스위치를 누르면 i-1, i, i+1의 세 개의 전구의 상태가 바뀐다. 즉, 꺼져 있는 전구는 켜지고, 켜져 있는 전구는 꺼지게 된다. 1번 스위치를 눌렀을 경우에는 1, 2번 전구의 상태가 바뀌고, N번 스위치를 눌렀을 경우에는 N-1, N번 전구의 상태가 바뀐다.

N개의 전구들의 현재 상태와 우리가 만들고자 하는 상태가 주어졌을 때, 그 상태를 만들기 위해 스위치를 최소 몇 번 누르면 되는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(2 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 전구들의 현재 상태를 나타내는 숫자 N개가 공백 없이 주어진다. 그 다음 줄에는 우리가 만들고자 하는 전구들의 상태를 나타내는 숫자 N개가 공백 없이 주어진다. 0은 켜져 있는 상태, 1은 꺼져 있는 상태를 의미한다.

출력
첫째 줄에 답을 출력한다. 불가능한 경우에는 -1을 출력한다.

예제 입력 1 
3
000
010
예제 출력 1 
3
***************************************************************************************************/

////////////////////// 모든 경우의 수를 계산해 비교, 시간 초과
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int min = 0;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str1 = br.readLine();
        String str2 = br.readLine();

        boolean[] Slamp = new boolean[N];
        boolean[] Mlamp = new boolean[N];
        arr = new int[N];

        // 0 = false = 꺼짐상태, 1 = true = 켜짐상태
        for (int i = 0; i < N; i++) {
            Slamp[i] = str1.charAt(i) == '0' ? false : true;
            Mlamp[i] = str2.charAt(i) == '0' ? false : true;
        }

        recur(0, N, Slamp, Mlamp);

        System.out.println(result);
    }

    public static void recur(int cur, int n, boolean[] Slamp, boolean[] Mlamp) {

        min = 0;

        if (cur == n) {
            boolean[] lamp = new boolean[Slamp.length];
            for (int i = 0; i < Slamp.length; i++) {
                lamp[i] = Slamp[i];
            }
            for (int i = 0; i < n; i++) {
                click(lamp, arr[i]);
                min++;
                if (check(lamp, Mlamp)) {
                    result = Math.min(min, result);
                    return;
                }
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[cur] = i;
            recur(cur + 1, n, Slamp, Mlamp);
        }
    }

    private static boolean check(boolean[] lamp, boolean[] mlamp) {

        int cnt = 0;

        for (int i = 0; i < lamp.length; i++) {
            if (lamp[i] == mlamp[i]) {
                cnt++;
            }
        }

        if (cnt == lamp.length) {
            return true;
        }

        return false;
    }

    private static void click(boolean[] lamp, int i) {
        if (i > 0) {
            if (lamp[i - 1]) {
                lamp[i - 1] = false;
            } else {
                lamp[i - 1] = true;
            }
        }

        if (i < lamp.length - 1) {
            if (lamp[i + 1]) {
                lamp[i + 1] = false;
            } else {
                lamp[i + 1] = true;
            }
        }

        if (lamp[i]) {
            lamp[i] = false;
        } else {
            lamp[i] = true;
        }
    }
}
*/

package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_2138 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int n = 0; n < N; n++) {
            arr1[n] = str1.charAt(n) - '0';
            arr2[n] = str2.charAt(n) - '0';
        }

        click(arr1, arr2, 0);
    }

    static void change(int[] light, int index) {
        for (int i = index - 1; i <= index + 1; i++) {
            if (0 <= i && i < light.length) {       // 경계 체크해서 바꿔주는 조건
                light[i] = 1 - light[i];            // 1은 0으로 변경, 0은 1로 변경
            }
        }
    }

    private static void click(int[] arr1, int[] arr2, int i) {
        int[] onarr = new int[arr1.length];
        int[] offarr = new int[arr1.length];
        int oncnt = 1;
        int offcnt = 0;

        for (int j = 0; j < arr1.length; j++) {
            onarr[j] = arr1[j];
            offarr[j] = arr1[j];
        }

        change(onarr, 0);

        for (i = 0; i < arr1.length - 1; i++) {
            if (onarr[i] != arr2[i]) {
                change(onarr, i + 1);
                oncnt++;
            }
        }

        for (i = 0; i < arr1.length - 1; i++) {
            if (offarr[i] != arr2[i]) {
                change(offarr, i + 1);
                offcnt++;
            }
        }

        int result = 0;

        if (onarr[arr1.length - 1] == arr2[arr1.length - 1] && offarr[arr1.length - 1] == arr2[arr1.length - 1]) {
            result = Math.min(oncnt, offcnt);
        } else if (onarr[arr1.length - 1] == arr2[arr1.length - 1]) {
            result = oncnt;
        } else if (offarr[arr1.length - 1] == arr2[arr1.length - 1]) {
            result = offcnt;
        } else {
            result = -1;
        }
        System.out.println(result);

    }
}