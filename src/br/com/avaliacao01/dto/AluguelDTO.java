package br.com.avaliacao01.dto;

import java.util.Date;

public class AluguelDTO {
    private double vlr_alu;
    private Date dta_loc;

    public double getVlr_alu() {
        return vlr_alu;
    }

    public void setVlr_alu(double vlr_alu) {
        this.vlr_alu = vlr_alu;
    }

    public Date getDta_loc() {
        return dta_loc;
    }

    public void setDta_loc(Date dta_loc) {
        this.dta_loc = dta_loc;
    }
}
