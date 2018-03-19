package FIRe;




import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public void traverseAST()
    {

    }

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
}

class WhileNode extends ControlStructureNode{

}

class ForNode extends  ControlStructureNode{
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
}

//End control-structures - begin RobotProperties

class RobotDclBodyNode extends  AbstractNode{
}

class GunColorNode extends AbstractNode{
    public ColorValNode Color;
}

class BodyColorNode extends AbstractNode{
    public ColorValNode Color;
}

class RadarColorNode extends AbstractNode{
    public ColorValNode Color;
}

//end RobotProperties - begin Types

class ValNode extends ExpressionNode{

}

class ArrayAccessNode extends ExpressionNode{
    ExpressionNode id;
    ExpressionNode index;
}

class TextNode extends ValNode{
    public String Content;

    public TextNode(){}
    public TextNode(String content){
        Content = content;
    }
}

class ColorValNode extends AbstractNode{
    public Color Color;
}

class NumberNode extends ValNode{
    public double value;
    public NumberNode(){}
    public NumberNode(double value){
        this.value = value;
    }
}

class BoolNode extends ExpressionNode{
    public boolean value;
}

//end types - begin expressions

class AdditionNode extends InfixExpressionNode{

}

class SubtractionNode extends InfixExpressionNode{

}

class MultiplicationNode extends InfixExpressionNode{

}

class DivisionNode extends InfixExpressionNode{

}

class PowerNode extends InfixExpressionNode{
    /* ex 3^4 */
}

class NegateNode extends ExpressionNode{
    // ex -34;
}

class NotNode extends ExpressionNode{
    public ExpressionNode Expression;
}

class AndNode extends InfixExpressionNode{

}

class OrNode extends InfixExpressionNode{

}

class ModuloNode extends InfixExpressionNode{

}

class GreaterThanNode extends InfixExpressionNode{

}

class LessThanNode extends InfixExpressionNode{

}

class GEQNode extends InfixExpressionNode{

}

class LEQNode extends InfixExpressionNode{

}

class EqualsNode extends InfixExpressionNode{

}

class NotEqualsNode extends  InfixExpressionNode{

}

class IdNode extends ExpressionNode{
    public String name;



}

//end expressions - begin Statements

class AssignNode extends StatementNode{
    public IdNode Id;
    public ExpressionNode Expression;
}

class FuncCallNode extends StatementNode{
}

class ActualParameterNode extends AbstractNode{
}

class ReturnNode extends StatementNode{
}

//end statements begin declarations

class NumberDeclarationNode extends DeclarationNode{ //Jeg ved ikke om vi skal lave typechecking endnu

}

class TextDeclarationNode extends DeclarationNode{

}

class BooleanDeclarationNode extends DeclarationNode{

}

//end declarations - begin Scope nodes

class WhenNode extends AbstractNode{
    public WhenNode(AbstractNode one, AbstractNode two){
        childList.add(one);
        childList.add(two);
    }
}

class ConditionDeclarationNode extends AbstractNode{
}

class BlockNode extends AbstractNode{

}

class FunctionDeclarationNode extends AbstractNode{
    String type;
}

class FormalParameterNode extends AbstractNode{
    Map<AbstractNode, String> parameterMap = new HashMap<AbstractNode, String>();
}

class StrategyDeclarationNode extends AbstractNode{
    public IdNode id;
    //public List<AbstractNode> childList = new ArrayList<>();
}

class ProgNode extends AbstractNode{
    public ArrayList<AbstractNode> _abstractNodesList = new ArrayList<>();
}