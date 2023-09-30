/**

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
 

Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

*/


public class IntegerListPermutations {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
//        combinations1(nums, 0, new ArrayList(), result);
        combinations2(nums, 0, result);
        return result;
    }

    public static void combinations1(int[] nums, int index, List<Integer> currentComb, List<List<Integer>> result){
        if(index==nums.length){
            result.add(new ArrayList(currentComb));
        }
        for(int i=0 ; i< nums.length; i++){
            if(currentComb.contains(nums[i]))
                continue;

            int num = nums[i];
            currentComb.add(num);
            combinations1(nums, index+1,currentComb, result);
            currentComb.remove(currentComb.size()-1);
        }
    }

    public static void combinations2(int[] nums, int index, List<List<Integer>> result){
        if(index==nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num:nums){
                list.add(num);
            }
            result.add(list);
            return;
        }

        for(int i=index; i<nums.length; i++){
            //swap
            swap(nums,index, i);
            combinations2(nums,index+1,result);
            //swap back
            swap(nums,i,index);
        }
    }

    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


}

