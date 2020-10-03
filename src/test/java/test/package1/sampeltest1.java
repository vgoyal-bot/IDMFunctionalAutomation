package test.package1;

public class sampeltest1 {

	public static void main(String[] args) {
		
		for(int j=0;j<3;j++) {

			for(int i=0 ;i<j;i++) {
				System.out.print(" ");
			}
			for(int i=6-2*j;i>0;i--) {
				System.out.print("*");
			}
			for(int i=0 ;i<j;i++) {
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}


