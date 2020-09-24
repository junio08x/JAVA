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
public class Retangulo extends Poligono{
    private double altura;
    public Retangulo(double lado, double altura){
        super(lado);
      this.altura = altura;
    }

    public double area(){
        return lado * altura;
    }
    public double perimetro(){
        return lado * 2 + altura * 2;
    }
    
    
}
