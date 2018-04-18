package FIRe;

import java.beans.Expression;

//Så skal man lave en klasse som nedarver denne klasse og som implementerer
//en traverse metode for dem alle fx depth-first, som er standarden.
public abstract class ASTVisitor
{
    //Har en overloaded visitmetode for hver node.
    //Dette er lavet på baggrund af slide 82 lecture 9
    public abstract void visit(AbstractNode node);
    public abstract void visit(AdditionNode node) throws Exception;
    public abstract void visit(ActualParameterNode node);
    public abstract void visit(AndNode node) throws Exception;
    public abstract void visit(ArrayAccessNode node);
    public abstract void visit(AssignNode node) throws Exception;
    public abstract void visit(BlockNode node);
    public abstract void visit(BodyColorNode node);
    public abstract void visit(BooleanDeclarationNode node) throws Exception;
    public abstract void visit(BoolArrayDeclarationNode node) throws Exception;
    public abstract void visit(BoolNode node);
    public abstract void visit(Color node);
    public abstract void visit(ColorValNode node);
    public abstract void visit(ControlStructureNode node);
    public abstract void visit(DeclarationNode node);
    public abstract void visit(DivisionNode node) throws Exception;
    public abstract void visit(EventDeclarationNode node) throws Exception;
    public abstract void visit(EqualsNode node) throws Exception;
    public abstract void visit(ExpressionNode node);
    public abstract void visit(FormalParameterNode node);
    public abstract void visit(ForNode node);
    public abstract void visit(FuncCallNode node);
    public abstract void visit(FunctionDeclarationNode node) throws Exception;
    public abstract void visit(GEQNode node) throws Exception;
    public abstract void visit(GreaterThanNode node) throws Exception;
    public abstract void visit(GunColorNode node);
    public abstract void visit(IdNode node) throws Exception;
    public abstract void visit(IfControlStructureNode node);
    public abstract void visit(InfixExpressionNode node) throws Exception;
    public abstract void visit(LEQNode node) throws Exception;
    public abstract void visit(LessThanNode node) throws Exception;
    public abstract void visit(ModuloNode node) throws Exception;
    public abstract void visit(MultiplicationNode node) throws Exception;
    public abstract void visit(NegateNode node);
    public abstract void visit(NotEqualsNode node) throws Exception;
    public abstract void visit(NotNode node);
    public abstract void visit(NumberDeclarationNode node) throws Exception;
    public abstract void visit(NumberArrayDeclarationNode node) throws Exception;
    public abstract void visit(NumberNode node);
    public abstract void visit(OrNode node) throws Exception;
    public abstract void visit(PowerNode node) throws Exception;
    public abstract void visit(ProgNode node);
    public abstract void visit(RadarColorNode node);
    public abstract void visit(ReturnNode node);
    public abstract void visit(RobotDclBodyNode node);
    public abstract void visit(RoutineNode node);
    public abstract void visit(StatementNode node);
    public abstract void visit(StrategyDeclarationNode node) throws Exception;
    public abstract void visit(SubtractionNode node) throws Exception;
    public abstract void visit(TextDeclarationNode node) throws Exception;
    public abstract void visit(TextArrayDeclarationNode node) throws Exception;
    public abstract void visit(TextNode node);
    public abstract void visit(ValNode node);
    public abstract void visit(WhenNode node);
    public abstract void visit(WhileNode node);


    public void VisitNode(AbstractNode node) {
        try {
            if (node instanceof ProgNode) //comment so i can commit
                visit((ProgNode) node);
            else if (node instanceof ActualParameterNode)
                visit((ActualParameterNode) node);
            else if (node instanceof AdditionNode)
                visit((AdditionNode) node);
            else if (node instanceof AndNode)
                visit((AndNode) node);
            else if (node instanceof ArrayAccessNode)
                visit((ArrayAccessNode) node);
            else if (node instanceof AssignNode)
                visit((AssignNode) node);
            else if (node instanceof BlockNode)
                visit((BlockNode) node);
            else if (node instanceof BodyColorNode)
                visit((BodyColorNode) node);
            else if (node instanceof BooleanDeclarationNode)
                visit((BooleanDeclarationNode) node);
            else if (node instanceof BoolNode)
                visit((BoolNode) node);
            else if (node instanceof ColorValNode)
                visit((ColorValNode) node);
            else if (node instanceof DivisionNode)
                visit((DivisionNode) node);
            else if (node instanceof EventDeclarationNode)
                visit((EventDeclarationNode) node);
            else if (node instanceof EqualsNode)
                visit((EqualsNode) node);
            else if (node instanceof FormalParameterNode)
                visit((FormalParameterNode) node);
            else if (node instanceof ForNode)
                visit((ForNode) node);
            else if (node instanceof FuncCallNode)
                visit((FuncCallNode) node);
            else if (node instanceof FunctionDeclarationNode)
                visit((FunctionDeclarationNode) node);
            else if (node instanceof GEQNode)
                visit((GEQNode) node);
            else if (node instanceof GreaterThanNode)
                visit((GreaterThanNode) node);
            else if (node instanceof GunColorNode)
                visit((GunColorNode) node);
            else if (node instanceof IdNode)
                visit((IdNode) node);
            else if (node instanceof IfControlStructureNode)
                visit((IfControlStructureNode) node);
            else if (node instanceof LEQNode)
                visit((LEQNode) node);
            else if (node instanceof LessThanNode)
                visit((LessThanNode) node);
            else if (node instanceof ModuloNode)
                visit((ModuloNode) node);
            else if (node instanceof MultiplicationNode)
                visit((MultiplicationNode) node);
            else if (node instanceof NegateNode)
                visit((NegateNode) node);
            else if (node instanceof NotEqualsNode)
                visit((NotEqualsNode) node);
            else if (node instanceof NotNode)
                visit((NotNode) node);
            else if (node instanceof NumberDeclarationNode)
                visit((NumberDeclarationNode) node);
            else if (node instanceof NumberNode)
                visit((NumberNode) node);
            else if (node instanceof OrNode)
                visit((OrNode) node);
            else if (node instanceof PowerNode)
                visit((PowerNode) node);
            else if (node instanceof RadarColorNode)
                visit((RadarColorNode) node);
            else if (node instanceof ReturnNode)
                visit((ReturnNode) node);
            else if (node instanceof RobotDclBodyNode)
                visit((RobotDclBodyNode) node);
            else if (node instanceof RoutineNode)
                visit((RoutineNode) node);
            else if (node instanceof StrategyDeclarationNode)
                visit((StrategyDeclarationNode) node);
            else if (node instanceof SubtractionNode)
                visit((SubtractionNode) node);
            else if (node instanceof TextDeclarationNode)
                visit((TextDeclarationNode) node);
            else if (node instanceof TextNode)
                visit((TextNode) node);
            else if (node instanceof ValNode)
                visit((ValNode) node);
            else if (node instanceof WhenNode)
                visit((WhenNode) node);
            else if (node instanceof WhileNode)
                visit((WhileNode) node);
            else if (node instanceof ArrayDeclarationNode)
                visit((ArrayDeclarationNode) node);
            else
                System.out.println("Error");
        } catch (Exception e) {
            System.out.println(e);

        }
    }


}