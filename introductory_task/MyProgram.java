import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;

public class MyProgram {

    public static void main(String[] args) {

        int f = 0;
        StringBuilder sb = new StringBuilder();
        String out;
        String two;
        //int i = 0;
        int k = 1;
        //int t = 0;
        int counter = 0;
        //int err = 0;
        TreeInform err = new TreeInform(0, 0, 0);
        System.out.println("Selected action: \n");
        System.out.println("0 - exit \n");
        System.out.println("1 - input from the file in the order of LKP \n");
        System.out.println("2 - input from the file in the order of LPK \n");
        System.out.println("3 - input from the console in the order of LKP \n");
        System.out.println("4 - input from the console in the order of LPK \n");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if (choice == 1 || choice == 2 || choice == 0 || choice == 3 || choice == 4) {
            if (choice == 0) {
                System.out.println("Goodbye! \n");

                System.exit(0);
            } else if (choice == 1 || choice == 2) {
                if (choice == 1)
                    f = 1;//flag to indicate the order of the LKP
                else
                    f = 2;//LPK

                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader(
                            "D:\\Users\\User\\IdeaProjects\\lab4\\test.txt"));
                    String str = reader.readLine();
                    sb.append(str);
                    System.out.println("A string was read from the file:    " + str + "\n");
                    /*while (line != null) {
                        System.out.println("A string was read from the file:    "+line);
                        // read next line
                        line = reader.readLine();
                    }*/
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            } else if (choice == 3 || choice == 4) {
                if (choice == 3)
                    f = 1;//flag to indicate the order of the LKP
                else f = 2;//LPK

                System.out.println("Please enter an expression!\n");
                Scanner in = new Scanner(System.in);
                String str = in.nextLine();
                sb.append(str);

            }
        } else {
            System.out.println("Invalid input!\n");
            System.out.println("Goodbye! \n");
            System.exit(0);

        }

        BinaryTree tree = new BinaryTree();

        String str = sb.toString();
        if (f == 1)//if the flag is 1, then call the function to bypass the LKP
        {

            System.out.println("The makeTreeLKP function starts! \n");
            tree = tree.makeTreeLKP(str, tree, err);
            System.out.println("The makeTreeLKP function shuts down! \n");


        } else//otherwise, the flag is equal to 2, so the function is called to bypass the LPK
        {
            System.out.println("The makeTreeLPK function starts! \n");
            tree = tree.makeTreeLPK(str, tree, err);
            System.out.println("The makeTreeLPK function shuts down! \n");

        }

        if (err.getErr() == 0) {
            System.out.println("Tree, in the order of LPK: \n");
            tree.printLPK(tree);
            System.out.println("\n");

            System.out.println("Tree, in the order of KLP: \n");
            tree.printKLP(tree);
            System.out.println("\n");

            System.out.println("Tree, in the order of LKP:\n");
            tree.printLKP(tree);
            System.out.println("\n");

            System.out.println("Tree: \n");

            tree.printTree(tree, k);
        }


    }


}