import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,min;
	static int[][] map;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		isSelected = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		
		subset(0);
		System.out.println(min);
	}
	
	private static void subset(int idx) {
		
		if(idx==N) {
			calc();
			return;
		}
		
		isSelected[idx]=true;
		subset(idx+1);
		isSelected[idx]=false;
		subset(idx+1);
	}
	
	private static void calc() {
		
		int Selected=0;
		int nSelected=0;
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if(isSelected[i] && isSelected[j]) {
					Selected+=map[i][j];
					Selected+=map[j][i];
				}else if(!isSelected[i] && !isSelected[j]) {
					nSelected+=map[i][j];
					nSelected+=map[j][i];
				}
			}
		}
		min = Math.min(min,Math.abs(Selected-nSelected));
	}
}
