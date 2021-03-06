package FIRe.ContextualAnalysis;

import FIRe.ASTVisitor;
import FIRe.Nodes.*;

//The purpose of this visitor is to set the parent for alle node in the AST.
//This is done by calling the accept method of the root in main
//Thereby starting the calls through the AST and each parent sends
//and instance of itself to its children.
public class ParentASTVisitor extends ASTVisitor {

    @Override
    public void visit(AbstractNode node, Object... arg) {
        //If there were sent a instance of a of parent node, assign it as this nodes parent.
        if (arg.length > 0)
            node.Parent = arg[0] != null ? (AbstractNode) arg[0] : null;
    }

    @Override
    public void visit(AdditionNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(ActualParameterNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(AndNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(ArrayAccessNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(AssignNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(BlockNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(BodyColorNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(BooleanDeclarationNode node, Object... arg) {
        visit((AbstractNode)node,arg);

    }

    @Override
    public void visit(BoolArrayDeclarationNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(BoolNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(ColorValNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(ControlStructureNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(DeclarationNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(DivisionNode node, Object... arg)  {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(EventDeclarationNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(EqualsNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(ExpressionNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(FormalParameterNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(ForNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(FuncCallNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(FunctionDeclarationNode node, Object... arg)  {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(GEQNode node, Object... arg)  {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(GreaterThanNode node, Object... arg)  {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(GunColorNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(IdNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(IfControlStructureNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(InfixExpressionNode node, Object... arg)  {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(LEQNode node, Object... arg)  {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(LessThanNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(ModuloNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(MultiplicationNode node, Object... arg)  {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(NegateNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(NotEqualsNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(NotNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(NumberDeclarationNode node, Object... arg)  {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(NumberArrayDeclarationNode node, Object... arg)  {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(NumberNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(OrNode node, Object... arg){
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(PowerNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(ProgNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(RadarColorNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(ReturnNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(RobotPropertiesNode node, Object... arg) {
        visit ((AbstractNode) node, arg);}

    @Override
    public void visit(RoutineNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(StatementNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(StrategyDeclarationNode node, Object... arg)  {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(SubtractionNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(TextDeclarationNode node, Object... arg)  {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(TextArrayDeclarationNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(TextNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(ValNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(WhenNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(WhileNode node, Object... arg) {
        visit((AbstractNode)node,arg);
    }

    @Override
    public void visit(RobotNameNode node, Object... arg) {
        visit((AbstractNode)node,arg); }

    @Override
    public void visit(RobotTypeNode node, Object... arg) {
        visit ((AbstractNode)node, arg);}
}