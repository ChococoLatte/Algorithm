import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int R,C;
	static boolean hasEnd,findEnd;
	static char[][] map;
	static boolean[][][][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			hasEnd=false;
			findEnd=false;
			
			map = new char[R][C];
			visited = new boolean[R][C][4][16];
			
			for(int i=0;i<R;i++) {
				String s = br.readLine();
				for(int j=0;j<C;j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j]=='@') hasEnd=true;
				}
			}
			if(hasEnd) {
				solve(0,0,3,0);
			}
			
			if(findEnd) System.out.println("#"+t+" YES");
			else System.out.println("#"+t+" NO");
		}
	}
	
	private static void solve(int x, int y, int dir, int mem) {
		
		if(findEnd) return;
		
		if(map[x][y]=='@') {
			findEnd=true;
			return;
		}
		
		if(visited[x][y][dir][mem]) return;
		
		visited[x][y][dir][mem]=true;
		
		int nd = dir;
		int nm = mem;
		
		switch(map[x][y]) {
		case '<' : nd = 2; break;
		case '>' : nd = 3; break;
		case '^' : nd = 0; break;
		case 'v' : nd = 1; break;
		case '_' : nd = (mem==0)? 3:2; break;
		case '|' : nd = (mem==0)? 1:0; break;
		case '+' : nm = (mem==15)?mem=0:mem+1; break;
		case '-' : nm = (mem==0)?mem=15:mem-1; break;
		case '0': case '1': case '2':case '3': case '4': case '5':
		case '6': case '7': case '8': case '9' : nm =map[x][y]-'0'; break;
		}
		
		if(map[x][y]=='?') {
			for(int i=0;i<4;i++) {
				if(x+dx[i]<0) {
					solve(R-1,y+dy[i],i,nm);
				}else if(x+dx[i]>=R) {
					solve(0,y+dy[i],i,nm);
				}else if(y+dy[i]<0) {
					solve(x+dx[i],C-1,i,nm);
				}else if(y+dy[i]>=C){
					solve(x+dx[i],0,i,nm);
				}else {
					solve(x+dx[i],y+dy[i],i,nm);
				}
			}
		}else {
			if(x+dx[nd]<0) {
				solve(R-1,y+dy[nd],nd,nm);
			}else if(x+dx[nd]>=R) {
				solve(0,y+dy[nd],nd,nm);
			}else if(y+dy[nd]<0) {
				solve(x+dx[nd],C-1,nd,nm);
			}else if(y+dy[nd]>=C){
				solve(x+dx[nd],0,nd,nm);
			}else {
				solve(x+dx[nd],y+dy[nd],nd,nm);
			}
		}
	}
}
