/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
 
/**
 *
 * @author d4nil
 */
public class Pago {
    
  private int idPago;
    private int idCasa;
    private int idPropietario;
    private int mes;
    private int anio;
    private double montoPagado;
    private String fechaPago;
    private int idCuota;
    private int pagoTardio;
    
    public Pago(int idCasa, int idPropietario, int mes, int anio,
                double montoPagado, String fechaPago, int idCuota, int pagoTardio){
        this.idCasa = idCasa;
        this.idPropietario = idPropietario;
        this.mes = mes;
        this.anio = anio;
        this.montoPagado = montoPagado;
        this.fechaPago = fechaPago;
        this.idCuota = idCuota;
        this.pagoTardio = pagoTardio;    
    }

    public Pago(int mes, int anio, double monto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdPago() { return idPago; }
    public void setIdPago(int idPago) { this.idPago = idPago; }

    public int getIdCasa() { return idCasa; }
    public void setIdCasa(int idCasa) { this.idCasa = idCasa; }

    public int getIdPropietario() { return idPropietario; }
    public void setIdPropietario(int idPropietario) { this.idPropietario = idPropietario; }

    public int getMes() { return mes; }
    public void setMes(int mes) { this.mes = mes; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public double getMontoPagado() { return montoPagado; }
    public void setMontoPagado(double montoPagado) { this.montoPagado = montoPagado; }

    public String getFechaPago() { return fechaPago; }
    public void setFechaPago(String fechaPago) { this.fechaPago = fechaPago; }

    public int getIdCuota() { return idCuota; }
    public void setIdCuota(int idCuota) { this.idCuota = idCuota; }

    public int getPagoTardio() { return pagoTardio; }
    public void setPagoTardio(int pagoTardio) { this.pagoTardio = pagoTardio; }

    @Override
    public String toString() {
        return "Pago{" +
               "casa=" + idCasa +
               ", mes=" + mes +
               ", anio=" + anio +
               ", monto=Q" + montoPagado +
               ", estado=" + (pagoTardio == 1 ? "Tardío" : "A tiempo") +
               '}';
    }

    public Object[] getMonto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
