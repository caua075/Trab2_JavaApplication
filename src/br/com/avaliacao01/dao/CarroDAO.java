package br.com.avaliacao01.dao;

import java.sql.*;
import br.com.avaliacao01.dto.CarroDTO;
import br.com.avaliacao01.dto.LocadoraDTO;

public class CarroDAO {
    
    public CarroDAO(){}
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    String comando = "";
    
    
// ------------------------ Método de Inserir ----------------------------------    
    
    public boolean inserirCarro(CarroDTO cdto, LocadoraDTO ldto){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            
            comando = "INSERT INTO carro (nome, marca, cor, placa, chassi, id_loc"
                    + ") VALUES ("
                    + "'" +cdto.getNome()+ "', "
                    + "'" +cdto.getMarca()+ "', "
                    + "'" +cdto.getCor()+ "', "
                    + "'" +cdto.getPlaca()+ "', "
                    + "'" +cdto.getChassi()+ "', "
                    + ldto.getId_loc() + ")";
            
            stmt.execute(comando.toUpperCase());
            
            ConnectDB.con.commit();
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println("Error 03: "+ e.getMessage()+
                    "Código incorreto na SQL de Cadastro");
            return false;
        }
        finally{
            ConnectDB.closeDB();
        }
    }
    
// ------------------------ Método de Consultar --------------------------------
    
    public ResultSet consultarCarro(CarroDTO cdto, int opc){
        try{
            ConnectDB.openDB();
            
            stmt = ConnectDB.con.createStatement();
            
            switch (opc) {
                case 1:
                    comando = "SELECT c.* FROM carro c WHERE c.nome ILIKE '" + 
                            cdto.getNome() + "%' ORDER BY c.nome";
                    break;
                case 2:
                    comando = "SELECT c.*, l.nome_loc, l.id_loc"
                            + " FROM carro c, locadora l WHERE c.id_loc = l.id_loc"
                            + " AND c.id = " + cdto.getId();
                    break;
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
            
        }catch(Exception e){
            System.out.println("Error 04: "+ e.getMessage()+
                    "Código incorreto na SQL de Consulta");
            return rs;
        }
    }
    
// ------------------------ Método de Alterar ----------------------------------
    
    public boolean alterarCarro(CarroDTO cdto, LocadoraDTO ldto){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            
            comando = "UPDATE carro SET "
                    + "nome = '" +cdto.getNome()+ "', "
                    + "marca = '" +cdto.getMarca()+ "', "
                    + "cor = '" +cdto.getCor()+ "', "
                    + "placa = '" +cdto.getPlaca()+ "', "
                    + "chassi = '" +cdto.getChassi()+ "',"
                    + "id_loc = " +ldto.getId_loc() + " WHERE id = "
                    + cdto.getId();
            
            stmt.execute(comando.toUpperCase());
            
            ConnectDB.con.commit();
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println("Error 06: "+ e.getMessage()+
                    "Código incorreto na SQL de Alterar");
            return false;
        }
        finally{
            ConnectDB.closeDB();
        }
    }
    
// ------------------------ Método de Excluir ----------------------------------
    public boolean excluirCarro(CarroDTO cdto){
        try{
            ConnectDB.openDB();
            stmt = ConnectDB.con.createStatement();
            
            comando = "DELETE FROM carro WHERE id = " + cdto.getId();
            
            stmt.execute(comando);
            ConnectDB.con.commit();
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println("Error 06: "+ e.getMessage() + "Código incorreto na SQL de Excluir");
            return false;
        }
        finally{
            ConnectDB.closeDB();
        }
    }
}
