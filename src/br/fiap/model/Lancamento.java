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
public class Lancamento {
    private int id_grupo;
    private float distancia;
    private float angulo;
    private float velocidade_vento;
    private float altitude_maxima;
    private float velocidade_maxima;
    private float pico_acelaracao;
    private float aceleracao_media;
    private float tempo_apogeu_descida;
    private float tempo_ejecao;
    private float altitude_ejecao;
    private float taxa_descida;
    private float duracao;

    public Lancamento(int id_grupo, float distancia, float angulo, float velocidade_vento, float altitude_maxima, float velocidade_maxima, float pico_acelaracao, float aceleracao_media, float tempo_apogeu_descida, float tempo_ejecao, float altitude_ejecao, float taxa_descida, float duracao) {
        this.id_grupo = id_grupo;
        this.distancia = distancia;
        this.angulo = angulo;
        this.velocidade_vento = velocidade_vento;
        this.altitude_maxima = altitude_maxima;
        this.velocidade_maxima = velocidade_maxima;
        this.pico_acelaracao = pico_acelaracao;
        this.aceleracao_media = aceleracao_media;
        this.tempo_apogeu_descida = tempo_apogeu_descida;
        this.tempo_ejecao = tempo_ejecao;
        this.altitude_ejecao = altitude_ejecao;
        this.taxa_descida = taxa_descida;
        this.duracao = duracao;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public float getAngulo() {
        return angulo;
    }

    public void setAngulo(float angulo) {
        this.angulo = angulo;
    }

    public float getVelocidade_vento() {
        return velocidade_vento;
    }

    public void setVelocidade_vento(float velocidade_vento) {
        this.velocidade_vento = velocidade_vento;
    }

    public float getAltitude_maxima() {
        return altitude_maxima;
    }

    public void setAltitude_maxima(float altitude_maxima) {
        this.altitude_maxima = altitude_maxima;
    }

    public float getVelocidade_maxima() {
        return velocidade_maxima;
    }

    public void setVelocidade_maxima(float velocidade_maxima) {
        this.velocidade_maxima = velocidade_maxima;
    }

    public float getPico_acelaracao() {
        return pico_acelaracao;
    }

    public void setPico_acelaracao(float pico_acelaracao) {
        this.pico_acelaracao = pico_acelaracao;
    }

    public float getAceleracao_media() {
        return aceleracao_media;
    }

    public void setAceleracao_media(float aceleracao_media) {
        this.aceleracao_media = aceleracao_media;
    }

    public float getTempo_apogeu_descida() {
        return tempo_apogeu_descida;
    }

    public void setTempo_apogeu_descida(float tempo_apogeu_descida) {
        this.tempo_apogeu_descida = tempo_apogeu_descida;
    }

    public float getTempo_ejecao() {
        return tempo_ejecao;
    }

    public void setTempo_ejecao(float tempo_ejecao) {
        this.tempo_ejecao = tempo_ejecao;
    }

    public float getAltitude_ejecao() {
        return altitude_ejecao;
    }

    public void setAltitude_ejecao(float altitude_ejecao) {
        this.altitude_ejecao = altitude_ejecao;
    }

    public float getTaxa_descida() {
        return taxa_descida;
    }

    public void setTaxa_descida(float taxa_descida) {
        this.taxa_descida = taxa_descida;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    
    
}
