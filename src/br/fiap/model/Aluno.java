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
public class Aluno {
    private int rm;
    private String nome;
    private String grupo;

    public Aluno(int rm, String nome, String grupo) {
        this.rm = rm;
        this.nome = nome;
        this.grupo = grupo;
    }
    
    public Aluno(){
        
    }

    public int getRm() {
        return rm;
    }

    public void setRm(int rm) {
        this.rm = rm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

   
    
}
