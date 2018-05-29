public class LinkedList {

    private Node head, tail;
    private int size = 0;

    public LinkedList() {

    }

    public void add(Integer data) {

        Node node = new Node();
        node.setData(data);
        if (tail == null) {
            head = node;
            tail = node;
        }
        else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public Integer get(int index) {

        if (size == 0 || size() - 1 < index || index < 0) {
            return null;
        }
        Node toGet = head;
        for (int i = 0; i < index; i++) {
            toGet = toGet.getNext();
        }
        return toGet.getData();
    }

    public boolean delete(int index) {

        if (size == 0 || size() - 1 < index || index < 0) {
            return false;
        }
        if (index == 0) {
            head = head.getNext();
            size--;
            return true;
        }

        Node toDelete = head;
        for (int i = 0; i < index - 1; i++) {
            toDelete = toDelete.getNext();
        }
        if (toDelete.getNext() == tail) {
            tail = toDelete;
        }
        toDelete.setNext(toDelete.getNext().getNext());
        size--;
        return true;
    }

    public int size() {
        return this.size;
    }

    class Node {
        private Node next;
        private Integer data;

        public Node() {
        }

        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public Integer getData() {
            return data;
        }
        public void setData(Integer data) {
            this.data = data;
        }
    }
}
