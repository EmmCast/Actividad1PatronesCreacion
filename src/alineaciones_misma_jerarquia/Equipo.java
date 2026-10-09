package alineaciones_misma_jerarquia;


/**
 * Clase padre que representa un equipo deportivo.
 *
 * Contiene los atributos comunes que utilizaran
 * los diferentes tipos de equipos.
 */
public class Equipo {

    // Cantidad de jugadores titulares
    public int num_titulares;

    // Cantidad de jugadores suplentes
    public int num_suplentes;

    /**
     * Constructor de la clase Equipo.
     *
     * @param num_titulares numero de titulares
     * @param num_suplentes numero de suplentes
     */
    public Equipo(int num_titulares, int num_suplentes) {
        this.num_titulares = num_titulares;
        this.num_suplentes = num_suplentes;
    }

    @Override
    public String toString() {
        return "Equipo deportivo:"
                + "\nTitulares: " + num_titulares
                + "\nSuplentes: " + num_suplentes;
    }
}