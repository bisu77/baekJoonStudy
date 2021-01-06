package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @문제 : 1로 만들기
 * https://www.acmicpc.net/problem/1463
 */
/**
 * 
 * @author KJ
 * 문제해결
 * 
 *   - 반복문 (Bottom-up) 방식
 *  	1) 배열 메모이제이션을 이용하기 위해 dp 배열 선언
 * 		2) 배열 인덱스의 값을 저장하기 위해 반복문(Bottom-up) 루프 실행
 * 		3) 루프에서 각 연산의 index 값의 최솟값 +1(연산 값)을 구한 후 구해진 값들의 최솟값을 구해 dp배열에 저장
 * 		4) dp배열의 입력 된 index 값 출력
 * 
 *   - getNumber함수(Top-down) 방식
 * 		1) 배열 메모이제이션을 이용하기 위해 dp 배열 선언(static 변수)
 *  	2) 재귀 함수 방식으로 처리
 * 		3) 배열 인덱스 값이 존재하면 해당 배열 값 반환
 *  	4) 존재하지 않으면 각 연산의 최솟값+1(연산 값)을 구한 후 구해진 값들의 최솟값을 구해 배열 인덱스 값 저장 후 반환
 * 
 */
public class Exercise_1463 {
	//static int dp[];
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int dp[] = new int[num+1];
		
		dp[0] = 0;
		dp[1] = 0;
		
		
		for(int i=2;i<=num;i++) {
			dp[i] = dp[i-1] + 1;//이전 인덱스의 최소 결과값 + 1(-1 연산)
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2] + 1);//2로 나눈 인덱스의 최소 결과 값 +1(/2 연산)
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3] + 1);//3로 나눈 인덱스의 최소 결과 값 +1(/3 연산)
		}
		
		System.out.println(dp[num]);
		
	}

	/*
	public static int getNumber(int num) {
		if(num==1) {
			return 0;
		}
		if(dp[num]>0) {
			return dp[num];
		}
		
		dp[num] = getNumber(num-1)+1;
		if(num%2==0) dp[num] = Math.min(dp[num], getNumber(num/2)+1);
		if(num%3==0) dp[num] = Math.min(dp[num], getNumber(num/3)+1);
		
		return dp[num];
	}
	*/
}
