package br.com.avaliacao01.dao;

import br.com.avaliacao01.dto.AluguelDTO;
import br.com.avaliacao01.dto.CarroDTO;
import br.com.avaliacao01.dto.ClienteDTO;
import java.sql.*;
import java.text.SimpleDateFormat;

public class AluguelDAO {
    
    public AluguelDAO(){}
    
    Statement stmt = null;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    
    public boolean inserirAluguel(AluguelDTO aluguelDTO, ClienteDTO clienteDTO, CarroDTO carroDTO){
        try{
            ConnectDB.openDB();
            
            stmt = ConnectDB.con.createStatement();
            
            String comando = "INSERT INTO alugaCarro(dta_loc, vlr_alu, id_cli, id_car)"
                    + " VALUES ("
                    + "TO_DATE('" + date.format(aluguelDTO.getDta_loc()) + "', 'DD/MM/YYYY'), "
                    + aluguelDTO.getVlr_alu() + ", "
                    + clienteDTO.getId_cli() + ", "
                    + carroDTO.getId() + ")";
            
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
}
