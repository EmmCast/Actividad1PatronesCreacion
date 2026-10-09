package alineaciones_misma_jerarquia;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Representa un equipo de League of Legends.
 *
 * Hereda de Equipo los atributos comunes
 * y define sus propias posiciones.
 */
public class EquipoLol extends Equipo {

    // Almacena las posiciones y jugadores de LoL
    private Map<String, String> titulares;

    /**
     * Constructor del equipo de LoL.
     * Tiene 5 titulares y 0 suplentes.
     */
    public EquipoLol() {
        super(5, 0);

        titulares = new LinkedHashMap<>();
    }

    // Agrega un jugador a una posicion
    public void agregarTitular(String posicion, String jugador) {
        titulares.put(posicion, jugador);
    }

    // Muestra los jugadores del equipo
    @Override
    public String toString() {

        StringBuilder resultado = new StringBuilder();

        resultado.append("Equipo de League of Legends:\n");

        for (Map.Entry<String, String> entrada : titulares.entrySet()) {

            resultado.append(entrada.getKey())
                     .append(" - ")
                     .append(entrada.getValue())
                     .append("\n");
        }

        return resultado.toString();
    }
}