package br.com.avaliacao01.dao;

import br.com.avaliacao01.dto.LocadoraDTO;
import java.sql.*;

public class LocadoraDAO {
    
    public LocadoraDAO(){}
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirLocadora(LocadoraDTO ldto){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            
            String comando  = "INSERT INTO locadora(cnpj_loc, nome_loc, rua_loc,"
                    + "num_loc, bairro_loc, cidade_loc, tel_loc) VALUES ("
                    + "'" + ldto.getCnpj_loc() + "', "
                    + "'" + ldto.getNome_loc() + "', "
                    + "'" + ldto.getRua_loc() + "', "
                    + ldto.getNum_loc() + ", "
                    + "'" + ldto.getBairro_loc() + "', "
                    + "'" + ldto.getCidade_loc() + "', "
                    + "'" + ldto.getTel_loc() + "')";
            
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
    
    public boolean alterarLocadora(LocadoraDTO ldto){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            
            String comando = "UPDATE locadora SET "
                    + "cnpj_loc = '" + ldto.getCnpj_loc() + "', "
                    + "nome_loc = '" + ldto.getNome_loc() + "', "
                    + "rua_loc = '" + ldto.getRua_loc() + "', "
                    + "num_loc = " + ldto.getNum_loc() + ", "
                    + "bairro_loc = '" + ldto.getBairro_loc() + "', "
                    + "cidade_loc = '" + ldto.getCidade_loc() + "', "
                    + "tel_loc = '" + ldto.getTel_loc() + "' "
                    + "WHERE id_loc = " + ldto.getId_loc();
            
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
    
    public boolean excluirLocadora(LocadoraDTO ldto){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            
            String comando = "DELETE FROM locadora WHERE id_loc = "
                            + ldto.getId_loc();
            
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
    
    public ResultSet consultarLocadora(LocadoraDTO ldto, int opc){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            String comando = "";
            
            switch(opc){
                case 1:
                    comando = "SELECT l.id_loc, l.nome_loc FROM locadora l "
                            + "WHERE l.nome_loc ILIKE '" + ldto.getNome_loc() + "%' "
                            + "ORDER BY l.nome_loc";
                break;
                case 2:
                    comando = "SELECT * FROM locadora l WHERE l.id_loc = "
                            + ldto.getId_loc();
                break;
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }
}
