import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] ans;
	static int[] num;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int[M];
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		combination(0,0);
		System.out.println(sb);
	}
	
	private static void combination(int start, int cnt) {
		
		if(cnt==M) {
			for(int i:ans) sb.append(i+" ");
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<N;i++) {
			ans[cnt]=num[i];
			combination(i,cnt+1);
		}
	}
}
