/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaduplamenteligada;

/**
 *
 * @author deborah
 */
public class Celula { //Configura cada célula da lista duplamente encadeada
    Celula Proxima; //Aponta para a próxima célula
    Celula Anterior; //Aponta para a célula anterior
    Integer Elemento; //Objeto armazenado

    Celula(Celula proxima, Integer elemento){ //Método construtor das células
        this.Proxima = proxima;
        this.Anterior = null;
        this.Elemento = elemento;
    }
    
    Celula(Integer elemento){ //Método construtor das células
        this.Proxima = null;
        this.Anterior = null;
        this.Elemento = elemento;
    }
    
    void setProxima(Celula proxima){ //Procedimento que define a próxima célula
        this.Proxima = proxima;
    }
    
    void setAnterior(Celula anterior){ //Procedimento que define a célula anterior
        this.Anterior = anterior;
    }
    
    Celula getProxima(){ //Função que recupera a próxima célula
        return(this.Proxima);
    }
    
    Celula getAnterior(){ //Função que recupera a célula anterior
        return(this.Anterior);
    }
    
    Object getElemento(){ //Função que recupera o objeto (informação) dentro da célula
        return(this.Elemento);
    }
}
