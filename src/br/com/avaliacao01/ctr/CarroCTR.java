package br.com.avaliacao01.ctr;

import java.sql.ResultSet;
import br.com.avaliacao01.dao.CarroDAO;
import br.com.avaliacao01.dao.ConnectDB;
import br.com.avaliacao01.dto.CarroDTO;
import br.com.avaliacao01.dto.LocadoraDTO;

public class CarroCTR {
    CarroDAO cdao = new CarroDAO();
    
    public String inserirCarro(CarroDTO cdto, LocadoraDTO ldto){
        try{
            if(cdao.inserirCarro(cdto, ldto)){
                return "Carro cadastrado com sucesso!";
            }
            else{
                return "Carro não cadastrado";
            }
        }catch(Exception e){
            System.out.println("Error 03: "+ e.getMessage());
            return "Carro não Cadastrado";
        }
    }
    
    public ResultSet consultarCarro(CarroDTO cdto, int opc){
        ResultSet rs = null;
        rs = cdao.consultarCarro(cdto, opc);
        return rs;
    }
    
    public void closeDB(){
        ConnectDB.closeDB();
    }
    
    public String alterarCarro(CarroDTO cdto, LocadoraDTO ldto){
        try{
            if(cdao.alterarCarro(cdto, ldto)){
                return "Carro alterado com sucesso!";
            }
            else{
                return "Carro não alterado";
            }
        }catch(Exception e){
            System.out.println("Error 03: "+ e.getMessage());
            return "Carro não alterado";
        }
    }
    
    public String excluirCarro(CarroDTO cdto){
        try{
            if(cdao.excluirCarro(cdto)){
                return "Carro excluído com sucesso!";
            }
            else{
                return "Carro não excluído";
            }
        }catch(Exception e){
            System.out.println("Error 03: "+ e.getMessage());
            return "Carro não excluído";
        }
    }
}
