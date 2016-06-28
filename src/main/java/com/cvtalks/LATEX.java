package com.cvtalks;

/**
 * @author: Petruk Eugen
 */
public class LATEX {
    private static class LATEXVisitor implements OperationVisitor {

        String m_value;

        @Override
        public void visit(Atan2 atan2) {
            m_value = " {\\rm atan2}\\left(" + LATEXVisitor.toString(atan2.firstArgument()) + "," + LATEXVisitor.toString(atan2.secondArgument()) + "\\right)";
        }

        @Override
        public void visit(Cos cos) {
            m_value = "\\cos\\left(" + LATEXVisitor.toString(cos.getArgument()) + "\\right)";
        }

        @Override
        public void visit(Divide divide) {
            m_value = "\\frac{" + LATEXVisitor.toString(divide.firstArgument()) + "}" + "{" + LATEXVisitor.toString(divide.secondArgument()) + "}";
        }

        @Override
        public void visit(Multiply multiply) {
            m_value =  LATEXVisitor.toString(multiply.firstArgument()) + "*" + LATEXVisitor.toString(multiply.secondArgument());
        }

        @Override
        public void visit(Neg neg) {
            m_value = "\\left(-{" + LATEXVisitor.toString(neg.getArgument()) + "}\\right)";
        }

        @Override
        public void visit(Pow pow) {
            m_value = "\\left(" + LATEXVisitor.toString(pow.firstArgument()) + "\\right)" + "^" + "{" + LATEXVisitor.toString(pow.secondArgument())+ "}";
        }

        @Override
        public void visit(Sin sin) {
            m_value = "\\sin\\left(" + LATEXVisitor.toString(sin.getArgument()) + "\\right)";
        }

        @Override
        public void visit(Sqrt sqrt) {
            m_value = "\\sqrt{" + LATEXVisitor.toString(sqrt.getArgument()) + "}";
        }

        @Override
        public void visit(Subtract subtract) {
            m_value = LATEXVisitor.toString(subtract.firstArgument()) + "-" + LATEXVisitor.toString(subtract.secondArgument()) ;
        }

        @Override
        public void visit(Sum sum) {
            m_value = LATEXVisitor.toString(sum.firstArgument()) + "+" + LATEXVisitor.toString(sum.secondArgument());
        }

        @Override
        public void visit(Tan tan) {
            m_value = "\\tan\\left(" + LATEXVisitor.toString(tan.getArgument()) + "\\right)";
        }

        @Override
        public void visit(Value value) {
            m_value = value.toString();
        }

        @Override
        public void visit(Variable variable) {
            m_value = variable.toString();
        }

        public static String toString(Operation op) {
            LATEXVisitor visitor = new LATEXVisitor();
            op.accept(visitor);
            return visitor.m_value;
        }


    }

    public static String toString(Operation op) {
        return LATEXVisitor.toString(op);
    }
}



