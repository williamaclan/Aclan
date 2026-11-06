import java.util.Scanner;

public class CustomerTransactionManager {

    public static void main(String[] args) {

        // TASK 1: Scanner Input
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of customers: ");
        int n = sc.nextInt();

        System.out.print("Transactions per customer: ");
        int t = sc.nextInt();

        // TASK 2: 1D and 2D Arrays
        double[][] data = new double[n][t];
        double[] total = new double[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < t; j++) {
                System.out.print("Enter amount: ");
                data[i][j] = sc.nextDouble();
                total[i] += data[i][j];
            }
        }

        // TASK 3: Sorting Algorithm
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Merge Sort");

        System.out.print("Choose: ");
        int choice = sc.nextInt();

        System.out.print("1. Ascending  2. Descending: ");
        int order = sc.nextInt();

        boolean asc = order == 1;

        switch (choice) {
            case 1:
                bubble(total, asc);
                break;
            case 2:
                insertion(total, asc);
                break;
            case 3:
                selection(total, asc);
                break;
            case 4:
                java.util.Arrays.sort(total);
                if (!asc) {
                    for (int i = 0; i < n / 2; i++) {
                        double temp = total[i];
                        total[i] = total[n - 1 - i];
                        total[n - 1 - i] = temp;
                    }
                }
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        // Display Result
        System.out.println("Sorted Transactions:");

        for (int i = 0; i < n; i++) {
            System.out.println(total[i]);
        }

        sc.close();
    }

    // Bubble Sort
    static void bubble(double[] a, boolean asc) {
        for (int i = 0; i < a.length - 1; i++)
            for (int j = 0; j < a.length - i - 1; j++)
                if (asc ? a[j] > a[j+1] : a[j] < a[j+1]) {
                    double temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
    }

    // Insertion Sort
    static void insertion(double[] a, boolean asc) {
        for (int i = 1; i < a.length; i++) {
            double key = a[i];
            int j = i - 1;
            while (j >= 0 && (asc ? a[j] > key : a[j] < key)) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }

    // Selection Sort
    static void selection(double[] a, boolean asc) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++)
                if (asc ? a[j] < a[min] : a[j] > a[min])
                    min = j;

            double temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
}