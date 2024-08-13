/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compi2.valitationsej.semantic;

import compi2.valitationsej.ast.Operation;
import compi2.valitationsej.components.SymbolT;
import compi2.valitationsej.components.Type;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author blue-dragon
 */
public class Compatibility {
    
    
    public boolean canOperate(Type typeL, Type typeR, Operation operation){
        if(operation == Operation.MULTIPLICACION){
            return typeL != Type.CADENA && typeR != Type.CADENA;
        }    
        return true;
    }
    
    public Type implicitTypeCon(Type typeL, Type typeR){
        if(typeL.getPrecedence() >= typeR.getPrecedence()){
            return typeL;
        } else {
            return typeR;
        }
    }
    
    public Type getIdType(String name, HashMap<String, SymbolT> st, List<String> errors){
        if(st.containsKey(name)){
            return st.get(name).getType();
        } else {
            errors.add("No se pudo encontrar el valor de una variabl en la tabla de simbolos");
            return Type.ERROR;
        }
    }
}
