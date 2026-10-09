package alineaciones_misma_jerarquia;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa un equipo de futbol.
 * Hereda los atributos comunes de Equipo.
 */
public class EquipoFutbol extends Equipo {

    // Almacena las posiciones y jugadores titulares
    private Map<String, String> titulares;

    // Almacena los jugadores suplentes
    private List<String> suplentes;

    public EquipoFutbol() {
        super(11, 11);

        titulares = new LinkedHashMap<>();
        suplentes = new ArrayList<>();
    }

    // Agrega un jugador titular con su posicion
    public void agregarTitular(String posicion, String jugador) {
        titulares.put(posicion, jugador);
    }

    // Agrega un jugador suplente
    public void agregarSuplente(String jugador) {
        suplentes.add(jugador);
    }

    @Override
    public String toString() {

        StringBuilder resultado = new StringBuilder();

        resultado.append("El equipo titular es el siguiente:\n");

        for (Map.Entry<String, String> entrada : titulares.entrySet()) {
            resultado.append(entrada.getKey())
                     .append(" - ")
                     .append(entrada.getValue())
                     .append("\n");
        }

        resultado.append("\nEl equipo suplente es el siguiente:\n");

        for (String jugador : suplentes) {
            resultado.append(jugador).append("\n");
        }

        return resultado.toString();
    }
}