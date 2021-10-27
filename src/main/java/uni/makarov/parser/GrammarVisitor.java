// Generated from D:/JB/IDEA/UNI_LAB1_V1/src/main/antlr4/uni/makarov/parser\Grammar.g4 by ANTLR 4.9.1
package uni.makarov.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(GrammarParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(GrammarParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericExpr}
	 * labeled alternative in {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericExpr(GrammarParser.NumericExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expExpr}
	 * labeled alternative in {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpExpr(GrammarParser.ExpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesisExpr}
	 * labeled alternative in {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExpr(GrammarParser.ParenthesisExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(GrammarParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSumExpr}
	 * labeled alternative in {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSumExpr(GrammarParser.AddSumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionExpr}
	 * labeled alternative in {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpr(GrammarParser.FunctionExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modDivExpr}
	 * labeled alternative in {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModDivExpr(GrammarParser.ModDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCellExpr}
	 * labeled alternative in {@link GrammarParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCellExpr(GrammarParser.FunctionCellExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cellIDExpr}
	 * labeled alternative in {@link GrammarParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCellIDExpr(GrammarParser.CellIDExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSumCellExpr}
	 * labeled alternative in {@link GrammarParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSumCellExpr(GrammarParser.AddSumCellExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modDivCellExpr}
	 * labeled alternative in {@link GrammarParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModDivCellExpr(GrammarParser.ModDivCellExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesisCellExpr}
	 * labeled alternative in {@link GrammarParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisCellExpr(GrammarParser.ParenthesisCellExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivCellExpr}
	 * labeled alternative in {@link GrammarParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivCellExpr(GrammarParser.MulDivCellExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expCellExpr}
	 * labeled alternative in {@link GrammarParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpCellExpr(GrammarParser.ExpCellExprContext ctx);
}