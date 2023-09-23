public class InPlaceMergeSortRecursion{

	public static void main(String[] args){
		int[] arr = new int[]{1,5,3,2,6,4,10,11,76,23,9};
		mergeSort(arr,0,arr.length-1);
		Arrays.stream(arr).forEach(System.out::println);
	}

	public static void mergeSort(int[] arr, int start, int end){
		if(start<end){
			int mid = start + (end-start)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}

	public static void merge(int[] arr, int start, int mid, int end){
		int start2 = mid+1;

		if(arr[mid]<=arr[start2])
			return;

		while(start<=mid && start2<=end){
			if(arr[start]<arr[start2]){
				start++;
			}else {
				int temp = arr[start2];
				int index = start2;
				while(index != start){
					arr[index] = arr[index-1];
					index--;
				}
				arr[start] = temp;
				start++;
				start2++;
				mid++;
			}
		}

	}
}
