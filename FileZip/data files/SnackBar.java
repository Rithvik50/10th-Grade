import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SnackBar extends JFrame
                      implements ActionListener
{
  private static final String MY_PASSWORD = "kirby";
  private VendingMachine machine1, machine2, machine3, machine4;

  public SnackBar()
  {
    super("Snack Bar");

    Color brandColor1 = new Color(255, 180, 180); // r, g, b
    Color brandColor2 = new Color(255, 0, 0);
    Color brandColor3 = new Color(255, 255, 0);
    Color brandColor4 = new Color(255, 255, 255);

    // Load the coin icon for the vending machine buttons:
    ImageIcon coin = new ImageIcon("coin.gif");

    machine1 = new VendingMachine("Cake", brandColor1, 35, coin);
    machine2 = new VendingMachine("MaximumTomato", brandColor2, 45, coin);
    machine3 = new VendingMachine("SuperStar", brandColor3, 50, coin);
    machine4 = new VendingMachine("Super Lolipop", brandColor4, 75, coin);

    Box wall = Box.createHorizontalBox();
    wall.add(Box.createHorizontalStrut(5));
    wall.add(machine1);
    wall.add(Box.createHorizontalStrut(5));
    wall.add(machine2);
    wall.add(Box.createHorizontalStrut(5));
    wall.add(machine3);
    wall.add(Box.createHorizontalStrut(5));
    wall.add(machine4);
    wall.add(Box.createHorizontalStrut(5));

    JPanel service = new JPanel();
    service.add(new JLabel(" Service login: "));
    JPasswordField password = new JPasswordField("", 5);
    password.addActionListener(this);
    service.add(password);

    Container c = getContentPane();
    c.setBackground(Color.MAGENTA);
    c.add(wall, BorderLayout.CENTER);
    c.add(service, BorderLayout.SOUTH);
  }

  /**
   *  Password field: user strikes <Enter>
   */
  public void actionPerformed(ActionEvent e)
  {
    JPasswordField password = (JPasswordField)e.getSource();
    String word = new String(password.getPassword());
    password.setText("");
    if (MY_PASSWORD.equals(word))
    {
       double amt = Vendor.getTotalSales();
       int cake = Vendor.getCake();
       int tomato = Vendor.getTomato();
       int star = Vendor.getStar();
       int loli = Vendor.getLoli();
      machine1.reload();
      machine2.reload();
      machine3.reload();
      machine4.reload();
      JOptionPane.showMessageDialog(null,
         String.format("Total sales: $%.2f\n", amt) +
        "Machines reloaded " + cake + " cakes were bought, " + tomato + " max tomatoes were bought " + star + " super stars were bought " + loli + " super lolipops were bought ",
        "Service", JOptionPane.INFORMATION_MESSAGE);
    }
    else
    {
      JOptionPane.showMessageDialog(null,
        "Login failed", "Service", JOptionPane.ERROR_MESSAGE);
    }
  }

  // *****************************************************

  public static void main(String[] args)
  {
    SnackBar window = new SnackBar();
    window.setBounds(50, 50, 840, 430);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true);
  }
}





class VendingMachine extends JPanel
                            implements ActionListener
{
  private static final int FULL_STOCK = 5;
  private JButton deposit, deposit10000c, deposit2000c, deposit1000c, deposit500c, deposit100c, deposit25c, deposit10c, deposit5c, deposit1c, go;
  private JTextField display;
  private Vendor vendor;
  private Coins coins;
  boolean trayFull;
  Color brandColor;
  String brandName;
  private int quarters;
  private int dimes;
  private int nickels;
  private int pennies;

  public VendingMachine(String brand, Color color, int price, ImageIcon coin)
  {
    setBackground(Color.BLUE);
    brandColor = color;
    brandName = brand;

    JTextField banner = new JTextField("  " + brandName +
                                       "  " + price + "c  ");
    banner.setEditable(false);
    banner.setFont(new Font("Serif", Font.BOLD, 14));
    banner.setHorizontalAlignment(JTextField.CENTER);

	deposit10000c = new JButton(" OMG$100.00", coin);
	deposit10000c.addActionListener(this);
	deposit2000c = new JButton(" $20.00", coin);
	deposit2000c.addActionListener(this);
	deposit1000c = new JButton(" $10.00", coin);
	deposit1000c.addActionListener(this);
	deposit500c = new JButton(" $5.00", coin);
	deposit500c.addActionListener(this);
	deposit100c = new JButton(" $1.00", coin);
	deposit100c.addActionListener(this);
    deposit25c = new JButton(" 25c ", coin);
    deposit25c.addActionListener(this);
    deposit10c = new JButton(" 10c ", coin);
    deposit10c.addActionListener(this);
    deposit5c = new JButton("  5c ", coin);
    deposit5c.addActionListener(this);
    deposit1c = new JButton("  1c ", coin);
    deposit1c.addActionListener(this);
    go = new JButton("   ");
    go.setBackground(Color.YELLOW);
    go.addActionListener(this);
    JPanel buttons = new JPanel(new GridLayout(30, 1, 5, 0));
    buttons.setBackground(Color.BLUE);
    buttons.add(deposit10000c);
    buttons.add(deposit2000c);
    buttons.add(deposit1000c);
    buttons.add(deposit500c);
    buttons.add(deposit100c);
    buttons.add(deposit25c);
    buttons.add(deposit10c);
    buttons.add(deposit5c);
    buttons.add(deposit1c);

    display = new JTextField("0  ");
    display.setFont(new Font("Monospaced", Font.BOLD, 16));
    display.setBackground(Color.GREEN);
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.RIGHT);

    Box b1 = Box.createVerticalBox();
    b1.add(banner);
    b1.add(Box.createVerticalStrut(5));
    b1.add(display);
    b1.add(Box.createVerticalStrut(12));
    Box b2 = Box.createHorizontalBox();
    b2.add(Box.createHorizontalStrut(60));
    Box b3 = Box.createVerticalBox();
    b3.add(go);
    b3.add(Box.createVerticalStrut(8));
    b3.add(buttons);
    b2.add(b3);
    b1.add(b2);
    b1.add(Box.createVerticalStrut(5));
    add(b1);

    vendor = new Vendor(price, FULL_STOCK);

  }

  public void reload()
  {
    vendor.setStock(FULL_STOCK);
    display.setText(" " + vendor.getDeposit() + "  ");
    repaint();
  }

  public void actionPerformed(ActionEvent e)
  {
    JButton b = (JButton)e.getSource();

	if(b == deposit10000c)
      vendor.addMoney(10000);
    else if(b == deposit2000c)
      vendor.addMoney(2000);
    else if(b == deposit1000c)
      vendor.addMoney(1000);
    else if(b == deposit500c)
      vendor.addMoney(500);
    else if(b == deposit100c)
      vendor.addMoney(100);
    else if(b == deposit25c)
      vendor.addMoney(25);
    else if(b == deposit10c)
      vendor.addMoney(10);
    else if(b == deposit5c)
      vendor.addMoney(5);
    else if(b == deposit1c)
      vendor.addMoney(1);
    else if(b == go)
    {
      trayFull = vendor.makeSale();
      int change = vendor.getChange();
      coins = new Coins(change);
      quarters = coins.getQuarters();
      dimes = coins.getDimes();
      nickels = coins.getNickels();
      pennies = coins.getPennies();
      if (trayFull)          // Successful sale
      {
        repaint();
        JOptionPane.showMessageDialog(null,
          "Enjoy your " + brandName + "\n" + " Change " + quarters  + "q " + dimes + "d " + nickels + "n " + pennies + "p ",
          "Enjoy " + brandName, JOptionPane.PLAIN_MESSAGE);
        trayFull = false;
      }
      else if (change > 0)   // Refund
      {
        JOptionPane.showMessageDialog(null,
          "Take " + change + "c back",
          "Money back", JOptionPane.ERROR_MESSAGE);
      }
    }

    if (vendor.getStock() > 0)
      display.setText(" " + vendor.getDeposit() + "  ");
    else
      display.setText("Call service ");

    repaint();
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    final int x0 = getWidth() / 12;
    final int y0 = getHeight() / 2;
    final int yStep = 14;

    g.setColor(Color.RED);
    g.drawRect(x0, y0, 28, FULL_STOCK * yStep + 4);

    int y = y0 + 4, x = x0 + 4;
    int stock = vendor.getStock();
    int count = FULL_STOCK;

    while (count > 0)
    {
      if (count <= stock)
        drawCan(g, x, y);
      y += yStep;
      count--;
    }

    g.setColor(Color.GREEN);
    y += yStep;
    g.drawRect(x0, y - 4, 28, 18);

    if (trayFull)
      drawCan(g, x, y);
  }


  private void drawCan(Graphics g, int x, int y)
  {
    g.setColor(brandColor);
    g.fillRoundRect(x, y, 20, 10, 4, 4);
    g.setColor(Color.GRAY);
    g.drawLine(x + 2, y + 4, x + 14, y + 4);
    g.drawLine(x + 2, y + 6, x + 14, y + 6);
  }
}



/*
   This class implements a vendor that sells one kind of items.
   A vendor carries out sales transactions.
*/

class Vendor
{
  // Fields:
  private int price;
  private int money;
  private int inventory;
  private int change;
  private static double total;
  private static int cake;
  private static int tomato;
  private static int star;
  private static int loli;

  //  Constructor
  //  Parameters:
  //    int price of a single item in cents
  //    int number of items to place in stock
  public Vendor(int p, int i)
  {
    price = p;
    inventory = i;
  }

  //  Sets the quantity of items in stock.
  //  Parameters:
  //    int number of items to place in stock
  //  Return:
  //    None
  public void setStock(int i)
  {
    inventory = i;
  }

  //  Returns the number of items currently in stock.
  //  Parameters:
  //    None
  //  Return:
  //    int number of items currently in stock
  public int getStock()
  {
    return inventory;
  }

  //  Adds a specified amount (in cents) to the deposited amount.
  //  Parameters:
  //    int number of cents to add to the deposit
  //  Return:
  //    None
  public void addMoney(int c)
  {
    money += c;
  }

  //  Returns the currently deposited amount (in cents).
  //  Parameters:
  //    None
  //  Return:
  //    int number of cents in the current deposit
  public int getDeposit()
  {
    return money;
  }

  //  Implements a sale.  If there are items in stock and
  //  the deposited amount is greater than or equal to
  //  the single item price, then adjusts the stock
  //  and calculates and sets change and returns true;
  //  otherwise refunds the whole deposit (moves it into change)
  //  and returns false.
  //  Parameters:
  //    None
  //  Return:
  //    boolean successful sale (true) or failure (false)
  public boolean makeSale()
  {
    if (money >= price && inventory >= 1)
    {
    	change = money - price;
    	money = 0;
    	inventory -= 1;
    	total += price * 0.01;
    	if (price == 35)
    	{
    		cake += 1;
    	}
    	else if (price == 45)
    	{
    		tomato += 1;
    	}
    	else if (price == 50)
    	{
    		star += 1;
    	}
    	else if (price == 75)
    	{
    		loli += 1;
    	}
    	return true;
    }
    else
    {
    	change = money;
    	money = 0;
    	return false;
    }
  }

  //  Returns and zeroes out the amount of change (from the last
  //  sale or refund).
  //  Parameters:
  //    None
  //  Return:
  //    int number of cents in the current change
  public int getChange()
  {
  	int chocolate;
  	chocolate = change;
  	change = 0;
    return chocolate;
  }

  public static double getTotalSales()
  {
  	double t = total;
  	total = 0;
  	return t;
  }

  public static int getCake()
  {
  	int c = cake;
  	cake = 0;
  	return c;
  }

  public static int getTomato()
  {
  	int t = tomato;
  	tomato = 0;
  	return t;
  }

  public static int getStar()
  {
  	int s = star;
  	star = 0;
  	return s;
  }

  public static int getLoli()
  {
  	int l = loli;
  	loli = 0;
  	return l;
  }
}




class Coins
{
	private int cents;
	private int quarters;
	private int dimes;
	private int nickels;
	private int pennies;

	public Coins(int c)
	{
		cents = c;
	}

	public int getQuarters()
	{
		while (cents - 25 > -1)
		{
			cents -= 25;
			quarters += 1;
		}
		return quarters;
	}

	public int getDimes()
	{
		while (cents - 25 > -1)
		{
			cents -= 25;
		}
		while (cents - 10 > -1)
		{
			cents -= 10;
			dimes += 1;
		}
		return dimes;
	}

	public int getNickels()
	{
		while (cents - 25 > -1)
		{
			cents -= 25;
		}
		while (cents - 10 > -1)
		{
			cents -= 10;
		}
		while (cents - 5 > -1)
		{
			cents -= 5;
			nickels += 1;
		}
		return nickels;
	}

	public int getPennies()
	{
		while (cents - 25 > -1)
		{
			cents -= 25;
		}
		while (cents - 10 > -1)
		{
			cents -= 10;
		}
		while (cents - 5 > -1)
		{
			cents -= 5;
		}
		while (cents - 1 > -1)
		{
			cents -= 1;
			pennies += 1;
		}
		return pennies;
	}

}