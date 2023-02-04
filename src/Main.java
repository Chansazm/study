//importing the right tools
import java.io.*; // for File
import java.util.*; // for Scanner
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Getting the file
        System.out.println("Enter the File name: ");
        //FileReader file = new FileReader();
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();

        Scanner input = new Scanner(new File(st));
        //Initialising variables
        int[] array;
        double sum = 0.0;

        //Declaring an array that will contain the numbers
        ArrayList<Double> list = new ArrayList<>();
        //looping through the input
        System.out.println("The numbers are:");
        while (input.hasNextDouble()) {
            double next = input.nextDouble();
            //adding the numbers in variable next to the array at each iteration
            list.add(next);

            //finding the sum of the numbers
            sum = sum + next;
        }



        System.out.println(list.size());
        //System.out.printf("Sum = %.1f\n", sum);

        //calculating the Mean by dividing by the number of items in the array
        double mean = sum/list.size();
        //Outputting the Mean
        System.out.println("The Mean is: "+mean +"\nThanks!");

        //standard deviation calculation
        double standardDeviation = 0.0;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            standardDeviation += Math.pow(list.get(i) - mean, 2);
        }

        standardDeviation = Math.sqrt(standardDeviation / n);
        System.out.println("The Standard Deviation is: "+standardDeviation +"\nThanks!");
    }
}