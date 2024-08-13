/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compi2.valitationsej.ast;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author blue-dragon
 */
@Getter @Setter
public class Declaration {
    private Type type;
    private Expresion typeExp;
    private ArrayList<String> ids;

    public Declaration(Type type, Expresion typeExp) {
        this.type = type;
        this.typeExp = typeExp;
        ids = new ArrayList<>();
    }
}
