package alineaciones_misma_jerarquia;

import java.util.Scanner;

/**
 * Programa principal.
 * Permite generar alineaciones deportivas
 * mediante el patron Builder.
 *
 * Modos:
 * 1. Demostracion estatica
 * 2. Personalizado dinamico
 */
public class GenerarEquipos {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();

            opcion = leerNumero("Seleccione una opcion: ");

            switch (opcion) {

                case 1:
                    modoEstatico();
                    break;

                case 2:
                    modoDinamico();
                    break;

                case 0:
                    System.out.println(
                        "Gracias por utilizar el sistema."
                    );
                    break;

                default:
                    System.out.println(
                        "Opcion no valida. Intente nuevamente."
                    );
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }

    // ============================================
    // MENU PRINCIPAL
    // ============================================

    private static void mostrarMenu() {

        System.out.println();
        System.out.println("====================================");
        System.out.println(" SISTEMA DE ALINEACIONES DEPORTIVAS");
        System.out.println("====================================");
        System.out.println("1. Modo demostracion (estatico)");
        System.out.println("2. Modo personalizado (dinamico)");
        System.out.println("0. Salir");
        System.out.println("====================================");
    }

    // ============================================
    // MODO ESTATICO
    // ============================================

    private static void modoEstatico() {

        System.out.println();
        System.out.println("=== MODO DEMOSTRACION ===");

        // Equipo de League of Legends
        AlineacionLol roasterLol = new AlineacionLol();

        Entrenador coachLol = new Entrenador(roasterLol);

        System.out.println(
            "\n======> Disenando equipo de LoL <======"
        );

        Equipo equipoLol = coachLol.decideAlineacion();

        System.out.println(
            "\n======> Equipo de LoL <======"
        );

        System.out.println(equipoLol);


        // Equipo de futbol
        AlineacionFutbol listaFutbol =
            new AlineacionFutbol();

        Entrenador misterFutbol =
            new Entrenador(listaFutbol);

        System.out.println(
            "\n======> Disenando equipo de futbol <======"
        );

        Equipo equipoFutbol =
            misterFutbol.decideAlineacion();

        System.out.println(
            "\n======> Equipo de futbol <======"
        );

        System.out.println(equipoFutbol);
    }

    // ============================================
    // MODO DINAMICO
    // ============================================

    private static void modoDinamico() {

        int deporte;

        System.out.println();
        System.out.println("=== MODO PERSONALIZADO ===");
        System.out.println("1. League of Legends");
        System.out.println("2. Futbol");
        System.out.println("0. Regresar");

        deporte = leerNumero("Seleccione deporte: ");

        switch (deporte) {

            case 1:
                crearLolPersonalizado();
                break;

            case 2:
                crearFutbolPersonalizado();
                break;

            case 0:
                System.out.println("Regresando al menu...");
                break;

            default:
                System.out.println("Deporte no valido.");
                break;
        }
    }

    // ============================================
    // EQUIPO PERSONALIZADO DE LOL
    // ============================================

    private static void crearLolPersonalizado() {

        System.out.println();
        System.out.println("=== ALINEACION DE LOL ===");

        String[] posiciones = {
            "Top",
            "Mid",
            "ADC",
            "Support",
            "Jungla"
        };

        String[] jugadores = new String[5];

        for (int i = 0; i < jugadores.length; i++) {

            jugadores[i] = leerTexto(
                "Nombre del jugador " + posiciones[i] + ": "
            );
        }

        AlineacionLol alineacion =
            new AlineacionLol(jugadores);

        mostrarEquipo(alineacion, "LoL");
    }

    // ============================================
    // EQUIPO PERSONALIZADO DE FUTBOL
    // ============================================

    private static void crearFutbolPersonalizado() {

        System.out.println();
        System.out.println("=== ALINEACION DE FUTBOL ===");

        String[] titulares = new String[11];
        String[] suplentes = new String[11];

        // Capturar portero
        titulares[0] = leerTexto(
            "Nombre del portero titular: "
        );

        // Capturar defensas
        for (int i = 1; i <= 4; i++) {

            titulares[i] = leerTexto(
                "Nombre del defensa " + i + ": "
            );
        }

        // Capturar mediocampistas
        for (int i = 5; i <= 7; i++) {

            titulares[i] = leerTexto(
                "Nombre del mediocampista " + (i - 4) + ": "
            );
        }

        // Capturar delanteros
        for (int i = 8; i <= 10; i++) {

            titulares[i] = leerTexto(
                "Nombre del delantero " + (i - 7) + ": "
            );
        }

        System.out.println();
        System.out.println("=== JUGADORES SUPLENTES ===");

        suplentes[0] = leerTexto(
            "Nombre del portero suplente: "
        );

        for (int i = 1; i < 11; i++) {

            suplentes[i] = leerTexto(
                "Nombre del suplente " + i + ": "
            );
        }

        AlineacionFutbol alineacion =
            new AlineacionFutbol(titulares, suplentes);

        mostrarEquipo(alineacion, "Futbol");
    }

    // ============================================
    // CONSTRUCCION MEDIANTE BUILDER
    // ============================================

    private static void mostrarEquipo(
            Alineacion alineacion,
            String deporte) {

        Entrenador entrenador = new Entrenador(alineacion);

        System.out.println();
        System.out.println(
            "======> Construyendo equipo de "
            + deporte + " <======"
        );

        Equipo equipo = entrenador.decideAlineacion();

        System.out.println();
        System.out.println(
            "======> Equipo de " + deporte + " <======"
        );

        System.out.println(equipo);
    }

    // ============================================
    // VALIDACION DE ENTRADAS
    // ============================================

    private static int leerNumero(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String entrada = scanner.nextLine();

            try {

                return Integer.parseInt(entrada.trim());

            } catch (NumberFormatException e) {

                System.out.println(
                    "Debe introducir un numero valido."
                );
            }
        }
    }

    private static String leerTexto(String mensaje) {

        String texto;

        do {

            System.out.print(mensaje);

            texto = scanner.nextLine().trim();

            if (texto.isEmpty()) {

                System.out.println(
                    "El nombre no puede estar vacio."
                );
            }

        } while (texto.isEmpty());

        return texto;
    }
}