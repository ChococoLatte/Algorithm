import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static char[] s;
	static int[] num;
	static boolean[] visited;
	static ArrayList<String> ans = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		
		s = new char[k];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			s[i] = st.nextToken().charAt(0);
		}
		
		num = new int[10];
		for(int i=0;i<10;i++) {
			num[i]=i;
		}
		
		for(int i=0;i<10;i++) {
			visited = new boolean[10];
			visited[i] = true;
			dfs(i,0,i+"");
			visited[i] = false;
		}
		System.out.println(ans.get(ans.size()-1));
		System.out.println(ans.get(0));
	}
	
	private static void dfs(int start, int idx, String word ) {
		
		if(word.length()==k+1) {
			ans.add(word);
			return;
		}
		
		for(int i=0;i<10;i++) {
			if(!visited[i]) {
				char temp = s[idx];
				if(temp=='>') {
					if(start>i) {
						visited[i]=true;
						dfs(i,idx+1,word+i);
						visited[i]=false;
					}
					}else {
						if(start<i) {
							visited[i]=true;
							dfs(i,idx+1,word+i);
							visited[i]=false;
						}
					}
				}
			}
		}
	}
