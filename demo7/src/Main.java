public class Main {
    public static void main(String[] args) {

        // pour tester notre implementation queue
        Queue myQueue = new Queue();

        // si on ajoute dans l'ordre 1,2,3,4,5 ...
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.enQueue(5);

        // ... on s'attend (dans une logique FIFO) à un ordre de sortie de
        // 1,2,3,4,5

        // testons cela :
        System.out.println(myQueue.dequeue()); //1
        System.out.println(myQueue.dequeue()); // 2
        System.out.println(myQueue.dequeue()); // 3
        System.out.println(myQueue.dequeue()); // 4
        System.out.println(myQueue.dequeue()); // 5

    }


}
