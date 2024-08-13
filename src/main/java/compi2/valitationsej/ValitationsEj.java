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
        StringReader reader = new StringReader("""
                                               int id1;
                                               int id2,id4;
                                               int[25] id3;
                                               string[12] id5;
                                               
                                               id1 = 5 * 12.5 + id3[5];
                                               id2 = id3[2];
                                               id3 = (5+4) * 1;""");
        Lexer lexer = new Lexer(reader);
        Parser parser = new Parser(lexer);
        try {
            parser.parse();
            if(parser.getSyntaxErrors().isEmpty()){
                System.out.println("Sin errores sintacticos");
            } else {
                System.out.println("Hay errores sintacticos");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
