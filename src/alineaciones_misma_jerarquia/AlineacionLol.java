package alineaciones_misma_jerarquia;


/**
 * Builder concreto para equipos de League of Legends.
 * Permite crear equipos estaticos y dinamicos.
 */
public class AlineacionLol implements Alineacion {

    private EquipoLol equipo;
    private String[] jugadores;

    // Constructor para modo estatico
    public AlineacionLol() {

        this(new String[] {
            "Jugador 1", // Top
            "Jugador 2", // Mid
            "Jugador 3", // ADC
            "Jugador 4", // Support
            "Jugador 5"  // Jungla
        });
    }

    // Constructor para modo dinamico
    public AlineacionLol(String[] jugadores) {

        if (jugadores == null || jugadores.length != 5) {
            throw new IllegalArgumentException(
                "LoL requiere exactamente 5 jugadores"
            );
        }

        this.jugadores = jugadores.clone();
        this.equipo = new EquipoLol();
    }

    @Override
    public void primeraLinea() {

        System.out.println("Top: " + jugadores[0]);

        equipo.agregarTitular(
            "top",
            jugadores[0]
        );
    }

    @Override
    public void segundaLinea() {

        System.out.println("Mid: " + jugadores[1]);
        System.out.println("Jungla: " + jugadores[4]);

        equipo.agregarTitular(
            "mid",
            jugadores[1]
        );

        equipo.agregarTitular(
            "jungla",
            jugadores[4]
        );
    }

    @Override
    public void terceraLinea() {

        System.out.println(
            "ADC: " + jugadores[2]
            + " | Support: " + jugadores[3]
        );

        equipo.agregarTitular(
            "adc",
            jugadores[2]
        );

        equipo.agregarTitular(
            "support",
            jugadores[3]
        );
    }

    @Override
    public void suplentes() {

        System.out.println(
            "LoL no tiene suplentes"
        );
    }

    @Override
    public void portero() {

        System.out.println(
            "LoL no tiene portero"
        );
    }

    @Override
    public Equipo generarEquipo() {

        System.out.println(
            "Se ha generado el equipo de LoL"
        );

        return equipo;
    }
}