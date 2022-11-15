import java.util.ArrayList;

public class ManejoDatos{
    private ArrayList<FichaMedica> pacientes;

    public ManejoDatos(){
        pacientes = new ArrayList<FichaMedica>();
    }
    
    /** 
     * @param nombre
     * @param apellidos
     * @param edad
     * @param peso
     * @param realizaEjercicio
     * @param numComida
     * @param sexo
     * @param datoIMC
     * @param estatura;
     */
    public void agregarPacientes(String nombre,String apellidos,int edad,int peso,String realizaEjercicio,int numComida,String sexo,float datoIMC,float estatura){
        FichaMedica nuevFichaMedica = new FichaMedica(nombre, apellidos, edad, peso, realizaEjercicio, numComida, sexo, datoIMC, estatura);
        this.pacientes.add(nuevFichaMedica);
    }

    
    /** 
     * @return ArrayList<FichaMedica>
     */
    public ArrayList<FichaMedica> getPacientes() {
        return this.pacientes;
    }

    
    /** 
     * @param pacientes
     */
    public void setPacientes(ArrayList<FichaMedica> pacientes) {
        this.pacientes = pacientes;
    }


    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
            " pacientes='" + getPacientes() + "'" +
            "}";
    }


    public String pacientesFichaMedica(){
        int i = 1; 
        String resultados = "";
        if(pacientes.size()>0){
            while (i<=pacientes.size()){
                resultados = resultados + "\n------ Paciente " + i + " ------\n";
                resultados = resultados + "Nombre: "+ pacientes.get(i-1).getNombre()+"\n";
                resultados = resultados + "Apeliido: "+ pacientes.get(i-1).getApellidos()+"\n";
                resultados = resultados + "Edad: "+ pacientes.get(i-1).getEdad()+" anios"+"\n";
                resultados = resultados + "Peso: "+ pacientes.get(i-1).getPeso()+" Kg"+"\n";
                resultados = resultados + "Realiza Ejercicio: "+ pacientes.get(i-1).getRealizaEjercicio()+"\n";
                resultados = resultados + "Sexo o Genero: "+ pacientes.get(i-1).getSexo()+"\n";
                resultados = resultados + "Numero de Comida: "+ pacientes.get(i-1).getNumComida()+"\n";
                resultados = resultados + "Dato IMC: "+ pacientes.get(i-1).getDatoIMC()+"\n";
                resultados = resultados + "Estatura: "+ pacientes.get(i-1).getEstatura()+" metros"+"\n";

                resultados = resultados + "-----------------------------\n";
                i++;
            }
        }
        else {
            resultados = "\nNo hay pacientes para mostrar.";
        }  
        return resultados;
    }

    public String estadistica(){
        String estadisticas = "";
        if(pacientes.size()>0){
            estadisticas = "Estadisticas de los datos recolectados\n--------------------------------------------------------\n";
            float sumaimc = 0;
            int i = 0;
            for (FichaMedica ficha : pacientes){
                sumaimc = sumaimc + ficha.getDatoIMC();
                i++;
            }
            float promedioimc = sumaimc/i;
            estadisticas = "IMC Promedio: "+promedioimc;
            float sumaimch = 0;
            float sumaimcm = 0;
            float sumaimco = 0;
            int ih = 0;
            int im = 0;
            int io = 0;
            for (FichaMedica ficha : pacientes){
                if(ficha.getSexo().equals("hombre") || ficha.getSexo().equals("Hombre")){
                    sumaimch = sumaimch + ficha.getDatoIMC();
                    ih++;
                }
                if(ficha.getSexo().equals("mujer") || ficha.getSexo().equals("Mujer")){
                    sumaimcm = sumaimcm + ficha.getDatoIMC();
                    im++;
                }
                if(ficha.getSexo().equals("otro") || ficha.getSexo().equals("Otro")){
                    sumaimco = sumaimco + ficha.getDatoIMC();
                    io++;
                    }
            }
            float promedioimch = sumaimc/ih;
            float promedioimcm = sumaimc/im;
            float promedioimco = sumaimc/io;
            estadisticas = estadisticas + "\nIMC Promedio para 'Hombres': " + promedioimch + "\nIMC Promedio para 'Mujeres': " + promedioimcm + "\nIMC Promedio para 'Otro': " + promedioimco + "\n";
            estadisticas = estadisticas + "\nTotal de fichas medicas registradas:\n'Hombres: "+ ih +"'Mujeres': "+ im + "'Otro': "+ io + "'Total': " + i;
        }
        else {
            estadisticas = "No hay pacientes de los cuales sacar estadisticas.";
        }
        return estadisticas;
    }
}
