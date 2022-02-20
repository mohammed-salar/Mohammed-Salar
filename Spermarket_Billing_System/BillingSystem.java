import java.util.ArrayList;
import java.util.Scanner;

class Product
{
	private String pname;
	private int qty;
	private double price;
	private double totalPrice;


	//constructor
	Product(String pname, int qty, double price, double totalPrice)
	{
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.totalPrice = totalPrice;
	}


	//display format
	public static void displayFormat()
	{
		System.out.println("\nName	Quantity	Price	totalPrice\n");
	}


	//display
	public void display()
	{
		System.out.format("%-9s %8d %10.2f %10.2f\n", pname, qty, price, totalPrice);
	}
}

public class BillingSystem
{
	public static void main(String[] args) 
	{
		String productName = null;
		int quantity = 0;
		double price = 0.0;
		double totalPrice = 0.0;
		double overallPrice = 0.0;
		char choice = '\0';


		Scanner sc = new Scanner(System.in);

		ArrayList<Product> product = new ArrayList<Product>();

		do
		{
			System.out.println("Enter product details ");
			

			System.out.println("Name : ");
			productName = sc.nextLine();


			System.out.println("Quantity : ");
			quantity = sc.nextInt();


			System.out.println("Price(per Item) : ");
			price = sc.nextDouble();


			//calculate total price for that product
			totalPrice = price * quantity;

			//calculate overall price
			overallPrice += totalPrice;

			//create product class object and ad it to the list
			product.add(new Product(productName, quantity, price, totalPrice));

			//ask to continue
			System.out.println("want to add more items? (Y or N) : ");
			choice = sc.next().charAt(0);

			sc.nextLine();
		}

		while(choice == 'y' || choice == 'Y');


		Product.displayFormat();
		for(Product p : product)
		{
			p.display();
		}

		System.out.println("\nOverall Price = "+overallPrice);

		sc.close();
	}
}