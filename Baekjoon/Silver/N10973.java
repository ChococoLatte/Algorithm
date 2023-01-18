import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		beforePermutation(arr);
	}
	
	private static void beforePermutation(int[] arr) {
	
		int n = arr.length;
		boolean b = true;
		
		outer: for(int i=n-1;i>0;i--) {
			if(arr[i-1]>arr[i]) {
				for(int j=n-1;j>=i;j--) {
					if(arr[j]<arr[i-1]) {
						int temp = arr[j];
						
						arr[j] = arr[i-1];
						arr[i-1] = temp;
						
						int k = n-1;
						while(i<k) {
							int temp2 = arr[i];
							
							arr[i] = arr[k];
							arr[k] = temp2;
							
							i++;
							k--;
						}
						b=false;
						break outer;
					}
				}
			}
		}
		if(b) System.out.println(-1);
		else {
			for(int i:arr) System.out.print(i+" ");
			System.out.println();
		}
	}
}
