/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula10;

/**
 *
 * @author junio
 */
public class Aula10 {
    public static int somaValores(int a, int b){

        return a+b;
    }

    public static void main(String[] args) {
         int a, b;
         System.out.println("Digite Quantas vezes vc quer que repita");
         int quantasSomas = Keyboard.readInt();
         for (int i=0; i<quantasSomas; i++){
             System.out.println("Digite o valor de a");
             a = Keyboard.readInt();
             System.out.println("Digite o valor de b");
             b = Keyboard.readInt();
             System.out.println(somaValores(a, b));
         }
        
    }
    
}
