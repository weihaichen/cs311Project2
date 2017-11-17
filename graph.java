public class graph{
  private linkedlist[] adj;
  public graph(int size){
    adj=new linkedlist[size+1];
    for(int i=1;i<=size;i++){
      adj[i]=new linkedlist(i);
    }
  }
  public void addEdge(int a,int b){
    adj[a].add(b);
  }
  public linkedlist[] getList(){
    return adj;
  }
}
