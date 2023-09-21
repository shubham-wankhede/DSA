public class RecursiveBubbleSort {

    	public static void main(String[] args) {
		int[] arr = new int[]{1,5,3,2,6,4};
		bubbleSort(arr,0,arr.length-1);
		Arrays.stream(arr).forEach(System.out::println);
	}

	//bubble sort
	public static void bubbleSort(int[] arr, int index, int length){
		if(length==1){
			return;
		}
		if(index<=length-1){
			if(arr[index]>arr[index+1]){
				swap(arr,index,index+1);
			}
			bubbleSort(arr,++index,length);
		}else{
			bubbleSort(arr,0,length-1);
		}
	}

	public static void swap(int[] arr, int x, int y){
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}

