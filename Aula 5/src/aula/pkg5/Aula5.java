/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula.pkg5;

/**
 *
 * @author junio
 */
public class Aula5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String dia;
        int idade;
        float ingresso;
        float valor;
        ingresso = 30;
        System.out.println("Que dia é hoje?");
        dia = Keyboard.readString();
        switch (dia){
            case "sabado":
            case "domingo":
                System.out.println("O valor do Ingresso é: "+ingresso);
                break;
            case "segunda":
            case "terça":
            case "quinta":
                valor =(ingresso-(ingresso*25)/100);
                System.out.println("O valor do Ingresso é " + valor);
                break;
            case "quarta":
                valor = (ingresso/2);
                System.out.println("O valor do Ingresso é: " +valor);
                break;
            default:
                   System.out.println("Digite sua Idade:");
                   idade =  Keyboard.readInt();
                   valor = (ingresso-(ingresso * idade)/100);
                   if(valor < 0){
                       valor = 0;
                   }
                    System.out.println("O valor do Ingresso é: " +valor);
                break;

                
        }
        
    }
}
 /*           char caractere;
            System.out.println("Digite um numero: ");
            caractere = Keyboard.readChar();
            if (caractere=='0' || caractere=='1' || caractere=='2' ||
                    caractere=='3' || caractere=='4' || caractere=='5' ||
                    caractere=='6' || caractere=='7' || caractere=='8' ||
                    caractere=='9'){
                System.out.println(caractere + " é um numero!");
            }
            else if(caractere=='a' || caractere=='e' || caractere=='i' ||
                    caractere=='o' || caractere=='u'){
                System.out.println(caractere + " é uma Vogal");
            }
            else {
                System.out.println(caractere + " é uma consoante!");
            }
            
    }
} */
        /*int numero;
        int divisor2;
        int divisor3;
        int soma;
        System.out.println("Digite um numero: ");
        numero = Keyboard.readInt();
        divisor2 = numero % 2;
        divisor3 = numero % 3;
        soma = divisor2 + divisor3;

        switch (soma) {
            case 0:
                System.out.println("é Multiplo de 2 e 3");
                break;
            default:
                if (numero % 2 == 0) {
                    System.out.println("é Multiplo de 2");
                } else if (numero % 3 == 0) {
                    System.out.println("é Multiplo de 3");
                } else {
                    System.out.println("Não é multiplo de 2 ou 3");
                }
                break;

        }

    }

}
*/