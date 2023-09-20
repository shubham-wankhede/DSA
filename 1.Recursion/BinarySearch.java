public class PracticeApplication {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7};
		binarySearch(arr, 0, arr.length-1, 5);
	}

	public static int binarySearch(int[] arr, int start, int end, int target){
		if(start<=end){
			int mid = start+(end-start)/2;
			if(arr[mid]==target)
				return mid;
			else if(target<arr[mid])
				return binarySearch(arr, start, mid-1, target);
			else if(target>arr[mid])
				return binarySearch(arr, mid+1, end, target);
		}
		return -1;
	}
