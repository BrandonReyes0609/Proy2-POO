//13/11/2022
public class FichaMedica{
    private String nombre;
    private String apellidos;
    private int edad;
    private double peso;
    private String realizaEjercicio;
    private int numComida;
    private String sexo;
    private double datoIMC;
    private double estatura;
/*
 * Audrey Samantha Bhor López - 22545
    Brandon Javier Reyes Morales - 22992
    Wilson Alejandro Calderón A. - 22018
    Jose Angel Morales Farfan - 22689

 */
    public FichaMedica() {
    }

    public FichaMedica(String nombre, String apellidos,int edad, double peso, String realizaEjercicio, int numComida, String sexo, double datoIMC, double estatura) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.peso = peso;
        this.realizaEjercicio = realizaEjercicio;
        this.numComida = numComida;
        this.sexo = sexo;
        this.datoIMC = datoIMC;
        this.estatura = estatura;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRealizaEjercicio() {
        return this.realizaEjercicio;
    }

    public void setRealizaEjercicio(String realizaEjercicio) {
        this.realizaEjercicio = realizaEjercicio;
    }

    public int getNumComida() {
        return this.numComida;
    }

    public void setNumComida(int numComida) {
        this.numComida = numComida;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getDatoIMC() {
        return this.datoIMC;
    }

    public void setDatoIMC(double datoIMC) {
        this.datoIMC = datoIMC;
    }

    public double getEstatura() {
        return this.estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    @Override

    public String toString(){
        String cadena = "";
        cadena = "Nombre: " + nombre + "\nApellido: " + apellidos;
        cadena = cadena + "\nEdad: " + edad +
                "\nPeso: " + peso + "\nRealizaEjercicio: " + realizaEjercicio + 
                "\nSexo: " + sexo + "\nNumComidas: " + numComida + 
                "\nDatoIMC: " + datoIMC + "\nEstatura: " + estatura;
        return cadena;
    }

}
