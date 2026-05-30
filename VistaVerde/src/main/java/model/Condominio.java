package model;

import java.util.ArrayList;

public class Condominio {

    private ArrayList<Casa> casas;

    public Condominio() {
        casas = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            // Inicialmente todas las casas están libres (ocupada = false, idPropietario = 0)
            casas.add(new Casa(i, false, 0));
        }
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public Casa buscarCasa(int idCasa) {
        for (Casa c : casas) {
            if (c.getIdCasa() == idCasa) {
                return c;
            }
        }
        return null;
    }
}
