package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @문제 : 사탕게임
 * https://www.acmicpc.net/problem/3085
 */
/**
 * 
 * @author KJ
 * 문제해결
 * 1) row swap
 * 2) count check
 * 3) col swap
 * 4) count check
 * 5) 1~4 과정에서 max값 구하기
 */
public class Exercise_3085 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int matrixSize = Integer.parseInt(br.readLine());
		
		char[][] matrix = new char[matrixSize][matrixSize];
		
		for(int i=0;i<matrixSize;i++){
			String row = br.readLine();
			for(int j=0;j<matrixSize;j++) {
				matrix[i][j] = row.charAt(j);
			}
		}
		
		System.out.println(solve(matrix));
	}
	public static int solve(char[][] matrix) {
		int max = 1;
		int cnt = 1;
		char temp;
		//swap & count
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {//row count check
				if(j==matrix[i].length-1)
					break;
				temp = matrix[i][j+1];
				matrix[i][j+1] = matrix[i][j];
				matrix[i][j] = temp;
				cnt = countCheck(matrix);
				matrix[i][j] = matrix[i][j+1];
				matrix[i][j+1] = temp;
				max = cnt > max ? cnt : max;
			}
			for(int j=0;j<matrix[i].length;j++) {//col count check
				if(j==matrix[i].length-1)
					break;
				temp = matrix[j+1][i];
				matrix[j+1][i] = matrix[j][i];
				matrix[j][i] = temp;
				cnt = countCheck(matrix);
				matrix[j][i] = matrix[j+1][i];
				matrix[j+1][i] = temp;
				max = cnt > max ? cnt : max;
			}
		}
		
		return max;
	}
	public static int countCheck(char[][] matrix) {
		int max = 1;
		int rowCnt = 1;
		int colCnt = 1;
		
		for(int i=0;i<matrix.length;i++) {
			rowCnt = 1;
			for(int j=0;j<matrix[i].length;j++) {
				if(j==matrix[i].length-1)
					break;
				
				if(matrix[i][j]==matrix[i][j+1]) {
					rowCnt++;
				}else{
					rowCnt=1;
				}
				
				max = (rowCnt > max) ? rowCnt : max;
			}
			colCnt = 1;
			for(int j=0;j<matrix[i].length;j++) {
				if(j==matrix[i].length-1)
					break;
				
				if(matrix[j][i]==matrix[j+1][i]) {
					colCnt++;
				}else{
					colCnt=1;
				}
				
				max = (colCnt > max) ? colCnt : max;
			}
		}
		
		return max;
	}
}
