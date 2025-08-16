// Generated from ./Mussumes.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MussumesParser}.
 */
public interface MussumesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MussumesParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MussumesParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MussumesParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(MussumesParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(MussumesParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(MussumesParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(MussumesParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(MussumesParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(MussumesParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(MussumesParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(MussumesParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(MussumesParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(MussumesParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MussumesParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MussumesParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(MussumesParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(MussumesParser.TermoContext ctx);
}