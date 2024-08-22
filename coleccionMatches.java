import java.util.ArrayList;
import java.util.Arrays;
/**
 * Clase donde se guardan los matches creados.
 * 
 * @param:  un ArrayList: matches.
 * @author: Anderson, Mariana.
 * @version: 1.1
 * 
 * Se modifico el método imprimirMatches, para que cuando hayan dos matches no muestre
 * "Otras opciones: "
 */
public class coleccionMatches
{
    private ArrayList<Match> matches;
    /**
     * Constructor default de la coleccionMatches.
     */
    public coleccionMatches(){
        matches = new ArrayList<>();
    }
    
    /**
     * Método que recibe un Match, y lo agrega en el ArrayList de la colección.
     */
    public void agregarMatches(Match match){
        matches.add(match);
    }
    
    /**
     * Método el cual ordena el ArrayList de forma descendiente (El mayor de primero) según el atributo afinidad del Match.
     */
    public void selectionSortArraylistDescendente(){
        if(matches.isEmpty()){
            System.out.println("No hay nada que ordenar");
        }else{
            for(int i = 0; i < matches.size()-1; i++){
                int posMayor = i;
                for(int j = i+1; j < matches.size(); j++){
                    Match matchPosMayor = matches.get(posMayor);
                    Match matchj = matches.get(j);
                    if(matchj.getAfinidad() > matchPosMayor.getAfinidad()){
                        posMayor = j;
                    }
                }
                //"swap"
                if(i!=posMayor){
                    Match matchaCambiar = matches.get(posMayor);
                    matches.add(i, matchaCambiar);
                    matches.remove(posMayor+1);
                }
            }
        }
    }
    /**
     * Este método imprimirá primero cuál es el match que tiene más afinidad y sus respuestas.
     * Luego, si la cantidad de matches es menor que 6, imprimirá todos los siguientes elementos del ArrayList.
     * Por último, si es mayor a 5, imprimirá los siguientes 4 primeros.
     * Imprimirá la afinidad como un porcentaje,y no como un double.
     */    
    public void imprimirMatches(){
        if(matches.isEmpty()){
            System.out.println("Está vacío");
        }
        System.out.println("El match con más afinidad es: " );
        Match primero = matches.get(0);
        double resultado1= primero.getAfinidad() *100;
        System.out.println("match: "+ primero.getNombres() + " con afinidad: " + (int)resultado1 +"%");
        System.out.println("Sus respuestas a las preguntas respectivamente son: ");
        String arr1 = Arrays.toString(primero.getResp1());
        String arr2 = Arrays.toString(primero.getResp2());
        System.out.println(arr1);
        System.out.println(arr2);
        if(matches.size() > 2){
            System.out.println("Otras opciones: ");
            if(matches.size() < 6){
                for(int i = 1; i < matches.size(); i++){
                    Match matchPosi = matches.get(i);
                    double resultadoi = matchPosi.getAfinidad() *100;
                    System.out.println("match: " + matchPosi.getNombres() + " = " + (int)resultadoi+"%");
                }
            }else{
                for(int i = 1; i < 5; i++){
                    Match matchPosi = matches.get(i);
                    double resultadoi = matchPosi.getAfinidad() *100;
                    System.out.println("match: "+ matchPosi.getNombres() + " - " +(int)resultadoi + "%");
                } 
            }
        }
    }
    /**
     * Método getter del atributo matches.
     */
    public ArrayList<Match> getMatches(){
        return this.matches;
    }
}
