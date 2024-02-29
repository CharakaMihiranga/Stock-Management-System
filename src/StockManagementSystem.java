import java.util.*;
class courseWork{
	public static Scanner input=new Scanner(System.in);
	public static String[] cred={"abc","0000"};
	public static String username;
	public static String password;
	public static String[][] supplier=new String [0][2];
	public static String[] itemCategories=new String [0];
	public static String[][] items=new String[0][6];
	private final static void clearConsole(){
		final String os=System.getProperty("os.name");
		try{
			if(os.equals("Linux")){
				System.out.print("\033\143");
				}else if(os.equals("Windows")){
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				}else{
					System.out.print("\033[H\033[2J");
					System.out.flush();
				}
				}catch(final Exception e){
					//handle the exception
					System.err.println(e.getMessage());
					}
			}
	public static void loginPage(){
		
		System.out.println("+-----------------------------------------------------------------+");
        System.out.println("|\t\t\tLOGIN PAGE	\t\t\t  |");
        System.out.println("+-----------------------------------------------------------------+");
		System.out.print("\n");
	
		
		do{
			System.out.print("User Name :");
			username=input.next();
			
			if(username.equals(cred[0])){
				do{
				System.out.print("\n");
				System.out.print("Password :");
				password=input.next();

				if(password.equals(cred[1])){
					continue;
					}else{
					System.out.println("password is incorrect.please try again!");
					}
					}while(!password.equals(cred[1]));

					}else{
				System.out.println("user name is invalid.please try again!");
				System.out.print("\n");
				}
		}while(!username.equals(cred[0]));
		
		clearConsole();
		homePage();
			
	}
	public static void homePage(){
		System.out.println("+-----------------------------------------------------------------+");
        System.out.println("| \t\tWELCOME TO IJSE STOCK MANAGEMENT SYSTEM\t\t  |");
        System.out.println("+-----------------------------------------------------------------+\n");
        System.out.println("[1] Change the Credentials		[2] Supplier Manage");
        System.out.println("[3] Stock Manage			[4] Log out");
        System.out.println("[5] Exit the system\n");
		
		System.out.print("Enter an option to continue >");
		int homePageOption=input.nextInt();
		
		
		switch(homePageOption){
			
			case 1:
				clearConsole();
				changeTheCredentials();
				break;
			
			case 2:
				clearConsole();
				supplierManage();
				break;
			case 3:
				clearConsole();
				stockManage();
				break;
			case 4:
				clearConsole();
				loginPage();
				break;
			case 5:
				clearConsole();
				System.exit(0);	
				break;
		}
	}
	public static void changeTheCredentials(){
		System.out.println("+-----------------------------------------------------------------+");
        System.out.println("| \t\t	CREDENTIAL MANAGE\t\t\t  |");
        System.out.println("+-----------------------------------------------------------------+\n");
		
			do{
			System.out.print("Please enter the user name to verify it's you :");
			username=input.next();
			
			if(username.equals(cred[0])){
				System.out.print("\n");	
				System.out.println("Hey "+username+" !");
				do{
				System.out.print("\n");	
				System.out.print("Enter your current password :");
				password=input.next();

				if(password.equals(cred[1])){
					System.out.print("Enter new password :");
					cred[1]=input.next();
					
					System.out.print("Password changed successfully!Do you want to go home page (Y/N) :");
					char credOp=input.next().charAt(0);
					
					if(credOp=='Y' || credOp=='y'){
						clearConsole();
						homePage();
						break;
						}else if(credOp=='N' || credOp=='n'){
							clearConsole();
							changeTheCredentials();
							break;
						}
					}else{
					System.out.println("incorrect password.try again!");
					}
					}while(!password.equals(cred[1]));

					}else{
				System.out.println("invalid user name.try again!");
				System.out.print("\n");
				}
		}while(!username.equals(cred[0]));
	}
	
	public static void supplierManage(){
		
		System.out.println("+-----------------------------------------------------------------+");
        System.out.println("| \t\t	SUPPLIER MANAGE\t\t\t\t  |");
        System.out.println("+-----------------------------------------------------------------+\n");
		
		System.out.println("[1] Add Supplier			[2] Update Supplier ");
        System.out.println("[3] Delete Supplier			[4] View Supplier");
        System.out.println("[5] Search Supplier			[6]Home Page");
		System.out.print("\nEnter an option to continue >");
		int supplierOption=input.nextInt();
		
		switch(supplierOption){
		
			case 1:
				clearConsole();
				addSupplier();
				break;
			case 2:
				clearConsole();
				updateSupplier();
				break;
			case 3:
				clearConsole();
				deleteSupplier();
				break;
			case 4:
				clearConsole();
				viewSuppliers();
				break;
			case 5:
				clearConsole();
				searchSupplier();
				break;
			case 6:
				clearConsole();
				homePage();
				break;
		}	
	}
	public static void addSupplier(){
		
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("| \t\t	ADD SUPPLIER\t\t\t\t  |");
		System.out.println("+-----------------------------------------------------------------+\n");
		
		boolean option=false;
		L1:
		do {
			System.out.print("Supplier ID :");
			String id = input.next();	
			for (int i = 0; i < supplier.length; i++) {
				if(id.equals(supplier[i][0])) {
					System.out.println("already exists.try another supplier id!\n");
					continue L1;
				}
			}
			System.out.print("Supplier Name :");
			String Name=input.next();
			
			supplier= supplierGrow();
			
			supplier[supplier.length- 1][0] = id;
			supplier[supplier.length- 1][1] = Name;
			
			System.out.print("added successfully!Do you want to add another supplier(Y/N)?");
			char addOption=input.next().charAt(0);
			
			if(addOption=='Y' || addOption=='y'){
				option=true;
				clearConsole();
				addSupplier();
				}
			if(addOption=='N' || addOption=='n'){
					clearConsole();
					supplierManage();
				}
			
		} while (option);
		
	}
		
	public static String[][] supplierGrow(){
		
		String[][] temp=new String[supplier.length+1][2];
		for (int i = 0; i < supplier.length; i++)
		{
			for (int j = 0; j < supplier[i].length; j++)
			{
				temp[i][j]=supplier[i][j];
			}
			
		}
		return temp;
	}	
	
	public static void updateSupplier(){
	
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("| \t\t	UPDATE SUPPLIER\t\t\t\t  |");
		System.out.println("+-----------------------------------------------------------------+\n");
		
		boolean updateCheck=false;
		int update=0;
		char updateOption='N';
		
		do {
			System.out.print("Supplier ID :");
			String supplierId=input.next();	
			
			for (int i = 0; i < supplier.length; i++)
			{	
				if(supplierId.equals(supplier[i][0])){
					updateCheck=true;
					update=i;
					break;
					}
				}
			
			if(updateCheck){
				System.out.print("Supplier Name :"+supplier[update][1]);
				System.out.print("\nEnter the new supplier name :");
				String name=input.next();
				supplier[update][1]=name;
			
				System.out.print("Updated Successfully!Do you want to update another supplier?(Y/N)");
				updateOption=input.next().charAt(0);
			
					if(updateOption=='Y' || updateOption=='y'){
						clearConsole();
						updateSupplier();
						}
					if(updateOption=='N' || updateOption=='n'){
						clearConsole();
						supplierManage();
						}	
							}else{
								
					System.out.print("can't find supplier id.try again!\n\n");
					
				}
		}while (updateOption!='Y' || updateOption!='y');
	}
	
	public static void deleteSupplier(){
		
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("| \t\t	DELETE SUPPLIER\t\t\t\t  |");
		System.out.println("+-----------------------------------------------------------------+\n");
		
		boolean deleteCheck=false;
		int delete=0;
		
		do {
			System.out.print("Supplier ID :");
			String supplierId=input.next();	
		
			for (int i = 0; i < supplier.length; i++)
			{	L1:
				if(supplierId.equals(supplier[i][0])){
					deleteCheck=true;
					delete=i;
					break;
				}
				
				}
		
			if(deleteCheck){
			
			supplier=deleteElement(delete);

			System.out.print("Deleted Successfully!Do you want to delete another supplier?(Y/N)");
			char deleteOption=input.next().charAt(0);
					
			
					if(deleteOption=='Y'|| deleteOption=='y'){
						clearConsole();
						deleteSupplier();
						}
					if(deleteOption=='N' || deleteOption=='n'){
						clearConsole();
						supplierManage();
						}	
			}else{
				System.out.print("Can't find supplier id.try again!\n\n");
				}
		}while (true);
	
	}
	public static String[][] deleteElement(int delete){
	
		String[][] temp=new String[supplier.length-1][2];
		int index=0;
	
			for (int i = 0; i < supplier.length; i++){
				if(supplier[i][0].equals(supplier[delete][0])){
					for (int j = 0; j < supplier.length; j++){
						if(j!=i){
						temp[index++]=supplier[j];	
						}
					}
					supplier=temp;
					break;
				}
			}	
		return temp;	
	}
	public static void viewSuppliers(){
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("| \t\t	VIEW SUPPLIERS\t\t\t\t  |");
		System.out.println("+-----------------------------------------------------------------+\n");
		
		System.out.printf("+----------------------+----------------------------+\n");
		System.out.printf("| %-20s | %-20s |","    SUPPLIER ID","	SUPPLIER NAME");
		System.out.printf("\n+----------------------+----------------------------+");
		
		for (int i = 0; i < supplier.length; i++)
		{
			System.out.printf("\n| %-20s | %-20s |","      "+supplier[i][0],"	"+supplier[i][1]);
		}
		System.out.printf("\n+----------------------+----------------------------+");
		
	System.out.print("\nDo you want to go supplier manage page(Y/N)?");
	char viewOption=input.next().charAt(0);
	
	if(viewOption=='Y' || viewOption=='y'){
		clearConsole();
		supplierManage();
	
		}else if(viewOption=='N' || viewOption=='n'){
			clearConsole();
			viewSuppliers();
	
			}
	
	}
	public static void searchSupplier(){
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("| \t\t	SEARCH SUPPLIER\t\t\t\t  |");
		System.out.println("+-----------------------------------------------------------------+\n");
		
		boolean searchCheck=false;
		int search=0;
		char searchOption='N';
		
			do {
			System.out.print("Supplier ID :");
			String supplierId=input.next();	
			
			for (int i = 0; i < supplier.length; i++)
			{	
				if(supplierId.equals(supplier[i][0])){
					searchCheck=true;
					search=i;
					break;
					}
				}
			
			if(searchCheck){
				System.out.print("Supplier Name :"+supplier[search][1]);
				
			
				System.out.print("\nadded successfully!Do you want to add another find(Y/N)?");
				searchOption=input.next().charAt(0);
			
					if(searchOption=='Y' || searchOption=='y'){
						clearConsole();
						searchSupplier();
						}
					if(searchOption=='N' || searchOption=='n'){
						clearConsole();
						supplierManage();
						}	
							}else{
								
					System.out.print("can't find supplier id.try again!\n\n");
					
				}
		}while (searchOption!='Y' || searchOption=='y');
	}
	public static void stockManage(){
		
		System.out.println("+-----------------------------------------------------------------+");
        System.out.println("| \t\t	STOCK MANAGEMENT\t\t\t  |");
        System.out.println("+-----------------------------------------------------------------+\n");
        
        System.out.println("[1] Manage Item Categories			[2] Add Item");
        System.out.println("[3] Get Item Supplier Wise			[4] View Items");
        System.out.println("[5] Rank Items Per Unit Price			[6] Home Page\n");
		
		System.out.print("Enter an option to continue >");
		int stockOption=input.nextInt();
		
		switch(stockOption){
			
			case 1:
				clearConsole();
				manageItemCategory();
				break;
			case 2:
				clearConsole();
				addItem();
				break;
			case 3:
				clearConsole();
				getItemSupplierWise();
				break;
			case 4:
				clearConsole();
				viewItems();
				break;
			case 5:
				clearConsole();
				rankedUnitPrice();
				break;
			case 6:
				clearConsole();
				homePage();
				break;
		}
			
	}
	public static void manageItemCategory(){
		
		System.out.println("+-----------------------------------------------------------------+");
        System.out.println("| \t\t\tMANAGE ITEM CATEGORY\t\t\t  |");
        System.out.println("+-----------------------------------------------------------------+\n");
        
        System.out.println("[1] Add New Item Category			[2] Delete Item Category");
        System.out.println("[3] Update Item Category			[4] Stock Management\n");
		
		System.out.print("Enter an option to continue >");
		int stockOption=input.nextInt();
		
		switch(stockOption){
		
			case 1:
				clearConsole();
				addItemCategory();
				break;
			case 2:
				clearConsole();
				deleteItemCategory();
				break;
			case 3:
				clearConsole();
				updateItemCategory();
				break;
			case 4:
				clearConsole();
				stockManage();
				break;
		}		
	}
	public static void addItemCategory(){
		System.out.println("+-----------------------------------------------------------------+");
        System.out.println("| \t\t\tADD ITEM CATEGORY\t\t\t  |");
        System.out.println("+-----------------------------------------------------------------+\n");
        
        boolean addItem=false;
		
		L1:
		do {
			System.out.print("Enter the new item category :");
			String categoryName = input.next();	
			
			for (int i = 0; i < itemCategories.length; i++) {
				if(categoryName.equals(itemCategories[i])) {
					System.out.println("already exists.try another category!\n");
					continue L1;
				}
			}
			
			itemCategories= itemsGrow();
			
			itemCategories[itemCategories.length-1] = categoryName;
					
			System.out.print("added successfully!Do you want to add another category(Y/N)?");
			char addItemOption=input.next().charAt(0);
			
			if(addItemOption=='Y' || addItemOption=='y'){
				addItem=true;
				clearConsole();
				addItemCategory();
				}
			if(addItemOption=='N' || addItemOption=='n'){
					clearConsole();
					manageItemCategory();
				}
			
		} while (addItem);
	}	
	public static String[] itemsGrow(){
		
		String[] temp=new String[itemCategories.length+1];
		
		for (int i = 0; i < itemCategories.length; i++)
		{
			
				temp[i]=itemCategories[i];
			}
			
		return temp;
	}	
	public static void deleteItemCategory(){
	
		System.out.println("+-----------------------------------------------------------------+");
        System.out.println("| \t\t\tDELETE ITEM CATEGORY\t\t\t  |");
        System.out.println("+-----------------------------------------------------------------+\n");
    	
    	boolean deleteCategoryCheck=false;
		int deleteCategory=0;
		
		do {
			System.out.print("Enter the item category :");
			String categoryName=input.next();	
		
			for (int i = 0; i < itemCategories.length; i++)
			{	L1:
				if(categoryName.equals(itemCategories[i])){
					deleteCategoryCheck=true;
					deleteCategory=i;
					break;
				}
				
			}
		
			if(deleteCategoryCheck){
			
			itemCategories=deleteItemElement(deleteCategory);

			System.out.print("Deleted Successfully!Do you want to delete another category?(Y/N)");
			char deleteCategoryOption=input.next().charAt(0);
					
			
					if(deleteCategoryOption=='Y'|| deleteCategoryOption=='y'){
						clearConsole();
						deleteItemCategory();
						}
					if(deleteCategoryOption=='N' || deleteCategoryOption=='n'){
						clearConsole();
						manageItemCategory();
						}	
			}else{
				System.out.print("Can't find category.try again!\n\n");
				}
		}while (true);
	
	}
	public static String[] deleteItemElement(int deleteCategory){
	
		String[] temp=new String[itemCategories.length-1];
		int index=0;
	
			for (int i = 0; i < itemCategories.length; i++){
				
				if(itemCategories[i].equals(itemCategories[deleteCategory])){
				
					for (int j = 0; j < itemCategories.length; j++){
						if(j!=i){
				
						temp[index++]=itemCategories[j];	
						}
					}
					itemCategories=temp;
					break;
				}
			}	
		return temp;	
	}			
	
	public static void updateItemCategory(){
	
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("| \t\t\tUPDATE ITEM CATEGORY\t\t\t  |");
		System.out.println("+-----------------------------------------------------------------+\n");
		
		boolean updateCategoryCheck=false;
		int updateCategory=0;
		char updateCategoryOption='N';
		
		
		do {
			System.out.print("Enter the item category :");
			String updateName=input.next();	
			
			for (int i = 0; i < itemCategories.length; i++)
			{	
				if(updateName.equals(itemCategories[i])){
					updateCategoryCheck=true;
					updateCategory=i;
					break;
					}
				}
			
			if(updateCategoryCheck){
				System.out.print("Enter the new item category name :");
				String category=input.next();
				itemCategories[updateCategory]=category;
			
				System.out.print("Updated Successfully!Do you want to update another category?(Y/N)");
				updateCategoryOption=input.next().charAt(0);
			
					if(updateCategoryOption=='Y' || updateCategoryOption=='y'){
						clearConsole();
						updateItemCategory();
						}
					if(updateCategoryOption=='N' || updateCategoryOption=='n'){
						clearConsole();
						manageItemCategory();
						}	
							}else{
								
					System.out.print("can't find category.try again!\n\n");
					
				}
		}while (updateCategoryOption=='N' || updateCategoryOption=='n');
	}
	
	public static void addItem(){
		
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("| \t\t\t    ADD ITEM\t\t\t\t  |");
		System.out.println("+-----------------------------------------------------------------+\n");
		
		int supplierLength=supplier.length;
		int itemCategoriesLength=itemCategories.length;
		boolean itemCodeOption=false;

		L1:
		do {
			
			if(itemCategoriesLength==0){
			System.out.print("OOPS!It seems that you don't have any item categories in the system.\nDo you want to add a new item category(Y/N)?");
			char add=input.next().charAt(0);
			
			if(add=='Y' || add=='y'){
				clearConsole();	
				addItemCategory();
				break;	
				}else{
					clearConsole();
					stockManage();	
					break;
					}
			}
			
			if(supplierLength==0){
			System.out.print("OOPS!It seems that you don't have any suppliers in the system.\nDo you want to add a new supplier(Y/N)?");
			char addsupplier=input.next().charAt(0);
			
			if(addsupplier=='Y' || addsupplier=='y'){
				clearConsole();
				addSupplier();
				}else{
					clearConsole();
					stockManage();
					}
				}	
			
			System.out.print("Item Code :");
			String itemCode = input.next();	
			
			for (int i = 0; i < items.length; i++) {
				if(itemCode.equals(items[i][1])) {
					System.out.println("already exists.try another item code!\n");
					continue L1;
				}
			}		
			
			items=growItems();
			
			items[items.length-1][1]=itemCode;
			
				System.out.print("\nSuppliers List :\n");
		
			System.out.printf("+----------+-------------------+----------------------------------+\n");
			System.out.printf("| %-8s | %-15s | %-26s |","    #   ","	SUPPLIER ID  ","	SUPPLIER NAME   ");
			System.out.printf("\n+----------+-------------------+----------------------------------+");
			
			
		for (int i = 0; i < supplier.length; i++)
		{
			System.out.printf("\n| %-8s | %-15s | %-26s  |","    "+(i+1)+"   ","	   "+supplier[i][0]+"  ","	 "+supplier[i][1]+"");
		}
			System.out.printf("\n+----------+-------------------+----------------------------------+");
		
			System.out.print("\n\nEnter the supplier number >");
			String supplierNum=input.next();
		
			int supplierNumber=Integer.parseInt(supplierNum);
		
			items[items.length-1][0]=supplier[supplierNumber-1][0];
		
			System.out.print("\nItem Categories :\n");
			
			System.out.printf("+---------------+----------------------+\n");
			System.out.printf("| %-8s | %-15s |","	# ","   CATEGORY NAME    ");
			System.out.printf("\n+---------------+----------------------+");
		
		for (int i = 0; i < itemCategories.length; i++)
		{
			System.out.printf("\n| %-8s | %-15s |","	"+(i+1),"	"+itemCategories[i]);
		}
			System.out.printf("\n+---------------+----------------------+");
		
			System.out.print("\n\nEnter the category number >");
			String categoryNum=input.next();
			
			int categoryNumber=Integer.parseInt(categoryNum);
		
			items[items.length-1][5]=itemCategories[categoryNumber-1];

			System.out.print("\nDescription :");
			items[items.length-1][2]=input.next();
	
			System.out.print("Unit price :");
			items[items.length-1][3]=input.next();
		
			System.out.print("Qty on hand :");
			items[items.length-1][4]=input.next();
			
			System.out.print("added successfully!Do you want to add another Item(Y/N)?");
			char addOption=input.next().charAt(0);
			
				if(addOption=='Y' || addOption=='y'){
					itemCodeOption=true;
					clearConsole();
					addItem();
					}
				if(addOption=='N' || addOption=='n'){
						clearConsole();
						stockManage();
					}
			
		 }while (itemCodeOption);
				
	}	
	public static String[][] growItems(){
		
		String[][] temp=new String[items.length+1][6];
		for (int i = 0; i < items.length; i++)
		{
			for (int j = 0; j < items[i].length; j++)
			{
				temp[i][j]=items[i][j];
			}
			
		}
		return temp;
	}	
	public static void 	getItemSupplierWise(){
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("| \t\t    SEARCH ITEMS SUPPLIER WISE    \t\t  |");
		System.out.println("+-----------------------------------------------------------------+\n");
		
		boolean searchItem=false;
		int itemSearch=0;
		char searchItemOption='n';
		
			do{
			System.out.print("Supplier ID :");
			String searchId=input.next();	
			
			for (int i = 0; i < supplier.length; i++)
			{	
				if(searchId.equals(supplier[i][0])){
					searchItem=true;
					itemSearch=i;
					break;
					}
				}
			
				if(searchItem){
					System.out.print("Supplier Name :"+supplier[itemSearch][1]+"\n\n");
				
				
					System.out.printf("+----------------------+----------------------------+----------------------+----------------------+----------------------+\n");
					System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | ","   ITEM CODE ","	DESCRIPTION   ","   UNIT PRICE ","   QTY ON HAND ","   CATEGORY ");
					System.out.printf("\n+----------------------+----------------------------+----------------------+----------------------+----------------------+");
		
					for (int i = 0; i < items.length; i++)
					{
					
					if(searchId.equals(items[i][0])){

						System.out.printf("\n| %-15s | %-20s | %-19s | %-18s | %-20s | ","	"+items[i][1],"	"+items[i][2],"	"+items[i][3],"	 "+items[i][4],"   "+items[i][5]);

						}
					}
					System.out.printf("\n+----------------------+----------------------------+----------------------+----------------------+----------------------+");
				
					System.out.print("\nSearch successfully!Do you want to another Search(Y/N)?");
					searchItemOption=input.next().charAt(0);
			
					if(searchItemOption=='Y' || searchItemOption=='y'){
						clearConsole();
						getItemSupplierWise();
					}
					if(searchItemOption=='N' || searchItemOption=='n'){
						clearConsole();
						stockManage();
					}	
						}else{
						System.out.print("can't find supplier id.try again!\n\n");
					}
			}while (searchItemOption=='N' || searchItemOption=='n');
	}	
	public static void viewItems(){
	
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("| \t\t\t    VIEW ITEMS\t\t\t\t  |");
		System.out.println("+-----------------------------------------------------------------+");
		
		for (int i = 0; i < itemCategories.length; i++)
		{
		
			System.out.print("\n\n"+itemCategories[i]+" :\n");
			System.out.printf("+----------------------+----------------------------+----------------------+----------------------+----------------------+\n");
			System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | ","   SID ","	ITEM CODE   ","   DESCRIPTION ","   UNIT PRICE ","   QTY ON HAND ");
			System.out.printf("\n+----------------------+----------------------------+----------------------+----------------------+----------------------+");
			
			for (int j = 0; j < items.length; j++)
			{
				if(itemCategories[i].equals(items[j][5])){

				System.out.printf("\n| %-15s | %-20s | %-19s | %-19s | %-19s | ","	"+items[j][0],"	"+items[j][1],"	"+items[j][2],"	 "+items[j][3],"   "+items[j][4]);

					}
			}
		
			System.out.printf("\n+----------------------+----------------------------+----------------------+----------------------+----------------------+");
		}
		
		System.out.print("\nDo you want to go stock manage page(Y/N)?");
		char viewItemsOption=input.next().charAt(0);
		
		if(viewItemsOption=='Y' || viewItemsOption=='y'){
			clearConsole();
			stockManage();
		}else if(viewItemsOption=='N' || viewItemsOption=='n'){
			clearConsole();
			viewItems();
			}
	}
	
	public static void rankedUnitPrice(){
	
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("| \t\t        RANKED UNIT PRICE\t\t\t  |");
		System.out.println("+-----------------------------------------------------------------+");
	
		int []ar=new int[items.length];

		String[] convertedPrices=new String[ar.length];
		
		for (int i = 0; i < ar.length; i++){
			
			ar[i]=Integer.parseInt(items[i][3]);
		}
	
		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = 0; j < ar.length - 1; j++) {
				if(ar[j] > ar[j+1]) {
					int temp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = temp;
				}	
			}
		}
			
		for (int i = 0; i < items.length; i++){
			
			convertedPrices[i]=Integer.toString(ar[i]);
			
		}
		
		System.out.printf("+----------------------+----------------------------+----------------------+----------------------+----------------------+----------------------+\n");
		System.out.printf("| %-15s | %-20s | %-20s | %-20s | %-20s | %-16s |","	SID ","	ITEM CODE   ","   DESCRIPTION ","   UNIT PRICE ","   QTY ON HAND ","	CATEGORY ");
		System.out.printf("\n+----------------------+----------------------------+----------------------+----------------------+----------------------+----------------------+");
			
		for (int i = 0; i < ar.length; i++)
		{
			for (int j = 0; j < items.length; j++){
		
				if(convertedPrices[i].equals(items[j][3])){
				
					System.out.printf("\n| %-15s | %-20s | %-19s | %-19s | %-20s | %-16s |","	"+items[j][0],"	"+items[j][1],"	  "+items[j][2],"	 "+items[j][3],"   "+items[j][4],"	"+items[j][5]);
				}
			}
		}
			System.out.printf("\n+----------------------+----------------------------+----------------------+----------------------+----------------------+----------------------+");
		
		System.out.print("\nDo you want to go stock manage page(Y/N)?");
		char RankItemsOption=input.next().charAt(0);
		
		if(RankItemsOption=='Y' || RankItemsOption=='y'){
			clearConsole();
			stockManage();
			
		}else if(RankItemsOption=='N' || RankItemsOption=='n'){
			clearConsole();
			rankedUnitPrice();
			
			}
	}	
	public static void main(String args[]){
		
		
		loginPage();
		
		clearConsole();
		
		homePage();
		
		
			}
	}
	

