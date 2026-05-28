package model;

public class Propietario {
    private int idPropietario;
    private int idCasa;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String fechaRegistro;

    public Propietario(int idCasa, String nombre, String apellido, String telefono, String correo) {
        this.idCasa = idCasa;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Propietario(int idPropietario, int idCasa, String nombre, String apellido,
                       String telefono, String correo, String fechaRegistro) {
        this.idPropietario = idPropietario;
        this.idCasa = idCasa;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdPropietario() { return idPropietario; }
    public void setIdPropietario(int idPropietario) { this.idPropietario = idPropietario; }

    public int getIdCasa() { return idCasa; }
    public void setIdCasa(int idCasa) { this.idCasa = idCasa; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(String fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (Casa " + idCasa + ")";
    }
}
