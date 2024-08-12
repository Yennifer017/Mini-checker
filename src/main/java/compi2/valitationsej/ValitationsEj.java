/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package compi2.valitationsej;

import compi2.valitationsej.analysis.Lexer;
import compi2.valitationsej.analysis.Parser;
import java.io.StringReader;

/**
 *
 * @author blue-dragon
 */
public class ValitationsEj {

    public static void main(String[] args) {
        StringReader reader = new StringReader("int id1;\n"
                + "int id2,id4;\n"
                + "int[25] id3;\n"
                + "string[12] id5;\n"
                + "\n"
                + "id1 = 5 * 12.5 + id3[5];\n"
                + "id2 = id3[2];");
        Lexer lexer = new Lexer(reader);
        Parser parser = new Parser(lexer);
        try {
            parser.parse();
            if(parser.getSyntaxErrors().isEmpty()){
                System.out.println("Sin errores sintacticos");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
