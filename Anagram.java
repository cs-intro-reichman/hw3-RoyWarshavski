/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
   
    String newStr1 = preProcess(str1);
    String newStr2 = preProcess(str2);


    String cleanStr1 = "";
    String cleanStr2 = "";

    
    for (int i = 0; i < newStr1.length(); i++) {
        if (newStr1.charAt(i) != ' ') {
            cleanStr1 += newStr1.charAt(i);
        }
    }

    for (int i = 0; i < newStr2.length(); i++) {
        if (newStr2.charAt(i) != ' ') {
            cleanStr2 += newStr2.charAt(i);
        }
    }

    
    if (cleanStr1.length() != cleanStr2.length())
        return false;

    for (int i = 0; i < cleanStr1.length(); i++) {
        boolean found = false;

        for (int j = 0; j < cleanStr2.length(); j++) {
            if (cleanStr1.charAt(i) == cleanStr2.charAt(j)) {
                cleanStr2 = cleanStr2.substring(0, j) + cleanStr2.substring(j + 1);
                found = true;
                break;
            }
        }

        if (!found)
            return false;
    }

    return cleanStr2.length() == 0;
}

	   





	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String lowStr = str.toLowerCase();
		for (int i=0;i<lowStr.length();i++) {
			if ((lowStr.charAt(i)< 'a' ||lowStr.charAt(i)> 'z'))
			{
				lowStr= lowStr.substring(0,i)+ lowStr.substring(i+1,lowStr.length());
				i--;

			}

		}

		return lowStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);
		String newWord = "";
		while (str.length() !=0){
			int i = (int) (Math.random()*str.length());
			 newWord = newWord + str.charAt(i);
			 str= str.substring(0,i)+ str.substring(i+1,str.length());

		}


		return newWord;
	}
}



