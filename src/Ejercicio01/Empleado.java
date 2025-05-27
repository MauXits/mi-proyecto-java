
package Ejercicio01;

/**
 *
 * @author Francis Damian
 */
public class Empleado {
    
    //Atributos Encapsulados
   private String codigo,nombre, area;
   private double sueldoBase, horasExtras;
   private String tipoSeguro;
   
   //Métodod constructor: SobreCarga de Constructores

    public Empleado(String codigo, String nombre, String area, 
            double sueldoBase, double horasExtras, 
            String tipoSeguro) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.area = area;
        this.sueldoBase = sueldoBase;
        this.horasExtras = horasExtras;
        this.tipoSeguro = tipoSeguro;
    }
    
    public Empleado(){
        
        
    }
   
   //Métodos get and set

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }
    
    //Métodos Adicionales
    public double calculoMontoHorasExtras(){
        return sueldoBase*horasExtras/240;
    }
    
    public double calculoMontoSeguro(){
        if(tipoSeguro.equals("AFP")){
        return sueldoBase*0.11;
    }
        if (tipoSeguro.equals("SNP")){
            return sueldoBase*0.06;
            
        }
        return 0;
    }
    public double calculoMontoEsSalud(){
        return sueldoBase*0.03;
    }
    
    public double calculoDescuentoTotal(){
        return calculoMontoSeguro()+calculoMontoEsSalud();
    }
    
    public double calculoSueldoBruto(){
        return sueldoBase + calculoMontoHorasExtras();
    }
    
    public double calculoSueldoNeto(){
        return calculoSueldoBruto()-calculoDescuentoTotal();
    }
    public String mostrarInf(){
        return "Codigo:" + codigo +
                "\n Nombre: " + nombre + 
                "\n Area: "+ area + 
                "\n Sueldo Base: "+ sueldoBase + 
                "\n Cantidad de Horas Extras: " + horasExtras +
                "\n Tipo de Seguro: " + tipoSeguro + 
                "\n Monto por Horas Extras: " + calculoMontoSeguro() + 
                "\n Monto de EsSalud: " +calculoMontoEsSalud() + 
                "\n Total de descuentos: " + calculoDescuentoTotal()+
                "\n Sueldo Bruto: "+ calculoSueldoBruto() +
                "\nSueldo Neto: " + calculoSueldoNeto(); 
    }
}
