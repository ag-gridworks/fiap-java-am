/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fiap.model;

/**
 *
 * @author paesv
 */
public class Foguete {
    private String nome;
    private float peso;
    private String nome_grupo;

    public Foguete(String nome, float peso, String nome_grupo) {
        this.nome = nome;
        this.peso = peso;
        this.nome_grupo = nome_grupo;
    }
    
    public Foguete(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getNome_grupo() {
        return nome_grupo;
    }

    public void setNome_grupo(String nome_grupo) {
        this.nome_grupo = nome_grupo;
    }
    
    
}
