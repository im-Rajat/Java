public class MegaBytesConverter {

    public static void printMegaBytesAndKiloBytes(int kiloByte) {

        if(kiloByte < 0) {
            System.out.println("Invalid Value");
        } else {
            int megaByte = kiloByte / 1024;
            int megaByte2 = kiloByte % 1024;
            System.out.println(kiloByte + " KB = " + megaByte + " MB and " + megaByte2 + " KB");
        }

    }

}