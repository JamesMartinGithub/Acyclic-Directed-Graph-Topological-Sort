import java.util.Arrays;

public class DAGProviderTEST {
  public static void main(String[] args) {
    int[][] DAG = {
        {1,2}, {3}, {3}, {}
    };
    tryDag(DAG);
  }

  private static void tryDag(int[][] DAG) {
    try {
      int[] returnedOrder = DAGSort.sortDAG(DAG);
      System.out.println(Arrays.toString(returnedOrder));
    }catch(CycleDetectedException e) {
      System.out.println("CycleDetectedException");
    }
    catch(NullPointerException e) {
      System.out.println("NullPointerException");
    }
    catch(InvalidNodeException e) {
      System.out.println("InvalidNodeException");
    }
  }
}