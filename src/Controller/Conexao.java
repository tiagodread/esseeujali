package Controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class Conexao {

    private static java.sql.Connection conexao; //Cria a variável conexao do tipo Connection

    private void conectar() {

        if (conexao == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver"); //carrega os drivers do mysql na memoria
                //abaixo: contato é o nome do banco; O usuário do banco é root e no caso está sem senha, por isso password está vazio
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/esseeujali?user=root&password="); //estabelece a conexao
            } catch (Exception e) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão com o banco de dados!");
            }

        }
    }

    public void executarSql(String sql) {
        try {
            conectar();// Faz a conexão
            Statement stmt = conexao.createStatement(); // Cria a variável do tipo Statement, permitindo a execução de um comando SQL
            stmt.executeUpdate(sql); //execução do comando SQL
            System.out.println("SQL EXECUTADA: " + sql); //exibe a sql executada
            stmt.close(); //fecha a sentença
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executarConsulta(String sql) { //ResultSet -> Conjunto de resultados
        try {
            conectar(); //Faz a conexão
            Statement stmt = conexao.createStatement(); // Cria a variável do tipo Statement, permitindo a execução de um comando SQL
            ResultSet rs = stmt.executeQuery(sql); //Cria uma variável do tipo ResultSet que irá guardar os resultados da execução SQL (executeQuery)
            return rs; //retorna o conjunto de resultados da consulta
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
