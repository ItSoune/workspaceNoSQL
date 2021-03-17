package main;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.stringtemplate.v4.compiler.Bytecode.Instruction;

import generated.NoSQLBaseListener;
import generated.NoSQLParser;

public class NoSQLParcoursArbreListener extends NoSQLBaseListener {

    Queue<String> sqlFragements = new ArrayDeque<>();
    //Map<String, Variable> variables = new HashMap<>();

    public Queue<String> getInstructionsQueue() {
        return sqlFragements;
    }


	public void enterListit (NoSQLParser.ListitContext ctx) {
		System.out.println(ctx.iteration(0));
	}
}
