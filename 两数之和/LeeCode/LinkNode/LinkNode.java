package LeeCode.LinkNode;

/**
 * 链表结点
 */
class Node
{
    int data;
    Node next;
    Node() {};
    Node(int data)
    {
        this.data = data;
    }
}

/**
 * 链表
 */
public class LinkNode
{
    /**
     * 链表的长度
     */
    private int length;

    /**
     * 链表的头结点
     */
    private Node head;

    /**
     * 链表的构造函数
     */
    public LinkNode()
    {
        this.length = 0;
        this.head = new Node();
    }

    /**
     * 链表的构造函数
     * @param dates 加入链表的数据
     */
    public LinkNode(int... dates)
    {
        this();
        for(int data: dates)
        {
            this.addNode(data);
        }
    }

    /**
     * @return 链表的长度
     */
    public int getLength()
    {
        return this.length;
    }

    /**
     * 插入尾结点
     * @param data 数据
     */
    public void addNode(int data)
    {
        Node temp = this.head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = new Node(data);
        this.length++;
    }

    /**
     * 插入结点
     * @param data 数据
     * @param index 插入的位置
     */
    public void insertNode(int data, int index)
    {
        if(index < 1 || index > this.length + 1)
        {
            System.out.println("插入位置错误！");
        }
        else if(index == this.length + 1)
        {
            this.addNode(data);
        }
        else
        {
            Node temp = this.head;
            for(int i = 0; i < index - 1; i++)
            {
                temp = temp.next;
            }
            Node memory;
            memory = temp.next;
            temp.next = new Node(data);
            temp.next.next = memory;
            this.length++;
        }
    }

    /**
     * 删除结点
     * @param index 删除结点的位置
     */
    public void deleteNode(int index)
    {
        if (index < 1 || index > this.length)
        {
            System.out.println("删除位置错误！");
        }
        else
        {
            Node temp = this.head;
            for(int i = 0; i < index - 1; i++)
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            this.length--;
        }
    }

    /**
     * 获取任意结点的数据
     * @param index 对应的位置
     * @return 结点不存在返回0，存在返回数据
     */
    public int getData(int index)
    {
        if(index < 1 || index > this.getLength())
        {
            System.out.println("结点不存在！");
            return 0;
        }
        else
        {
            Node temp = this.head;
            for(int i = 0; i < index; i++)
            {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    /**
     * 打印所有结点的内容
     */
    public void printAllData()
    {
        Node temp = this.head.next;
        for(int i = 1; i <= this.length; i++)
        {
            System.out.println("" + temp.data);
            temp = temp.next;
        }
    }

    /**
     * 更改任意结点的数据
     * @param data 更改的数据
     * @param index 更改的结点的位置
     */
    public void changeNode(int data, int index)
    {
        if(index < 1 || index > this.length)
        {
            System.out.println("更改的位置错误！");
        }
        else
        {
            Node temp = this.head;
            for(int i = 0; i < index; i++)
            {
                temp.data = data;
            }
        }
    }
}
