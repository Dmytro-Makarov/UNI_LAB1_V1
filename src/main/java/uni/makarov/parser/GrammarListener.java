// Generated from D:/JB/IDEA/UNI_LAB1_V1/src/main/antlr4/uni/makarov/parser\Grammar.g4 by ANTLR 4.9.2
package uni.makarov.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(GrammarParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(GrammarParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(GrammarParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(GrammarParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumericExpr(GrammarParser.NumericExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumericExpr(GrammarParser.NumericExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpExpr(GrammarParser.ExpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpExpr(GrammarParser.ExpExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cellIDExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCellIDExpr(GrammarParser.CellIDExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cellIDExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCellIDExpr(GrammarParser.CellIDExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExpr(GrammarParser.ParenthesisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExpr(GrammarParser.ParenthesisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(GrammarParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(GrammarParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSumExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSumExpr(GrammarParser.AddSumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSumExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSumExpr(GrammarParser.AddSumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpr(GrammarParser.FunctionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpr(GrammarParser.FunctionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modDivExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterModDivExpr(GrammarParser.ModDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modDivExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitModDivExpr(GrammarParser.ModDivExprContext ctx);
}