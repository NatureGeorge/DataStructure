package lessons;

public class SubString{
	
	private String text;
	private int text_len;
	
	public SubString(String text) {
		setText(text);
	}
	
	public SubString() {
	}
	
	public void setText(String text) {
		this.text = text;
		this.text_len = text.length();
	}
	
	public int[] getNextVal(String str) {
        int n = str.length();
        int[] pi = new int[n];
        pi[0] = 0;
        int q = 0;
        for (int i = 1; i < n; i++) {
            while (q > 0 && str.charAt(q) != str.charAt(i)) {
                q = pi[q - 1];
            }

            if (str.charAt(q) == str.charAt(i)) {
                q++;
            }

            pi[i] = q;

        }
        return pi;
    }
	
	public int[] KMP(String needle) {
		int needle_len = needle.length();
		int[] pi = getNextVal(needle);
		int q = 0;
		int[] result = new int[(int)(text_len/needle.length())];
		int count = 0;
		
        for (int i = 0; i < text_len; i++) {
            while (q > 0 && text.charAt(i) != needle.charAt(q)) {
                q = pi[q - 1];
            }

            if (text.charAt(i) == needle.charAt(q)) {
                q++;
            }

            if (q == needle_len) {
            	result[count] = i + 1 - needle_len;
            	count += 1;
            	q = pi[q - 1];
            }
        }
        
        if (count == 0) {
        	result = new int[1];
        	result[0] = -1;
        	return result;
        }else {
        	return result;
        }
	}
	
	public static void main(String[] args) {
		SubString a = new SubString("CAACCGGAA");
		int[] result = a.KMP("AA");
		
		for (int i=0; i<result.length; i++) {
			if (i > 0 && result[i]==0) {
				break;
			}
			System.out.println("SubString starts: " + (result[i]));
		}
	}
}