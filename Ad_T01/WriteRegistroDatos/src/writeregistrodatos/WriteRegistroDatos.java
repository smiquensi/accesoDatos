    package writeregistrodatos;

    import java.io.IOException;
    import java.io.RandomAccessFile;

    public class WriteRegistroDatos {

        public static void main(String[] args) {
            final int CHAR_X_LINEA = 62;
            int i;
            try {
                RandomAccessFile writeFile = new RandomAccessFile("empleados.data", "rw");
                char[] arrayChar = new char[CHAR_X_LINEA];
                // Recorro el documento linea por linea, almaceno cada linea en  
                // el array, busco en la posicion 4 de cada linea. En caso de que la
                // posicion 4 sea igual a , se escribirán los nuevos datos y se saldrá del bucle
                for (i = 0; i < writeFile.length(); i += CHAR_X_LINEA) {
                    writeFile.seek(i);
                    arrayChar = writeFile.readLine().toCharArray();
                    if (arrayChar[4] == '4') {
                        System.out.print("Datos sin modificar: ");
                        System.out.println(arrayChar);
                        writeFile.seek(i);
                        writeFile.writeBytes("ID: 4, Apellido: LOPEZ, Departamento: 22 Salario:2324.23    ");
                        break;
                    }
                }
                writeFile.seek(i);
                System.out.println("Modificación realizada: " + writeFile.readLine());            
                writeFile.close();
            } catch (IOException e) {
                System.out.println("Error E/S");
            }
        }
    }
