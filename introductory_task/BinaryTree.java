public class BinaryTree {
    char info;//information that is stored in the node BT
    BinaryTree lt;//pointer to the left root
    BinaryTree rt;//pointer to the right root

    public BinaryTree() {
        lt = null;
        rt = null;
    }

    //__________________LKP_______________________________________________________________
    BinaryTree makeTreeLKP(String in, BinaryTree root, TreeInform inform) {
        char[] chars = in.toCharArray();
        if (chars[inform.getPtr()] == '\0')
            return null;
        root = new BinaryTree();//creating a node
        System.out.println("The line is passed through. At the moment we are:   " + chars[inform.getPtr()] + "\n");
        if (chars[inform.getPtr()] == '(') {
            inform.setT(1);
            inform.IncreatePtr();//increasing the ptr by 1

            root.lt = makeTreeLKP(in, root.lt, inform);


            if (inform.getErr() != 0 || chars[inform.getPtr()] == ')') {
                System.out.println("Error! after the left node, the root node is not entered, or its empty designation! \n");
                inform.setErr(3);
                return root;
            }
            if (inform.getErr() != 0)
                return root;
            if (chars[inform.getPtr()] == '#')// check
            {
                System.out.println("Error! Empty head! \n");
                inform.setErr(2);
                return root;
            }

            System.out.println("The line is passed through. At the moment we are:   " + chars[inform.getPtr()] + "\n");
            System.out.println("Writing the symbol to the root node of the tree!!! \n");
            //root.info = chars[ptr++];

            root.info = chars[inform.getPtr()];
            inform.IncreatePtr();
            if (inform.getErr() != 0 || chars[inform.getPtr()] == ')') {
                System.out.println("Error! the right node is not entered after the root node!\n");
                inform.setErr(3);
                return root;
            }
            inform.setT(2);

            root.rt = makeTreeLKP(in, root.rt, inform);

            if (inform.getErr() != 0)
                return root;
            if (chars[inform.getPtr()] == ')') {
                System.out.println("The line is passed through. At the moment we are:   " + chars[inform.getPtr()] + "\n");
                if (chars[inform.getPtr()] != '\0')
                    inform.IncreatePtr();

            } else
                inform.setErr(1);
            return root;
        } else {
            if (inform.getT() == 1) {
                System.out.println("Write the symbol to the left node of the tree!!!\n");
            }
            if (inform.getT() == 2) {
                System.out.println("Write the symbol to the right node of the tree!!!\n");
            }

            root.info = chars[inform.getPtr()];
            inform.IncreatePtr();

        }
        return root;
    }

//____________________________________________LPK___________________________________________________________

    BinaryTree makeTreeLPK(String in, BinaryTree root, TreeInform inform) {
        char[] chars = in.toCharArray();
        if (chars[inform.getPtr()] == '\0')
            return null;
        root = new BinaryTree();//creating a node

        System.out.println("The line is passed through. At the moment we are:   " + chars[inform.getPtr()] + "\n");

        if (chars[inform.getPtr()] == '(') {
            inform.setT(1);
            inform.IncreatePtr();

            root.lt = makeTreeLPK(in, root.lt, inform);

            if (inform.getErr() != 0 || chars[inform.getPtr()] == ')') {
                System.out.println("Error! after the left node, the right node is not entered, or its empty designation!\n");
                inform.setErr(3);
                return root;
            }

            inform.setT(2);
            root.rt = makeTreeLPK(in, root.rt, inform);


            if (inform.getErr() != 0 || chars[inform.getPtr()] == ')') {
                System.out.println("Error! the root is not entered after the right node!\n");
                inform.setErr(3);
                return root;
            }
            if (inform.getErr() != 0)
                return root;
            if (chars[inform.getPtr()] == '#') {
                System.out.println("Error! Empty head!\n");
                inform.setErr(2);
                return root;
            }
            inform.setT(0);

            System.out.println("The line is passed through. At the moment we are:   " + chars[inform.getPtr()] + "\n");
            System.out.println("Writing the symbol to the root node of the tree!!!\n");

            root.info = chars[inform.getPtr()];
            inform.IncreatePtr();
            if (chars[inform.getPtr()] == ')') {
                System.out.println("The line is passed through. At the moment we are:   " + chars[inform.getPtr()] + "\n");
                if (chars[inform.getPtr()] != '\0')
                    inform.IncreatePtr();
            } else
                inform.setErr(1);
            return root;
        } else {

            if (inform.getT() == 1) {
                System.out.println("Write the symbol to the left node of the tree!!!\n");
            }
            if (inform.getT() == 2) {
                System.out.println("Write the symbol to the right node of the tree!!!\n");
            }

            root.info = chars[inform.getPtr()];
            inform.IncreatePtr();
        }
        return root;
    }

    boolean isNull(BinaryTree b) {
        return (b == null);
    }


    char RootBT(BinaryTree b)            // for a non-empty bin.trees
    {
        if (b == null) {
            System.out.println("Error: RootBT(null) \n");
            System.exit(1);
        } else
            return b.info;
        return 0;
    }


    BinaryTree Left(BinaryTree b)        // for a non-empty bin.trees
    {
        if (b == null) {
            System.out.println("Error: Left(null) \n");
            System.exit(1);
        } else
            return b.lt;
        return null;
    }


    BinaryTree Right(BinaryTree b)        // for a non-empty bin.trees
    {
        if (b == null) {
            System.out.println("Error: Right(null) \n");
            System.exit(1);
        } else
            return b.rt;

        return null;
    }


    void printLPK(BinaryTree b) {
        if (!isNull(b)) {
            if (Left(b) != null) {
                printLPK(Left(b));
            }
            if (Right(b) != null) {
                printLPK(Right(b));
            }

            System.out.print(RootBT(b));

        }
    }

    void printKLP(BinaryTree b) {
        if (!isNull(b)) {
            System.out.print(RootBT(b));
            printKLP(Left(b));
            printKLP(Right(b));
        }
    }

    void printLKP(BinaryTree b) {
        if (!isNull(b)) {
            printLKP(Left(b));
            System.out.print(RootBT(b));
            printLKP(Right(b));
        }
    }

    void printTree(BinaryTree p, int level)//function for displaying a tree on the screen
    {
        if (p != null) {
            printTree(p.rt, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("   ");

            }
            System.out.print(p.info + "\n");

            printTree(p.lt, level + 1);
        }
    }
}