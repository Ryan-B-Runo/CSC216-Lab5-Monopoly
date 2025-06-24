
public class CircularLinkedList<E> {

    private Node<E> tail = null;
    private Node<E> currentNode = null;
    private int size = 0;

    public CircularLinkedList() {
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    public void appendFirst(E e) {
        if(size == 0){
            tail = new Node<>(e, null);
            tail.setNext(tail);
            currentNode = tail;
        }else{
            Node<E> newNode = new Node<>(e, tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    public void append(E e) {
        appendFirst(e);
        tail = tail.getNext();
    }

    public void step(){
        currentNode = currentNode.getNext();
    }

    public E getCurrentNode() {
        return currentNode.getElement();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<E> prev = tail;
        str.append(tail.getElement()).append(" -> ");

        for(int i = 0; i < size - 1; i++){
            str.append(prev.getNext().getElement()).append(" -> ");
            prev = prev.getNext();
        }
        return str.toString();
    }
}
