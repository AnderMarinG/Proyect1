/**
 * Clase donde se crean los matches entre dos personas.
 * 
 * @param:  un double: afinidad, un string: nombres y dos arrays: resp1, resp2.
 * @author: Anderson, Mariana.
 * @version: 1.0
 */
public class Match
{
    private double afinidad;
    private String nombres;
    private int[] resp1;
    private int[] resp2;
    /**
     * Constructor clase matches.
     */
    public Match(double afinidad, String nombres,int [] resp1, int [] resp2){
        this.afinidad = afinidad;
        this.nombres =  nombres;
        this.resp1 = resp1;
        this.resp2 = resp2;
    }
    /**
     * Getter del atributo afinidad.
     */
    public double getAfinidad(){
        return this.afinidad;
    }
    /**
     * Getter del atributo nombres
     */
    public String getNombres(){
        return this.nombres;
    }
    /**
     * Getter del atributo resp1
     */
    public int[] getResp1(){
        return this.resp1;
    }
    /**
     * Getter del atributo resp2.
     */
    public int[] getResp2(){
        return this.resp2;
    }
}
