package Calculator;

public class Calculator {
    private String expression;
    private int pos;
    private enum Operation {ADD, SUB, MUL, DIV, NONE};

    public Calculator(String expression) {
        this.expression = expression;
    }

    // scanner
    private String getNext() throws Exception {
        if (hasNext()) {
            return expression.substring(pos++,pos);
        } else
            throw new Exception("unexpected end of expression");
    }
    private String checkNext() throws Exception {
        if (hasNext())
            return expression.substring(pos,pos+1);
        else
            return "";
    }
    private boolean hasNext() {
        return pos < expression.length();
    }

    int getNumber() throws Exception {
        String num = getNext();
        return Integer.valueOf(num);
    }

    Operation getOperation(String op) throws Exception {
        switch (op) {
            case ""  :
            case ")" : return Operation.NONE;
            case "+" : return Operation.ADD;
            case "-" : return Operation.SUB;
            case "*" : return Operation.MUL;
            case "/" : return Operation.DIV;
        }
        throw new Exception("unknown operation "+op);
    }

    Operation getOperation() throws Exception {
            String op = getNext();
            return getOperation(op);
    }

    Operation checkOperation() throws Exception {
        String op = checkNext();
        return getOperation(op);
    }

    private int getTerm2() throws Exception {
        String br = checkNext();
        if (br.equals("(")) {
            getNext();
            int expr = expression();
            if (!getNext().equals(")"))
                throw new Exception("\")\" expected");
            return expr;
        }
        return getNumber();
    }

    // parser
    private int getTerm() throws Exception {
        int res = getTerm2();
        while (hasNext()) {
            Operation op = checkOperation();
            if (op == Operation.MUL || op == Operation.DIV) {
                op = getOperation();
                int num = getTerm2();
                switch (op) {
                    case MUL:
                        res *= num;
                        break;
                    case DIV:
                        res /= num;
                        break;
                    default:
                        throw new Exception("internal error: invalid operation " + op);
                }
            }  else
                return res;
        }
        return res;
    }

    private int expression() throws Exception {
        int res = getTerm();
        while (hasNext()) {
            Operation op = checkOperation();
            if (op == Operation.ADD || op == Operation.SUB) {
                op = getOperation();
                int num = getTerm();
                switch (op) {
                    case ADD:
                        res += num;
                        break;
                    case SUB:
                        res -= num;
                        break;
                    default:
                        throw new Exception("internal error: invalid operation " + op);
                }
            } else
                return res;
        }
        return res;
    }

    private int calculate() throws Exception {
        return expression();
    }

    public static int calculate(String expression) throws Exception {
        return new Calculator(expression).calculate();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Calculator.calculate("2+3/(2*6-1-9-2)"));
    }
}
