package main;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.*;

import generated.NoSQLLexer;
import generated.NoSQLParser;



public class Main {

	public static void main(String[] args) {
		CharStream input = null;
		try {
			input = new ANTLRFileStream(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NoSQLLexer lexer = new NoSQLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
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
    		str_return += map.get("GROUP BY");
    	printToFile(str_return+";");
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
