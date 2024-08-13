/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compi2.valitationsej.ast;

import compi2.valitationsej.components.Type;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author blue-dragon
 */
@Getter @Setter
public class Declaration {
    private Type typeDef;
    private Expresion typeExp;
    private ArrayList<String> ids;

    public Declaration(Type typeDef, Expresion typeExp) {
        this.typeDef = typeDef;
        this.typeExp = typeExp;
        ids = new ArrayList<>();
    }
}
