/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compi2.valitationsej.semantic;

import compi2.valitationsej.ast.*;
import compi2.valitationsej.components.SymbolT;
import compi2.valitationsej.components.Type;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author blue-dragon
 */
public class Valitator {
    private Compatibility comp;
    
    public Valitator(){
        this.comp = new Compatibility();
    }
    
    public void insertIntoST(Declaration declaration, HashMap<String, SymbolT> st, List<String> errors){
        for (String id : declaration.getIds()) {
            SymbolT symbol = new SymbolT(id, 
                    declaration.getTypeDef(), 
                    declaration.getTypeExp().getType(), 
                    0);
            if(declaration.getTypeExp().getType() == Type.VECTOR){
                Type lenghtType = validate(declaration.getTypeExp().getLeftExp(), st, errors);
                if(lenghtType != Type.ENTERO){
                    errors.add("Un vector no ha sido definido con un tipo valido de dimension.");
                }
            }
            
            insertIntoST(symbol, st, errors);
        }
    }
    private void insertIntoST(SymbolT symbol, HashMap<String, SymbolT> st, List<String> errors){
        if(st.containsKey(symbol.getName())){
            errors.add("Se esta definiendo de nuevo la variable: " + symbol.getName());
        } else {
            st.put(symbol.getName(), symbol);
        }
    }
    
    public void validate(Asignation asign, HashMap<String, SymbolT> st, List<String> errors){
        String varName = asign.getVariable().getSymbol();
        if(!st.containsKey(varName)){
            errors.add("No se encontro la variable " + varName
                    + ", no se puede asignarle ningun valor." );
        } else if(st.get(varName).getType() != validate(asign.getExpresion(), st, errors)){
            errors.add("No se puede asignar a la variable " + varName 
                    + " el tipo de dato especificado, porque no es el adecuado" );
        }
        
    }
    public Type validate(Expresion expresion, HashMap<String, SymbolT> st, List<String> errors){
        if(expresion == null){
            System.out.println("Se encontro un nulo en expresion");
            return null;
        }
        if(expresion.isLeaf()){
            return expresion.getType();
        } else if(expresion.isVector()){
            
            return validate(expresion.getLeftExp(), st, errors);
        } else { //it's an operation
            //getting the types
            Type rightT = validate(expresion.getRightExp(), st, errors);
            if(rightT == Type.ID){
                rightT = comp.getIdType(expresion.getRightExp().getSymbol(), st, errors);
            }
            Type leftT = validate(expresion.getLeftExp(), st, errors);
            if(leftT == Type.ID){
                leftT = comp.getIdType(expresion.getLeftExp().getSymbol(), st, errors);
            }
            
            //types valitations
            if(!comp.canOperate(leftT, rightT, expresion.getOperation())){
                errors.add("No se puede operar");
                return Type.ERROR;
            } else {
                return comp.implicitTypeCon(leftT, rightT);
            }
        }
    }
    
    
}
