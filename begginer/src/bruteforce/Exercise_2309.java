package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @문제 : 일곱난장이
 * https://www.acmicpc.net/problem/2309
 */
public class Exercise_2309 {
	// 1) idx 2개 제외 후 합산 방식
	// 2) 모두 합산 후 나머지 차이 값 idx 찾기
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] nan9height = new int[9];
		int[] nan7height = new int[7];
		int heightSum 	 = 0;
		int nanLier1  	 = 0;
		int nanLier2  	 = 0;
		
		/* ========================================================== */
		/* 					 	합산 후 차이 값 idx 찾기 				  	  */
		/* ========================================================== */
		int overHeight	 = 0;
		for(int i=0;i<9;i++){
			nan9height[i] = Integer.parseInt(br.readLine());
			heightSum += nan9height[i];
		}
		
		overHeight = heightSum - 100;
		
		try {
			for(int i=0;i<9;i++) {
				for(int j=(i+1);j<9;j++) {
					int sum = nan9height[i] + nan9height[j];

					if(overHeight==sum) {
						nanLier1 = i;
						nanLier2 = j;
						throw new Exception("find lier nanjang");
					}
				}
			}
		}catch(Exception e) {
			int idx = 0;
			for(int i=0;i<9;i++){
				if(i==nanLier1 || i==nanLier2) {
					continue;
				}
				nan7height[idx++] = nan9height[i];
			}

			Arrays.sort(nan7height);

			for(int i=0;i<7;i++){
				System.out.println(nan7height[i]);
			}
		}

		/* ========================================================== */
		/* 					 idx 2개 제외 후 합산 방식 					  */
		/* ========================================================== */
		/*
		for(int i=0;i<9;i++){
			nan9height[i] = Integer.parseInt(br.readLine());
		}

		try{
			for(int i=0;i<9;i++){
				for(int j=(i+1);j<9;j++){
					heightSum = 0;
					for(int k=0;k<9;k++){
						if(i==k) {
							nanLier1 = i;
							continue;
						}
						if(j==k) {
							nanLier2 = j;
							continue;
						}
						heightSum += nan9height[k];
					}
					if(heightSum==100){
						throw new Exception("find lier nanjang");
					}
				}
			}
		}catch(Exception e){
			int idx = 0;
			for(int i=0;i<9;i++){
				if(i==nanLier1 || i==nanLier2) {
					continue;
				}
				nan7height[idx++] = nan9height[i];
			}

			Arrays.sort(nan7height);

			for(int i=0;i<7;i++){
				System.out.println(nan7height[i]);
			}
		}
		*/
	}
}
