/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fiap.dao;

import br.fiap.conexao.Conexao;
import br.fiap.model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author paesv
 */
public class AdminDAO {
        private Connection connection;
        private PreparedStatement p;
        private ResultSet rs;
        private String sql;
        
        public boolean adminLogin(Admin admin){
            boolean status = false;
            
            sql = "SELECT * FROM am_admin WHERE username = ? AND password = ?";
            
            try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setString(1, admin.getUsername());
            p.setString(2, admin.getPassword());
            rs = p.executeQuery();
            if(rs.next()){
                status = true;
            }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            return status;
        }
        
        public boolean deletarGrupo(String grupo){
            boolean status = false;
            
            sql = "DELETE FROM am_grupos WHERE nome = ?";
            String sql2 = "DELETE FROM am_alunos where nome_grupo = ?";
            
            try {
            connection = Conexao.getConnection();
            //connection.setAutoCommit(false); 
            p = connection.prepareStatement(sql);
            p.setString(1, grupo);
            rs = p.executeQuery();
            
            p = connection.prepareStatement(sql2);
            p.setString(1, grupo);
            rs = p.executeQuery();
            
            status = true;
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            return status;
        }
        
        public boolean resetarDados(){
            boolean status = false;
            
            sql = "TRUNCATE TABLE am_alunos";
            
            try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            rs = p.executeQuery();
            if(rs.next()){
                status = true;
            }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            return status;
        }
}
