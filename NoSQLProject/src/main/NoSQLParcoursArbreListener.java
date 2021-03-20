package main;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.antlr.v4.runtime.misc.NotNull;
import org.stringtemplate.v4.compiler.Bytecode.Instruction;

import generated.NoSQLBaseListener;
import generated.NoSQLParser;
import generated.NoSQLParser.IterationContext;

public class NoSQLParcoursArbreListener extends NoSQLBaseListener {

    ArrayList<String> sqlFragements = new ArrayList<String>();
    //Map<String, Variable> variables = new HashMap<>();

    public ArrayList<String> getInstructionsQueue() {
        return sqlFragements;
    }
	public void enterExpression(NoSQLParser.ExpressionContext ctx) {
		System.out.println("Start processing expression");
	}

	public void enterListit (NoSQLParser.ListitContext ctx) {
		System.out.println(ctx.iteration(0));
	}
	
	@Override 
	public void exitListit(@NotNull NoSQLParser.ListitContext ctx) {
		ctx.iteration(0).hashCode();
		System.out.println(ctx.iteration(0));
		System.out.println(ctx.iteration(1).getStart());
		System.out.println(ctx.iteration(1).getStop());
		System.out.println(ctx.iteration(1).getRuleIndex());
		System.out.println(ctx.iteration(1).depth());
		String str = new String("FROM");
		
		int i = 0;
		while (ctx.iteration(i) != null) {
			IterationContext itCtx = ctx.iteration(i);
			str += " "+itCtx.getChild(3).getText()+" " + itCtx.getChild(1).getText()+",";
			i++;
		}
		str = str.substring(0, str.length()-1);
		System.out.println(str);
		
		sqlFragements.add(str);
	}
	
}
