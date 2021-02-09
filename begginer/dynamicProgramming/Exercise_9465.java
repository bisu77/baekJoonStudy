package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @문제 : 스티커
 * https://www.acmicpc.net/problem/9465
 * @예제입력
 * 2
 * 5
 * 50 10 100 20 40
 * 30 50 70 10 60
 * 7
 * 10 30 10 50 100 20 40
 * 20 40 30 50 60 20 80
 *
 * 예제 출력
 * 260
 * 290
 *
 */
/**
 * 
 * @author KJ
 * 문제해결
 *
 * Dynamic Programming 문제
 * 1) 스티커를 뗄 수 있는 범위 생각하기
 * 2) 스티커를 뗄 수 있는 범위는 대각선 && 대각선 한칸 옆
 * 3) 그 이상의 대각선은 중간 점 점수 먹고 갈 수 있기 때문에 고려할 필요 없음
 * 4) loop의 자신 값 + dp에 저장 된 대각선 && 대각선 한칸 옆 중 max 값을 더해서 dp 저장
 * 5) row 별 최고 dp 값 출력
 * 6) readme.md 참고
 */
public class Exercise_9465 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int loop 				= Integer.parseInt(br.readLine());

		for(int i=0;i<loop;i++){
			int colSize 			= Integer.parseInt(br.readLine());
			int [][]arr 			= new int[2][colSize+1];
			int [][]dp				= new int[2][colSize+1];

			for(int j=0;j<2;j++){
				String[] col = br.readLine().split(" ");
				for(int k=1;k<=colSize;k++){
					arr[j][k]= Integer.parseInt(col[k-1]);
				}
			}

			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];

			for(int j=2;j<=colSize;j++){
				dp[0][j] = Math.max(dp[1][j-1],dp[1][j-2]) + arr[0][j];
				dp[1][j] = Math.max(dp[0][j-1],dp[0][j-2]) + arr[1][j];
				System.out.println ((j-1)+"loop) 0 idx : " + dp[0][j]);
				System.out.println ((j-1)+"loop) 1 idx : " + dp[1][j]);
			}

			System.out.println(Math.max(dp[0][colSize], dp[1][colSize]));
		}
	}
}

