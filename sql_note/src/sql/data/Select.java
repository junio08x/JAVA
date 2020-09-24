/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author junio
 */
public class Select {
   public static void main(String[] args) {
  Connect conexao = new Connect();
  conexao.conectar();
  String sql;
  sql = "Select * from epg where emp_codigo = ?";
  
  try {
      PreparedStatement stmt = conexao.conexao.prepareStatement(sql);
      
      ResultSet rs = stmt.executeQuery();
      while(rs.next()){
          String empresa = rs.getString("emp_codigo");
          String matricula = rs.getString("codigo");
          String nome = rs.getString("nome");
          System.out.println("Empresa: "+empresa + " Matricula: " + matricula + " Nome: " + nome);
          
      }
//      pst.setInt(1, 432); //para insert
//      pst.setString(2, "max");//para insert
//      ResultSet rs = stmt.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta Realizada com Sucesso!");
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro na consulta!\nErro: " + ex.getMessage());
    }
  }
    
}
