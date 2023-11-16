# Acyclic-Directed-Graph-Topological-Sort
A tool that takes a directed acyclic graph as input and returns a topological sort of the nodes.

*Nodes are assumed to be labelled from 0 to [number of nodes] - 1.*

# Usage:
- Example usage can be found in `DAGProviderTEST.java`
- **DAGSort.SortDag()** takes int[][] as a parameter; an array representing the edges of the graph. Each row contains the immediate out-neighbours of a particular node.

# Tests:
- Junit tests can be found in `DAGSortTest.java`
- Tested graphs are seen in `GraphValidArrays.txt` and `Graphs.png`
