// Generated from ./Mussumes.g4 by ANTLR 4.13.2
package parser;

    import datastructures.Symbol;
    import datastructures.Variable;
    import datastructures.SymbolTable;
    import exceptions.SemanticException;
    import java.util.ArrayList;

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
	 * Enter a parse tree produced by {@link MussumesParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(MussumesParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(MussumesParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(MussumesParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(MussumesParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(MussumesParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(MussumesParser.TipoContext ctx);
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
	 * Enter a parse tree produced by {@link MussumesParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(MussumesParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(MussumesParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#expr_or_bool}.
	 * @param ctx the parse tree
	 */
	void enterExpr_or_bool(MussumesParser.Expr_or_boolContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#expr_or_bool}.
	 * @param ctx the parse tree
	 */
	void exitExpr_or_bool(MussumesParser.Expr_or_boolContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link MussumesParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(MussumesParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(MussumesParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolexpr(MussumesParser.BoolexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolexpr(MussumesParser.BoolexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#booltermo}.
	 * @param ctx the parse tree
	 */
	void enterBooltermo(MussumesParser.BooltermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#booltermo}.
	 * @param ctx the parse tree
	 */
	void exitBooltermo(MussumesParser.BooltermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#boolfator}.
	 * @param ctx the parse tree
	 */
	void enterBoolfator(MussumesParser.BoolfatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#boolfator}.
	 * @param ctx the parse tree
	 */
	void exitBoolfator(MussumesParser.BoolfatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MussumesParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(MussumesParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link MussumesParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(MussumesParser.ComparisonContext ctx);
}