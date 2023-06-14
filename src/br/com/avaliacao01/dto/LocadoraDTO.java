package br.com.avaliacao01.dto;


public class LocadoraDTO {
    private String cnpj_loc, nome_loc, tel_loc, rua_loc, bairro_loc, cidade_loc;
    private int num_loc, id_loc;

    public int getId_loc() {
        return id_loc;
    }

    public void setId_loc(int id_loc) {
        this.id_loc = id_loc;
    }

    public String getCnpj_loc() {
        return cnpj_loc;
    }

    public void setCnpj_loc(String cnpj_loc) {
        this.cnpj_loc = cnpj_loc;
    }

    public String getNome_loc() {
        return nome_loc;
    }

    public void setNome_loc(String nome_loc) {
        this.nome_loc = nome_loc;
    }

    public String getTel_loc() {
        return tel_loc;
    }

    public void setTel_loc(String tel_loc) {
        this.tel_loc = tel_loc;
    }

    public String getRua_loc() {
        return rua_loc;
    }

    public void setRua_loc(String rua_loc) {
        this.rua_loc = rua_loc;
    }

    public String getBairro_loc() {
        return bairro_loc;
    }

    public void setBairro_loc(String bairro_loc) {
        this.bairro_loc = bairro_loc;
    }

    public String getCidade_loc() {
        return cidade_loc;
    }

    public void setCidade_loc(String cidade_loc) {
        this.cidade_loc = cidade_loc;
    }

    public int getNum_loc() {
        return num_loc;
    }

    public void setNum_loc(int num_loc) {
        this.num_loc = num_loc;
    }
}
