package main;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;

import generated.NoSQLBaseListener;
import generated.NoSQLParser;
import generated.NoSQLParser.IterationContext;

public class NoSQLParcoursArbreListener extends NoSQLBaseListener {

    Map<String, String> sqlFragements = new HashMap<String, String>();
    //Map<String, Variable> variables = new HashMap<>();

    public Map<String, String> getInstructions() {
        return sqlFragements;
    }
	public void enterExpression(NoSQLParser.ExpressionContext ctx) {
		System.out.println("Start processing expression");
	}

	public void enterListit (NoSQLParser.ListitContext ctx) {
		System.out.println("Entering ListIt");
	}
	
	@Override 
	public void exitListit(@NotNull NoSQLParser.ListitContext ctx) {
		
		/*System.out.println(ctx.iteration(0).hashCode());
		System.out.println(ctx.iteration(0));
		System.out.println(ctx.iteration(1).getStart());
		System.out.println(ctx.iteration(1).getStop());
		System.out.println(ctx.iteration(1).getRuleIndex());
		System.out.println(ctx.iteration(1).depth());*/
		String str = new String("FROM");
		
		int i = 0;
		while (ctx.iteration(i) != null) {
			IterationContext itCtx = ctx.iteration(i);
			str += " "+itCtx.getChild(3).getText()+" " + itCtx.getChild(1).getText()+",";
			i++;
		}
		str = str.substring(0, str.length()-1);
		System.out.println(str);
		
		sqlFragements.put("FROM", str);
		System.out.println("Exiting ListIt");
	}
	
	@Override 
	public void enterIteration(@NotNull NoSQLParser.IterationContext ctx) {
		System.out.println("Entering Iter");
		//System.out.println(ctx.hashCode());
		
	}
	
	@Override 
	public void exitIteration(@NotNull NoSQLParser.IterationContext ctx) {
		
		//System.out.println(ctx.hashCode());
		System.out.println("Exiting Iter");
	}
	
	@Override 
	public void enterVariable(@NotNull NoSQLParser.VariableContext ctx) {
		System.out.println("Entering Var");
		
	}
	
	@Override 
	public void exitVariable(@NotNull NoSQLParser.VariableContext ctx) {
		System.out.println(ctx.SQL_WORD());
		System.out.println("Exiting Var");
	}
	
	@Override 
	public void enterRelation(@NotNull NoSQLParser.RelationContext ctx) {
		System.out.println("Entering Rel");
		
	}
	
	@Override 
	public void exitRelation(@NotNull NoSQLParser.RelationContext ctx) {
		System.out.println(ctx.SQL_WORD());
		System.out.println("Exiting Rel");
	}
	
	@Override public void enterOutput(@NotNull NoSQLParser.OutputContext ctx) {
		
		
		
	}

	@Override public void exitOutput(@NotNull NoSQLParser.OutputContext ctx) { 
		String str = new String("SELECT ");
		
		if (ctx.variable() != null) {
			str += ctx.variable().getText() + " ";
		}
		
		System.out.println(str);
//		System.out.println(ctx.getChild(0));
//		System.out.println(ctx.getChild(1).getText());
//		System.out.println(ctx.variable().getText());
//		System.out.println(ctx.listattr());
		
		sqlFragements.put("SELECT", str);
	}
	
}
