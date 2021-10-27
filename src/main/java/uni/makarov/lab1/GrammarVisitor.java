package uni.makarov.lab1;

import javafx.scene.control.cell.MapValueFactory;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.misc.Interval;
import uni.makarov.parser.GrammarBaseVisitor;
import uni.makarov.parser.GrammarLexer;
import uni.makarov.parser.GrammarParser;

import java.nio.file.LinkPermission;
import java.util.Map;

public class GrammarVisitor extends GrammarBaseVisitor {

    //TODO
    @Override
    public Object visitParse(GrammarParser.ParseContext ctx) {
        return super.visitParse(ctx);
    }

    @Override
    public String visitString(GrammarParser.StringContext ctx) {
        String string;
        CharStream input = ctx.start.getInputStream();
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        string = input.getText(interval);
        System.out.println(string);
        System.out.println(ctx.WORD().toString());
        return string;
    }

    @Override
    public Integer visitNumericExpr(GrammarParser.NumericExprContext ctx) {
        return Integer.parseInt(ctx.NUMBER().toString());
    }

    @Override
    public Integer visitExpExpr(GrammarParser.ExpExprContext ctx) {
        int left =  Integer.parseInt(super.visit(ctx.number(0)).toString());
        int right = Integer.parseInt(super.visit(ctx.number(1)).toString());
        return (int) Math.pow(left, right);
    }

    @Override
    public Object visitParenthesisExpr(GrammarParser.ParenthesisExprContext ctx) {
        return visit(ctx.number());
    }

    @Override
    public Integer visitMulDivExpr(GrammarParser.MulDivExprContext ctx) {
        int left =  Integer.parseInt(super.visit(ctx.number(0)).toString());
        int right = Integer.parseInt(super.visit(ctx.number(1)).toString());
        if (ctx.operatorToker.getType() == GrammarLexer.MULTIPLY)
            return left*right;
        else return  left/right;
    }

    @Override
    public Integer visitAddSumExpr(GrammarParser.AddSumExprContext ctx) {
        int left =  Integer.parseInt(super.visit(ctx.number(0)).toString());
        int right = Integer.parseInt(super.visit(ctx.number(1)).toString());
        if (ctx.operatorToker.getType() == GrammarLexer.ADD)
            return left+right;
        else return left-right;
    }

    @Override
    public Object visitFunctionExpr(GrammarParser.FunctionExprContext ctx) {
        return super.visitFunctionExpr(ctx);
    }

    @Override
    public Integer visitModDivExpr(GrammarParser.ModDivExprContext ctx) {
        int left =  Integer.parseInt(super.visit(ctx.number(0)).toString());
        int right = Integer.parseInt(super.visit(ctx.number(1)).toString());
        if (ctx.operatorToker.getType() == GrammarLexer.MOD)
            return Math.floorMod(left, right);
        else return Math.floorDiv(left, right);
    }

    @Override
    public Object visitFunctionCellExpr(GrammarParser.FunctionCellExprContext ctx) {
        return super.visitFunctionCellExpr(ctx);
    }

    @Override
    public Object visitCellIDExpr(GrammarParser.CellIDExprContext ctx) {
        CellID cellID = new CellID(ctx.ID().getText());
        Object result = ApplicationModel.getCellValue(cellID.row, cellID.column, true);
        try {
            result = Integer.parseInt((String) result);
        } catch (NumberFormatException e) {
            return "A cell is not numeric!";
        }
        return result;
    }

    @Override
    public Object visitAddSumCellExpr(GrammarParser.AddSumCellExprContext ctx) {
        Object left = super.visit(ctx.id(0)).toString();
        Object right = super.visit(ctx.id(1)).toString();
        try {
            left = Integer.parseInt((String) left);
            right = Integer.parseInt((String) right);
        } catch (NumberFormatException e) {
            return "A cell is not numeric!";
        }

        if (ctx.operatorToker.getType() == GrammarLexer.ADD)
            return (Integer) left + (Integer) right;
        else return (Integer) left - (Integer) right;
    }

    @Override
    public Object visitModDivCellExpr(GrammarParser.ModDivCellExprContext ctx) {
        Object left = super.visit(ctx.id(0)).toString();
        Object right = super.visit(ctx.id(1)).toString();
        try {
            left = Integer.parseInt((String) left);
            right = Integer.parseInt((String) right);
        } catch (NumberFormatException e) {
            return "A cell is not numeric!";
        }

        if (ctx.operatorToker.getType() == GrammarLexer.MOD)
            return Math.floorMod((Integer) left, (Integer) right);
        else return Math.floorDiv((Integer) left, (Integer) right);
    }

    @Override
    public Object visitParenthesisCellExpr(GrammarParser.ParenthesisCellExprContext ctx) {
        return visit(ctx.id());
    }

    @Override
    public Object visitMulDivCellExpr(GrammarParser.MulDivCellExprContext ctx) {
        Object left = super.visit(ctx.id(0)).toString();
        Object right = super.visit(ctx.id(1)).toString();
        try {
            left = Integer.parseInt((String) left);
            right = Integer.parseInt((String) right);
        } catch (NumberFormatException e) {
            return "A cell is not numeric!";
        }

        if (ctx.operatorToker.getType() == GrammarLexer.MULTIPLY)
            return (Integer) left * (Integer) right;
        else return  (Integer) left/ (Integer) right;
    }

    @Override
    public Object visitExpCellExpr(GrammarParser.ExpCellExprContext ctx) {
        Object left = super.visit(ctx.id(0)).toString();
        Object right = super.visit(ctx.id(1)).toString();
        try {
            left = Integer.parseInt((String) left);
            right = Integer.parseInt((String) right);
        } catch (NumberFormatException e) {
            return "A cell is not numeric!";
        }

        return (int) Math.pow((Integer) left,(Integer)  right);
    }

}
