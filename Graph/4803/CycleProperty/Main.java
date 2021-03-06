import java.util.*;
import java.io.*;

/**
 * problem 4803
 * 트리
 * https://www.acmicpc.net/problem/4803
 * written by progresivoJS on 2017.10.19
 */
public class Main
{
    private static LinkedList<Integer>[] adj;
    private static boolean[] marked;
    private static boolean hasCycle;

    private static StringBuilder str;
    
    // count acyclic graph.
    public static void solve(LinkedList<Integer>[] adj, int caseNumber)
    {
        int n = adj.length;
        
        marked = new boolean[n];
        int count = 0;
        for (int v = 0; v < n; v++)
            if (!marked[v])
            {
                hasCycle = false;
                dfs(-1, v);
                if (!hasCycle)
                    count++;
            }
            
        str.append("Case ").append(caseNumber).append(": ");
        if (count == 0)
            str.append("No trees.");
        else if (count == 1)
            str.append("There is one tree.");
        else
            str.append("A forest of ").append(count).append(" trees.");
        str.append('\n');
    }
    
    private static void dfs(int u, int v)
    {
        marked[v] = true;
        for (int w : adj[v])
        {
            if (hasCycle) return;
            if (!marked[w])
                dfs(v, w);
            else if (w != u)
                hasCycle = true;
        }
    }
    
    public static void main(String[] args)
    {
        In.init();
        str = new StringBuilder();
        int caseNumber = 1;
        while (true)
        {
            int n = In.nextInt();
            int m = In.nextInt();
            if (n == 0 && m == 0) break;
            
            adj = (LinkedList<Integer>[]) new LinkedList[n];
            for (int i = 0; i < n; i++)
                adj[i] = new LinkedList<>();
            
            while (m-- > 0)
            {
                int from = In.nextInt() - 1;
                int to = In.nextInt() - 1;
                adj[from].add(to);
                adj[to].add(from);
            }
            
            solve(adj, caseNumber++);
        }
        System.out.println(str);
    }
    
    private static class In
    {
        private static BufferedReader br;
        private static StringTokenizer st;
    
        public static void init()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    
        public static String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    
        public static int nextInt()
        {
            return Integer.parseInt(next());
        }
    }
}
