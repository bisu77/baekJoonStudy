package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @문제 : 유레카이론
 * https://www.acmicpc.net/problem/10448
 */
/**
 * 
 * @author KJ
 * 문제해결
 * 
 * 1) 1~1000까지의 삼각수 구하기.
 * 2) 3증 for문을 돌면서 삼각수의 숫자 합산
 * 3) 합산된 값이 입력된 값과 같으면 return true; 그렇지 않으면 return false;
 * 
 */
public class Exercise_10448 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inputStr = br.readLine();
		int inputNum 	= Integer.parseInt(inputStr);
		int[] num		= new int[inputNum];
		int endNum 		= 1000;
		int triangleNum	= 0;
		int index		= 0;
		
		ArrayList<Integer> trigonometric = new ArrayList<>();
		
		for(int i=0;i<inputNum;i++){
			num[i] = Integer.parseInt(br.readLine());
		}
		
		while(triangleNum <= endNum) {
			index++;
			triangleNum = triangleNum + index;
			trigonometric.add(triangleNum);
		}
		
		for(int i=0;i<inputNum;i++) {
			if(isTrigonometric(num[i],trigonometric)) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
		}
		
	}
	
	public static boolean isTrigonometric(int num, ArrayList<Integer> trigonometric) {
		int triangleNum1 = 0;
		int triangleNum2 = 0;
		int triangleNum3 = 0;
		int sum			 = 0;
		
		for(int i=0;i<trigonometric.size();i++) {
			triangleNum1 = trigonometric.get(i);
			for(int j=0;j<trigonometric.size();j++) {
				triangleNum2 = trigonometric.get(j);
				for(int k=0;k<trigonometric.size();k++) {
					triangleNum3 = trigonometric.get(k);
					sum = triangleNum1 + triangleNum2 + triangleNum3;
					if(num==sum) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
}