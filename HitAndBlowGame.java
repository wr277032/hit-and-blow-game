import java.util.Scanner;
import java.util.Random;

class HitAndBlowGame {
	public static void main(String[] args) {
		
		Scanner stdIn = new Scanner(System.in);
		Random rand = new Random();
		
		int hit;
		int blow;
		
		System.out.print("ヒットアンドブローゲーム\n何桁でプレイしますか(3~5) : ");
		int n = stdIn.nextInt();
		
		if (n < 3 || n > 5) {
			while (n < 3 || n > 5) {
			System.out.println("ERROR : 3~5桁の整数を入力してください");
			n = stdIn.nextInt();
			}
		}
		
		int[] answerDiv = new int[n];
			
		if (n == 3)	{
			answerDiv[2] = rand.nextInt(9) + 1;
			while (answerDiv[1] == answerDiv[2]) {
				answerDiv[1] = rand.nextInt(10);
			}
			while (answerDiv[0] == answerDiv[1] || answerDiv[0] == answerDiv[2]) {
				answerDiv[0] = rand.nextInt(10);
			}
		}
		
		if (n == 4) {
			answerDiv[3] = rand.nextInt(9) + 1;
			while (answerDiv[2] == answerDiv[3]) {
				answerDiv[2] = rand.nextInt(10);
			}
			while (answerDiv[1] == answerDiv[2] || answerDiv[1] == answerDiv[3]) {
				answerDiv[1] = rand.nextInt(10);
			}
			while (answerDiv[0] == answerDiv[1] || answerDiv[0] == answerDiv[2] || answerDiv[0] == answerDiv[3]) {
				answerDiv[0] = rand.nextInt(10);
			}
		}
		
		if (n == 5) {
			answerDiv[4] = rand.nextInt(9) + 1;
			while (answerDiv[3] == answerDiv[4]) {
				answerDiv[3] = rand.nextInt(10);
			}
			while (answerDiv[2] == answerDiv[3] || answerDiv[2] == answerDiv[4]) {
				answerDiv[2] = rand.nextInt(10);
			}
			while (answerDiv[1] == answerDiv[2] || answerDiv[1] == answerDiv[3] || answerDiv[1] == answerDiv[4]) {
				answerDiv[1] = rand.nextInt(10);
			}
			while (answerDiv[0] == answerDiv[1] || answerDiv[0] == answerDiv[2] || answerDiv[0] == answerDiv[3] || answerDiv[0] == answerDiv[4]) {
				answerDiv[0] = rand.nextInt(10);
			}
		}
		
		System.out.println(n + "桁のヒットアンドブローゲームを開始します");
for (int i = n - 1; i >= 0; i--) {
System.out.println(answerDiv[i]);
}		
		do {
			System.out.println("予想した" + n + "桁の数字を入力してください");
			String inputStr = stdIn.next();
			int input = Integer.parseInt(inputStr);
			
			if (inputStr.length() != n) {
				do {
					System.out.println("ERROR : " + n + "桁の数字を入力してください");
					input = stdIn.nextInt();
					inputStr = String.valueOf(input);
				} while (inputStr.length() != n);
			}
				
				int[] inputDiv = new int[n];
				
				for (int i = 0; i < n; i++) {
					inputDiv[i] = input % 10;
					input /= 10;
				}
				
				hit = 0;
				blow = 0;
				
				for (int i = 0; i < n; i++) {
					if(inputDiv[i] == answerDiv[i]) {
						hit++;
					}
					for (int j = 0; j < n; j++) {
						if (inputDiv[i] == answerDiv[j] && inputDiv[j] != answerDiv[j]) {
							blow++;
						}
					}
				}
					
				
				System.out.println("hit: " + hit + "\nblow: " + blow);
				
		} while (hit != n);
			
		System.out.println("正解です");
		return;
		
	}
}
