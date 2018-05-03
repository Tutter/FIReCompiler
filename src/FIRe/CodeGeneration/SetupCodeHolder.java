package FIRe.CodeGeneration;

public class SetupCodeHolder extends CodeHolder {
    SetupCodeHolder(){
        super();
    }
    String name = "UnnamedRobot";
    String robotType = "AdvancedRobot";
    String imports = "import java.awt.*;\nimport java.lang.*;\nimport robocode.*;\n";


    @Override
    public String getCode() {
        return imports + "public class " + name + " extends " + robotType + "{\n" + "\tString currentStrategy " +
                "= \"_Default\";\n" + sb.toString() + "\n}";
    }
}