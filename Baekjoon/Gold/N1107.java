import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[] broken = new boolean[10];
		if(M!=0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				broken[Integer.parseInt(st.nextToken())]=true;
			}
		}
		
		int target = Math.abs(N-100);
		for(int i=0;i<=999999;i++) {
			String s = String.valueOf(i);
			int len = s.length();
			
			boolean isBreak = false;
			for(int j=0;j<len;j++) {
				if(broken[s.charAt(j)-'0']) {
					isBreak=true;
					break;
				}
			}
			
			if(!isBreak) {
				int min = Math.abs(N-i)+len;
				target = Math.min(target,min);
			}
		}
		System.out.println(target);
	}
}
