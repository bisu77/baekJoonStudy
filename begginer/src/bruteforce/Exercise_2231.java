package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @문제 : 분해합
 * https://www.acmicpc.net/problem/2231
 */
public class Exercise_2231 {
	/* 최대값 : 입력값
	 * 최소값 : 입력값 - (입력값 자릿수 * 9)
	 * for 루프 돌리는 완전탐색 방식 
	 * 
	 * point) 3자리의 분해 값을 구한다고 하면 '9','9','9' 가 더해지는 것이 최대 분해합이기 때문에
	 * 		   최소값은 입력값 - (입력자릿수 * 9)가 된다.
	 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inputStr = br.readLine();
		int inputNum 	= Integer.parseInt(inputStr);

		final int MIN_NUM = inputNum - (inputStr.length()*9);
		
		int cstrNum 	= 0;//생성자
		
		for (int i=MIN_NUM; i<inputNum; i++) {
			if(inputNum == calcDecompo(i)) {
				cstrNum = i;
				break;
			}
		}
		System.out.println(cstrNum);
	}
	
	public static int calcDecompo(int num) {//분해합 계산
		int decompo = num;
		for(char temp :  String.valueOf(num).toCharArray()) {
			decompo += Character.getNumericValue(temp);
		}
		return decompo;
	}
}
