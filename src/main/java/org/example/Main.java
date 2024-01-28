package org.example;

import gen.OberonLexer;
import gen.OberonParser;
import interpreter.Interpreter;
import org.antlr.v4.runtime.*;
import semanticanalysis.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable();
        CharStream input = CharStreams.fromString(
                "MODULE Example;\n" +
                        "VAR promenna: INTEGER;\n" +
                        "VAR beta: INTEGER;\n" +
                        "VAR p: INTEGER;\n" +
                        "\n" +
                        "BEGIN\n" +
                        "    promenna := 1024;\n" +
                        "    IF promenna > 1000 THEN\n" +
                        "        beta := 2;\n" +
                        "    ELSE\n" +
                        "        beta := 3;\n" +
                        "    END;\n" +
                        "    p := 0;\n" +
                        "END Example."
        );

//        CharStream input = CharStreams.fromString("MODULE ArrayExample;\n" +
//                "VAR\n" +
//                "  matrix: ARRAY [2] OF ARRAY [3] OF INTEGER;\n" +
//                "BEGIN\n" +
//                "  matrix[0, 0] := 1;\n" +
//                "  matrix[0, 1] := 2;\n" +
//                "  matrix[0, 2] := 3;\n" +
//                "  matrix[1, 0] := 4;\n" +
//                "  matrix[1, 1] := 5;\n" +
//                "  matrix[1, 2] := 6;\n" +
//                "END ArrayExample.\n");

//        CharStream input = CharStreams.fromString("MODULE MathModule;\n" +
//                "VAR\n" +
//                "    x, y, max: INTEGER;\n" +
//                "\n" +
//                "BEGIN\n" +
//                "    x := 25;\n" +
//                "    y := 15;\n" +
//                "\n" +
//                "    IF x > y THEN\n" +
//                "        max := x;\n" +
//                "    ELSE\n" +
//                "        max := y;\n" +
//                "    END;\n" +
//                "\n" +
//                "END MathModule.\n");

        OberonLexer lexer = new OberonLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OberonParser parser = new OberonParser(tokens);
        ParserRuleContext tree = parser.module();

        SemanticAnalyzer analyzer = new SemanticAnalyzer(symbolTable);
        analyzer.visit(tree);

        Interpreter interpreter = new Interpreter(symbolTable);
        interpreter.interpret(tree);

        System.out.println("Tree: " + tree.toStringTree(parser));

        LLVMIRGenerator irGenerator = new LLVMIRGenerator();
        String llvmIrCode = irGenerator.generateLLVMIR(tree);
        System.out.println(llvmIrCode);

        try {
            Files.write(Paths.get("output.ll"), llvmIrCode.getBytes());
            runProcess("C:\\Program Files\\LLVM\\bin\\clang.exe", "output.ll", "-o", "output.exe");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void runProcess(String... command) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        int exitCode = process.waitFor();
        System.out.println("Exit code: " + exitCode);
    }

}


