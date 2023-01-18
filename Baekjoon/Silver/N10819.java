import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,max;
	static int[] arr,ans;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		ans = new int[N];
		
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		max = Integer.MIN_VALUE;
		perm(0);
		
		System.out.println(max);
	}
	
	private static void perm(int idx) {
		
		if(idx==N) {
			calc();
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			ans[idx]=arr[i];
			perm(idx+1);
			isSelected[i] = false;
		}
	}
	
	private static void calc() {
		
		int sum=0;
		for(int i=0;i<N-1;i++) {
			sum+=Math.abs(ans[i]-ans[i+1]);
		}
		
		max = Math.max(max,sum);
	}
}
