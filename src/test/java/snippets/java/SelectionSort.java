package snippets.java;

/**
 * In selection sort we take the first value and compare it with second ,
 *  then third, then fourth and at the end 1st value will be the minimum value.
 *  
 *  then compare the second value, with third, fourth and fifth and at the end make the second value as second minimum value
 *  
 * @author vinitg
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {64, 34, 25, 12, 22, 11, 90};
		selectionSort(arr);
		for(int i=0; i< arr.length ; i++) {
			System.out.print(arr[i] + ",");
		}
	}

	static void selectionSort(int arr[]){
		int n = arr.length;

		for(int i=0; i < n-1; i++) {
			for(int j=i+1 ; j<n ; j++) {
				if(arr[i]>arr[j]) {
					arr[i] = arr[i] + arr[j];
					arr[j] = arr[i] - arr[j];
					arr[i] = arr[i] - arr[j];
				}
			}
		}
	}
}
