public class QuickSort{
	
	public static void main(String[] args){
		int[] arr = new int[]{32, 55, 66, 0,1,5,3,2,6,4,10,11,76,23,9};
		quickSort(arr,0,arr.length-1);
		Arrays.stream(arr).forEach(System.out::println);
	}

	public static void quickSort(int[] arr, int start, int end){
		if(start<end){
			int pivot = partition(arr, start, end);
			quickSort(arr,start,pivot-1);
			quickSort(arr,pivot+1,end);
		}
	}

	public static int partition(int[] arr, int start, int end){
		int pivot = arr[end];
		int k = start-1;
		while(start<end){
			if(arr[start]<pivot){
				swap(arr,++k,start );
			}
			start++;
		}
		swap(arr,++k,end);
		return k;
	}

	public static void swap(int[] arr, int x, int y){
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
