import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] dp,arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N];
		dp[0]=1;
		
		for(int i=1;i<N;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && dp[i]<=dp[j]) {
					dp[i] = dp[j]+1;
				}
			}
		}
		int max=0;
		for(int i:dp) {
			max = Math.max(max,i);
		}
		System.out.println(max);
	}
}
