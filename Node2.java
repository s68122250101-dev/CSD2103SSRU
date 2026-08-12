public class Node2<T> {

    public T nodeValue;

    public Node2<T> next;

    public Node2() {
        this.nodeValue = null;
        this.next = null;
    }

    public Node2(T item) {
        this.nodeValue = item;
        this.next = null;
    }

    public static int countNode(Node2<String> head) {

        int count = 0;
        Node2<String> temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }


    public static void main(String[] args) {

        Node2<String> p = new Node2<String>("red");

        System.out.println("p" + p);
        System.out.println("p.nodeValue" + p.nodeValue);
        System.out.println("p.next before" + p.next);


        Node2<String> q = new Node2<String>("green");
        Node2<String> m = new Node2<String>("pink");
        Node2<String> n = new Node2<String>("yellow");


        System.out.println("q" + q);
        System.out.println("q.nodeValue" + q.nodeValue);
        System.out.println("q.next" + q.next);


        p.next = q;
        q.next = m;
        m.next = n;


        Node2<String> head = p;
        Node2<String> tail = n;
        System.out.println("head = " + head);
        System.out.println("tail = " + tail);


        Node2<String> temp = p.next;

        m.next = null;

        p.next = n;
        n.next = temp;


        tail = m;



        System.out.println();
        System.out.println("List:");

        Node2<String> current = head;

        while (current != null) {

            System.out.print(current.nodeValue);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();



        Node2<String> search = head;

        while (search != null) {

            if (search.nodeValue.equals("blue")) {
                System.out.println("พบ Node ที่มีค่า blue");
                break;
            }

            search = search.next;
        }

        if (search == null) {
            System.out.println("ไม่พบ Node ที่มีค่า blue");
        }


        int total = countNode(head);

        System.out.println("จำนวน Node ใน List = " + total);
    }
}