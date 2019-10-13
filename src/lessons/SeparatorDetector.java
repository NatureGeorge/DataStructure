package lessons;

import java.util.HashMap;

public class SeparatorDetector{
	private HashMap<String, String> separatorMap = new HashMap<String, String>() {
	    /**
		 * This is a hashMap that stores the separators.
		 */
		private static final long serialVersionUID = 1L;

		{
	        put("{", "}");  
	        put("[", "]");
	        put("/*", "*/");
	        put("(", ")");
	    }
	};
	
	public String show = "Nothing";
	
	
	public boolean isLegal(String str) throws Exception{
		if (!"".equals(str) && str != null) {
			str += " ";
			LinkStack S = new LinkStack();
			//SqStack S = new SqStack(100);
			int length = str.length();
			for (int i=0; i < length; i++) {
				char c = str.charAt(i);
				String t = String.valueOf(c);
				
				if (i != length) {
					if (('/' == c && '*' == str.charAt(i+1)) || ('*' == c && '/' == str.charAt(i+1))){
						t = t.concat(String.valueOf(str.charAt(i+1)));
						++i;
					}
				}
				
				if (separatorMap.keySet().contains(t)) {
					S.push(t);
					System.out.println(S.display());
				}
				else if (separatorMap.values().contains(t)) {
					show = S.display();
					if (S.isEmpty() || (!separatorMap.get(S.pop().toString()).equals(t))) {
						try {
							return false;
						}catch (Exception e1) {
							return false;
						}
					}
				}
			}
			
			if (!S.isEmpty()) {
				show = S.display();
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}
}