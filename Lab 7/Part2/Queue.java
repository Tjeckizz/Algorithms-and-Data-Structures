package Labb7_1;

import AlexTree.TreeGenerator;

import java.util.Random;

public class Queue {
    Node Head = null;
    Node Tail = null;

    public void add(Node node) {
        Node newNode = new Node(node.key, node.value);
        newNode.left = node.left;
        newNode.right = node.right;

        //System.out.println("Inserting: " + newNode.key);

        //If queue is empty create first node
        if (Head == null) {
            Head = newNode;
            Tail = newNode;
        } else {
            Tail.next = newNode;
            Tail = newNode;
        }
    }

    public Node remove() {
        Node R = Head;
        // System.out.println("Removing: " + R.key);

        // advance front to the next node
        Head = Head.next;

        //if the list becomes empty
        if (Head == null) {
            Tail = null;
        }
        return R;
    }


    public static void main(String[] Args) {


        int[] n = {100, 200, 400, 800, 1600, 3200, 6400};
        int k = 100000;
        long t, t0, t_tot = 0;

        Random rnd = new Random();

        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < k; j++) {
                Queue q = new Queue();
                Node r = new Node(rnd.nextInt(n[i] * n[i] / 2), rnd.nextInt((n[i] * n[i]) / 2));
                t0 = System.nanoTime();

                for (int m = 0; m < n[i]; m++) {

                    q.add(r);
                }
                t = System.nanoTime() - t0;
                t_tot += t;

                /*
                TreeIteratorBF iter = new TreeIteratorBF(julgran.root);
                Integer findkey = rnd.nextInt(n[i]);


                while (iter.hasNext() == true) {
                    if (iter.next().key == findkey) {
                        break;
                    }
                }*/

            }
            t_tot = t_tot / k;
            System.out.println("n: " + n[i] + " tid: " + t_tot);
        }
    }



        /*
        int[] n = {100, 200, 400, 800, 1600, 3200, 6400};
        int k = 100000;
        long t, t0, t_tot = 0;

        Random rnd = new Random();

        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < k; j++) {

                BinaryTree julgran = new BinaryTree();
                t0 = System.nanoTime();
                julgran.addTree((n[i]*n[i])/2,(n[i]*n[i])/2);
                for(int m = 0; m < n[i] - 1; m++) {
                    int rando = rnd.nextInt((n[i]*n[i]));
                    julgran.addTree(rando, rando);
                }
                t = System.nanoTime() - t0;
                t_tot += t;

                /*
                TreeIteratorBF iter = new TreeIteratorBF(julgran.root);
                Integer findkey = rnd.nextInt(n[i]);


                while (iter.hasNext() == true) {
                    if (iter.next().key == findkey) {
                        break;
                    }
                }

            }
            t_tot = t_tot / k;
            System.out.println("n: " + n[i] + " tid: " + t_tot);
        }*/
}




