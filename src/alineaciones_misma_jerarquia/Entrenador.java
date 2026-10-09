package alineaciones_misma_jerarquia;


/**
 * Director del patron Builder.
 *
 * Coordina los pasos necesarios para construir
 * un equipo, independientemente del deporte.
 */
public class Entrenador {

    // Referencia al Builder
    private Alineacion alineacion;

    // Constructor que recibe la alineacion
    public Entrenador(Alineacion alineacion) {
        this.alineacion = alineacion;
    }

    /**
     * Ejecuta los pasos para construir el equipo.
     *
     * @return Equipo construido
     */
    public Equipo decideAlineacion() {

        // Agrega al portero si corresponde
        alineacion.portero();

        // Construye las lineas del equipo
        alineacion.primeraLinea();
        alineacion.segundaLinea();
        alineacion.terceraLinea();

        // Agrega los suplentes
        alineacion.suplentes();

        // Devuelve el equipo construido
        return alineacion.generarEquipo();
    }
}