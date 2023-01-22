import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static final int MAX = 1000000;
	static int N,max,p1,p2;
	static boolean flag;
	static boolean prime[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		prime = new boolean[MAX+1];
		getPrime();
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			max = Integer.MIN_VALUE;
			flag=false;
			
			for(int i=2;i<=N/2;i++) {
				if(!prime[i] && !prime[N-i]) {
					sb.append(N+" = "+i+" + "+(N-i)).append("\n");
					flag=true;
					break;
				}
			}
			
		}
		if(!flag) System.out.println("Goldbach's conjecture is wrong.");
		else System.out.println(sb);
	}
	
	private static void getPrime() {
		
		prime[0]=prime[1]=true;
		
		for(int i=2;i<=MAX;i++) {
			if(prime[i]) continue;
			for(int j=i*2;j<=MAX;j+=i) {
				prime[j]=true;
			}
		}
	}
}
