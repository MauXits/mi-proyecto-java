
package Ejercicio02;

public class JEFE {
    
    private final String nombres;
    private final String dni;
    private final String cargo;
    private final String area;
    private final int antiguedad;
    
    public JEFE(String nombres, String dni, String cargo, String area, int antiguedad) {
        this.nombres = nombres;
        this.dni = dni;
        this.cargo = cargo;
        this.area = area;
        this.antiguedad = antiguedad;
    }
     public double calcularSueldoBase() {
        if (cargo.equalsIgnoreCase("Gerente")) {
            if (area.equalsIgnoreCase("Contabilidad"))
                return 6000;
            if (area.equalsIgnoreCase("Planificación")) 
                return 7000;
        } else if (cargo.equalsIgnoreCase("Subgerente")) {
            if (area.equalsIgnoreCase("Contabilidad")) 
                return 5000;
            if (area.equalsIgnoreCase("Planificación"))
                return 6000;
        }
        return 0;
    }

    public double obtenerBonificacion() {
        return 2000;
    }

    public double obtenerMovilidad() {
        if (cargo.equalsIgnoreCase("Gerente")) 
            return 700;
        else if (cargo.equalsIgnoreCase("Subgerente"))
            return 400;
        return 0;
    }

    public double obtenerDescuentoSistemaPension(String tipo) {
        double sueldoBase = calcularSueldoBase();
        if (tipo.equalsIgnoreCase("AFP")) 
            return sueldoBase * 0.15;
        if (tipo.equalsIgnoreCase("SNP"))
            return sueldoBase * 0.08;
        
        return 0;
    }

    public double calcularSueldoBruto() {
        return calcularSueldoBase() + obtenerBonificacion();
    }

    public double obtenerDescuentoAntiguedad() {
        if (antiguedad < 7) 
            return calcularSueldoBruto() * 0.05;
        else 
            return calcularSueldoBruto() * 0.04;
    }

    public double calcularSueldoNeto(String tipoPension) {
        double bruto = calcularSueldoBruto();
        double descuentoPension = obtenerDescuentoSistemaPension(tipoPension);
        double descuentoAntiguedad = obtenerDescuentoAntiguedad();
        double movilidad = obtenerMovilidad();
        return bruto - descuentoPension - descuentoAntiguedad + movilidad;
    }

    public String mostrarInformacion(String tipoPension) {
        return "Nombre: " + nombres +
                "\nDNI: " + dni +
                "\nCargo: " + cargo +
                "\nÁrea: " + area +
                "\nAntigüedad: " + antiguedad + " años" +
                "\nSueldo Base: S/ " + calcularSueldoBase() +
                "\nBonificación: S/ " + obtenerBonificacion() +
                "\nMovilidad: S/ " + obtenerMovilidad() +
                "\nDescuento por " + tipoPension + ": S/ " + obtenerDescuentoSistemaPension(tipoPension) +
                "\nDescuento por Antigüedad: S/ " + obtenerDescuentoAntiguedad() +
                "\nSueldo Bruto: S/ " + calcularSueldoBruto() +
                "\nSueldo Neto: S/ " + calcularSueldoNeto(tipoPension);
    }
}
