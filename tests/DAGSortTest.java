import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class to test if the DAG sort implementation works
 */
class DAGSortTest {

  private static int[][] DAG;
  //Valid edge arrays for output tests
  private static final int[][] DAG1 = {
      {1,2}, {3}, {3}, {}
  };
  private static final int[][] DAG2 = {
      {}, {2}, {4}, {0, 1}, {}, {0, 4}
  };
  private static final int[][] DAG3 = {
      {1}, {2, 3}, {}, {2}, {0}
  };
  private static final int[][] DAG4 = {
      {4}, {0, 3}, {1}, {}, {}
  };
  //Invalid edge arrays for cycle detection tests
  private static final int[][] DAG5 = {
      {3}, {2}, {0, 4}, {}, {1}
  };
  private static final int[][] DAG6 = {
      {3}, {0}, {1}, {2}
  };
  //Invalid edge arrays for invalid node tests
  private static final int[][] DAG7 = {
      {4}, {0}, {1}, {2}
  };
  private static final int[][] DAG8 = {
      {3}, {-1}, {1}, {2}
  };
  //Valid int[] outputs for each valid edge array
  private static final List<int[]> DAG1Outputs = Arrays.asList(new int[][]{{0, 1, 2, 3},
      {0, 2, 1, 3}});
  private static final List<int[]> DAG2Outputs = Arrays.asList(new int[][]{{3, 1, 2, 5, 0, 4},
      {3, 1, 2, 5, 4, 0}, {3, 1, 5, 0, 2, 4}, {3, 1, 5, 2, 0, 4}, {3, 1, 5, 2, 4, 0},
      {3, 5, 0, 1, 2, 4}, {3, 5, 1, 0, 2, 4}, {3, 5, 1, 2, 0, 4}, {3, 5, 1, 2, 4, 0},
      {5, 3, 0, 1, 2, 4}, {5, 3, 1, 0, 2, 4}, {5, 3, 1, 2, 0, 4}, {5, 3, 1, 2, 4, 0}});
  private static final List<int[]> DAG3Outputs = Arrays.asList(new int[][]{{4, 0, 1, 3, 2}});
  private static final List<int[]> DAG4Outputs = Arrays.asList(new int[][]{{2, 1, 0, 3, 4},
      {2, 1, 0, 4, 3}, {2, 1, 3, 0, 4}});

  /**
   * Test that providing 4 valid non-cyclic DAGs each result in a valid output
   */
  @Test
  void DAGSortValidOrderTest() throws InvalidNodeException, CycleDetectedException {
    int[] output;
    output = DAGSort.sortDAG(DAG1);
    assertTrue(compareAgainstList(DAG1Outputs, output));
    output = DAGSort.sortDAG(DAG2);
    assertTrue(compareAgainstList(DAG2Outputs, output));
    output = DAGSort.sortDAG(DAG3);
    assertTrue(compareAgainstList(DAG3Outputs, output));
    output = DAGSort.sortDAG(DAG4);
    assertTrue(compareAgainstList(DAG4Outputs, output));
  }

  private boolean compareAgainstList(List<int[]> expectedList, int[] actual) {
    for (int[] intArray : expectedList) {
      if (Arrays.equals(intArray, actual)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Test that providing invalid cyclic DAGs results in a CycleDetectedException
   */
  @Test
  void DAGSortCycleDetectionTest() {
    assertThrows(CycleDetectedException.class, () -> {DAGSort.sortDAG(DAG5);});
    assertThrows(CycleDetectedException.class, () -> {DAGSort.sortDAG(DAG6);});
  }

  /**
   * Test that passing a null parameter results in a NullPointerException
   */
  @Test
  void DAGSortNullExceptionTest() {
    assertThrows(NullPointerException.class, () -> {DAGSort.sortDAG(null);});
  }

  /**
   * Test that providing 2 invalid DAGs with incorrect node values results in an InvalidNodeException
   */
  @Test
  void DAGSortInvalidNodeExceptionTest() {
    assertThrows(InvalidNodeException.class, () -> {DAGSort.sortDAG(DAG7);});
    assertThrows(InvalidNodeException.class, () -> {DAGSort.sortDAG(DAG8);});
  }
}