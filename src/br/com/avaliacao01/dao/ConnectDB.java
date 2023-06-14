package br.com.avaliacao01.dao;
import java.sql.*;

public class ConnectDB {
    
    public static Connection con = null;
    
    public ConnectDB(){}
    
    public static void openDB(){
        try{
            String nomeBD = "carro";
            String usuario = "seuUsuario";
            String senha = "suaSenha";
            
            //DriverManager.registerDriver(new org.postgresql.Driver());
            
            String url = "jdbc:postgresql://localhost:5432/"+nomeBD;
            
            con = DriverManager.getConnection(url, usuario, senha);
            
            con.setAutoCommit(false);
            
            if(con == null){
                System.out.println("Falha ao conectar com o Banco");
            }
            
        }catch(Exception e){
            System.out.println("Error 01:"+ e.getMessage()+
                    "\nFalha ao abrir a base de dados: ");
        }
    }
    
    
    public static void closeDB(){
        try{
            con.close();
        }catch(Exception e){
            System.out.println("Error 02:"+ e.getMessage()+
                    "\nFalha ao abrir a fechar de dados: ");
        }
    }
}
