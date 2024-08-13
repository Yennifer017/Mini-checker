/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compi2.valitationsej.components;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author blue-dragon
 */
@Getter @Setter
public class SymbolT {
    private String name;
    private Type type;
    private Type secondType;
    private int memoryDirect;

    public SymbolT(String name, Type type, Type secondType, int memoryDirect) {
        this.name = name;
        this.type = type;
        this.secondType = secondType;
        this.memoryDirect = memoryDirect;
    }

    
}
