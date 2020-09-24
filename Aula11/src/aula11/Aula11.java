/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11;

/**
 *
 * @author junio
 */
public class Aula11 {
    public static char retornaPrimeiraLetra(String palavra){
        char letra = palavra.charAt(0);
        switch (letra){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return 'v';
            default :
                return 'c';
        }
    }
    public static void main(String[] args) {
        System.out.println("Digite uma palavra");
        String palavra = Keyboard.readString();
        char letra = retornaPrimeiraLetra(palavra);
        if (letra == 'v'){
            System.out.println("Vogal");
        }else{
            System.out.println("Consoante");
        }
        

    }
    
}
