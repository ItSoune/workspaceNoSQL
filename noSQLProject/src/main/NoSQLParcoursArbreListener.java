package main;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;

import generated.NoSQLBaseListener;
import generated.NoSQLParser;
import generated.NoSQLParser.ComparaisonContext;
import generated.NoSQLParser.IterationContext;

public class NoSQLParcoursArbreListener extends NoSQLBaseListener {

    Map<String, String> sqlFragements = new HashMap<String, String>();

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
	
	@Override 
    public void enterSelection(@NotNull NoSQLParser.SelectionContext ctx) {

    }

	@Override 
    public void exitSelection(@NotNull NoSQLParser.SelectionContext ctx) {

        //System.out.println("coucou " + ctx.SELECT_IF().getParent().getChild(1).getText());
        //System.out.println("hellooo" );


        String colonne = new String();
        String operator = new String();
        String data = new String();
        String resultat = new String(); // requête traduite en sql


        ComparaisonContext comparaison  = ctx.condition().logicaland(0).logical(0).comparaison(); // on avance dans l'arbre


        System.out.println("------------------" + comparaison.attribute(2));
        if(comparaison.data()!=null) {
            System.out.println("yoyo");
        }
        else {
            System.out.println(comparaison.attribute());
        }
        /*
        colonne += comparaison.attribute().get(0).SQL_WORD();

        operator += comparaison.OPERATOR();

        data += comparaison.data().STRING();
        data = "'" + data.substring(1, data.length()-1) + "'"; // pour enlever les guillemets et mettre des apostrophes
        System.out.println(data);

        resultat = "WHERE" +" "+ colonne +" "+ operator +" "+ data;

        System.out.println("---resultat--- "+resultat);
        */
    }
	
	@Override public void exitGroup(@NotNull NoSQLParser.GroupContext ctx) {
		String str = new String("GROUP BY");
		for(NoSQLParser.AttributeContext ctxAttr : ctx.listattr().attribute()) {
			str += " ";
			if (ctxAttr.variable() == null) {
				str += ctxAttr.SQL_WORD()+".*";
			}
			else {
				str += ctxAttr.variable().SQL_WORD()+"."+ctxAttr.SQL_WORD();
			}
			str += ",";
		}
		str = str.substring(0, str.length()-1);

		
		sqlFragements.put("GROUP BY", str);
	}
	
	@Override public void enterOutput(@NotNull NoSQLParser.OutputContext ctx) {
		System.out.println("Entering output");
		
		
		
	}

	@Override public void exitOutput(@NotNull NoSQLParser.OutputContext ctx) { 
		String str = new String("SELECT");
		
		if (ctx.variable() == null) {
			
			for(NoSQLParser.AttributeContext ctxAttr : ctx.listattr().attribute()) {
				str += " ";
				if (ctxAttr.variable() == null) {
					str += ctxAttr.SQL_WORD()+".*";
				}
				else {
					str += ctxAttr.variable().SQL_WORD()+"."+ctxAttr.SQL_WORD();
				}
				str += ",";
			}
			str = str.substring(0, str.length()-1);
		}
		
		else {
			str += " "+ctx.variable().getText() + ".*";
		}
		
		sqlFragements.put("SELECT", str);
		System.out.println("Exiting output");
	}
	
	@Override
	public void exitOrder(@NotNull NoSQLParser.OrderContext ctx) {
		String str = new String("ORDER BY");
		
		/*if (ctx.list() == null) {
			
			for(NoSQLParser.AttributeContext ctxAttr : ctx.listattr().attribute()) {
				str += " ";
				if (ctxAttr.variable() == null) {
					str += ctxAttr.SQL_WORD()+".*";
				}
				else {
					str += ctxAttr.variable().SQL_WORD()+"."+ctxAttr.SQL_WORD();
				}
				str += ",";
			}
			str = str.substring(0, str.length()-1);
		}
		
		else {
			str += " "+ctx.variable().getText() + ".*";
		}
		
		sqlFragements.put("SELECT", str);*/
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

	}

	
}
