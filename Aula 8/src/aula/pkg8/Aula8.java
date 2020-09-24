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
public class Aula8 {

    public static void main(String[] args) {
        char a[] = new char [5]; // aqui eu atribuo o tamanho do meu vetor que no caso é 3 que vai de 0 a 2
        
        //a[0] = 3; //aqui atribuo o valor 3 na posição 0 do meu vetor
        //a[1] = 2; //aqui atribuo o valor 2 na posição 1 do meu vetor
        //a[2] = 5; //aqui atribuo o valor 5 na posição 2 do meu vetor
        //System.out.println(a[2]); //aqui eu estou imprimindo o valor que esta na posição 2 vai sair o valor 5
        
        for (int i=0; i<a.length; i++){ //aqui estou percorrendo o a ate o ultima posição dele com o comando a.length
            System.out.println("Digite as letras");
            a[i] = Keyboard.readChar();
            //System.out.println(a[i]); //aqui estou imprimindo os valores em sequencia com 1 vetor e o for
        }
        for (int i=0; i<a.length; i++){
            System.out.print(a[i]);
        }

    }

}
/* System.out.println("Digite um número:");
 int num = Keyboard.readInt();
 while (num > 0){
 System.out.println(num);
 num--;
 }
 while (num <0){
 System.out.println(num);
 num++;
 }
 System.out.println(num);
 }

 }
 */
/*
 1 - Faça um programa que leia três notas (AP, NP e EF) de um aluno e só siga em frente caso a nota digitada seja de 0 a 10. Notem que combinado ao programa do cáculo das médias, isso seria suficiente para fazer um programa completo para o cálculo das médias de um aluno.
 Ex.: -> Digite a AP:
 <- -1
 -> Nota inválida, digite novamente uma AP:
 <- 11
 -> Nota inválida, digite novamente uma AP:
 <- -10
 -> Nota inválida, digite novamente uma AP:
 <- 50
 -> Nota inválida, digite novamente uma AP:
 <- 25
 -> Nota inválida, digite novamente uma AP:
 <- 2
 -> OK. Digite a NP:
 */
/* EXERCICIO 1 AULA 7 
 System.out.println("Digite a AP");
 float ap = Keyboard.readFloat();
 while (ap < 0 || ap > 10) {
 System.out.println("Nota invalida");
 System.out.println("Digite a AP");
 ap = Keyboard.readFloat();
 }
 System.out.println("OK. AP = " + ap);
        
 System.out.println("Digite a NP");
 float np = Keyboard.readFloat();
 while (np < 0 || np > 10) {
 System.out.println("Nota invalida");
 System.out.println("Digite a NP");
 np = Keyboard.readFloat();
 }
 System.out.println("OK. NP = " + np);
 float mp = ap*0.75f+np*0.25f; // O "f" no final dos numeros é para indicar que é do tipo float
 if (mp>=6){
 System.out.println("Aprovado com media: " +mp);
 } else {
 System.out.println("Reprovado com media: "+mp);
 }
        
 }
    

 }*/
