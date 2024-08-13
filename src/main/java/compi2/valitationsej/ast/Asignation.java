/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compi2.valitationsej.ast;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author blue-dragon
 */
@Getter @Setter
public class Asignation {
    private Expresion variable;
    private Expresion expresion;

    public Asignation(Expresion variable, Expresion expresion) {
        this.variable = variable;
        this.expresion = expresion;
    }
    
}
