/***************************************************************************************************
3273번 두 수의 합

limit_time : 1s, limit_memory : 128MB

문제
n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다. ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다. 자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수열의 크기 n이 주어진다. 다음 줄에는 수열에 포함되는 수가 주어진다. 셋째 줄에는 x가 주어진다. (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)

출력
문제의 조건을 만족하는 쌍의 개수를 출력한다.

예제 입력 1 
9
5 12 7 10 9 1 2 3 11
13
예제 출력 1 
3
***************************************************************************************************/

package pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PN_3273 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int p = 0;
        int q = N - 1;

        int res = 0;

        while(p < q){
            int sum = arr[p] + arr[q];
            if(sum == x){
                res++;
                p++;
            } else if(sum > x){
                q--;
            } else{
                p++;
            }
        }

        System.out.println(res);
    }
}
