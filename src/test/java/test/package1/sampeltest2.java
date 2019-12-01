package test.package1;

public class sampeltest2 {

	public static void main(String[] args) {

		Integer arr1[] = {1,5,4,3,2};			// {6,9,7,5}
		Integer newArr[] = new Integer[arr1.length-1];
		
		for(int i=0;i<arr1.length-1;i++) {
			newArr[i] = arr1[i] + arr1[i+1];
		}
		
		int n = newArr.length;
		int max = newArr[0];
		for(int i=0;i<n;i++) {
			if(max<newArr[i]) {
				max = newArr[i];
			}
		}
		
		System.out.println("maximum value: " +max);

		
		
		
		
		
		/*for(int i=0;i<n-1;i++) {
			for(int j=0 ;j<n-i-1; j++) {
				if(newArr[j]>newArr[j+1]) {
					//replace
					int temp = newArr[j];
					newArr[j] = newArr[j+1];
					newArr[j+1] = newArr[j];
				}
			}
		}*/
		
	}
}


