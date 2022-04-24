import javax.swing.*;

public class Driver{
    public static void main(String[] args){
        AddressBook book = new AddressBook();
        int choice;
        String name;
        
        while(true){
            choice = Integer.parseInt(
                JOptionPane.showInputDialog("Menu\n1-Add a Person\n2-Search a Person\n3-Delete a Person\n4-Exit\n"+"Enter Your Choice(1-4): ")
            );
            switch(choice){
                case 1:
                    book.add();
                    break;
                case 2:
                    name = JOptionPane.showInputDialog("Enter Name to Search: ");
                    book.search(name);
                    break;
                case 3:
                    name = JOptionPane.showInputDialog("Enter Name to Delete: ");
                    book.delete(name);
                    break;
                case 4:
                    book.saveToFile();
                    JOptionPane.showMessageDialog(null, "Thanks for using our program...");
                    System.exit(0);
            }
        }
    }
}