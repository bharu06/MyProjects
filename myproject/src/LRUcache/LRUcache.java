package LRUcache;

import java.util.HashMap;
import java.util.Scanner;

public class LRUcache {

    public static void main(String[] args) {
        int pageNumber;
        HashMap<Integer, Node> map = new HashMap<>();
        DLL mydll = new DLL();
        while(true) {
            System.out.println("enter the page number");
            Scanner sc = new Scanner(System.in);
            pageNumber = sc.nextInt();
            if(map.containsKey(pageNumber)) {
                Node node = map.get(pageNumber);
                mydll.removeNodeAtRandom(node);
                mydll.putAtHead(node);
            } else {
                if(mydll.getSize() == 7){
                    Node node = mydll.removeNodeAtLast();
                    Node newNode = new Node(pageNumber, null, null);
                    mydll.putAtHead(newNode);
                    map.put(pageNumber, newNode);
                } else {
                    Node newNode = new Node(pageNumber, null, null);
                    mydll.putAtHead(newNode);
                    map.put(pageNumber, newNode);
                }
            }
            mydll.printDLL();

        }

    }
}
