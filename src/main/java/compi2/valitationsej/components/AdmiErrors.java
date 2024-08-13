/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compi2.valitationsej.components;

import java.util.List;

/**
 *
 * @author blue-dragon
 */
public class AdmiErrors {
    public void showErrors(String title, List<String> errors){
        System.out.println(title);
        if(errors.isEmpty()){
            System.out.println("No hay errores");
        } else {
            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}
