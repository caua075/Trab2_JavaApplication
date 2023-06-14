package br.com.avaliacao01.ctr;

import br.com.avaliacao01.dao.AluguelDAO;
import br.com.avaliacao01.dao.ConnectDB;
import br.com.avaliacao01.dto.AluguelDTO;
import br.com.avaliacao01.dto.CarroDTO;
import br.com.avaliacao01.dto.ClienteDTO;


public class AluguelCTR {
    AluguelDAO aluguelDAO = new AluguelDAO();
    
    public AluguelCTR(){}
    
    public String inserirAluguel(AluguelDTO aluguelDTO, ClienteDTO clienteDTO, CarroDTO carroDTO){
        try{
            if(aluguelDAO.inserirAluguel(aluguelDTO, clienteDTO, carroDTO)){
                return "Aluguel Bem Sucedido!";
            }
            else{
                return "Aluguel Mal Sucedido";
            }
        }catch(Exception e){
            System.out.println("Error 03: "+ e.getMessage());
            return "Aluguel não Cadastrado";
        }
    }
    
    public void closeDB(){
        ConnectDB.closeDB();
    }
}
