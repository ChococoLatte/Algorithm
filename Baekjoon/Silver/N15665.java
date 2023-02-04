import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] ans, num;
	static StringBuffer sb = new StringBuffer();
	static LinkedHashSet<String> a;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int[M];
		num = new int[N+1];
		
		a = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		permutation(0);
		System.out.println(sb);
		
	}
	
	private static void permutation(int idx) {
		
		if(idx==M) {
			for(int i: ans) sb.append(i+" ");
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(num[i-1]!=num[i]) {
				ans[idx] = num[i];
				permutation(idx+1);
			}
		}
	}
}
