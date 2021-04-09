package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.NoSQLBaseListener;
import generated.NoSQLParser;
import generated.NoSQLParser.*;
import utils.Equivalence;



public class NoSQLParcoursArbreListener extends NoSQLBaseListener {

    Map<String, String> sqlFragements = new HashMap<String, String>();

    public Map<String, String> getInstructions() {
        return sqlFragements;
    }
    
    String date = new String();

    @Override
    public void exitDate(@NotNull DateContext ctx) {
    	date += "TO_DATE('"+Equivalence.appendRight(ctx.INT(0).getText(), 2, '0')+"/"+Equivalence.appendRight(ctx.INT(1).getText(), 2, '0')+"/"+Equivalence.appendRight(ctx.INT(2).getText(), 2, '0')+"', 'DD/MM/YYYY')";
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
		
        
        String arg1 = new String(); // arg1 et arg2 peuvent être une data ou une table_identifier     
        String arg2 = new String();
        String operator = new String();
        String resultat = new String(); // résultat de la requête traduite en sql
        


        resultat = "WHERE";
        for(LogicalandContext logicalandctx : ctx.condition().logicaland()) {
        	
        	for(LogicalContext logicalctx : logicalandctx.logical()) {
        		ComparaisonContext comparaison = logicalctx.comparaison();
		        if (comparaison.data() == null) { // est de forme column_identifier OPERATOR column_identifier
		        	//System.out.println("c o c");
		        	arg1 = comparaison.column_identifier(0).getText();
		        	arg2 = comparaison.column_identifier(1).getText();
		        	operator = Equivalence.operator(comparaison.OPERATOR().getText());
		        	
		        }
		        else if (comparaison.getChild(0) == comparaison.column_identifier(0)) { // est de forme column_identifier OPERATOR data
		        	//System.out.println("c o d");
		        	arg1 = comparaison.column_identifier(0).getText();
		        	if (comparaison.data().date() != null)
		        		arg2 = date;
		        	else if (comparaison.data().STRING() != null)
		        		arg2 = Equivalence.changeDoubleQuote(comparaison.data().STRING().getText());
		        	else 
		        		arg2 = comparaison.data().getText();
		        	operator = Equivalence.operator(comparaison.OPERATOR().getText());
		        }
		        else { // est de forme data OPERATOR column_identifier
		        	//System.out.println("d o c");
		        	arg1 = comparaison.column_identifier(0).getText();
		        	if (comparaison.data().date() != null)
		        		arg2 = date;
		        	else if (comparaison.data().STRING() != null)
		        		arg2 = Equivalence.changeDoubleQuote(comparaison.data().STRING().getText());
		        	else 
		        		arg2 = comparaison.data().getText();
		        	operator = comparaison.OPERATOR().getText();
		        	operator = Equivalence.inverseOperator(Equivalence.operator(operator));
		        }
		        
		        resultat += " "+ arg1 +" "+ operator +" "+ arg2 + " and";
        	}
        	resultat = resultat.substring(0, resultat.length()-4);
        	resultat += " or";
        	
        }
        resultat = resultat.substring(0, resultat.length()-3);
        sqlFragements.put("WHERE", resultat);
        System.out.println(resultat);
	}
	@Override 
	public void exitGroup(@NotNull NoSQLParser.GroupContext ctx) {
		String str = new String("GROUP BY");

		for(Column_identifierContext ctxColid : ctx.listper().column_identifier()) {
			str += " ";
			if (ctxColid.table_identifier() == null) {
				str +=ctxColid.column().getText()+".*";
			}
			else {
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
			for(AggregationContext ctxAggr : ctx.listattr().aggregation()) {
				str += " ";
				if (ctxAggr.AGGREGAT() != null)	{			
					if (ctxAggr.column_identifier().table_identifier() == null)
						str += ctxAggr.AGGREGAT().getText().toUpperCase()+"("+ctxAggr.column_identifier().column().SQL_WORD()+".*"+")";
					else
						str += ctxAggr.AGGREGAT().getText().toUpperCase()+"("+ctxAggr.column_identifier().getText()+")";
				}
				else {
					if (ctxAggr.column_identifier().table_identifier() == null)
						str += ctxAggr.column_identifier().column().SQL_WORD()+".*";
					else 
						str += ctxAggr.column_identifier().getText();
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
	
	@Override
	public void exitOrder(@NotNull OrderContext ctx) {
		String str = new String("ORDER BY");
		
		for(Column_numContext ctxColNum : ctx.listcolumn().column_num()) {
			str += " " + ctxColNum.INT() + ",";
		}
		
		for(AggregationContext ctxAggr : ctx.listcolumn().aggregation()) {
			if (ctxAggr.AGGREGAT() != null) {
				str += " " + ctxAggr.AGGREGAT().getText().toUpperCase()+"("+ctxAggr.column_identifier().getText()+")"+",";
			}
			else 
				str += " " + ctxAggr.column_identifier().getText() + ",";
		}
		str = str.substring(0, str.length()-1);
		sqlFragements.put("ORDER BY", str);
	}	
}
