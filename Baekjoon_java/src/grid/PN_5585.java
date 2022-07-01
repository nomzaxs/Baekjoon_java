/***************************************************************************************************
5585번 거스름돈

limit_time : 1s, limit_memory : 128MB

문제
타로는 자주 JOI잡화점에서 물건을 산다. JOI잡화점에는 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있고, 언제나 거스름돈 개수가 가장 적게 잔돈을 준다. 타로가 JOI잡화점에서 물건을 사고 카운터에서 1000엔 지폐를 한장 냈을 때, 받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램을 작성하시오.

입력
입력은 한줄로 이루어져있고, 타로가 지불할 돈(1 이상 1000미만의 정수) 1개가 쓰여져있다.

출력
제출할 출력 파일은 1행으로만 되어 있다. 잔돈에 포함된 매수를 출력하시오.

예제 입력 1 
380
예제 출력 1 
4
예제 입력 2 
1
예제 출력 2 
15
***************************************************************************************************/

package grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_5585 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int bill = Integer.parseInt(br.readLine());

        int money = 1000 - bill;

        int coin = 0;

        coin += money / 500;
        money %= 500;
        coin += money / 100;
        money %= 100;
        coin += money / 50;
        money %= 50;
        coin += money / 10;
        money %= 10;
        coin += money / 5;
        money %= 5;
        coin += money;

        System.out.println(coin);
    }
}