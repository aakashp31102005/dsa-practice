import  java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class graphtropologicalfull {
    public static void main(String[] args) {
        int n = 5; // Number of nodes
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }

        // Sample Graph (Adjacency List Representation)
        al.get(5).add(0);
        al.get(5).add(2);
        al.get(4).add(0);
        al.get(4).add(1);
        al.get(3).add(1);
        al.get(2).add(3);

        boolean[] visited = new boolean[n]; // Visited array

        tropologicalsort(al);
    }

    public static boolean courseschedulecanFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < numCourses; i++) {
            al.get(prerequisites[i][1]).add(0);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(i, al, visited, recStack)) {
                    return false; // Cycle detected
                }
            }
        }
        boolean[] arr = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!arr[i]) {
                helper(i, arr, al);
            }
        }
        for (boolean visi : arr) {
            if (!visi) return false;
        }
        return true;
    }

    public static boolean hasCycle(int i, ArrayList<ArrayList<Integer>> al, boolean[] visited, boolean[] recStack) {
        if (recStack[i]) return true;
        if (visited[i]) return false;

        visited[i] = true;
        recStack[i] = true;

        for (int neighbor : al.get(i)) {
            if (hasCycle(neighbor, al, visited, recStack)) {
                return true;
            }
        }

        recStack[i] = false;
        return false;
    }

    public static void helper(int i, boolean[] visited, ArrayList<ArrayList<Integer>> arr) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int element : arr.get(i)) {
            if (!visited[element]) {
                helper(element, visited, arr);
            }
        }
    }


    public static void tropologicalsort(ArrayList<ArrayList<Integer>> al) {
        boolean[] arr = new boolean[al.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < al.size(); i++) {
            if (!arr[i]) {
                dfs(i, arr, al, stack);
                stack.add(i);
            }
        }
        System.out.println(stack.reversed());
    }

    public static void dfs(int i, boolean[] arr, ArrayList<ArrayList<Integer>> al, Stack<Integer> stack) {
        if (arr[i]) {
            return;
        }
        arr[i] = true;
        int iter = 0;
        while (iter < al.get(i).size()) {
            if (!arr[al.get(i).get(iter)]) {
                dfs(al.get(i).get(iter), arr, al, stack);
                stack.add(al.get(i).get(iter));
            }
            iter++;
        }
    }


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null; // Edge case
        HashMap<Node, Node> visited = new HashMap<>();
        return helperForCloneGraph(node, visited);
    }

    private Node helperForCloneGraph(Node node, HashMap<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node); // Return the already created clone
        }

        // Create a new cloned node
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone); // Mark node as visited

        // Recursively clone all neighbors and add them to the clone's neighbors list
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(helperForCloneGraph(neighbor, visited));
        }

        return clone;
    }


}