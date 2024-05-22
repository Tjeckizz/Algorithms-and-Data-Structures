package Labb5;

import java.util.Arrays;

public class LinkedListStack {

    int head;
    LinkedListStack tail;
    static int n = 1000;

    public static void main(String[] Args) {


        int[] expr = new int[n];
        int[] answ;
        for (int i = 0; i < n; i++) {
            expr[i] = i;
        }

        System.out.println(Arrays.toString(expr));
        answ = run(expr);
        System.out.println(Arrays.toString(answ));
    }

    public LinkedListStack(int item, LinkedListStack list) {
        head = item;
        tail = list;
    }

    public static LinkedListStack Stack(int element) {
        LinkedListStack stack = new LinkedListStack(element, null);
        return stack;
    }


    public static int[] run(int[] expr) {
        LinkedListStack stack = Stack(expr[0]);
        //LinkedListStack stack;

        for (int ip = 1; ip < expr.length; ip++) {
            int element = expr[ip];
            LinkedListStack Element = new LinkedListStack(element, null);
            stack = Element.push(stack);
        }
        return pop(stack);
    }

    public LinkedListStack push(LinkedListStack stack) {
        LinkedListStack nxt = this; //elementet som matas in (*element*.append(b)
        nxt.tail = stack;
        return nxt;
    }

    public static int[] pop(LinkedListStack stack) {
        int[] element = new int[n];
        int i = 0;
        while (stack.tail != null) {
            element[i] = stack.head;
            stack = stack.tail;
            i++;
        }
        return element;
    }

}
