import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static class Point{
		int x;
		int y;
		int t;
		
		public Point(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	static int N,M,min;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<Point> q;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==0) {
						
						check = new boolean[4];
						for(int d=0;d<4;d++) {
							int nx = i+dx[d];
							int ny = j+dy[d];
							
							if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
							if(map[nx][ny]==0) {
								check[d]=true;
							}
						}
						if(check[0] && check[2]) continue;
						else if(check[0]&& check[3]) continue;
						else if(check[1] && check[2]) continue;
						else if(check[1] && check[3]) continue;
						
						map[i][j]=M;
						visited = new boolean[N][N];
						
						bfs();
						map[i][j]=0;
					}
				}
			}
			System.out.println(min);
	}
	
	private static void bfs() {
		
		visited[0][0]=true;
		
		q = new LinkedList<>();
		q.offer(new Point(0,0,0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x==N-1 && p.y==N-1) {
				min = Math.min(min,p.t);
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(visited[nx][ny] || map[nx][ny]==0) continue;
				
				if(map[nx][ny]==1) {
					visited[nx][ny]=true;
					q.offer(new Point(nx,ny,p.t+1));
				}
				
				if(map[nx][ny]>1 && map[p.x][p.y]==1) {
					if((p.t+1)%map[nx][ny]==0) {
						visited[nx][ny]=true;
						q.offer(new Point(nx,ny,p.t+1));
					}else {
						q.offer(new Point(p.x,p.y,p.t+1));
					}
				}
			}
		}
	}
}
