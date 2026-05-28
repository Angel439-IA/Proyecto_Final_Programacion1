package model;

import java.util.ArrayList;

public class Condominio {
    private ArrayList<Casa> casas;

    public Condominio() {
        casas = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            casas.add(new Casa(i, "Casa " + i, true));
        }
    }

    public ArrayList<Casa> getCasas() { return casas; }

    public Casa buscarCasa(int idCasa) {
        for (Casa c : casas) {
            if (c.getIdCasa() == idCasa) return c;
        }
        return null;
    }
}