/**

print the forward combination of characters in from given String.

Input : "ABC"

Output :
	ABC
	AB
	AC
	A
	BC
	B
	C


*/

public class PrintForwardCombinations {
	
	public static void main(String[] args){
		subseq("ABC");
	}

	public static void subseq(String str){
		printSubseq("", str);
	}

	public static void printSubseq(String p, String up){
		if(p.isEmpty()){
			if(!up.isEmpty()){
				System.out.println(up);
			}
			return;
		}

		char ch = p.charAt(0);

		printSubseq(p+ch, up.substring(1));
		printSubseq(p, up.substring(1));
	}

}
