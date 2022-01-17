/***************************************************************************************************
1065번 한수

limit_time : 2s, limit_memory : 128MB

문제
어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 

입력
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.

예제 입력 1 
110

예제 출력 1 
99

예제 입력 2 
1

예제 출력 2 
1

예제 입력 3 
210

예제 출력 3 
105

예제 입력 4 
1000

예제 출력 4 
144

예제 입력 5 
500

예제 출력 5 
119
***************************************************************************************************/

package function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PN_1065 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());

            han(n);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void han(int n) {
        int count = 0;
        ArrayList arrNum = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            int num = i;
            
            while(num > 0){
                arrNum.add(num % 10);
                num /= 10;
            }

            int[] arr = new int[arrNum.size()];

            for(int j = 0; j < arr.length; j++){
                arr[j] = (int) arrNum.get(j);
            }

            if(i < 100){
                count++;
            } else if ( i < 1000){
                if(arr[0] - arr[1] == arr[1] - arr[2]){
                    count++;
                }
            }

            arrNum.clear();
        
        }
        System.out.println(count);
    }
}