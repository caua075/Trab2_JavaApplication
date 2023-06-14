package br.com.avaliacao01.dao;

import br.com.avaliacao01.dto.ClienteDTO;
import java.sql.*;

public class ClienteDAO {
    
    public ClienteDAO(){}
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirCliente(ClienteDTO cdto){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            
            String comando = "INSERT INTO cliente(nome_cli, cpf_cli, rua_cli, "
                    + "num_cli, bairro_cli, cep_cli, cidade_cli, estado_cli) "
                    + "VALUES ("
                    + "'" + cdto.getNome_cli() + "', "
                    + "'" + cdto.getCpf_cli() + "', "
                    + "'" + cdto.getRua_cli() + "', "
                    + cdto.getNum_cli() + ", "
                    + "'" + cdto.getBairro_cli() + "', "
                    + "'" + cdto.getCep_cli() + "', "
                    + "'" + cdto.getCidade_cli() + "', "
                    + "'" + cdto.getEstado_cli() + "')";
            
            stmt.execute(comando.toUpperCase());
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
    
    public boolean alterarCliente(ClienteDTO cdto){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            
            String comando = "UPDATE cliente SET "
                    + "nome_cli = '" + cdto.getNome_cli() + "', "
                    + "cpf_cli = '" + cdto.getCpf_cli() + "', "
                    + "rua_cli = '" + cdto.getRua_cli() + "', "
                    + "num_cli = " + cdto.getNum_cli() + ", "
                    + "bairro_cli = '" + cdto.getBairro_cli() + "', "
                    + "cep_cli = '" + cdto.getCep_cli() + "', "
                    + "cidade_cli = '" + cdto.getCidade_cli() + "', "
                    + "estado_cli = '" + cdto.getEstado_cli() + "' "
                    + "WHERE id_cli = " + cdto.getId_cli();
            
            stmt.execute(comando.toUpperCase());
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
    
    public boolean excluirCliente(ClienteDTO cdto){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            
            String comando = "DELETE FROM cliente WHERE id_cli = " +
                            cdto.getId_cli();
            
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
    
    public ResultSet consultarCliente(ClienteDTO cdto, int opc){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            String comando = "";
            
            switch (opc) {
                case 1:
                    comando = "SELECT c.* FROM cliente c WHERE c.nome_cli LIKE '"
                            + cdto.getNome_cli() + "%' ORDER BY c.nome_cli";
                break;
                case 2:
                    comando = "SELECT c.* FROM cliente c WHERE id_cli = " +
                            cdto.getId_cli();
                break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
    public void closeDB(){
        ConnectDB.closeDB();
    }
}
