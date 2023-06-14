package br.com.avaliacao01.ctr;

import br.com.avaliacao01.dao.ConnectDB;
import br.com.avaliacao01.dao.LocadoraDAO;
import br.com.avaliacao01.dto.LocadoraDTO;
import java.sql.ResultSet;
public class LocadoraCTR {
    LocadoraDAO ldao = new LocadoraDAO();
    
    public LocadoraCTR(){}
    
    public String inserirLocadora(LocadoraDTO ldto){
        try{
            if(ldao.inserirLocadora(ldto)){
                return "Locadora cadastrada com sucesso!";
            }
            else{
                return "Locadora não cadastrada";
            }
        }catch(Exception e){
            System.out.println("Error 03: "+ e.getMessage());
            return "Locadora não Cadastrado";
        }
    }
    
    public ResultSet consultarLocadora(LocadoraDTO ldto, int opc){
        ResultSet rs = null;
        rs = ldao.consultarLocadora(ldto, opc);
        return rs;
    }
    
    public void closeDB(){
        ConnectDB.closeDB();
    }
    
    public String alterarLocadora(LocadoraDTO ldto){
        try{
            if(ldao.alterarLocadora(ldto)){
                return "Locadora alterada com sucesso!";
            }
            else{
                return "Locadora não alterada";
            }
        }catch(Exception e){
            System.out.println("Error 03: "+ e.getMessage());
            return "Locadora não alterada";
        }
    }
    
    public String excluirLocadora(LocadoraDTO ldto){
        try{
            if(ldao.excluirLocadora(ldto)){
                return "Locadora excluída com sucesso!";
            }
            else{
                return "Locadora não excluída";
            }
        }catch(Exception e){
            System.out.println("Error 03: "+ e.getMessage());
            return "Locadora não excluída";
        }
    }
}
