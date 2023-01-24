import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static long sum;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] arr = new long[1000001];
		Arrays.fill(arr, 1);
		
		for(int i=2;i<=1000000;i++) {
			for(int j=1;i*j<=1000000;j++) {
				arr[i*j]+=i;
			}
			arr[i] = arr[i-1]+arr[i];
		}
		
		int T= Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			N = Integer.parseInt(br.readLine());
			sb.append(arr[N]).append("\n");
		}
		System.out.println(sb);
	}
}
