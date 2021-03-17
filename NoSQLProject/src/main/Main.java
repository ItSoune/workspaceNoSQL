package main;

import java.io.IOException;

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
	}

}
