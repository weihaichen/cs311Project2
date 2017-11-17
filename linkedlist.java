public class linkedlist{
  LLNode head;
  LLNode tail;
  public linkedlist(){
    head=null;
    tail=null;
  }
  public linkedlist(int element){
    head=new LLNode(element,null);
    tail=head;
  }
  public void add(int element){
    if(head==null){
      head=new LLNode(element,null);
      tail=head;
    }
    else{
    LLNode n=new LLNode(element,null);
    tail.setNext(n);
    tail=tail.getNext();
  }
  }
  public int deQueue(){
    int n=head.getElement();
    head=head.getNext();
    return n;
  }
  public LLNode getHead(){
    return head;
  }
  public boolean isEmpty(){
    return head==null;
  }

}
