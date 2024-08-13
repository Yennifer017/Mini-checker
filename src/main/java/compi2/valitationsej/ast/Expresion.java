/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compi2.valitationsej.ast;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author blue-dragon
 */
@Getter @Setter @NoArgsConstructor
public class Expresion {
    private Operation operation;
    private Type type;
    private String symbol;
    private Expresion rightExp;
    private Expresion leftExp;

    public Expresion(Type type) {
        this.type = type;
    }

    public Expresion(Operation operation, Expresion rightExp, Expresion leftExp) {
        this.operation = operation;
        this.rightExp = rightExp;
        this.leftExp = leftExp;
    }

    public Expresion(Operation operation) {
        this.operation = operation;
    }
    
    
    
}
