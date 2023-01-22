import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int cnt=0;
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(sosu(num)) cnt++;
		}
		System.out.println(cnt);
	}
	
	private static boolean sosu(int n) {
		
		if(n==1) return false;
		if(n==2) return true;
		
		for(int i=2;i<n;i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
