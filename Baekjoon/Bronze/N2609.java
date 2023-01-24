import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int gcd = gcd(N,M);
		
		System.out.println(gcd);
		System.out.println(N*M/gcd);
	}
	
	private static int gcd(int a, int b) {
		
		if(b==0) {
			return a;
		}
		
		return gcd(b,a%b);
	}
}
