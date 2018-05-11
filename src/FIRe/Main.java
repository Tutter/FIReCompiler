package FIRe;

import FIRe.CodeGeneration.CGTopVisitor;
import FIRe.CodeGeneration.SetUnderScoreVisitor;
import FIRe.ContextualAnalysis.ParentASTVisitor;
import FIRe.Exceptions.*;
import FIRe.Parser.CFGLexer;
import FIRe.Parser.CFGParser;
import org.antlr.v4.runtime.*;
import FIRe.ContextualAnalysis.*;
import FIRe.Nodes.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.*;
import java.util.Scanner;
//********************************************************************************
// HOW TO RUN THE PROGRAM WITHOUT INTELLIJ:
//Navigate to: FIReCompiler\out\artifacts\FIReCompiler_jar in the commando prompt
//Then write java -jar FIReCompiler.jar
//********************************************************************************

public class Main {

    public final static String BOOL = "bool";
    public final static String NUMBER = "number";
    public final static String TEXT = "text";
    public final static String BOOLARRAY = "bool array";
    public final static String NUMBERARRAY = "number array";
    public final static String TEXTARRAY = "text array";
    public static boolean CodeGenerationFlag = false; //Set to true, if/when there is an error that prevents code generation
    public static boolean ContextualAnalysisFlag = false; //Set to true, if/when there is an error that prevents the contextual analysis

    public static void main(String[] args) throws Exception {

        //Reads from the example program. (Debug code)
        //Tuple<String, String> pathAndFileName = ReadUserInput();
        //Scanner in = new Scanner(new FileReader(pathAndFileName.x+pathAndFileName.y));
        Scanner in = new Scanner(new FileReader("src\\FIRe\\Kodeeksempler\\KodeEx3.txt"));
        //We use this delimiter, to chop the code into bits. We split by the backslash character "\n"
        in.useDelimiter("\n");

        Errors errors = new Errors();

        //Creates a StringBuilder from the given code file.
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            sb.append(in.next() + "\n");
        }

        CFGParser.ProgContext cst = null;

        //We append $ because this is the terminal symbol of the program.
        sb.append("$");
        in.close();

        //Converts the StringBuilder to a string.
        String outString = sb.toString();

        try {
            //https://stackoverflow.com/questions/18110180/processing-a-string-with-antlr4
            //Setup to perform lexical analysis on the input string.
            AntlrException antlrException = new AntlrException();
            CFGLexer lexer = new CFGLexer(CharStreams.fromString(outString));
            lexer.removeErrorListeners();
            lexer.addErrorListener(antlrException);

            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            CFGParser parser = new CFGParser(tokenStream);
            parser.removeErrorListeners();
            parser.addErrorListener(antlrException);

            //Performs lexical analysis and builds a CST.
            cst = parser.prog();
            //cst.children.add(parser.dcl());
        } catch (ParseCancellationException ex) {
            System.out.println(ex.getMessage());
            ContextualAnalysisFlag = true; //If there is a mistake in the syntax, disable the Contextual Analysis
        }

        if (!ContextualAnalysisFlag) {//If the syntax is ok.
            //Builds an AST from the CST
            RobotHeaderTable RHT = new RobotHeaderTable();
            ProgNode ast = (ProgNode) new BuildASTVisitor().visitProg(cst);
            ParentASTVisitor PASTV = new ParentASTVisitor();
            try {
                ast.accept(PASTV, null);
            } catch (Exception e) {
                System.out.println("Exception type: " + e.getClass() + "Message: " + e.getMessage());
            }

            //Prints the AST to check whether it has all the correct info. (Debug code)
            PrintTraversal print = new PrintTraversal();
            //print.Print(ast, 0);


            //Creating instance of the symboltable
            SymbolTable symbolTable = new SymbolTable();


            //Collecting typeinformation about: Functions, strategies and events.
            FESVisitor fes = new FESVisitor(symbolTable);
            fes.visit(ast);


            //Filling the symboltable
            ScopeTypeCheckVisitor STV = new ScopeTypeCheckVisitor(symbolTable, RHT);
            STV.visit(ast);


            //We now know all the functions, strategies and events in the program.
            //Therefore checking if the "Default"-strategy exists.
            try {
                symbolTable.Search("Default", 0);
            } catch (SymbolNotFoundException e) {
                //Could not find the strategy with name "Default";
                try {
                    throw new MissingDefaultStrategyException("No strategy with name: \"Default\" was found");
                } catch (MissingDefaultStrategyException f) {
                    System.out.println(f.getMessage());
                }
            }


            //Checking correct use of returns.
            ReturnCheckVisitor returnCheckVisitor = new ReturnCheckVisitor(symbolTable);
            returnCheckVisitor.visit(ast);

            if (!CodeGenerationFlag) { //If no breaking mistakes were found, generate the code.
                SetUnderScoreVisitor underscoreVis = new SetUnderScoreVisitor();

                underscoreVis.visit(ast);

                //Code generation
                CGTopVisitor codeGenerator = new CGTopVisitor(symbolTable);

                try {
                    codeGenerator.visit(ast);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }


                codeGenerator.generateOutputFile("src\\FIRe\\Kodeeksempler\\");
                //codeGenerator.generateOutputFile(pathAndFileName.x);
            } else { //If the semantics are wrong, print that code generation was not performed
                System.out.println("Contextual errors detected. No code was generated.");
            }
        }
        else {
            System.out.println("Syntactic errors detected. No code was generated.");
        }
    }

    static Tuple<String, String> ReadUserInput()
    {
        Scanner userInput = new Scanner(System.in);
        String path;
        String fileName;
        System.out.println("> Write the name of the file including file extension fx Robot.txt:");
        System.out.print("> ");
        fileName =  userInput.nextLine();
        System.out.println("\n> Write the full path for your FIRe program excluding the file name fx C:\\Desktop\\: ");
        System.out.print("> ");
        path = userInput.nextLine();
        System.out.println("\nThe compiled file will be made in the same path.");
        Tuple<String, String> pathAndFileName = new Tuple<String, String>(path, fileName);

        return pathAndFileName;
    }
}