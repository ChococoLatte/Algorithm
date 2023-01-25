import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer>[] a;
	static char[] sw;
	static int[] score;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		a = new ArrayList[N+1];
		sw = new char[N+1];
		score = new int[N+1];
		
		for(int i=0;i<N+1;i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=2;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			
			char SW = st.nextToken().charAt(0);
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			sw[i] = SW;
			score[i] = s;
			a[p].add(i);
			
		}
		System.out.println(postOrder(1));
	}
	
	private static long postOrder(int node) {
		long sum=0;
		for(int next: a[node]) {
			sum+=postOrder(next);
		}
		
		if(sw[node] == 'S') return sum+score[node];
		else return (sum-score[node]>=0)? sum-score[node]:0;
	}
}
