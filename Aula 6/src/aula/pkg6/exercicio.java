/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula.pkg6;

/**
 *
 * @author junio
 */
public class exercicio {

    public static void main(String[] args) {

        int numero1 = 0;
        int numero2 = 1;
        int fibonacci;

        for (fibonacci = 0; fibonacci <= 30; fibonacci++) {
            
           fibonacci = numero1+numero2;
            System.out.println(fibonacci);
            

        }

    }
}
