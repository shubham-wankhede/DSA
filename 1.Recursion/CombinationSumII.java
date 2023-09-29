/**

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

*/
public class CombinationSumII {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{10,1,2,7,6,1,5},8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        //combinations1(candidates,target,0,result,new ArrayList<>());
        combinations2(candidates,target,0,new ArrayList<>(),result);
        return result;
    }

    private static void combinations1(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> currentComb){
        if(index==candidates.length){
            if(target==0){
                if(!result.contains(currentComb)){
                    result.add(new ArrayList<>(currentComb));
                }
            }
            return;
        }

        if(candidates[index]<=target){
            currentComb.add(candidates[index]);
            combinations1(candidates,target-candidates[index],index+1,result,currentComb);
            currentComb.remove(currentComb.size()-1);
        }
        combinations1(candidates,target,index+1,result,currentComb);
    }

    private static void combinations2(int[] candidates, int target, int index, List<Integer> curr, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i < candidates.length; ++i) {
            if(i > index && candidates[i] == candidates[i - 1])
                continue;

            if(candidates[i] > target)
                break;

            curr.add(candidates[i]);
            combinations2(candidates, target - candidates[i], i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}

