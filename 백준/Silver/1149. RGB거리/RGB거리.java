import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
@author 		Ryong
@since 			2023. 8. 9.
@see			https://www.acmicpc.net/problem/1149
@performance	12112kb	96ms
@category 		#DP
@note
*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] houseCost = new int[N][3];
		int[][] dp = new int[N][3]; 
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				houseCost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int j = 0; j < 3; j++) {
			dp[0][j] = houseCost[0][j];
		}
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + houseCost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + houseCost[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + houseCost[i][2];
		}
		
		int min = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
		System.out.println(min);
		br.close();
	}

}