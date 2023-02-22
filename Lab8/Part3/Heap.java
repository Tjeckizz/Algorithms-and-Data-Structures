package Labb8_2;

import java.util.Arrays;

public class Heap {

    private int indexNext;
    private final int capacity;

    private final Integer[] Heap;

    public Heap(int cap) {
        capacity = cap;
        Heap = new Integer[capacity];
        indexNext = 0;
    }

    public void add(Integer element) {
        int indexPrev;
        int indexNext1 = indexNext;
        Integer temp;
        Heap[indexNext] = element;

        if (indexNext % 2 == 0) {
            indexPrev = (indexNext - 2) / 2;
        } else {
            indexPrev = (indexNext - 1) / 2;
        }
        if (indexNext != 0) {
            while (indexPrev >= 0 && Heap[indexNext1] < Heap[indexPrev]) {
                temp = Heap[indexNext1];
                Heap[indexNext1] = Heap[indexPrev];
                Heap[indexPrev] = temp;
                indexNext1 = indexPrev;
                if (indexPrev % 2 == 0) {
                    indexPrev = (indexPrev - 2) / 2;
                } else {
                    indexPrev = (indexPrev - 1) / 2;
                }
            }
        }
        //System.out.println(Arrays.toString(Heap));
        indexNext++;
    }

    public Integer remove() {
        Integer returner = Heap[0];
        Heap[0] = Heap[--indexNext];
        Heap[indexNext] = null;
        restoreHeap(0);
        //System.out.println(Arrays.toString(Heap));
        return returner;
    }


    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    private boolean isLeaf(int i) {
        return rightChild(i) >= capacity || leftChild(i) >= capacity;
    }


    private void restoreHeap(int prev) {
        if ((rightChild(prev) < indexNext && leftChild(prev) < indexNext)) {
            if (Heap[prev] > Heap[leftChild(prev)] || Heap[prev] > Heap[rightChild(prev)]) {
                Integer temp;
                if (Heap[leftChild(prev)] < Heap[rightChild(prev)]) {
                    temp = Heap[prev];
                    Heap[prev] = Heap[leftChild(prev)];
                    Heap[leftChild(prev)] = temp;
                    restoreHeap(leftChild(prev));
                } else {
                    temp = Heap[prev];
                    Heap[prev] = Heap[rightChild(prev)];
                    Heap[rightChild(prev)] = temp;
                    restoreHeap(rightChild(prev));
                }
            }
        }
    }
}

