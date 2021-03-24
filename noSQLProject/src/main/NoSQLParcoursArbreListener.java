package main;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;

import generated.NoSQLBaseListener;
import generated.NoSQLParser;
import generated.NoSQLParser.*;
import utils.Equivalence;


public class NoSQLParcoursArbreListener extends NoSQLBaseListener {

    Map<String, String> sqlFragements = new HashMap<String, String>();

    public Map<String, String> getInstructions() {
        return sqlFragements;
    }
    
	public void enterExpression(ExpressionContext ctx) {
		//System.out.println("Start processing expression");
	}

	public void enterListit (ListitContext ctx) {
		//System.out.println("Entering ListIt");
	}
	
	@Override 
	public void exitListit(@NotNull ListitContext ctx) {
		

		String str = new String("FROM");
		
		int i = 0;
		while (ctx.iteration(i) != null) {
			IterationContext itCtx = ctx.iteration(i);
			str += " "+itCtx.getChild(3).getText()+" "+itCtx.getChild(1).getText()+",";
			i++;
		}
		str = str.substring(0, str.length()-1);
		System.out.println(str);
		
		sqlFragements.put("FROM", str);
		//System.out.println("Exiting ListIt");
	}
	
	@Override 
	public void enterIteration(@NotNull IterationContext ctx) {
		//System.out.println("Entering Iter");
		//System.out.println(ctx.hashCode());
		
	}
	
	@Override 
	public void exitIteration(@NotNull IterationContext ctx) {
		
		//System.out.println(ctx.hashCode());
		//System.out.println("Exiting Iter");
	}
	
	@Override 
	public void enterVariable(@NotNull VariableContext ctx) {
		//System.out.println("Entering Var");
	}
	
	@Override 
	public void exitVariable(@NotNull VariableContext ctx) {
		//System.out.println(ctx.SQL_WORD());
		//System.out.println("Exiting Var");
	}
	
	@Override 
	public void enterRelation(@NotNull RelationContext ctx) {
		//System.out.println("Entering Rel");
		
	}
	
	@Override 
	public void exitRelation(@NotNull RelationContext ctx) {
		//System.out.println(ctx.SQL_WORD());
		//System.out.println("Exiting Rel");
	}
	
	@Override 
    public void enterSelection(@NotNull SelectionContext ctx) {

    }

	@Override 
    public void exitSelection(@NotNull SelectionContext ctx) {

        //System.out.println("coucou " + ctx.SELECT_IF().getParent().getChild(1).getText());
        //System.out.println("hellooo" );


        String colonne = new String();
        String operator = new String();
        String data = new String();
        String resultat = new String(); // requête traduite en sql


        ComparaisonContext comparaison  = ctx.condition().logicaland(0).logical(0).comparaison(); // on avance dans l'arbre


/*    
        
        colonne += comparaison.column_identifier(0).column().SQL_WORD();
        //String col1 = comparaison.column_identifier(0).table_identifier().getText();
        //String col2 = comparaison.column_identifier(0).column().getText();
        //colonne = col1 + "." + col2;
        
        if (comparaison.column_identifier(0).table_identifier() == null)
        	System.out.println("--------------" + comparaison.column_identifier(0).table_identifier());
        	//System.out.println("---------------------------huefgfu");
        	//System.out.println("--------------" + comparaison.column_identifier(0).table_identifier());
        
        operator += Equivalence.operator(comparaison.OPERATOR().getText());

        data += comparaison.data().STRING();
        data = "'" + data.substring(1, data.length()-1) + "'"; // pour enlever les guillemets et mettre des apostrophes
        System.out.println(data);

        resultat = "WHERE" +" "+ colonne +" "+ operator +" "+ data;

        System.out.println("---resultat--- "+resultat);
        
    }*/
	}
	@Override public void exitGroup(@NotNull NoSQLParser.GroupContext ctx) {
		String str = new String("GROUP BY");
		System.out.println("************************************");

		for(Column_identifierContext ctxColid : ctx.listattr().column_identifier()) {
			str += " ";
			if (ctxColid.table_identifier() == null) {
				//str += ctxColid.column().SQL_WORD()+".*";
				str +=ctxColid.column().getText()+".*";
			}
			else {
				//str += ctxColid.column().SQL_WORD()+"."+ctxColid.table_identifier().getText();
				str +=ctxColid.table_identifier().getText()+"."+ctxColid.column().getText();

			}
			str += ",";
		}
		str = str.substring(0, str.length()-1);

		
		sqlFragements.put("GROUP BY", str);
		
	}
	
	@Override public void enterOutput(@NotNull OutputContext ctx) {
		//System.out.println("Entering output");
	}

	@Override 
	public void exitOutput(@NotNull OutputContext ctx) { 
		String str = new String("SELECT");
		if (ctx.DISTINCT() != null) {
			str += " DISTINCT";
		}
		if (ctx.variable() == null) {
			for(Column_identifierContext ctxColid : ctx.listattr().column_identifier()) {
				str += " ";
				if (ctxColid.table_identifier() == null) {
					str += ctxColid.column().SQL_WORD()+".*";
				}
				else {
					str += ctxColid.table_identifier().getChild(0).getText()+"."+ctxColid.column().SQL_WORD();
				}
				str += ",";
			}
			str = str.substring(0, str.length()-1);
		}
		
		else {
			str += " "+ctx.variable().getText() + ".*";
		}
		
		sqlFragements.put("SELECT", str);
		//System.out.println("Exiting output");
	}
	/*
	@Override
	public void exitOrder(@NotNull OrderContext ctx) {
		String str = new String("ORDER BY");
		
		for(NoSQLParser.ColumnContext ctxCol : ctx.column()) {
			str += " ";
			if (ctxCol.INT() == null) {
				str += ctxCol.variable().SQL_WORD()+"."+ctxCol.SQL_WORD();
			}
			else {
				str +=ctxCol.INT();
			}
			str +=",";
		}
		str = str.substring(0, str.length()-1);
		sqlFragements.put("ORDER BY", str);
		

	}*/

	
}
