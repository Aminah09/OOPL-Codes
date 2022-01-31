public class Generics {
    static boolean isPrime(int num)
    {
        int flag = 0;
        for (int i = 2; i<num; i++)
            if (num % i ==0)
            {
                flag = 1;
                break;
            }
        if (flag == 0)
            return true;
        return false;
    }
    static <T> void count (String type, T[] element)
    {
        int even = 0, odd = 0, prime = 0, palindrome = 0;

        // EVEN
        if(type.equals("even"))
        {
            for (T value : element)
                if (Integer.parseInt(value.toString()) % 2==0)
                    even++;
            System.out.println("Total even count is: "+even);
        }

        // ODD
        if(type.equals("odd"))
        {
            for (T value : element)
                if (Integer.parseInt(value.toString()) % 2 != 0)
                    odd++;
            System.out.println("Total odd count is: "+odd);
        }

        // PRIME
        if(type.equals("prime"))
        {
            for (T value : element)
                if (isPrime(Integer.parseInt(value.toString())))
                    prime++;
            System.out.println("Total prime count is: "+prime);
        }

        // PALINDROME
        if(type.equals("palindrome"))
        {
            for (T value : element) {
                StringBuffer rev = new StringBuffer(value.toString());
                if (value.toString().equals(new String(rev.reverse())))
                    palindrome++;
            }
            System.out.println("Total palindrome count is: "+palindrome);
        }
    }
    public static void main(String[] args) {
        Integer array1[] = {45,7,12,84,38,115,29,30,19};
        count("even", array1);
        count("odd", array1);
        count("prime", array1);
        count("palindrome", array1);

        Short array2[] = {45,73,12,84,38,151,29,30,19};
        count("even", array2);
        count("odd", array2);
        count("prime", array2);
        count("palindrome", array2);

    }
}
