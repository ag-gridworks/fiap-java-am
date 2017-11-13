/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fiap.dao;

import br.fiap.conexao.Conexao;
import br.fiap.model.Aluno;
import br.fiap.model.Foguete;
import br.fiap.model.Grupo;
import br.fiap.model.Lancamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author paesv
 */
public class DashboardDAO {
        private Connection connection;
        private PreparedStatement p;
        private ResultSet rs;
        private String sql;
    
    // Metodos de registro
        
    public boolean registrarAluno(Aluno aluno){
         boolean status = false;
        sql = "insert into am_alunos(nome, rm, nome_grupo) values(?,?,?)";
        
        try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            
            p.setString(1, aluno.getNome());
            p.setInt(2, aluno.getRm());
            p.setString(3, aluno.getGrupo());
            p.execute();
            status = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
        
        return status;
    }
    
    public boolean deletarAluno(int rm){
        boolean status = false;
        sql = "DELETE FROM am_alunos WHERE rm = ?";
        
       try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setInt(1, rm);
            p.executeUpdate();
            status = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
        
        return status;
    }
        
    public boolean registrarGrupo(Grupo grupo){
        boolean status = false;
        sql = "insert into am_grupos(nome, turma) values(?,?)";
        
       try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            
            p.setString(1, grupo.getNome());
            p.setString(2, grupo.getTurma());
            p.execute();
            status = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
        
        return status;
    } 
    
    public boolean registrarFoguete(Foguete foguete, String nomeGrupo){
        boolean status = false;
        
        sql = "insert into am_foguetes(nome, peso, nome_grupo) values(?,?,?)";
        String sql2 = "UPDATE am_grupos SET foguete_status = 1 WHERE nome = ?";
        
       try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            
            p.setString(1, foguete.getNome());
            p.setFloat(2, foguete.getPeso());
            p.setString(3, foguete.getNome_grupo());
            p.execute();
            status = true;
            
            p = connection.prepareStatement(sql2);
            p.setString(1, nomeGrupo);
            p.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
        
        return status;
    }
    
    public boolean editarFoguete(Foguete foguete){
        boolean status = false;
        
        sql = "UPDATE am_foguetes SET nome = ?, peso = ?";
       
        
       try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            
            p.setString(1, foguete.getNome());
            p.setFloat(2, foguete.getPeso());
            p.executeUpdate();
            status = true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
        
        return status;
    }
    
    public boolean registrarLancamento(Lancamento lancamento){
        boolean status = false;
        sql = "INSERT INTO am_lancamentos ("
                + "distancia, angulo, velocidade_vento, altitude_maxima, velocidade_maxima, pico_acelaracao, aceleracao_media, tempo_apogeu_descida, altitude_ejecao, taxa_descida, duracao"
                + ")"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setFloat(1, lancamento.getDistancia());
            p.setFloat(2, lancamento.getAngulo());
            p.setFloat(3, lancamento.getVelocidade_vento());
            p.setFloat(4, lancamento.getAltitude_maxima());
            p.setFloat(5, lancamento.getVelocidade_maxima());
            p.setFloat(6, lancamento.getPico_acelaracao());
            p.setFloat(7, lancamento.getAceleracao_media());
            p.setFloat(8, lancamento.getTempo_apogeu_descida());
            p.setFloat(9, lancamento.getAltitude_ejecao());
            p.setFloat(10, lancamento.getTaxa_descida());
            p.setFloat(11, lancamento.getDuracao());
            p.executeUpdate();
            status = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
        
        return status;
    }
    
    
    // Metodos de Pesquisa
    
    public Grupo pesquisarGrupo(String nome){
        
        sql = "SELECT * from am_grupos WHERE nome = ?";
        
        Grupo grupo = new Grupo();

        try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setString(1, nome);
            rs = p.executeQuery();
            if(rs.next()){
                String nome_grupo = rs.getString("nome");
                String turma = rs.getString("turma");
                
                grupo.setNome(nome_grupo);
                grupo.setTurma(turma);
            } else {
                grupo = null;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return grupo;
    }
    
    public Foguete pesquisarFoguete(String nomeGrupo){
         sql = "SELECT * from am_foguetes WHERE nome_grupo = ?";
        
        Foguete foguete = new Foguete();

        try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setString(1, nomeGrupo);
            rs = p.executeQuery();
            if(rs.next()){
                String nome = rs.getString("nome");
                float peso = rs.getFloat("peso");
                
                System.out.println(nome+" "+peso);
                
                foguete.setNome(nome);
                foguete.setPeso(peso);
                foguete.setNome_grupo(nomeGrupo);
               
            } else {
                foguete = null;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return foguete;
    }
    
    public int checarFoguete(String grupo){
        int status = 0;
        
        sql = "SELECT foguete_status from am_grupos WHERE nome = ?";
        

        try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setString(1, grupo);
           
            rs = p.executeQuery();
            if(rs.next()){
                status = rs.getInt("foguete_status");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return status;
    }
    
    // Metodos de Preencimento
    
    public List<Aluno> preencherTabela(int id_grupo){
        
        sql = "select * from am_alunos WHERE id_grupo = ?";
        
        System.out.print(id_grupo);
        
        List<Aluno> alunos = new ArrayList<>();
        
        try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setInt(1, id_grupo);
            rs = p.executeQuery();
           
            while(rs.next()){
                Aluno aluno = new Aluno();
                
                aluno.setNome(rs.getString("nome"));
                aluno.setRm(rs.getInt("rm"));
                
                alunos.add(aluno);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } 
        
        return alunos;
    }
}
