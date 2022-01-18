/***************************************************************************************************
1152번 단어의 개수

limit_time : 2s, limit_memory : 128MB

문제
영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.

입력
첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다. 단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 또한 문자열은 공백으로 시작하거나 끝날 수 있다.

출력
첫째 줄에 단어의 개수를 출력한다.

예제 입력 1 
The Curious Case of Benjamin Button

예제 출력 1 
6

예제 입력 2 
 The first character is a blank

예제 출력 2 
6

예제 입력 3 
The last character is a blank

예제 출력 3 
6
***************************************************************************************************/

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer로 " "을 구분해 문자열을 분리한다.
        // StringTikenizer는 split과 달리 구분문자를 인자로 받지 않는다.
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        // // 문자열 앞 뒤 공백 제거 후 공백을 기준으로 배열에 초기화
        // String[] arr = bf.readLine().trim().split(" ");

        // // 만약 공백 하나만 입력시 1이 출력되는 예외를 처리해준다.
        // if(arr.length == 1 && arr[0].equals("")){
        //     System.out.println(0);
        //     return;
        // }
        
        // System.out.println(arr.length);

        // 
        System.out.println(st.countTokens());

        return;
    }
}