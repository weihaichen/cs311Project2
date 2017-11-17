import java.util.*;
import java.io.*;

public class graph_driver{
  public static void main(String[] args) throws Exception {
    graph TC=null;

    String fileName = "smallgraph";
    FileReader fileReader =
        new FileReader(fileName);


    BufferedReader bufferedReader =
        new BufferedReader(fileReader);


    String line=bufferedReader.readLine();
    String[] b=line.split(" ");
    int size=Integer.parseInt(b[0]);
    TC=new graph(size);

		while((line = bufferedReader.readLine()) != null) {
        String[] a=line.split(" ");
        TC.addEdge(Integer.parseInt(a[0]),Integer.parseInt(a[1]));
        TC.addEdge(Integer.parseInt(a[1]),Integer.parseInt(a[0]));
    }

    linkedlist queue=new linkedlist();
    linkedlist cycle=new linkedlist();
    int counter=1;
    int startLevel=1;
    while(counter<=size){
      for(int i=1;i<=size;i++){
        if(counter>size){
          break;
        }
        if(!TC.getList()[i].getHead().isVisited()){
          queue.add(i);
        TC.getList()[i].getHead().setVisit(true);
        TC.getList()[i].getHead().setLevel(startLevel);
        counter++;
        while(!queue.isEmpty()){
          int index=queue.deQueue();
          LLNode temp = TC.getList()[index].getHead().getNext();
        //  System.out.println(index);
          while(temp!=null){

            if(!TC.getList()[temp.getElement()].getHead().isVisited()){
              TC.getList()[temp.getElement()].getHead().setVisit(true);
              TC.getList()[temp.getElement()].getHead().setPred(index);
              int level=TC.getList()[index].getHead().getLevel()+1;
              TC.getList()[temp.getElement()].getHead().setLevel(level);
              queue.add(temp.getElement());
              counter++;
            }
            else{

              if(TC.getList()[temp.getElement()].getHead().getLevel()==TC.getList()[index].getHead().getLevel()){
                //odd cycle detcted

                int v1=index;
                int v2=temp.getElement();

                cycle.add(v1);
                cycle.add(v2);

                int pred=TC.getList()[v1].getHead().getPred();
                while(TC.getList()[v1].getHead().getPred()!=TC.getList()[v2].getHead().getPred()){

                  v1=TC.getList()[v1].getHead().getPred();
                  v2=TC.getList()[v2].getHead().getPred();

                  cycle.add(v1);
                  cycle.add(v2);

                  pred=TC.getList()[v1].getHead().getPred();
                }
                cycle.add(pred);


                break;
              }
            }

            temp=temp.getNext();


          }
          //adj vertex
          if(!cycle.isEmpty())
          break;

        }
        //queue

        if(!cycle.isEmpty())
        break;
      }
    }//go over all the vertex
      if(!cycle.isEmpty())
      break;
    }//loop start
    FileWriter fileWriter =
							 new FileWriter("smallgraphoutput");

					 // Always wrap FileWriter in BufferedWriter.
					 BufferedWriter bufferedWriter =
							 new BufferedWriter(fileWriter);

    if(!cycle.isEmpty()){

    bufferedWriter.write("Odd Cycle exist: ");
    while(!cycle.isEmpty()){
      int out=cycle.deQueue();
      bufferedWriter.write(out+"   ");

    }
      bufferedWriter.newLine();

    }
    else{
    for(int i=1;i<TC.getList().length;i++){
      //System.out.println(i);
      LLNode temp=TC.getList()[i].getHead();

      if(temp.getLevel()%2==0){
      bufferedWriter.write(temp.getElement()+": Blue" );

      }
      else{
      bufferedWriter.write(temp.getElement()+": Red" );

      }
      bufferedWriter.newLine();

      }
    }
    bufferedWriter.close();
  }
}
