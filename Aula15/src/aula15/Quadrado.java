/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula15;


public class Quadrado extends Poligono{
    public Quadrado(double lado){
        super(lado);
    }

    public double area(){
        return Math.pow(lado, 2);
    }
    public double perimetro(){
        return lado * 4;
    }
    
}
