/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula15;

/**
 *
 * @author junio
 */
public class Aula15 {

 
    public static void main(String[] args) {
       Quadrado q = new Quadrado(3);
        System.out.println(q.area());
        System.out.println(q.perimetro());
        System.out.println(q.tamanhoDosLados());
        Triangulo t = new Triangulo(3);
        System.out.println(t.area());
        System.out.println(t.perimetro());
        System.out.println(t.tamanhoDosLados());
        Retangulo r = new Retangulo(3, 2);
        System.out.println(r.area());
        System.out.println(r.perimetro());
    }
    
}
