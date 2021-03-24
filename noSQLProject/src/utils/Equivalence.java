package utils;

public class Equivalence {
	
	public static String operator (String operator) {
		switch (operator) {
        case "==":    return "=";
        case "!=":    return "<>";
        
        default : return ""; 
                 
        
		}
	}	

}
