package LeeCode.LinkNode;

public class LinkNodeTest
{
    public static void main(String[] args)
    {
        LinkNode L = new LinkNode();
        System.out.println("" + L.getLength());
        L.addNode(1);
        L.addNode(2);
        L.insertNode(3, 3);
        L.insertNode(4, 3);
        L.deleteNode(3);
        L.printAllData();
    }
}
