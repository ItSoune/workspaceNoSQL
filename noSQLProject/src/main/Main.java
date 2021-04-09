package main;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.antlr.v4.runtime.*;

import error.ParenthesisIssue;
import generated.NoSQLLexer;
import generated.NoSQLParser;
import utils.Equivalence;



public class Main {
	public static void main(String[] args) throws ParenthesisIssue {
		CharStream input = null;
		try {
			input = new ANTLRFileStream(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NoSQLLexer lexer = new NoSQLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		testParenthesis(tokens.getText(null, null));
		NoSQLParser parser = new NoSQLParser(tokens);
    	NoSQLParcoursArbreListener nspal = new NoSQLParcoursArbreListener();
    	parser.addParseListener(nspal);
    	parser.start();
    	
    	Map<String, String>map = nspal.getInstructions();
    	Set<String> s = map.keySet();
    	String str_return = new String();
    	if (s.contains("SELECT"))
    		str_return += map.get("SELECT") + "\n";
    	if (s.contains("FROM"))
    		str_return += map.get("FROM") + "\n";
    	if (s.contains("WHERE"))
    		str_return += map.get("WHERE") + "\n";
    	if (s.contains("GROUP BY"))
    		str_return += map.get("GROUP BY") + "\n";
    	if (s.contains("ORDER BY"))
    		str_return += map.get("ORDER BY") + "\n";
    	printToFile(str_return.substring(0, str_return.length()-1)+";");
	}
	
	public static Boolean testParenthesis(String parseParenthesis) throws ParenthesisIssue {
        Stack<Integer> pile = new Stack<Integer>();
        System.out.println(parseParenthesis);
        char c;
        for (int i = 0; i < parseParenthesis.length(); i++){
            c = parseParenthesis.charAt(i);
            if (c == '(')
            	pile.push(i);
            //Process char
            else if(c == ')')
            	if (pile.isEmpty())
            		pile.pop();
            	else {
					throw new ParenthesisIssue("Parenthèse fermée et pas ouverte ; caractère numero: "+String.valueOf(i));
				}
        }
        if (!pile.isEmpty())
        	throw new ParenthesisIssue("Parenthèse ouverte et pas fermée ; caractère numero: "+String.valueOf(pile.pop()));
        return true;
	}
	
	private static void printToFile(String s) {
    	File file = null;
    	try {
			file = new File("results.sql");
	        if (file.createNewFile()) {
	          System.out.println("File created: " + file.getName());
	        } 
	        else {
	          System.out.println("File already exists.");
	        }
	        FileWriter myWriter = new FileWriter(file);
	        myWriter.write(s);
	        myWriter.close();
	        System.out.println("Successfully wrote to the file.");
    	} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
}
