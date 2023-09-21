import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[][] registro = crearMatriz();
        menu(registro);
    }

    public static int obtenerUltimoEspacio(String [][] registro) {
        return registro.length - espaciosOcupados(registro);
    }

    public static boolean hayCupo(String [][] registro) {
        return espaciosOcupados(registro) != 0;
    }

    public static int espaciosOcupados(String [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0].equals("")){
                return registro.length - i;
            }
        }
        return 0;
    }

    public static void mostrarMayorDeEdad(String[][] registro){
        int mayoresDeEdad = 0;

        for (String [] persona : registro) {
            int edad = Integer.parseInt(persona[2]);
            if (edad >= 18) mayoresDeEdad++;
        }

        System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
    }

    public static void mostrarMenorDeEdad(String[][] registro){
        int menoresDeEdad = 0;

        for (String[] persona : registro){
            int edad = Integer.parseInt(persona[2]);
            if (edad < 18) {
                menoresDeEdad++;
            }
        }
    }

    public static void mostrarTerceraEdad(String[][] registro){
        int terceraEdad = 0;

        for (String [] persona : registro) {
            int edad = Integer.parseInt(persona[2]);
            if (edad >= 60 && persona[1].equals("casado/a")) {
                terceraEdad++;
            } else if(edad >= 65 && persona[1].equals("soltero/a")) {
                terceraEdad++;
            }
        }
        System.out.println("Hay " + terceraEdad + " personas de tercera edad");
    }

    public static void mostrarCasadosYSolteros(String[][] registro){
        int casados = 0;
        int solteros = 0;
        for(String[] persona : registro) {
            if(persona[1].equals("casado/a")) {
                casados++;
            } else if(persona[1].equals("soltero/a")) {
                solteros++;
            }
        }

        System.out.println("Hay " + casados + " casados/as.");
        System.out.println("Hay " + solteros + " solteros/as.");
    }

    public static String[][] crearMatriz(){
        return new String [50][3];
    }

    public static void pedirNombre(String[][] registro){
        if(hayCupo(registro)) {
            int indiceDisponible = obtenerUltimoEspacio(registro);
            String nombre;

            while (true) {
                try {
                    nombre = new Scanner(System.in).nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                    continue;
                }
                break;
            }
            registro[indiceDisponible][0] = nombre;
        }
        else {
            System.out.println("No hay cupo.");
        }
    }

    public static void pedirEstadoCivil(String[][] registro){
        String Estadocivil;
        int indiceDisponible = obtenerUltimoEspacio(registro);

        if(hayCupo(registro)) {
            while(true) {
                try {
                    Estadocivil = new Scanner(System.in).nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                    continue;
                }
                break;
            }
            registro[indiceDisponible][1] = Estadocivil;
        }
        else{
            System.out.println("No hay cupo.");
        }
    }

    public static void pedirEdad(String[][] registro){
        int indiceDisponible = obtenerUltimoEspacio(registro);
        String edad;
        if(hayCupo(registro)) {
            while(true) {
                try {
                    edad = new Scanner(System.in).nextLine();

                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                    continue;
                }
                break;
            }

            registro[indiceDisponible][2] = edad;
            System.out.println("Persona agregada.");
        } else {
            System.out.println("No hay cupo.");
        }
    }
    public static void agregarPersona(String[][] registro){
        pedirNombre(registro);
        pedirEstadoCivil(registro);
        pedirEdad(registro);
    }


    public static void menu(String[][] registro){
        int opcionUsuario;

        do {
            mostrarMenu();
            opcionUsuario = pedirInput();

            switch (opcionUsuario) {
                case 1 -> agregarPersona(registro);
                case 2 -> mostrarMayorDeEdad(registro);
                case 3 -> mostrarMenorDeEdad(registro);
                case 4 -> mostrarTerceraEdad(registro);
                case 5 -> mostrarCasadosYSolteros(registro);
                case 6 -> System.out.println("Saliste");
            }
        } while (opcionUsuario != 6);
    }

    public static int pedirInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngresa una opción: ");

        try {
            int inputUsuario = scanner.nextInt();

            if (inputUsuario < 1 || inputUsuario > 6) {
                System.out.println("Opción inválida.");
                return pedirInput();
            }

            return inputUsuario;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número válido.");
            scanner.nextLine();
            return pedirInput();
        }
    }

    public static void mostrarMenu() {
        System.out.println("""
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6)Salir.
                """);
    }


}
