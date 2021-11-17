package uni.makarov.lab1;

import javafx.scene.control.Cell;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.misc.Interval;
import uni.makarov.parser.GrammarBaseVisitor;
import uni.makarov.parser.GrammarLexer;
import uni.makarov.parser.GrammarParser;

public class GrammarVisitor extends GrammarBaseVisitor {

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
        return string;
    }

    @Override
    public Object visitNumericExpr(GrammarParser.NumericExprContext ctx) {
        return (int) Double.parseDouble(ctx.NUMBER().toString());
    }

    @Override
    public Object visitCellIDExpr(GrammarParser.CellIDExprContext ctx) {
        CellID cellID = new CellID(ctx.ID().getText());
        Object result = ApplicationModel.getCellValue(cellID.row, cellID.column, true);
        try {
            result = (int) Double.parseDouble((String) result);
        } catch (NumberFormatException e) {
            return "Cells are not numeric!";
        }
        return result;
    }

    @Override
    public Object visitExpExpr(GrammarParser.ExpExprContext ctx) {
        int left;
        int right;
        try {
            left = (int) Double.parseDouble(super.visit(ctx.expression(0)).toString());
            right = (int) Double.parseDouble(super.visit(ctx.expression(1)).toString());
        } catch (NumberFormatException e) {
            return "Cells are not numeric!";
        }
        return (int) Math.pow(left, right);
    }

    @Override
    public Object visitParenthesisExpr(GrammarParser.ParenthesisExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Object visitMulDivExpr(GrammarParser.MulDivExprContext ctx) {
        int left;
        int right;
        try {
        left = (int) Double.parseDouble(super.visit(ctx.expression(0)).toString());
        right = (int) Double.parseDouble(super.visit(ctx.expression(1)).toString());
        } catch (NumberFormatException e) {
            return "Cells are not numeric!";
        }
        if (ctx.operatorToker.getType() == GrammarLexer.MULTIPLY)
            return left * right;
        else return left / right;
    }

    @Override
    public Object visitAddSumExpr(GrammarParser.AddSumExprContext ctx) {
        int left;
        int right;
        try {
            left = (int) Double.parseDouble(super.visit(ctx.expression(0)).toString());
            right = (int) Double.parseDouble(super.visit(ctx.expression(1)).toString());
        } catch (NumberFormatException e) {
            return "Cells are not numeric!";
        }
        if (ctx.operatorToker.getType() == GrammarLexer.ADD)
            return left + right;
        else return left - right;
    }

    @Override
    public Object visitFunctionExpr(GrammarParser.FunctionExprContext ctx) {
        Integer optimalValue;
        Integer nextValue;

        try {
            optimalValue = (int) Double.parseDouble(super.visit(ctx.expression(0)).toString());
        } catch (NumberFormatException e) {
            return "Cells are not numeric!";
        }

        int i = 1;
        while(true) {
            try {
                nextValue = (int) Double.parseDouble(super.visit(ctx.expression(i)).toString());
                if(ctx.operatorToker.getType() == GrammarLexer.MMAX){
                    optimalValue = Math.max(optimalValue, nextValue);
                } else {
                    optimalValue = Math.min(optimalValue, nextValue);
                }
                i++;
            } catch (NumberFormatException e) {
                return "Cells are not numeric!";
            } catch (NullPointerException e){
                return optimalValue;
            }
        }
    }

    @Override
    public Object visitModDivExpr(GrammarParser.ModDivExprContext ctx) {
        int left;
        int right;
        try {
            left = (int) Double.parseDouble(super.visit(ctx.expression(0)).toString());
            right = (int) Double.parseDouble(super.visit(ctx.expression(1)).toString());
        } catch (NumberFormatException e) {
            return "Cells are not numeric!";
        }
        if (ctx.operatorToker.getType() == GrammarLexer.MOD)
            return Math.floorMod(left, right);
        else return Math.floorDiv(left, right);
    }
}
