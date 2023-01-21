import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int x = String.valueOf(N).length();
		
		int sum=0;
		for(int i=0;i<x-1;i++) {
			sum+=(Math.pow(10, i+1)-Math.pow(10, i))*(i+1);
		}
		sum+=(x)*(N-Math.pow(10, x-1)+1);
		
		System.out.println(sum);
	}
}
