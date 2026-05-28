package model;

public class Casa {
    private int idCasa;
    private String ubicacion;
    private boolean disponible;

    public Casa(int idCasa, String ubicacion, boolean disponible) {
        this.idCasa = idCasa;
        this.ubicacion = ubicacion;
        this.disponible = disponible;
    }

    public int getIdCasa() { return idCasa; }
    public void setIdCasa(int idCasa) { this.idCasa = idCasa; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "Casa " + idCasa + " - " + (disponible ? "Disponible" : "Ocupada");
    }
}