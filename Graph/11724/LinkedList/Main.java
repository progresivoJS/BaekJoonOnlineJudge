import java.util.*;
import java.io.*;

/**
 * problem 11724
 * 연결 요소의 개수
 * https://www.acmicpc.net/problem/11724
 * written by progresivoJS on 2017.09.21
 */
public class Main
{
    private static boolean[] marked;
    public static void solve(LinkedList<Integer>[] adj)
    {
        int n = adj.length;
        marked = new boolean[n];
        int count = 0;
        for (int v = 0; v < n; v++)
            if (!marked[v])
            {
                dfs(adj, v);
                count ++;
            }
        System.out.println(count);
    }
    
    private static void dfs(LinkedList<Integer>[] adj, int v)
    {
        marked[v] = true;
        
        for (int w : adj[v])
            if (!marked[w])
                dfs(adj, w);
    }
    
    public static void main(String[] args)
    {
        In.init();
        int n = In.nextInt();
        int m = In.nextInt();
        
        LinkedList<Integer>[] adj = (LinkedList<Integer>[]) new LinkedList[n];
        for (int i = 0; i < adj.length; i++)
            adj[i] = new LinkedList<Integer>();
            
        for (int i = 0; i < m; i++)
        {
            int from = In.nextInt() - 1;
            int to = In.nextInt() - 1;
            adj[from].add(to);
            adj[to].add(from);
        }
        
        solve(adj);
    }
    
    private static class In
    {
        private static BufferedReader br;
        private static StringTokenizer st;
    
        public static void init()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                br = new BufferedReader(new FileReader("/home/ubuntu/workspace/data.txt"));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
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