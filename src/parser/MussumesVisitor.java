// Generated from ./Mussumes.g4 by ANTLR 4.13.2
package parser;

    import datastructures.Symbol;
    import datastructures.Variable;
    import datastructures.SymbolTable;
    import exceptions.SemanticException;
    import ast.Program;
    import ast.AbstractCommand;
    import java.util.ArrayList;
    import java.util.Stack;
    import ast.CommandLeitura;
    import ast.CommandEscrita;
    import ast.CommandBloco;
    import ast.CommandDecisao;
    import ast.CommandEnquanto;
    import ast.CommandAtribuicao;
    import org.antlr.v4.runtime.ParserRuleContext;
    import org.antlr.v4.runtime.misc.Interval;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MussumesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MussumesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MussumesParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(MussumesParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(MussumesParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#declaravar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaravar(MussumesParser.DeclaravarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(MussumesParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#bloco}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloco(MussumesParser.BlocoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(MussumesParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#cmdleitura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdleitura(MussumesParser.CmdleituraContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#cmdescrita}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdescrita(MussumesParser.CmdescritaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#cmdattrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdattrib(MussumesParser.CmdattribContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#cmdselecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdselecao(MussumesParser.CmdselecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#cmdrepeticao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdrepeticao(MussumesParser.CmdrepeticaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#cmdfor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdfor(MussumesParser.CmdforContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#expr_or_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_or_bool(MussumesParser.Expr_or_boolContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MussumesParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(MussumesParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(MussumesParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#boolexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolexpr(MussumesParser.BoolexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#booltermo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooltermo(MussumesParser.BooltermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#boolfator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolfator(MussumesParser.BoolfatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MussumesParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(MussumesParser.ComparisonContext ctx);
}