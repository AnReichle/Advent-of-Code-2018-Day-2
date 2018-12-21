import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		String path = "src\\input12.txt";
		ArrayList<String> input = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String str;
			while((str = br.readLine()) != null) {
				input.add(str);
			}
		}
		long n_group3 = input.stream().filter(str -> hasGroupOfN(str, 3)).count();
		long n_group2 = input.stream().filter(str -> hasGroupOfN(str, 2)).count();
		System.out.println("answer for (a): " + (n_group3 * n_group2));
		System.out.print("answer for (b): ");
		outerLoop:
		for(String str1 : input) {
			for(String str2 : input) {
				if(differsIn1Place(str1, str2)) {
					for(int i = 0; i<str1.length(); i++) {
						if(str1.charAt(i) == str2.charAt(i)) System.out.print(str2.charAt(i));
					}
					break outerLoop;
				}
			}
		}
	}
	static boolean hasGroupOfN(String str, int n) {
		for(char c1 : str.toCharArray()) { 
			int counter = 0;
			for(char c2 : str.toCharArray()) {
				if(c1 == c2) counter ++;
			}
			if(counter == n) return true;
		}
		return false;
	}
	static boolean differsIn1Place(String str1, String str2) {
		char[] strArr1 = str1.toCharArray();
		char[] strArr2 = str2.toCharArray();
		int counter = 0;
		for(int i = 0; i < strArr1.length; i++) {
			if(strArr1[i] != strArr2[i]) counter++;
		}
		if(counter == 1) return true;
		else return false;
	}
}
