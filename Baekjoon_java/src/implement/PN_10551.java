/***************************************************************************************************
10551번 STROJOPIS

limit_time : 1s, limit_memory : 32MB

문제
Proper typing is becoming an essential part of culture. If you are still not using all ten fingers for typing, you have to re-learn typing – then you will type faster and feel more comfortable and enjoyable.

There are a lot of web sites teaching proper typing. The following image depicts the basic principle; the keys needed to press with the same finger are of the same color. The yellow keys need to be pressed with the pinky, the blue ones with the ring finger, the green ones with the middle finger and the red ones with the index finger. Naturally, the left hand presses the left side of the keyboard (starting with keys 5, T, G, B to the left), the right hand presses the right side (starting with keys 6, Y, H, N to the right). Thumbs are responsible for space.



Please note: the image depicts the US layout. For programming purposes, it is advised to switch to this layout because a lot of special characters, like [], are easier to type. The US layout can be easily set on any operation system.

Your task is to output how many times each finger, excluding thumbs, participated in typing the given string properly.

입력
The first and only line of input contains of a string consisting of at least one and at most fifty characters. The string doesn’t contain whitespaces and consists only of characters depicted on the image above.

출력
The output must consist of eight lines, in each line one integer denoting the number of presses of each finger, excluding thumbs, observed from left to right.

예제 입력 1 
AON=BOO;
예제 출력 1 
1
0
0
1
1
0
3
2
예제 입력 2 
PRINT'NY'[NASLA]
예제 출력 2 
2
1
0
2
4
1
1
5
예제 입력 3 
VIDI,KO,JE,DOSA
예제 출력 3 
1
1
3
1
1
6
2
0
***************************************************************************************************/

package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_10551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        int[] res = new int[8];

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case '1':
                case 'Q':
                case 'A':
                case 'Z':
                    res[0]++;
                    break;

                case '2':
                case 'W':
                case 'S':
                case 'X':
                    res[1]++;
                    break;

                case '3':
                case 'E':
                case 'D':
                case 'C':
                    res[2]++;
                    break;

                case '4':
                case 'R':
                case 'F':
                case 'V':
                case '5':
                case 'T':
                case 'G':
                case 'B':
                    res[3]++;
                    break;

                case '6':
                case 'Y':
                case 'H':
                case 'N':
                case '7':
                case 'U':
                case 'J':
                case 'M':
                    res[4]++;
                    break;

                case '8':
                case 'I':
                case 'K':
                case ',':
                    res[5]++;
                    break;

                case '9':
                case 'O':
                case 'L':
                case '.':
                    res[6]++;
                    break;

                case '0':
                case '-':
                case '=':
                case 'P':
                case '[':
                case ']':
                case ';':
                case '\'':
                case '/':
                    res[7]++;
                    break;
            }
        }

        for (int i = 0; i < 8; i++) {
            System.out.println(res[i]);
        }
    }
}