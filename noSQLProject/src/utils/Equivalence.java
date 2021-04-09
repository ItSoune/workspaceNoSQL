package utils;

public class Equivalence {
	
	public static String operator (String operator) {
		switch (operator) {
        case "==":    return "=";
        case "!=":    return "<>";
        
        default : return operator; 
                 
        
		}
	}
	/*
	 * enleve les guillemets d'une data pour les remplacer par des apostrophes
	 */
	public static String changeDoubleQuote (String data) {
		data = "'"+data.substring(1, data.length()-1)+"'";
		return data;
	}
	
	/*
	 * inverse le sens de l'OPERATOR
	 */
	public static String inverseOperator (String operator) {
		switch (operator) {
        case "<":    return ">";
        case ">":    return "<";
        case "<=":    return ">=";
        case ">=":    return "<=";
        
        default : return operator; 
		}
	}
	
	public static String appendRight (String str, int length, char c) {
		length -= str.length();
		System.out.println(length);
		for(int i = 0; i<length; i++) {
			str = c + str;
		}
		return str;
	}

}
