/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.listaduplamenteligada;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author deborah
 */
public class ListaDuplamenteLigada {

    public static void main(String[] args) {
        
        Random gerador = new Random(); //Gerador de números aleatórios
        int[] numeros = new int[1000]; //Vetor auxiliar para armazenar os números gerados
        ListaDupla lista = new ListaDupla(); //Lista Duplamente Encadeada para armazenar os números ordenados
        int posicao = 0;

        for(int i = 0; i < 1000; i++){ //Estrutura de repetição para gerar e armazenar os números aleatórios no vetor
            numeros[i] = gerador.nextInt((9999 - (-9999)) + 1) + (-9999);
        }

        System.out.println("Vetor => " + Arrays.toString(numeros)); //Impressão do vetor com os números na ordem de geração
      
        lista.adicionaNoComeco(numeros[0]); //Adição do primeiro número do vetor na lista
        
        Integer atual = numeros[0];

        for(int i = 1; i < numeros.length; i++){
            if(numeros[i] < atual){ //Verifica se o número é o menor e adiciona no começo da lista
                lista.adicionaNoComeco(numeros[i]);
            }else if(numeros[i] > (Integer)lista.pega(lista.tamanho() - 1)){ //Verifica se o número é o maior e adiciona no final da lista
                lista.adicionaNoFinal(numeros[i]);
            }else{ //Identifica qual posição correta para inserir o número caso ele não seja nem o menor nem o maior
                int contador = 0;
                while(numeros[i] >= (Integer)lista.pega(contador)){
                    contador++;
                    posicao = contador;
                }
                lista.adiciona(posicao, numeros[i]);
            }
            atual = (Integer)lista.pega(0);
        }

        lista.imprimir(); //Lista impressa em ordem crescente
        lista.imprimirInverso(); //Lista impressa em ordem decrescente
        
        for(int j = 0; j < lista.tamanho(); j++){ //Percorre a lista verificando se cada número é primo ou não
            if(lista.primo((Integer)lista.pega(j)) == true){
                lista.remove(j); //Remove os números que são primos
            }
        }
        lista.imprimir(); //Lista sem os números primos impressa em ordem crescente
        lista.imprimirInverso(); //Lista sem os números primos impressa em ordem decrescente
    }
}
