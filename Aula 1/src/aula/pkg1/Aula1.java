/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula.pkg1;

/**
 *
 * @author Vitor Rodrigues
 */
public class Aula1 {

    /**
     * @param args the command line arguments
     */
    /*  EXEMPLO
     int soma, sub, mult, div;
     int valor=10, valor2=2;
     soma = valor + valor2;
     sub = valor - valor2;
     mult = valor * valor2;
     div = valor / valor2;
   
     System.out.println("Soma de: " + valor + "+" + valor2 + " = "+ soma );
     System.out.println("Subtração de: " + valor + " por "+ valor2 + " = "+ sub );
     System.out.println("Multiplicação de: " + valor + " por "+ valor2+ " = " + mult);
     System.out.println("Divisão de: "+ valor + " por "+ valor2 +" = " +div );
     */
    public static void main(String[] args) {
        int numero;
        int divisor2;
        int divisor3;
        System.out.println("Digite um numero: ");
        numero = Keyboard.readInt();
        divisor2 = numero % 2;
        divisor3 = numero % 3;
        if (divisor2 + divisor3 == 0) {
            System.out.println("Esse Numero digitado é divisor por 2 e por 3");
        } else {
            System.out.println("Esse numero não é Divisor por 2 e por 3");
        }
    }
}
