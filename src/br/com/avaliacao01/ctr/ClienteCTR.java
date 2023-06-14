package br.com.avaliacao01.ctr;

import br.com.avaliacao01.dao.ClienteDAO;
import br.com.avaliacao01.dao.ConnectDB;
import br.com.avaliacao01.dto.ClienteDTO;
import java.sql.ResultSet;


public class ClienteCTR {
    
    ClienteDAO clienteDAO = new ClienteDAO();
    
    public ClienteCTR(){}
    
    public String inserirCliente(ClienteDTO cdto){
        try{
            if(clienteDAO.inserirCliente(cdto)){
                return "Cliente cadastrado com sucesso!";
            }
            else{
                return "Cliente não cadastrado";
            }
        }catch(Exception e){
            System.out.println("Error 03: "+ e.getMessage());
            return "Cliente não Cadastrado";
        }
    }
    
    public ResultSet consultarCliente(ClienteDTO cdto, int opc){
        ResultSet rs = null;
        rs = clienteDAO.consultarCliente(cdto, opc);
        return rs;
    }
    
    public void closeDB(){
        ConnectDB.closeDB();
    }
    
    public String alterarCliente(ClienteDTO cdto){
        try{
            if(clienteDAO.alterarCliente(cdto)){
                return "Cliente alterado com sucesso!";
            }
            else{
                return "Cliente não alterado";
            }
        }catch(Exception e){
            System.out.println("Error 03: "+ e.getMessage());
            return "Cliente não alterado";
        }
    }
    
    public String excluirCliente(ClienteDTO cdto){
        try{
            if(clienteDAO.excluirCliente(cdto)){
                return "Cliente excluído com sucesso!";
            }
            else{
                return "Cliente não excluído";
            }
        }catch(Exception e){
            System.out.println("Error 03: "+ e.getMessage());
            return "Cliente não excluído";
        }
    }
}
