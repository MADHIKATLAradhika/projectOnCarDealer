package carDealer;
import java.util.*;
public class CarDealerUse {
	public static void main(String[] args)
	{
		
		String carNames[]={"Polo Trendline","Polo Highline","Virtus Trendline","Virtus Highline","Taigun Trendline","Taigun Highline ","Taigun Topline"};
		int showRoomPrice[]= {870000,1009000,1105000,1308000,1489000,1542000,1771000};
		for(int i=0;i<carNames.length;i++)
			System.out.println((i+1)+"  "+carNames[i]+"  "+showRoomPrice[i]);
		System.out.println("Select car model: ");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Car temp = null;
		switch(n)
		{
		case 1:temp =new PoloTrendline();
		break;
		case 2:temp =new PoloHighline();
		break;
		case 3:temp =new VirtusTrendline();
		break;
		case 4:temp =new VirtusHighline();
		break;
		case 5:temp=new TaigunTrendline();
		break;
		case 6:temp = new TaigunHighline();
		break;
		case 7:temp=new TaigunTopline();
		break;
	}
		System.out.println("Do you need Insurance: ");
		String ins=sc.next();
		System.out.println("Do you need Additional Accessories: ");
		String acc=sc.next();
		double discount;
		String inputdis;
		boolean isAccessory = false;
		boolean isInsurance=false;
		double total;
		System.out.println("Dealer discount: ");
		inputdis=sc.next();
		if(acc.charAt(0)=='y'||acc.charAt(0)=='Y')
			isAccessory=true;
		if(ins.charAt(0)=='y'||ins.charAt(0)=='Y')
			isInsurance=true;
		
		if(inputdis.contains("%"))
		{
			discount=Double.parseDouble(inputdis.replace("%",""));
			discount=(discount)*(temp.cost/100);
			
		}
		else {
			discount=Double.parseDouble(inputdis);
		}
		
		if(discount > 30000)
		{
			System.out.println("Discount cannot exceeds 30000");
			return;
		}
		else
		{
			if(isAccessory==true && isInsurance==true)
			{
				total=temp.cost+113990+47300+11000+15000-discount;
			}    
			else if(isAccessory==false && isInsurance==true)
			{
				total=temp.cost+113990+47300+11000+0-discount;
			}
			else
			{
				total=temp.cost+113990+0+11000+0-discount;
			}
		}
			System.out.println("Total Cost is : "+total);
		
	}

}
