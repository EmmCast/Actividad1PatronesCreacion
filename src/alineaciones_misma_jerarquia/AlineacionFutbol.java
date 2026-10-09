package alineaciones_misma_jerarquia;

/**
 * Builder concreto para equipos de futbol.
 * Admite alineaciones predeterminadas y personalizadas.
 */
public class AlineacionFutbol implements Alineacion {

    private EquipoFutbol equipo;

    private String[] titulares;
    private String[] suplentesEquipo;

    // Constructor para el modo estatico
    public AlineacionFutbol() {

        this(
            generarJugadores(11, 1),
            generarSuplentes()
        );
    }

    // Constructor para el modo dinamico
    public AlineacionFutbol(String[] titulares,
                            String[] suplentes) {

        if (titulares == null || titulares.length != 11) {
            throw new IllegalArgumentException(
                "Futbol requiere 11 titulares"
            );
        }

        if (suplentes == null || suplentes.length != 11) {
            throw new IllegalArgumentException(
                "Futbol requiere 11 suplentes"
            );
        }

        this.titulares = titulares.clone();
        this.suplentesEquipo = suplentes.clone();

        this.equipo = new EquipoFutbol();
    }

    // Genera los titulares predeterminados
    private static String[] generarJugadores(int cantidad,
                                              int inicio) {

        String[] jugadores = new String[cantidad];

        jugadores[0] = "Portero 1";

        for (int i = 1; i < cantidad; i++) {
            jugadores[i] = "Jugador " + (inicio + i - 1);
        }

        return jugadores;
    }

    // Genera los suplentes predeterminados
    private static String[] generarSuplentes() {

        String[] suplentes = new String[11];

        suplentes[0] = "Portero 2";

        for (int i = 1; i < 11; i++) {
            suplentes[i] = "Jugador " + (i + 10);
        }

        return suplentes;
    }

    @Override
    public void primeraLinea() {

        System.out.println("Linea de defensas");

        for (int i = 1; i <= 4; i++) {
            equipo.agregarTitular(
                "defensa " + i,
                titulares[i]
            );
        }
    }

    @Override
    public void segundaLinea() {

        System.out.println("Linea de centros");

        for (int i = 5; i <= 7; i++) {
            equipo.agregarTitular(
                "centro " + (i - 4),
                titulares[i]
            );
        }
    }

    @Override
    public void terceraLinea() {

        System.out.println("Linea de delanteros");

        for (int i = 8; i <= 10; i++) {
            equipo.agregarTitular(
                "delantero " + (i - 7),
                titulares[i]
            );
        }
    }

    @Override
    public void suplentes() {

        System.out.println("Agregando suplentes de futbol");

        for (String jugador : suplentesEquipo) {
            equipo.agregarSuplente(jugador);
        }
    }

    @Override
    public void portero() {

        System.out.println("Agregando portero");

        equipo.agregarTitular(
            "portero",
            titulares[0]
        );
    }

    @Override
    public Equipo generarEquipo() {

        System.out.println(
            "Se ha generado el equipo de futbol"
        );

        return equipo;
    }
}