package cl.bice.sampleapp.model;

import lombok.Data;

@Data
public class Indice {

    private Currency cobre;
    private Currency dolar;
    private Currency euro;
    private Currency ipc;
    private Currency ivp;
    private Currency oro;
    private Currency plata;
    private Currency uf;
    private Currency utm;
    private Currency yen;

    public Indice(){
        this.cobre = new Currency();
        this.cobre.setUnit("dolar");
    }
}
