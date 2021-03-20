// Generated from NoSQL.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NoSQLParser}.
 */
public interface NoSQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#listit}.
	 * @param ctx the parse tree
	 */
	void enterListit(@NotNull NoSQLParser.ListitContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#listit}.
	 * @param ctx the parse tree
	 */
	void exitListit(@NotNull NoSQLParser.ListitContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull NoSQLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull NoSQLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(@NotNull NoSQLParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(@NotNull NoSQLParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#listexcl}.
	 * @param ctx the parse tree
	 */
	void enterListexcl(@NotNull NoSQLParser.ListexclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#listexcl}.
	 * @param ctx the parse tree
	 */
	void exitListexcl(@NotNull NoSQLParser.ListexclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull NoSQLParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull NoSQLParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#exclusion}.
	 * @param ctx the parse tree
	 */
	void enterExclusion(@NotNull NoSQLParser.ExclusionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#exclusion}.
	 * @param ctx the parse tree
	 */
	void exitExclusion(@NotNull NoSQLParser.ExclusionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#logical}.
	 * @param ctx the parse tree
	 */
	void enterLogical(@NotNull NoSQLParser.LogicalContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#logical}.
	 * @param ctx the parse tree
	 */
	void exitLogical(@NotNull NoSQLParser.LogicalContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(@NotNull NoSQLParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(@NotNull NoSQLParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutput(@NotNull NoSQLParser.OutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutput(@NotNull NoSQLParser.OutputContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull NoSQLParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull NoSQLParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#listattr}.
	 * @param ctx the parse tree
	 */
	void enterListattr(@NotNull NoSQLParser.ListattrContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#listattr}.
	 * @param ctx the parse tree
	 */
	void exitListattr(@NotNull NoSQLParser.ListattrContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(@NotNull NoSQLParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(@NotNull NoSQLParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#comparaison}.
	 * @param ctx the parse tree
	 */
	void enterComparaison(@NotNull NoSQLParser.ComparaisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#comparaison}.
	 * @param ctx the parse tree
	 */
	void exitComparaison(@NotNull NoSQLParser.ComparaisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull NoSQLParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull NoSQLParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#iteration}.
	 * @param ctx the parse tree
	 */
	void enterIteration(@NotNull NoSQLParser.IterationContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#iteration}.
	 * @param ctx the parse tree
	 */
	void exitIteration(@NotNull NoSQLParser.IterationContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull NoSQLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull NoSQLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(@NotNull NoSQLParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(@NotNull NoSQLParser.AttributeContext ctx);
}