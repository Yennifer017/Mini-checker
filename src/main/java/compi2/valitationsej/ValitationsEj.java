/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package compi2.valitationsej;

import compi2.valitationsej.analysis.Lexer;
import compi2.valitationsej.analysis.Parser;
import compi2.valitationsej.components.AdmiErrors;
import java.io.StringReader;

/**
 *
 * @author blue-dragon
 */
public class ValitationsEj {

    public static void main(String[] args) {
        AdmiErrors admiE = new AdmiErrors();
        StringReader reader = new StringReader("""
                                               int id1;
                                               int id2,id4;
                                               int[25] id3;
                                               string[12] id5;
                                               
                                               id1 = 5 + 2 * 5;
                                               id1 = 5 * 12.5 + id3[5];
                                               id2 = id3[2];
                                               id3 = (5+4) * 1;""");
        Lexer lexer = new Lexer(reader);
        Parser parser = new Parser(lexer);
        try {
            parser.parse();
            admiE.showErrors("Errores Lexicos:", lexer.getErrors());
            System.out.println("-------------------------------------------");
            admiE.showErrors("Errores Sintacticos",parser.getSyntaxErrors());
            System.out.println("-------------------------------------------");
            admiE.showErrors("Errores Semanticos", parser.getSemanticErrors());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
