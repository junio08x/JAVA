/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobd2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sql.data.Connect;

/**
 *
 * @author junio
 */
public class ConnectBD2 { //Responsavel pela conexão com o BD 2
    public Statement stm; // Responsavel por preparar e realizar pesquisas no banco de dados;
    public ResultSet rs; // Responsavel por armazenar o resultado de um pesquisa passada para o statement;
    private final String driver = "net.sourceforge.jtds.jdbc.Driver";
    private final String caminho = "jdbc:jtds:sqlserver://localhost:1433/AC_HSM"; // O "AC_OBJETIVO" representa a minha database 
    private final String usuario = "sa";
    private final String senha = "Sa123";
    public Connection conexao; // Responsavel por realizar a conexão com o banco de dados;
    
    public void conectar2() { // Metodo responsavel por realizar a conexão;
        try {
            System.setProperty("jdbc.Drivers", driver); // Seta a propriedade do driver de conexão;
            conexao = DriverManager.getConnection(caminho, usuario, senha); // Realiza a conexão com o banco;
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!", "AC_OBJETIVO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de conexão!\nERRO: " + ex.getMessage(), "AC_HSM", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void desconectar() { // Metodo responsavel por fechar a conexão
        try {
            conexao.close(); // Fechar conexão
            JOptionPane.showMessageDialog(null, "Conexão fechada com sucesso!", "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\nERRO: " + ex.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

    

