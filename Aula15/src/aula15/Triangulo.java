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
public class Triangulo extends Poligono{
    private double altura;
    public Triangulo(double lado){
        super(lado);
        altura=lado*Math.cos(Math.PI/3);
    }
    public double area(){
        return lado * altura /2;
    }
    public double perimetro(){
        return lado*3;
    }
}
