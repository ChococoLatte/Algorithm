import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] ans,num;
	static StringBuffer sb;
	static LinkedHashSet<String> a;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int[M];
		num = new int[N];
		
		a = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		combination(0,0);
		a.forEach(System.out::println);
	}
	
	private static void combination(int start, int cnt) {
		
		if(cnt==M) {
			sb = new StringBuffer();
			for(int i: ans) sb.append(i+" ");
			a.add(sb.toString());
			return;
		}
		
		for(int i=start;i<N;i++) {
			ans[cnt] = num[i];
			combination(i+1,cnt+1);
		}
	}
}
