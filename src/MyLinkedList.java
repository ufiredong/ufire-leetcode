class MyLinkedList {
    Node head=null;
    class Node{
        int val;
        Node next=null;
        Node(int val){
            this.val=val;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node tmp=head;
        int sum=0;
        while(tmp.next!=null){
            if(sum==index){
                break;
            }
            tmp=tmp.next;
            sum++;
        }
        return tmp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode=new Node(val);
        if(head==null){
            head=newNode;
        }else{
            Node tmp=head;
            head=newNode;
            head.next=tmp;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode=new Node(val);
        Node tmp=head;
        if(tmp==null){
            head=newNode;
        }
        while(head.next!=null){
            tmp=tmp.next;
        }
        tmp.next=newNode;
    }


    public int length(){
        if(head==null){
            return 0;
        }
        int count=1;
        Node tmp=head;
        while(tmp.next!=null){
            tmp=tmp.next;
            count++;
        }
        return count;
    }


    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        /*
           index > length()  如果 索引下标大于链表实际节点数量 （加入有N的节点 那么存在最大索引为N-1） 如果index>length()  则不合理
        */
        if(index>length()){
            return;
        }
        if(index==length()){
            addAtTail(val);
            return;
        }
        if(index<0){
            addAtHead(val);
            return;
        }
        Node newNode=new Node(val);
        Node tmp=head;
        int sum=1;
        Node cur=null;
        Node pre=null;
        while(tmp.next!=null){
            pre=tmp;
            cur=tmp.next;
            if(index==sum){
                pre.next=newNode;
                newNode.next=cur;
            }
            tmp=tmp.next;
            sum++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<=length()){
            Node tmp=head;
            Node cur=null;
            Node pre=null;
            int indexSum=0;
            while(tmp.next==null){
                pre=tmp;
                cur=tmp.next;
                if(index==indexSum){
                    pre=cur;
                }
                tmp=tmp.next;
                indexSum++;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }
}
