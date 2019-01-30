import java.util.Scanner;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Iface iface = new Iface();
        int op = 0;
        boolean correctInput;

        System.out.print("Welcome to Iface!\n\n");

        while (op != 3) {
            System.out.print("What do you want to do?\n");
            System.out.print("1 - Sing up;\n");
            System.out.print("2 - Sing in;\n");
            System.out.print("3 - Turn off the system (Stop Program).\n");
            op = iface.readInteger(op);

            if (op == 1) {
                iface.addAccount();
            }

            if (op == 2) {
                iface.login();
            }

            if(op>3 || op<1){
                System.out.print("\nPlease, enter a valid operation number.\n\n");
            }
        }
    }
}