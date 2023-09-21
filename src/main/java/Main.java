import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String [][] registro = new String [50][3];
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
            } while (a < 1 || a > 6);




            if(a == 1) {
                if(hayCupo(registro)) {
                    int indiceDisponible = obtenerUltimoEspacio(registro);
                    String nombre;
                    String Estadocivil;
                    String edad;

                    while(true) {
                        try {
                            nombre = new Scanner(System.in).nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                        }
                    }




                    while(true) {
                        try {
                            Estadocivil = new Scanner(System.in).nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                        }
                    }




                    while(true) {
                        try {
                            edad = new Scanner(System.in).nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                        }
                    }




                    registro[indiceDisponible][0] = nombre;
                    registro[indiceDisponible][1] = Estadocivil;
                    registro[indiceDisponible][2] = edad;
                    System.out.println("Persona agregada.");
                } else {
                    System.out.println("No hay cupo.");
                }
            } else if (a == 2) {
                int mayoresDeEdad = 0;
                for (String[] persona : registro) {
                    if (persona != null && persona[2] != null && !persona[2].isEmpty()) {
                        int edad = Integer.parseInt(persona[2]);
                        if (edad >= 18) {
                            mayoresDeEdad++;
                        }
                    }
                }
                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
            } else if (a == 3) {
                int menoresDeEdad = 0;
                for (String[] persona : registro) {
                    if (persona != null && persona[2] != null && !persona[2].isEmpty()) {
                        int edad = Integer.parseInt(persona[2]);
                        if (edad < 18) {
                            menoresDeEdad++;
                        }
                    }
                }
                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
            } else if (a == 4) {
                int personasDeTerceraEdad = 0;
                for (String[] persona : registro) {
                    if (persona != null && persona[2] != null && !persona[2].isEmpty() && persona[1] != null) {
                        int edad = Integer.parseInt(persona[2]);
                        String estadoCivil = persona[1];
                        if ((edad >= 60 && estadoCivil.equals("casado/a")) || (edad >= 65 && estadoCivil.equals("soltero/a"))) {
                            personasDeTerceraEdad++;
                        }
                    }
                }
                System.out.println("Hay " + personasDeTerceraEdad + " personas de tercera edad.");
            } else if (a == 5) {
                int casados = 0;
                int solteros = 0;
                for (String[] persona : registro) {
                    if (persona != null && persona[1] != null) {
                        if (persona[1].equals("casado/a")) {
                            casados++;
                        } else if (persona[1].equals("soltero/a")) {
                            solteros++;
                        }
                    }
                }
                System.out.println("Hay " + casados + " casados/as.");
                System.out.println("Hay " + solteros + " solteros/as.");
            }
            else if(a == 6) {
                System.out.println("Programa finalizado");
                break;
            }
        } while (a == 6);
    }




    public static int obtenerUltimoEspacio(String [][] registro) {
        return registro.length - espaciosOcupados(registro);
    }




    public static boolean hayCupo(String [][] registro) {
        return espaciosOcupados(registro) != 0;
    }




    public static int espaciosOcupados(String[][] registro) {
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0] == null || registro[i][0].equals("")) {
                return registro.length - i;
            }
        }




        return 0;
    }
}
