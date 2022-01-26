/***************************************************************************************************
14500번 테트로미노

limit_time : 2s, limit_memory : 512MB

문제
폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

정사각형은 서로 겹치면 안 된다.
도형은 모두 연결되어 있어야 한다.
정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.



아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.

테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

입력
첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)

둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.

예제 입력 1 
5 5
1 2 3 4 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1
예제 출력 1 
19
예제 입력 2 
4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
예제 출력 2 
20
예제 입력 3 
4 10
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1
예제 출력 3 
7
***************************************************************************************************/

package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PN_14500 {

	static int N;
	static int M;
	static int[][]arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int max = 0;	// 최댓값

		// 입력받은 N, M 크기만큼 배열을 만들어 준다.
		arr = new int[N][M];

		// 배열 입력받아 초기화
		for(int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			for(int i = 0; i < M; i++) {
				arr[t][i] = Integer.parseInt(st.nextToken());
			}
		}

		int s1 = shape1();
		int s2 = shape2();
		int s3 = shape3();
		int s4 = shape4();
		int s5 = shape5();

		if(max < s1) {
			max = s1;
		}
		if(max < s2) {
			max = s2;
		}
		if(max < s3) {
			max = s3;
		}
		if(max < s4) {
			max = s4;
		}
		if(max < s5) {
			max = s5;
		}

		System.out.println(max);
	}

	// ㅡ 모양
	private static int shape1() {
		int max = 0;
		int score = 0;

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M - 3; j++) {
				for(int k = 0; k < 4; k++) {
					score += arr[i][j + k];
				}

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}

		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N - 3; j++) {
				for(int k = 0; k < 4; k++) {
					score += arr[j + k][i];
				}

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}

		return max;
	}

	// 네모모양
	private static int shape2() {
		int max = 0;
		int score = 0;

		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 1; j++) {
				score += arr[i][j];
				score += arr[i + 1][j];
				score += arr[i][j + 1];
				score += arr[i + 1][j + 1];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}

		return max;
	}

	// ㄴ 모양
	private static int shape3() {
		int max = 0;
		int score = 0;

		// |_ 모양
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				score += arr[i][j];
				score += arr[i + 1][j];
				score += arr[i + 2][j];
				score += arr[i + 2][j + 1];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}

		// _| 모양
		for(int i = 0; i < N - 2; i++) {
			for(int j = 1; j < M; j++) {
				score += arr[i][j];
				score += arr[i + 1][j];
				score += arr[i + 2][j];
				score += arr[i + 2][j - 1];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}

		// ______| 모양
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < M - 2; j++) {
				score += arr[i][j];
				score += arr[i][j + 1];
				score += arr[i][j + 2];
				score += arr[i - 1][j + 2];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}
		
		// ㅡㅡㅡㅡㅡ| 모양
				for(int i = 0; i < N - 1; i++) {
					for(int j = 0; j < M - 2; j++) {
						score += arr[i][j];
						score += arr[i][j + 1];
						score += arr[i][j + 2];
						score += arr[i + 1][j + 2];

						if(max < score) {
							max = score;
						}

						score = 0;
					}
				}

		// -| 모양
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				score += arr[i][j];
				score += arr[i][j + 1];
				score += arr[i + 1][j + 1];
				score += arr[i + 2][j + 1];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}
		
		// |- 모양
				for(int i = 0; i < N - 2; i++) {
					for(int j = 0; j < M - 1; j++) {
						score += arr[i][j];
						score += arr[i][j + 1];
						score += arr[i + 1][j];
						score += arr[i + 2][j];

						if(max < score) {
							max = score;
						}

						score = 0;
					}
				}

		// |ㅡㅡㅡㅡㅡㅡㅡㅡ 모양
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 2; j++) {
				score += arr[i][j];
				score += arr[i][j + 1];
				score += arr[i][j + 2];
				score += arr[i + 1][j];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}
		
		// |___________ 모양
				for(int i = 0; i < N - 1; i++) {
					for(int j = 0; j < M - 2; j++) {
						score += arr[i][j];
						score += arr[i + 1][j];
						score += arr[i + 1][j + 1];
						score += arr[i + 1][j + 2];

						if(max < score) {
							max = score;
						}

						score = 0;
					}
				}


		return max;
	}

	// Z 모양
	private static int shape4() {
		int max = 0;
		int score = 0;

		// |-| 모양
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				score += arr[i][j];
				score += arr[i + 1][j];
				score += arr[i + 1][j + 1];
				score += arr[i + 2][j + 1];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}
		
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				score += arr[i][j + 1];
				score += arr[i + 1][j + 1];
				score += arr[i + 1][j];
				score += arr[i + 2][j];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}

		// -|- 모양
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < M - 2; j++) {
				score += arr[i][j];
				score += arr[i][j + 1];
				score += arr[i - 1][j + 1];
				score += arr[i - 1][j + 2];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 2; j++) {
				score += arr[i][j];
				score += arr[i][j + 1];
				score += arr[i + 1][j + 1];
				score += arr[i + 1][j + 2];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}

		return max;
	}

	// ㅗ 모양
	private static int shape5() {
		int max = 0;
		int score = 0;

		// ㅜ 모양
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 2; j++) {
				score += arr[i][j];
				score += arr[i][j + 1];
				score += arr[i + 1][j + 1];
				score += arr[i][j + 2];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}

		// ㅏ 모양
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				score += arr[i][j];
				score += arr[i + 1][j];
				score += arr[i + 1][j + 1];
				score += arr[i + 2][j];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}

		// ㅗ 모양
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < M - 2; j++) {
				score += arr[i][j];
				score += arr[i][j + 1];
				score += arr[i - 1][j + 1];
				score += arr[i][j + 2];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}

		// ㅓ 모양
		for(int i = 0; i < N - 2; i++) {
			for(int j = 1; j < M; j++) {
				score += arr[i][j];
				score += arr[i + 1][j];
				score += arr[i + 1][j - 1];
				score += arr[i + 2][j];

				if(max < score) {
					max = score;
				}

				score = 0;
			}
		}

		return max;
	}
}