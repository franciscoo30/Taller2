import java.util.InputMismatchException;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
        String[][] registro = crearMatriz();
        menu(registro);
    }

    public static void codigoTotal(){
        {
            int a = -1;

            do {
                System.out.println("""
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6)Salir.
                """);




                do {
                    try {
                        a = new Scanner(System.in).nextInt();
                    } catch (InputMismatchException e) {
                        System.err.println("Opción inválida");
                    }
                }while (a > 0 || a < 6);



                if(a == 1) {
                    if(hayCupo(registro)) {
                        int indiceDisponible = obtenerUltimoEspacio(registro);
                        String nombre;
                        String Estadocivil;
                        int edad;




                        while(true) {
                            try {
                                nombre = new Scanner(System.in).nextLine();
                            } catch (InputMismatchException e) {
                                System.err.println("Opción inválida");
                                continue;
                            }
                            break;
                        }




                        while(true) {
                            try {
                                Estadocivil = new Scanner(System.in).nextLine();
                            } catch (InputMismatchException e) {
                                System.err.println("Opción inválida");
                                continue;
                            }
                            break;
                        }




                        while(true) {
                            try {
                                edad = new Scanner(System.in).nextLine();
                            } catch (InputMismatchException e) {
                                System.err.println("Opción inválida");
                                continue;
                            }
                            break;
                        }


                        registro[indiceDisponible][0] = nombre;
                        registro[indiceDisponible][1] = Estadocivil;
                        registro[indiceDisponible][2] = edad;
                        System.out.println("Persona agregada.");
                    } else {
                        System.out.println("No hay cupo.");
                    }
                } else if(a == 2) {
                    int mayoresDeEdad = 0;




                    for (double [] persona : registro) {
                        if (persona[2] >= 18) mayoresDeEdad++;
                    }




                    System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
                } else if(a == 3) {
                    int menoresDeEdad = 0;
                    int queSera = obtenerUltimoEspacio(registro);




                    for (int i = 0; i < queSera; i++) {
                        if (registro[i][2] < 18) menoresDeEdad++;
                    }




                    System.out.println("Hay " + menoresDeEdad + " menores de edad.");
                } else if(a == 4) {
                    int mmmm = 0;




                    for (double [] persona : registro) {
                        if (persona[2] >= 60 && persona[1].equals("casado/a")) {
                            mmmm++;
                        } else if(persona[2] >= 65 && persona[1].equals("soltero/a")) {
                            mmmm++;
                        }
                    }
                    System.out.println("Hay " + mmmm + " personas de tercera edad");
                } else if(a == 5) {
                    int c = 0;
                    int d = 0;
                    for(double[] persona : registro) {
                        if(persona[1].equals("casado/a")) {
                            c++;
                        } else if(persona[1].equals("soltero/a")) {
                            d++;
                        }
                    }



                    System.out.println("Hay " + d + " casados/as.");
                    System.out.println("Hay " + c + " solteros/as.");
                } else if(a == 6) {
                    System.out.println("Programa finalizado");
                }
            }while (a == 6);
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

    public static void menu(double[][] registro) {
        int opcionUsuario;

        do {
            mostrarMenu();
            opcionUsuario = pedirInput();

            switch (opcionUsuario) {
                case 1 -> agregarPersona(registro);
            }
        } while (opcionUsuario != 7);
    }

    public static String[][] crearMatriz(){
        return new String [50][3];
    }

    public static void pedirDatosMatriz(String[][] registro) {
        for (int y = 0; y < registro[0].length; y++) {
            registro[0][y] = agregarPersona();
            registro[1][y] = pedirEstadoCivil();
            registro[2][y] = String.valueOf(pedirEdad());
        }
    }

    public static void contador(){

    }

    public static String agregarPersona() {
        Scanner scanner = new Scanner(System.in);
        String inputNombre;

        do {
            System.out.println("Ingresa el nombre del niño: ");
            inputNombre = scanner.nextLine().trim(); // trim elimina espacios para poder detectar si está vacío :)

            if (inputNombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (inputNombre.isEmpty());

        return inputNombre;
    }

    public static String pedirEstadoCivil() {
        Scanner scanner = new Scanner(System.in);
        String estadoCivil;

        do {
            System.out.println("Ingresa el estado civil: ");
            estadoCivil = scanner.nextLine().trim(); // trim elimina espacios para poder detectar si está vacío :)

            if (estadoCivil.isEmpty()) {
                System.out.println("El estado civil no puede estar vacío.");
            }
        } while (estadoCivil.isEmpty());

        return estadoCivil;
    }

    public static double pedirEdad() {
        Scanner scanner = new Scanner(System.in);
        double inputEdad = 0.0;
        System.out.println("Ingresa la edad de la persona: ");

        try {
            inputEdad = Double.parseDouble(scanner.next());

            if (inputEdad < 10 || inputEdad > 150) {
                throw new NumberFormatException("La edad debe estar entre 0 y 100.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Debes ingresar un número válido entre 0 y 100.");
            inputEdad = pedirEdad();
        }

        return inputEdad;
    }

    public static void pedirDatosMatriz(String[][] registro) {
        for (int y = 0; y < registro[0].length; y++) {
            registro[0][y] = agregarPersona();
            registro[1][y] = pedirEstadoCivil();
            registro[2][y] = String.valueOf(pedirEdad());
        }
    }

    public static int obtenerUltimoEspacio(double [][] registro) {
        return registro.length - opa(registro);
    }

    public static boolean hayCupo(double [][] registro) {
        if (opa(registro) != 0){
            return true;
        }
        return false;
    }

    public static int opa(double [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0].equals("")){
                return registro.length - i;
            }
        }
        return 0;
    }
}