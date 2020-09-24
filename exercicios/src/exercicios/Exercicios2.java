/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

/**
 *
 * @author junio
 */
public class Exercicios2 {

    public static void main(String[] args) {
        System.out.println("Digite uma palavra");
        String nome = Keyboard.readString();
        for(int i=nome.length()-1; i>=0; i--){
            
            System.out.print(nome.charAt(i));
            
        }
        System.out.println("");
    }
}
