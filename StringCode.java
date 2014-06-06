package assign1;

import java.util.HashSet;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adjacent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		if (str.length() == 0) return 0;
		int run = 1;
		int temprun = 0;
		for (int i = 0; i < str.length() - 1; i++){
			if(str.charAt(i) == str.charAt(i + 1)){
				int n = i;
				temprun++;
				while(str.charAt(n) == str.charAt(n + 1)){
					temprun++;
					n++;
					if(n == str.length()-1) break;
				}
				if(temprun > run) run = temprun;
				temprun = 0;
			}
		}
		return run;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		String blownStr = "";
		for(int i = 0; i < str.length(); i++){
			if(Character.isDigit(str.charAt(i))){
				if(i == str.length() - 1) break;
				for (int n = 0; n < (str.charAt(i) - 48); n++){
					blownStr += str.charAt(i + 1);
				}
			} else {
				blownStr += str.charAt(i);
			}
		}
		return blownStr;
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> substrA = new HashSet<String>();
		for(int i = 0; i <= a.length() - len; i++){
			String substr = a.substring(i, i + len);
			substrA.add(substr);
		}
		for(int n = 0; n <= b.length() - len; n++){
			String substr = b.substring(n, n + len);
			if(substrA.contains(substr)) return true;
		}
		return false; // TO DO ADD YOUR CODE HERE
	}
}
