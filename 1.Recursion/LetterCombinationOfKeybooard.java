/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

*/


public class LetterCombinationOfKeyboard{
	
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    private static List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return new ArrayList<String>();
        return combinations(digits, 0, "");
    }

    private static List<String> combinations(String digits, int index, String comb){
        if(index>=digits.length()){
            List<String> list = new ArrayList<>();
            list.add(comb);
            return list;
        }

        List<String> list = new ArrayList<>();

        String letters = getDigitMapping(digits.charAt(index));

        for(char ch : letters.toCharArray()){
            list.addAll(combinations(digits, index+1, comb+ch));
        }

        return list;

    }

    private static String getDigitMapping(char digit){
        String mapping = "";
        switch(digit){
            case '2' :
                mapping = "abc";
                break;
            case '3' :
                mapping = "def";
                break;
            case '4' :
                mapping = "ghi";
                break;
            case '5' :
                mapping = "jkl";
                break;
            case '6' :
                mapping = "mno";
                break;
            case '7' :
                mapping = "pqrs";
                break;
            case '8' :
                mapping = "tuv";
                break;
            case '9' :
                mapping = "wxyz";
                break;
        }
        return mapping;
    }
}
