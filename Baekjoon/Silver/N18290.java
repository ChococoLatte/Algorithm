import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K,max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = Integer.MIN_VALUE;
		dfs(0,0,0,0);
		
		System.out.println(max);
	}
	
	private static void dfs(int x, int y, int idx, int cnt) {
		
		if(idx==K) {
			max = Math.max(max,cnt);
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j]) {
					if(check(i,j)) {
						visited[i][j] = true;
						dfs(i,j,idx+1,cnt+map[i][j]);
						visited[i][j] = false;
					}
				}
			}
		}
	}
	
	private static boolean check(int x, int y) {
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			if(visited[nx][ny]) return false;
		}
		
		return true;
	}
}
