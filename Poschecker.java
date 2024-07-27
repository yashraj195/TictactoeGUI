//Positive,Negative and zero

class Poschecker
{
    public static void main(String[] args)
    {
        int num;
        Scanner sc = new Scanner(System.in);  
        System.out.print("Enter a number: ");
        num = sc.nextlnt();

        if (num>0)
        {
            system.out.println("The number is positive.");
        }

        else if (num<0)
        {
            system.out.println("The number is negative.");
        }

        else
        {
            system.out.println("The number is zero");
        }  
    }
}