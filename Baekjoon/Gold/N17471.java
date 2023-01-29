import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N,ans;
	static int[] num;
	static int[][] group;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		
		num = new int[N];
		group = new int[N][N];
		
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			for(int j=0;j<n;j++) {
				group[i][Integer.parseInt(st.nextToken())-1]=1;
			}
		}
		
		subset(0);
		
		if(ans==Integer.MAX_VALUE) ans=-1;
		System.out.println(ans);
	}
	
	private static void subset(int idx) {
		
		if(idx==N) {
			if(check(true) && check(false)) {
				ans = Math.min(ans,calcMin());
			}
			return;
		}
		
		isSelected[idx]=true;
		subset(idx+1);
		isSelected[idx]=false;
		subset(idx+1);
	}
	
	private static boolean check(boolean chk) {
		
		boolean[] visited = new boolean[N];
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]==chk) {
				list.addLast(i);
				visited[i]=true;
				break;
			}
		}
		
		while(!list.isEmpty()) {
			int n = list.pollFirst();
			
			for(int i=0;i<N;i++) {
				
				if(visited[i] || chk !=isSelected[i]) continue;
				if(group[n][i]==1) {
					list.addLast(i);
					visited[i]=true;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]==chk && !visited[i]) return false;
		}
		
		return true;
	}
	
	private static int calcMin() {
		
		int Selected=0;
		int nSelected=0;
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) Selected+=num[i];
			else nSelected+=num[i];
		}
		
		return Math.abs(Selected-nSelected);
	}
}
