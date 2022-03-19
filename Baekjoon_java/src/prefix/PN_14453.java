/***************************************************************************************************
14453번 Hoof, Paper, Scissors (Silver)

limit_time : 2s, limit_memory : 512MB

문제
You have probably heard of the game "Rock, Paper, Scissors". The cows like to play a similar game they call "Hoof, Paper, Scissors".

The rules of "Hoof, Paper, Scissors" are simple. Two cows play against each-other. They both count to three and then each simultaneously makes a gesture that represents either a hoof, a piece of paper, or a pair of scissors. Hoof beats scissors (since a hoof can smash a pair of scissors), scissors beats paper (since scissors can cut paper), and paper beats hoof (since the hoof can get a papercut). For example, if the first cow makes a "hoof" gesture and the second a "paper" gesture, then the second cow wins. Of course, it is also possible to tie, if both cows make the same gesture.

Farmer John wants to play against his prize cow, Bessie, at N games of "Hoof, Paper, Scissors" (1 ≤ N ≤ 100,000). Bessie, being an expert at the game, can predict each of FJ's gestures before he makes it. Unfortunately, Bessie, being a cow, is also very lazy. As a result, she tends to play the same gesture multiple times in a row. In fact, she is only willing to switch gestures at most once over the entire set of games. For example, she might play "hoof" for the first x games, then switch to "paper" for the remaining N−x games.

Given the sequence of gestures FJ will be playing, please determine the maximum number of games that Bessie can win.

입력
The first line of the input file contains N.

The remaining N lines contains FJ's gestures, each either H, P, or S.


출력
Print the maximum number of games Bessie can win, given that she can only change gestures at most once.

예제 입력 1 
5
P
P
H
P
S
예제 출력 1 
4
***************************************************************************************************/

package prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PN_14453 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] arr = new char[N];
        int[] prefixP = new int[N + 1];
        int[] prefixH = new int[N + 1];
        int[] prefixS = new int[N + 1];

        prefixP[0] = 0;
        prefixH[0] = 0;
        prefixS[0] = 0;

        for (int n = 0; n < N; n++) {
            arr[n] = br.readLine().charAt(0);
            if (arr[n] == 'P') {
                prefixP[n + 1] = prefixP[n] + 1;
                prefixH[n + 1] = prefixH[n];
                prefixS[n + 1] = prefixS[n];
            } else if (arr[n] == 'H') {
                prefixH[n + 1] = prefixH[n] + 1;
                prefixP[n + 1] = prefixP[n];
                prefixS[n + 1] = prefixS[n];
            } else {
                prefixS[n + 1] = prefixS[n] + 1;
                prefixP[n + 1] = prefixP[n];
                prefixH[n + 1] = prefixH[n];
            }
        }

        int max = 0;

        max = Math.max(max, prefixH[N]);
        max = Math.max(max, prefixP[N]);
        max = Math.max(max, prefixS[N]);

        for (int i = 1; i < N; i++) {
            max = Math.max(prefixH[i] + prefixP[N] - prefixP[i], max);
            max = Math.max(prefixH[i] + prefixS[N] - prefixS[i], max);
            max = Math.max(prefixP[i] + prefixS[N] - prefixS[i], max);
            max = Math.max(prefixP[i] + prefixH[N] - prefixH[i], max);
            max = Math.max(prefixS[i] + prefixH[N] - prefixH[i], max);
            max = Math.max(prefixS[i] + prefixP[N] - prefixP[i], max);
        }

        System.out.println(max);
    }
}