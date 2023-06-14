package br.com.avaliacao01.ctr;

import br.com.avaliacao01.dao.ConnectDB;
import br.com.avaliacao01.dao.FuncionarioDAO;
import br.com.avaliacao01.dto.FuncionarioDTO;
import java.sql.ResultSet;


public class FuncionarioCTR {
    
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    public FuncionarioCTR(){}
    
    public String inserirFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            if(funcionarioDAO.inserirFuncionario(funcionarioDTO))
                return "Funcionário Cadastrado com Sucesso!";
            else
                return "Funcionário não Cadastrado!";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Funcionário não Cadastrado";
        }
    }
    
    public String alterarFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            if(funcionarioDAO.alterarFuncionario(funcionarioDTO))
                return "Funcionário Alterado com Sucesso!";
            else
                return "Funcionário não Alterado!";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Funcionário não Alterado";
        }
    }
    
    public String excluirFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            if(funcionarioDAO.excluirFuncionario(funcionarioDTO))
                return "Funcionário Excluído com Sucesso!";
            else
                return "Funcionário não Excluído!";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Funcionário não Excluído";
        }
    }
    
    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opc){
        ResultSet rs = null;
        
        rs = funcionarioDAO.consultarFuncionario(funcionarioDTO, opc);
        
        return rs;
    }
    
    public String logarFuncionario(FuncionarioDTO funcionarioDTO){
        return funcionarioDAO.logarFuncionario(funcionarioDTO);
    }
    
    public void closeDB(){
        ConnectDB.closeDB();
    }
}
