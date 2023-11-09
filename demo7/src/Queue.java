import java.util.Stack;

/***
 * Implémentation d'une queue (file) avec 2 stack (piles)
 * Ici on assume que ça va comporter des éléments du type int
 */
public class Queue {

    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    /***
     * ajouter un élément à la queue/file
     * @param x élément ajouté
     */
    public void enQueue(int x) {
        stack1.push(x);
    }

    /***
     * enlever un élément (en respectant la logique FIFO d'une file/queue)
     * @return int représentant l'élément retiré
     */
    public int dequeue() {
        // on utilise des deux piles pour renverser l'ordre
        // en tout transférant de stack1 à stack2
        // visuel :  https://i.stack.imgur.com/1YfMo.png

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) { // tant que stack1 a toujours des éléments
                stack2.push(stack1.pop()); // enlever du premier stack, mettre sur l'autre stack
            }
        }

        // maintenant que c'est dans l'ordre "souhaité", resortir du stack2
        return stack2.pop();
    }
}
