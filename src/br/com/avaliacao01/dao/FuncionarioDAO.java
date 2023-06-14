package br.com.avaliacao01.dao;

import br.com.avaliacao01.dto.FuncionarioDTO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


public class FuncionarioDAO {
    
    public FuncionarioDAO(){}
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            ConnectDB.openDB();
            
            stmt = ConnectDB.con.createStatement();
            
            String comando = "INSERT INTO funcionario(nome_fun, login_fun, senha_fun, tipo_fun)"
                    + "VALUES ("
                    + "'" + funcionarioDTO.getNome_fun().toUpperCase() + "', "
                    + "'" + funcionarioDTO.getLogin_fun()+ "', "
                    + "'" + criptografar(funcionarioDTO.getSenha_fun())+ "', "
                    + "'" + funcionarioDTO.getTipo_fun().toUpperCase()+ "' "
                    + ")";
            
            stmt.execute(comando);
            ConnectDB.con.commit();
            stmt.close();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            ConnectDB.closeDB();
        }
    }
    
    public boolean alterarFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            String comando = "";
            
            comando = "UPDATE funcionario SET "
                    + "nome_fun = '" + funcionarioDTO.getNome_fun().toUpperCase() + "', "
                    + "login_fun = '" + funcionarioDTO.getLogin_fun() + "', ";
            
            if(funcionarioDTO.getSenha_fun() != null){
                    comando+= "senha_fun = '" + criptografar(funcionarioDTO.getSenha_fun()) + "', ";
            }
            comando += "tipo_fun = '" + funcionarioDTO.getTipo_fun() + "' "
                    + "WHERE id_fun = " + funcionarioDTO.getId_fun();
            
            stmt.execute(comando);
            ConnectDB.con.commit();
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            ConnectDB.closeDB();
        }
    }
    
    public boolean excluirFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            
            String comando = "DELETE FROM funcionario WHERE id_fun = "
                    + funcionarioDTO.getId_fun();
            
            stmt.execute(comando);
            ConnectDB.con.commit();
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            ConnectDB.closeDB();
        }
    }
    
    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opc){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            
            String comando = "";
            
            switch(opc){
                case 1:
                    comando = "SELECT f.* FROM funcionario f WHERE nome_fun ILIKE '"
                            + funcionarioDTO.getNome_fun() + "%' ORDER BY f.nome_fun";
                break;
                case 2:
                    comando = "SELECT f.* FROM funcionario f WHERE f.id_fun = "
                            +funcionarioDTO.getId_fun();
                break;
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
    public String logarFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            
            String comando = "SELECT f.tipo_fun FROM funcionario f WHERE "
                    + "f.login_fun = '" + funcionarioDTO.getLogin_fun() + "' "
                    + "AND f.senha_fun = '" + criptografar(funcionarioDTO.getSenha_fun()) + "'";
            
            rs = null;
            rs = stmt.executeQuery(comando);
            if(rs.next()){
                return rs.getString("tipo_fun");
            }else{
                return "";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "";
        }finally{
            ConnectDB.closeDB();
        }
    }
    
    private static MessageDigest md = null;
    
    static {
        try{
            md = MessageDigest.getInstance("MD5");
        }catch(NoSuchAlgorithmException ex){
            ex.printStackTrace();
        }
    }
    
    private static char[] hexCodes(byte[] text){
        char[] hexOutput = new char[text.length * 3];
        String hexString;
        
        for(int i=0; i<text.length; i++){
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length()-3, hexString.length(), hexOutput, i*3);
        }
        return hexOutput;
    }
    
    private static String criptografar(String pwd){
        if(md != null){
            return new String(hexCodes(md.digest(pwd.getBytes())));
        }
        return null;
    }
}
