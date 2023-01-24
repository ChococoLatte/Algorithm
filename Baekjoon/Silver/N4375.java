import java.util.Scanner;

public class Main {
	static int N,num;
	static String s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			N = sc.nextInt();
			num=0;
			
			for(int i=1;;i++) {
				num = (num*10+1)%N;
				if(num==0) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}
