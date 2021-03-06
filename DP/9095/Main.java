import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class Main
{
    private static int[] cache;
    public static int solve(int n)
    {
        cache = new int[n+1];
        Arrays.fill(cache, -1);
        
        return oneTwoThree(n);
    }
    
    private static int oneTwoThree(int n)
    {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else if (n == 3)
            return 4;
        
        if (cache[n] != -1)
            return cache[n];
        
        return cache[n] = oneTwoThree(n-3) + oneTwoThree(n-2) + oneTwoThree(n-1);
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(in.readLine());
        for (int i = 0; i < test; i++)
        {
            int n = Integer.parseInt(in.readLine());
            System.out.println(solve(n));
        }
    }
}