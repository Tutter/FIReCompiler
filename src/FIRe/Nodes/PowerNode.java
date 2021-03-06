package FIRe.Nodes;


import FIRe.ASTVisitor;

public class PowerNode extends InfixExpressionNode {
    @Override
    public void accept(ASTVisitor v, AbstractNode parent) throws Exception {
        v.visit(this, parent);
        this.LeftChild.accept(v, this);
        this.RightChild.accept(v, this);
    }
    /* ex 3^4 */
}
