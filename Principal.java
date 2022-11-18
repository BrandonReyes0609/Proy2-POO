/*
 * Audrey Samantha Bhor López - 22545
    Brandon Javier Reyes Morales - 22992
    Wilson Alejandro Calderón A. - 22018
    Jose Angel Morales Farfan - 22689

 */
import java.util.ArrayList;

public class Recomendaciones {

    //private ArrayList<FichaMedica> listadoP;
    private ArrayList<FichaMedica> _listadoP;  
    private String _nombreBuscar;


    public Recomendaciones() {
        _listadoP = new ArrayList<FichaMedica>();
        _nombreBuscar = "";
        
    }

    public void AgregarListadoPersonas(ArrayList<FichaMedica> listado, String nombreBuscar) {
        _listadoP = listado;
        _nombreBuscar = nombreBuscar;
        //ArrayList<FichaMedica> listadoP = (ArrayList<FichaMedica>)listado.clone();
    }      

    public ArrayList<FichaMedica> getListadoP() {
        return this._listadoP;
    }

    public void setListadoP(ArrayList<FichaMedica> listadoP) {
        this._listadoP = listadoP;
    }

    public String get_nombreBuscar() {
        return this._nombreBuscar;
    }

    public void set_nombreBuscar(String _nombreBuscar) {
        this._nombreBuscar = _nombreBuscar;
    }




    @Override
    public String toString() {
        return "{" +
            " listadoP='" + getListadoP() + "'" +
            ", _nombreBuscar='" + get_nombreBuscar() + "'" +
            "}";
    }


    public String CalculadorString(){
        IDatosPredefinidos cartero = new Mesaje();
        //--------------------------------------------

        String nombre = "";
        String apellidos = "";
        int edad = 0;
        double peso  = 0.0;
        String realizaEjercicio  = "";
        int numComida  = 0;
        String sexo  = "";
        double datoIMC  = 0.0;
        double estatura  = 0.0;
        //--------------------------------------------
        int media = 0;
        String nameB = get_nombreBuscar();
        String cadena = "";
        int i = 0;
        while(i<_listadoP.size()){
            if(nameB.equals(_listadoP.get(i).getNombre())){
                edad = edad+_listadoP.get(i).getEdad();
                peso = peso+_listadoP.get(i).getPeso();
                numComida = numComida+_listadoP.get(i).getNumComida();
                datoIMC = datoIMC+_listadoP.get(i).getDatoIMC();
                //Datos Extras-
                estatura = _listadoP.get(i).getEstatura();
                apellidos = _listadoP.get(i).getApellidos();
                sexo = _listadoP.get(i).getSexo();
                edad = _listadoP.get(i).getEdad();
                estatura = _listadoP.get(i).getEstatura();
                realizaEjercicio = _listadoP.get(i).getRealizaEjercicio();
                //---------------------
                media++;
                
            }
            i++;
        }
        edad = edad/media;
        peso = peso/media;
        numComida = numComida/media;
        datoIMC = datoIMC/media;
        nombre = nameB;
        double estaturaM = estatura*0.01; 
        double pesoKG = peso*1/2.20462; 
        String cadenaIMC = "";
        if(datoIMC<18.5){
            cadenaIMC = cadenaIMC + cartero.mensaje1()+"\n";
        }else if(18.5>=datoIMC && datoIMC<24.9){
            cadenaIMC = cadenaIMC + cartero.mensaje2()+"\n";//"se encuentra dentro del rango de peso normal o saludable.";
        }else if(25>=datoIMC && datoIMC<29.9){
            cadenaIMC = cadenaIMC + cartero.mensaje3()+"\n";//"se encuentra dentro del rango de sobrepeso";
        }else if(datoIMC>=30){
            cadenaIMC = cadenaIMC + cartero.mensaje4()+"\n";//"se encuentra dentro del rango de obesidad";
        }


        //Cantidad e calorias necesaria
        //https://aprendeconreyhan.org/como-realizar-mi-calculo-calorico/
        double _KcalDia = 0;
        String  _Res_KcalDia = "";
        if(sexo.equals("mujer") || sexo.equals("Mujer")){
            if(edad < 3)
            {
                //ya
                _KcalDia = 58.317*pesoKG-31.1;
            }
            else if(edad>=3 && edad<10)
            {
                //ya
                _KcalDia = (20.315*pesoKG)+485.9;
            }
            else if(edad>=10 && edad<18)
            {
                //ya
                _KcalDia = (13.384*pesoKG)+692.6;
            }
            else if(edad>=18 && edad<30)
            {
                //ya
                _KcalDia = (14.818*pesoKG)+486.6;
            }
            else if(edad>=30 && edad<60)
            {
                _KcalDia = (8.126*pesoKG)+873.1;
            }
            else if(edad>=60)
            {
                _KcalDia = (9.082*pesoKG)+658.5;
            }
            _Res_KcalDia = _Res_KcalDia + "Mujer de "+edad+" anios con un peso de "+peso+"lb con una estatura de "+estatura+"cm\n";
            _Res_KcalDia = _Res_KcalDia + "La cantidad de calorias necesaria al día son: "+_KcalDia+" Kcal/día\n";

            
        }
        if(sexo.equals("hombre") || sexo.equals("Hombre")){
            if(edad < 3)
            {
                //ya
                _KcalDia = 59.512*pesoKG-30.4;
            }
            else if(edad>=3 && edad<10)
            {
                //ya
                _KcalDia = (22.706*pesoKG)+504.3;
            }
            else if(edad>=10 && edad<18)
            {
                //
                _KcalDia = (17.686*pesoKG)+658.2;
            }
            else if(edad>=18 && edad<30)
            {
                //
                _KcalDia = (15.057*pesoKG)+692.2;
            }
            else if(edad>=30 && edad<60)
            {
                //
                _KcalDia = (11.472*pesoKG)+873.1;
            }
            else if(edad>=60)
            {
                //
                _KcalDia = (11.711*pesoKG)+587.7;
            }
            _Res_KcalDia = _Res_KcalDia + "Hombre de "+edad+" anios con un peso de "+peso+"lb con una estatura de "+estatura+"cm\n";
            _Res_KcalDia = _Res_KcalDia + "La cantidad de calorias necesaria al día son: "+_KcalDia+" Kcal/día\n";   
        }

        //---------------------------------------------------------calorias
        String caloriasConsumidas = "";
        double valorCalorias = 0.0;
        double FinalvCalorico = 0.0;
        if(realizaEjercicio.equals("1")){
            caloriasConsumidas = "Estilo de Vida Sedentario";
            valorCalorias = 1.40;
        }
        if(realizaEjercicio.equals("2")){
            caloriasConsumidas = "Estilo de Vida Ligeramente activo";
            valorCalorias = 1.69;
        }
        if(realizaEjercicio.equals("3")){
            caloriasConsumidas = "Estilo de Vida Activo o Moderadamente activo";
            valorCalorias = 1.845;
        }
        if(realizaEjercicio.equals("4")){
            caloriasConsumidas = "Estilo de Vida Vigoroso";
            valorCalorias = 2.00;
        }
        FinalvCalorico = _KcalDia * valorCalorias;

        //-----------------------------------------------------------------------------

        cadena = cadena + "| ------ Receta Medica ------ |\n";
        cadena = cadena + "Los datos de la persona"+ nombre + apellidos +" son lo siguiente\n";
        cadena = cadena + "-> Edad: "+edad+"\n";
        cadena = cadena + "->Peso : "+peso+" lb\n";
        cadena = cadena + "-> Realiza Ejercio: "+realizaEjercicio+"\n";
        cadena = cadena + "-> Numero de comdas al día: "+numComida+"\n";
        cadena = cadena + "-> Sexo: "+sexo+"\n";
        cadena = cadena + "-> Edad: "+edad+"\n";
        cadena = cadena + "-> Estatura :"+estatura+" cm\n";
        //cadena = cadena + "->  :"++"\n";

        cadena = cadena + "| ------ Datos IMC ------ |\n";
        cadena = cadena + "| ------ Indice de Masa Corporal ------ |\n";
        cadena = cadena + cadenaIMC+"\n";

        cadena = cadena + "| ------ Calculo Calórico ------ |\n";

        cadena = cadena + "Formula de la orgranización Mundial de la Salud\n";

        cadena = cadena + ""+_Res_KcalDia;
        cadena = cadena + "\n Estilo de vida  Ligeramente activo"+caloriasConsumidas;
        cadena = cadena + "Lelvando un " + FinalvCalorico +"\n y consume "+caloriasConsumidas +"\n";
   
         
        cadena = cadena + "RECUERDA Realizar actividad física para reducir el riesgo a padecer \n";
        cadena = cadena + "enfermedades como obesidad, diabetes y/o hipertensión. El ejercicio y\"n";
        cadena = cadena + " una alimentación balanceada nos ayuda a mantener un peso saludable.\n";
        return cadena;

    }

            /*
         * Docuemntación de apoyo
         * https://www.cdc.gov/healthyweight/spanish/assessing/bmi/adult_bmi/metric_bmi_calculator/bmi_calculator.html
         */

}
    
