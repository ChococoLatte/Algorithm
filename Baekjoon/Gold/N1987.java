import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C,max;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		isSelected = new boolean[26];
		dfs(0,0,0);
		
		System.out.println(max);
		
	}
	
	private static void dfs(int x, int y, int cnt) {
		
		if(isSelected[map[x][y]-'A']) {
			max = Math.max(max,cnt);
			return;
		}
		
		isSelected[map[x][y]-'A'] = true;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
			
			dfs(nx,ny,cnt+1);
		}
		isSelected[map[x][y]-'A'] = false;
	}
}
