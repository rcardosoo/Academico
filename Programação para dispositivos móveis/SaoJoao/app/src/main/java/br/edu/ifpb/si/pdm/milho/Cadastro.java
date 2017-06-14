package br.edu.ifpb.si.pdm.milho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 05/06/17.
 */

public class Cadastro {
    private List<Gasto> gastos;

    public Cadastro(){
        this.gastos = new ArrayList<Gasto>();
    }

    public void add(Gasto gasto){
        this.gastos.add(gasto);
    }

    public float getTotal(){
        float soma = 0;
        for (Gasto g: this.gastos) {
            soma += g.getTotal();
        }
        return soma;
    }

    public List<Gasto> getGastos() {
        return this.gastos;
    }

    public Gasto getGastoPosicao(int p) {
        return gastos.get(p);
    }

    public int getQuantidade() {
        return this.gastos.size();
    }

    public String toString() {
        return "Total: "+this.getTotal();
    }
}
