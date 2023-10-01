/**
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/

public class PermutationsII{
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        combinations(nums, 0, result);
        return result;
    }

    public void combinations(int[] nums, int index, List<List<Integer>> result){
        if(index == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            result.add(list);

            return;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = index ; i< nums.length; i++){
            if(set.add(nums[i])){
                swap(nums, i, index);
                combinations(nums, index+1, result);
                swap(nums, i, index);
            }
            
        }
    }

    public void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
