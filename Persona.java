/**
 * La clase Persona representa una persona con un nombre y un conjunto de respuestas a preguntas.
 * 
 * @param nombre Nombre de una persona.
 * @param resp Arreglo de enteros con referencia a las respuestas de las personas.
 * 
 * @author Mariana Carrasquilla
 * @author Jhon Anderson Marin
 * @version 1.0
 */
public class Persona
{
    private String nombre;
    private int[] resp;
    /**
     * Constructor de objectos de la clase Persona. Asigna los parámetros del constructor a los parámetros de la clase y a su vez inicializa el arreglo con tamaño 5 
     * 
     * @param nombre El nombre de la persona.
     * @param resp   Un arreglo de enteros que representa las respuestas de la persona.
     * 
     * se inicializa en 5 porque son 5 preguntas, es extendible cambiando esta parte del codigo.

     */
    public Persona(String nombre, int[] resp)
    {
        this.nombre = nombre;
        this.resp = new int[5];
        this.resp = resp;
    }

    /**
     * El método agrega una persona a la colección.
     * 
     * @param persona La persona a agregar a la colección.
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Devuelve un arreglo con las respuestas de la persona.
     * 
     * @return Un arreglo de enteros que representa las respuestas de la persona.
     */
    public int[] getRespuestas(){
        return this.resp;
    }

    /**
     * Devuelve una representación en forma de cadena de la persona, incluyendo su nombre en minusculas y respuestas.
     * 
     * @return Una cadena que representa a la persona.
     */
    public String toString(){
        String resultado= nombre + " ";
        for(int i= 0; i< resp.length; i++ ){
            resultado += resp[i];
            if(i< resp.length-1){
                resultado+= " ";
            }
        }
        return resultado; 
    }
}
