/**
 * Created by tomek on 9/26/14.
 */
public class AddInts {
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        int sum = 0;
        for (int i = 0; i < N; i++)
            sum = sum + StdIn.readInt();
        System.out.println("Sum is " + sum);
    }
}
