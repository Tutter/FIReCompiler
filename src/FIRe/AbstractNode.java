package FIRe;




import java.beans.Expression;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//begin enums
enum Color{
    red,
    blue,
    yellow,
    green,
    black,
    white
}
//end enums - begin abstract classes

abstract class AbstractNode
{
    //Should contain management functions.
    public void connectSibling()
    {

    }
    public void adoptChildren()
    {

    }

    /*Each class needs this in order to accept a
    * visit from a visitor. Then each nodes has to call
    * its childrens accept-methods.*/
    public abstract void accept(ASTVisitor v);

    public ArrayList<AbstractNode> childList = new ArrayList<>();

    @Override
    public String toString() {
        return Type.class.toString();
    }

    public void Print(){
        System.out.print(this);
        for (AbstractNode AN : this.childList) {
            AN.Print();
        }
    }

}

abstract class ExpressionNode extends AbstractNode
{

}

abstract class StatementNode extends  AbstractNode{

}

abstract class DeclarationNode extends AbstractNode{

}

abstract class ControlStructureNode extends AbstractNode{
    public boolean Incremental;
}

abstract class InfixExpressionNode extends ExpressionNode{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;
}

//End abstract classes - begin control structures

class IfControlStructureNode extends ControlStructureNode{
    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for (AbstractNode child:childList) {
            if(child != null)
                child.accept(v);
        }
    }
}

class WhileNode extends ControlStructureNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for(AbstractNode node : childList)
            node.accept(v);
    }
}

class ForNode extends  ControlStructureNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for(AbstractNode child : childList)
        {
            if(child != null)
                child.accept(v);
        }
    }
}

class RoutineNode extends ControlStructureNode{
    String val;

    public RoutineNode(String val, AbstractNode routineBlock){
        this.val = val;
        childList.add(routineBlock);
    }

    public RoutineNode(AbstractNode id, AbstractNode routineBlock){
        childList.add(id);
        childList.add(routineBlock);
    }

    public RoutineNode(AbstractNode routineBlock){
        val = null;
        childList.add(routineBlock);
    }

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for(AbstractNode node : childList)
            node.accept(v);
    }
}

//End control-structures - begin RobotProperties

class RobotDclBodyNode extends  AbstractNode{
    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for (AbstractNode child: childList)
        {
            child.accept(v);
        }
    }
}

class GunColorNode extends AbstractNode{
    public ColorValNode Color;

    @Override
    public void accept(ASTVisitor v) {
        //bruges ikke
    }
}

class BodyColorNode extends AbstractNode{
    public ColorValNode Color;

    @Override
    public void accept(ASTVisitor v) {
        //bruges ikke
    }
}

class RadarColorNode extends AbstractNode{
    public ColorValNode Color;

    @Override
    public void accept(ASTVisitor v) {
        //bruges ikke
    }
}

//end RobotProperties - begin Types

class ValNode extends ExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        //Denne burde ikke blive benyttet
    }
}

class ArrayAccessNode extends ExpressionNode{
    public ExpressionNode id;
    public ExpressionNode index;

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        id.accept(v);
        index.accept(v);
    }
}

class TextNode extends ValNode{
    public String Content;

    public TextNode(){}
    public TextNode(String content){
        Content = content;
    }

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
    }
}

class ColorValNode extends AbstractNode{
    public Color Color;

    @Override
    public void accept(ASTVisitor v) {
        //bruges ikke
    }
}

class NumberNode extends ValNode{
    public double value;
    public NumberNode(){}
    public NumberNode(double value){
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
    }
}

class BoolNode extends ExpressionNode{
    public boolean value;

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
    }
}

//end types - begin expressions

class AdditionNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
}

class SubtractionNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
}

class MultiplicationNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
}

class DivisionNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
}

class PowerNode extends InfixExpressionNode{
    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
    /* ex 3^4 */
}

class NegateNode extends ExpressionNode{
    @Override
    public void accept(ASTVisitor v) {
        //Tror ikke denne bliver benyttet
    }
    // ex -34;
}

class NotNode extends ExpressionNode{
    public ExpressionNode Expression;

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.Expression.accept(v);
    }
}

class AndNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
}

class OrNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
}

class ModuloNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
}

class GreaterThanNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
}

class LessThanNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
}

class GEQNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
}

class LEQNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
}

class EqualsNode extends InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
}

class NotEqualsNode extends  InfixExpressionNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        this.LeftChild.accept(v);
        this.RightChild.accept(v);
    }
}

class IdNode extends ExpressionNode{
    public String name;
    public String type;


    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
    }
}

//end expressions - begin Statements

class AssignNode extends StatementNode{
    public IdNode Id;
    public ExpressionNode Expression;

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for (AbstractNode child: childList) {
            if(child != null)
                child.accept(v);
        }
    }
}

class FuncCallNode extends ExpressionNode{
    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for(AbstractNode node : childList)
            node.accept(v);
    }
}

class ActualParameterNode extends AbstractNode{
    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for(AbstractNode child : childList)
        {
            if(child != null)
                child.accept(v);
        }
    }
}

class ReturnNode extends StatementNode{
    AbstractNode expr;

    public ReturnNode(AbstractNode node){
        expr = node;
    }
    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        if(expr != null)
            expr.accept(v);
    }
}

//end statements begin declarations

class NumberDeclarationNode extends DeclarationNode{
    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for (AbstractNode node : this.childList) {
            if(node != null)
                node.accept(v);
        }
    } //Jeg ved ikke om vi skal lave typechecking endnu

}

class TextDeclarationNode extends DeclarationNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for (AbstractNode node : this.childList) {
            if(node != null)
                node.accept(v);
        }
    }
}

class BooleanDeclarationNode extends DeclarationNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for (AbstractNode node : this.childList) {
            if(node != null)
                node.accept(v);
        }
    }
}

//end declarations - begin Scope nodes

class WhenNode extends AbstractNode{
    public WhenNode(AbstractNode one, AbstractNode two){
        childList.add(one);
        childList.add(two);
    }

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for(AbstractNode node : childList)
            node.accept(v);
    }
}

class ConditionDeclarationNode extends AbstractNode{
    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);

        for(AbstractNode node : childList)
            node.accept(v);
    }
}

class BlockNode extends AbstractNode{

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for(AbstractNode node : this.childList)
            if(node != null)
                node.accept(v);
    }
}

class FunctionDeclarationNode extends AbstractNode{
    String type;

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for(AbstractNode node : childList)
            if(node != null)
                node.accept(v);
    }
}

class FormalParameterNode extends AbstractNode{
    Map<AbstractNode, String> parameterMap = new HashMap<AbstractNode, String>();

    @Override
    public void accept(ASTVisitor v) {
        //Hvor man inde i denne visit metode så printer elementerne i mappen.
        v.visit(this);

    }
}

class StrategyDeclarationNode extends AbstractNode{
    public IdNode id;

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for(AbstractNode node : this.childList)
            if(node != null)
                node.accept(v);
    }
    //public List<AbstractNode> childList = new ArrayList<>();
}

class ProgNode extends AbstractNode{
    public ArrayList<AbstractNode> _abstractNodesList = new ArrayList<>();

    @Override
    public void accept(ASTVisitor v) {
        v.visit(this);
        for(AbstractNode child : childList)
            if(child != null)
                child.accept(v);
    }
}