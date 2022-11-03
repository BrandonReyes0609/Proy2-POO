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
     * @param talla
     * @param peso
     * @param realizaEjercicio
     * @param numComida
     * @param sexo
     * @param datoIMC
     * @param estatura;
     */
    public void agregarPacientes(String nombre,String apellidos,int edad,int talla,int peso,String realizaEjercicio,int numComida,String sexo,float datoIMC,float estatura){
        FichaMedica nuevFichaMedica = new FichaMedica(nombre, apellidos, edad, talla, peso, realizaEjercicio, numComida, sexo, datoIMC, estatura);
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
        int i = 0; 
        String resultados = "";
        while (i<pacientes.size()){

            resultados = resultados + "Edad: "+ pacientes.get(i).getEdad()+"\n";
            resultados = resultados + "Peso: "+ pacientes.get(i).getPeso()+"\n";
            resultados = resultados + "Realiza Ejercicio: "+ pacientes.get(i).getRealizaEjercicio()+"\n";
            resultados = resultados + "Sexo o Genero: "+ pacientes.get(i).getSexo() +"\n";
            resultados = resultados + "Numero de Comida: "+ pacientes.get(i).getNumComida()+"\n";
            resultados = resultados + "Dato IMC: "+ pacientes.get(i).getDatoIMC()+"\n";
            resultados = resultados + "Estatura: "+ pacientes.get(i).getEstatura()+"\n";

            resultados = resultados + "-----------------------------\n";
            i++;
        }
        return resultados;
    }

    public String estadistica(){
        String estadisticas = "Estadisticas de los datos rescolectados\n--------------------------------------------------------\n";
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
        return estadisticas;
    }
}

