package snippets.java;

/**
 * Bubble sort compares the two adjacent pair and at the end of 1 sequence, max value will be at the end side.
 * @author vinitg
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {64, 34, 25, 12, 22, 11, 90};
		bubbleSort(arr);
		for(int i=0; i< arr.length ; i++) {
			System.out.println(arr[i]);
		}
	}

	static void bubbleSort(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
			if (arr[j] > arr[j+1])
			{
				// swap temp and arr[i]
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
	}

}
