/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaduplamenteligada;

/**
 *
 * @author deborah
 */
public class ListaDupla { //Define a estrutura da lista duplamente encadeada e seus métodos
    Celula primeira;
    Celula ultima;
    int totalDeElementos = 0;
    
    // Métodos
    boolean posicaoOcupada(int posicao){ //Função que verifica se a posição está ocupada
        return posicao >= 0 && posicao < this.totalDeElementos;
    }
    
    Celula pegaCelula(int posicao) { //Função que recupera a célula em uma posição específica da lista
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }
        Celula atual = primeira;
        
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }
    
    Object pega(int posicao) { //Função que retorna o item em uma posição específica da lista
        return this.pegaCelula(posicao).getElemento();
    }
    
    void adicionaNoComeco(Integer elemento) { //Procedimento que diciona um item no começo da lista
        if(this.totalDeElementos == 0){
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        } else {
            Celula nova = new Celula(this.primeira, elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }
        this.totalDeElementos++;
    }

    void adicionaNoFinal(Integer elemento) { //Procedimento que adiciona um item no final da lista
        if (this.totalDeElementos == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }

    void adiciona(int posicao, Integer elemento) { //Procedimento que adiciona um item em uma posição específica da lista
        if(posicao == 0){ // No começo.
            this.adicionaNoComeco(elemento);
        } else if(posicao == this.totalDeElementos){ // No fim.
            this.adicionaNoFinal(elemento);
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula proxima = anterior.getProxima();
            Celula nova = new Celula(anterior.getProxima(), elemento);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            this.totalDeElementos++;
        }
    }
    
    void removeDoComeco() { //Procedimento que remove um item do começo da lista
        if (!this.posicaoOcupada(0)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        this.primeira = this.primeira.getProxima();
        this.totalDeElementos--;
        
        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }
    }
    
    void removeDoFim() { //Procedimento que remove um item do fim da lista
        if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        
        if (this.totalDeElementos == 1) {
            this.removeDoComeco();
        } else {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }
    }
    
    void remove(int posicao) { //Procedimento que remove um item em uma posição específica da lista
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        
        if (posicao == 0) {
            this.removeDoComeco();
        } else if (posicao == this.totalDeElementos - 1) {
            this.removeDoFim();
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula atual = anterior.getProxima();
            Celula proxima = atual.getProxima();
            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);
            this.totalDeElementos--;
        }
    }
   
    int tamanho() { //Função que retorna o tamanho da lista
        return this.totalDeElementos;
    }

    void imprimir(){ //Procedimento que imprime a lista
        if(this.totalDeElementos == 0){
            System.out.println("[]");
        }else{
            StringBuilder builder = new StringBuilder("Lista crescente => [");
            Celula atual = this.primeira;
            
            for(int i = 0; i < this.totalDeElementos -1; i++){
                builder.append(atual.getElemento());
                builder.append(", ");
                atual = atual.getProxima();
            }
            builder.append(atual.getElemento());
            builder.append("]");
            System.out.println(builder.toString());
        }
    }
    
    void imprimirInverso(){ //Procedimento que imprime a lista na ordem inversa
        if(this.totalDeElementos == 0){
            System.out.println("[]");
        }else{
            StringBuilder builder = new StringBuilder("Lista decrescente => [");
            Celula atual = this.ultima;
            
            for(int i = this.totalDeElementos -1; i > 0; i--){
                builder.append(atual.getElemento());
                builder.append(", ");
                atual = atual.getAnterior();
            }
            builder.append(atual.getElemento());
            builder.append("]");
            System.out.println(builder.toString());
        }
    }
    
    boolean primo(int numero){ //Função que verifica se um número é primo
        if (numero <= 1){
            return false;
        }else{
            for (int i = 2; i < numero; i++){
                if (numero % i == 0){
                    return false;  
                }
            }
            return true;
        }
    }
}
