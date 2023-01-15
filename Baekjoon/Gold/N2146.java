import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		int x;
		int y;
		int n;
		
		public Point(int x, int y,int n) {
			this.x = x;
			this.y = y;
			this.n = n;
		}
	}
	static int N,cnt,min;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited,visited2;
	static Queue<Point> q;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt=1;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && map[i][j]>0) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>0 && !visited[i][j]) {
					bfs(i,j,map[i][j]);
				}
			}
		}
		System.out.println(min);
	}
	
	private static void dfs(int x, int y) {
		
		visited[x][y] = true;
		map[x][y] = cnt;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
			if(visited[nx][ny] || map[nx][ny]==0) continue;
			
			dfs(nx,ny);
		}
	}
	
	private static void bfs(int x, int y, int sNum) {
		
		visited2 = new boolean[N][N];
		q = new LinkedList<>();
		
		q.offer(new Point(x,y,0));
		visited2[x][y] = true;
		
		while(!q.isEmpty()) {
			
			Point p = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(map[nx][ny]==sNum || visited2[nx][ny]) continue;
				
				if(map[nx][ny]==0) {
					visited2[nx][ny] = true;
					q.offer(new Point(nx,ny,p.n+1));
				}else if(map[nx][ny]>0) {
					min = Math.min(min,p.n);
				}
			}
		}
	}
}
