/**
iven n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8

*/

public class GenerateParanthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));

    }
    public static List<String> generateParenthesis(int n) {
//        return paranthesis(n*2,"");
        return paranthesis2ndApproach(n,0,0,"");
    }

    public static List<String> paranthesis(int n, String p){
        if(n==0 ){
            List<String> list = new ArrayList<>();
            if(isValid(p))
                list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();

        list.addAll(paranthesis(n-1,p+'('));
        list.addAll(paranthesis(n-1,p+')'));

        return list;

    }

    private static boolean isValid(String p){
        Stack<Character> stack = new Stack<>();
        for(char ch : p.toCharArray()){
            if(ch == '('){
                stack.push(')');
            }else if(stack.isEmpty() || stack.pop() != ')'){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static List<String> paranthesis2ndApproach(int n, int left, int right, String p){
        if(p.length() == 2*n ){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();
        if(left<n){
            list.addAll(paranthesis2ndApproach(n,left+1,right,p+'('));
        }
        if(right<left){
            list.addAll(paranthesis2ndApproach(n,left,right+1,p+')'));
        }

        return list;

    }
}
