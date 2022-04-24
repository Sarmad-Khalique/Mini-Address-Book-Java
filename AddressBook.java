import java.util.*;
import javax.swing.*;
import java.io.*;

class AddressBook{
    ArrayList<PersonInfo> persons;

    public AddressBook(){
        persons = new ArrayList<PersonInfo>();
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader("addressbook.txt");
            br = new BufferedReader(fr);

            String line;
            String tokens[] = null;
            line = br.readLine();
            while(line!=null){
                tokens = line.split(":");

                PersonInfo p = new PersonInfo();
                p.setName(tokens[0]);
                p.setAddress(tokens[1]);
                p.setPhoneNumber(tokens[2]);

                persons.add(p);
                line = br.readLine();
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "An Error Occoured While Loading Data from file");
        }
        finally{
            try{
                br.close();
                fr.close();
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null, "An Error Occoured!");
            }
        }
    }

    // Adding new person to address book
    public void add(){
        String name = JOptionPane.showInputDialog("Enter Name: ");
        String address = JOptionPane.showInputDialog("Enter Address: ");
        String phone_number = JOptionPane.showInputDialog("Enter Phone Number: ");
        
        PersonInfo p = new PersonInfo();
        p.setName(name);
        p.setAddress(address);
        p.setPhoneNumber(phone_number);

        persons.add(p);
    }

    // Searching for a person in record
    public void search(String name){
        for(PersonInfo person: persons){
            if(name.equals(person.name)){
                person.display();
            }
        }
    }

    //Deleting a person
    public void delete(String name){
        for(int i=0;i<persons.size();i++){
            PersonInfo p = persons.get(i);
            if(name.equals(p.name)){
                persons.remove(i);
            }
        }
    }

    //Save Data in file
    public void saveToFile(){
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try{
            fw = new FileWriter("addressbook.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            for(PersonInfo person: persons){
                pw.println(person.name+":"+person.address+":"+person.phone_number);
            }

            pw.flush();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "An Error Occoured While Writing Data to file");
        }
        finally{
            try{
                pw.close();
                bw.close();
                fw.close();
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null, "An Error Occoured!");
            }
        }
    }
}