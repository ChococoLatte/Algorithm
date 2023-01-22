import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M,N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=M;i<=N;i++) {
			if(sosu(i)) sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static boolean sosu(int n) {
		
		if(n==1) return false;
		if(n==2) return true;
		
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
