/***************************************************************************************************
15439번 Vera and Outfits

limit_time : 2s, limit_memory : 256MB

문제
Vera owns N tops and N pants. The i-th top and i-th pants have colour i, for 1 ≤ i ≤ N, where all N colours are different from each other.

An outfit consists of one top and one pants. Vera likes outfits where the top and pants are not the same colour.

How many different outfits does she like?

입력
The input will be in the format:

N
Constraints:

1 ≤ N ≤ 2017
N is integer
출력
Output one line with the number of different outfits Vera likes.

예제 입력 1 
1
예제 출력 1 
0
예제 입력 2 
2
예제 출력 2 
2
예제 입력 3 
5
예제 출력 3 
20
***************************************************************************************************/

package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_15439 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    System.out.println(N * (N - 1));
  }
}