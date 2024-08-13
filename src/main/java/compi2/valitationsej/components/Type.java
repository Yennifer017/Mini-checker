/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package compi2.valitationsej.components;

/**
 *
 * @author blue-dragon
 */
public enum Type {
    ENTERO(2),
    DECIMAL(3),
    BOOLEANO(1),
    ID,
    VECTOR,
    CADENA(4),
    ERROR(-1000)
    ;
    private int precedence;
    private Type(int precedence){
        this.precedence = precedence;
    }
    
    private Type(){}
    
    public int getPrecedence(){
        return this.precedence;
    }
}
