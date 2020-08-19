package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @����
 * �պ� ���� �ϰ� �����̵�� �Բ� ��ȭ�Ӱ� ��Ȱ�ϰ� �ִ� �鼳���ֿ��� ���Ⱑ ã�ƿԴ�. �ϰ��� ��ġ�� ���ƿ� �����̰� �ϰ� ���� �ƴ� ��ȩ ���̾��� ���̴�.
 * ��ȩ ���� �����̴� ��� �ڽ��� "�鼳 ���ֿ� �ϰ� ������"�� ���ΰ��̶�� �����ߴ�. �پ ������ �������� ������ �ִ� �鼳���ִ�, ���ེ���Ե� �ϰ� �������� Ű�� ���� 100�� ���� ����� �´�.
 * ��ȩ �������� Ű�� �־����� ��, �鼳���ָ� ���� �ϰ� �����̸� ã�� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * @�Է�
 * ��ȩ ���� �ٿ� ���� �����̵��� Ű�� �־�����. �־����� Ű�� 100�� ���� �ʴ� �ڿ����̸�, ��ȩ �������� Ű�� ��� �ٸ���, 
 * ������ ������ ���� ������ ��쿡�� �ƹ��ų� ����Ѵ�.
 * 
 * @���
 * �ϰ� �������� Ű�� ������������ ����Ѵ�. �ϰ� �����̸� ã�� �� ���� ���� ����.
 * 
 * @�����Է�
 * 20
 * 7
 * 23
 * 19
 * 10
 * 15
 * 25
 * 8
 * 13
 * 
 * @�������
 * 
 * 7
 * 8
 * 10
 * 13
 * 19
 * 20
 * 23
 */
public class Exercise_2309 {
	// 1) idx 2�� ���� �� �ջ� ���
	// 2) ��� �ջ� �� ������ ���� �� idx ã��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nan9height = new int[9];
		int[] nan7height = new int[7];
		int heightSum 	 = 0;
		int nanLier1  	 = 0;
		int nanLier2  	 = 0;
		
		/* ========================================================== */
		/* 					 	�ջ� �� ���� �� idx ã�� 				  	  */
		/* ========================================================== */
		int overHeight	 = 0;
		for(int i=0;i<9;i++){
			nan9height[i] = sc.nextInt();
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
		/* 					 idx 2�� ���� �� �ջ� ��� 					  */
		/* ========================================================== */
		/*
		for(int i=0;i<9;i++){
			nan9height[i] = sc.nextInt();
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
