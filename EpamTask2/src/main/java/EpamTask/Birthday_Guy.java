package EpamTask;
import java.util.*;
abstract class Candie{
  //Base class for all the sweets and chocolates
  int weight;
  int price;
  //constructor to instantiate the object
  Candie(int weight,int price){
	  this.weight=weight;
	  this.price=price;
  }
  //setter and getter methods for two properties of base class
  void setWeight(int weight){
	  this.weight=weight;
  }
  void setPrice(int price){
	  this.price=price;
  }
  int getWeight(){
	  return(weight);
  }
  int getPrice(){
	  return(price);
  }
  abstract int choosingCandie(int total_weight);
}
class Chocolate extends Candie{
	String brand;
	//brand of the candie like diary milk,snickers etc,
	Chocolate(int weight,int price,String brand){
		super(weight,price);
		this.brand=brand;
	}
	void setBrand(String brand){
		this.brand=brand;
	}
	String getBrand(){
		return(brand);
	}
	int choosingCandie(int total_weight){
		System.out.println("Gift consist of "+brand+" chocolate"+" and price is:"+price);
		return(total_weight-weight);
	}
}
class Sweet extends Candie{
	String type_of_sweet;
	//type sweet like kova,laddo etc,
	Sweet(int weight,int price,String type_of_sweet){
		super(weight,price);
		this.type_of_sweet=type_of_sweet;
	}
	void setTypeOfSweet(String type_of_sweet){
		this.type_of_sweet=type_of_sweet;
	}
	String getTypeOfSweet(){
		return(type_of_sweet);
	}
	int choosingCandie(int total_weight){
		System.out.println("Gift consist of "+type_of_sweet+" chocolate"+" and price is:"+price);
		return(total_weight-weight);
	}
}

public class Birthday_Guy{
	
	public static void main(String args[]) {
		int total_weight;
		
	    //weight in grams,price in Rs
		ArrayList<String> gift=new ArrayList<String>();//stores the final gift
		int choice;//variable used to select a particular item
		Chocolate[] choco= {new Chocolate(100,10,"Nestle"),new Chocolate(200,20,"Amul"),new Chocolate(300,30,"Cadbury")  };
		Sweet[] sweet= {new Sweet(100,10,"Laddo"),new Sweet(200,20,"Kova"),new Sweet(300,30,"Rasgulla")};
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the total weight of the birthday gift in grams:");
		total_weight=scanner.nextInt();
		int flag=0;//To ask the user to add more candies if there are are less
		while(total_weight>0) {
			    
				System.out.println("Choose your favourite candie between chocolate and sweet....");
				System.out.println("For chocolate enter 1");
				System.out.println("For Sweet enter 2");
				choice=scanner.nextInt();
				if(choice==1) {
					int choice_chocolate=-1;
					System.out.println("Choose your favourite chocolate....");
					System.out.println("For Nestle enter 0");
					System.out.println("For Amul enter 1");
					System.out.println("For Cadbury enter 2");
					choice_chocolate=scanner.nextInt();
					if(choice_chocolate==0) {
						total_weight=choco[0].choosingCandie(total_weight);
						gift.add(choco[0].getBrand());
					}
					else if(choice_chocolate==1) {
						total_weight=choco[1].choosingCandie(total_weight);
						gift.add(choco[1].getBrand());
					}
					else if(choice_chocolate==2)
					{
						total_weight=choco[2].choosingCandie(total_weight);
						gift.add(choco[2].getBrand());
					}
					else
						System.out.println("Wrong option entered please try again..!");
						
					
			}
				else {
					int choice_sweet=-1;
					choice_sweet=scanner.nextInt();
					System.out.println("Choose your favourite Sweet....");
					System.out.println("For Laddo enter 0");
					System.out.println("For Kova enter 1");
					System.out.println("For Rasgulla enter 2");
					if(choice_sweet==0) {
						total_weight=choco[0].choosingCandie(total_weight);
						gift.add(sweet[0].getTypeOfSweet());
					}
					else if(choice_sweet==1) {
						total_weight=choco[1].choosingCandie(total_weight);
						gift.add(sweet[1].getTypeOfSweet());
					}
					else if(choice_sweet==2)
					{
						total_weight=sweet[2].choosingCandie(total_weight);
						gift.add(sweet[2].getTypeOfSweet());
					}
					else
						System.out.println("Wrong option entered please try again..!");
					
				}
				System.out.println("Available weight left:"+total_weight);
				System.out.println("Enter 0 to add more candies");
				System.out.println("Enter 1 to stop preparing the gift");
				flag=scanner.nextInt();
			if(total_weight<100 && flag==1)
				 break;
			
		}
		
		
		scanner.close();
		
	}
	

}
