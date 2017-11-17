public class LLNode{
	int element;
	LLNode next;
	boolean visited;
	int level;
	int pred;
	public LLNode(int e,LLNode n) {
		element=e;
		next=n;
		visited=false;
		level=0;
		int pred=0;
	}
	public void setElement(int e) {
		element=e;
	}
	public void setNext(LLNode n){
		next=n;
	}
	public LLNode getNext() {
		return next;
	}
	public int getElement() {
		return element;
	}
	public void setVisit(boolean t){
		visited=t;
	}
	public boolean isVisited(){
		return visited;
	}
	public void setLevel(int l){
		level=l;
	}
	public int getLevel(){
		return level;
	}
	public void setPred(int pre){
		pred=pre;
	}
	public int getPred(){
		return pred;
	}
}
