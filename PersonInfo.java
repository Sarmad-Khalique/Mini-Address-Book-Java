import javax.swing.*;

class PersonInfo{
    String name, address, phone_number;
    
    // Getters
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPhoneNumber(){
        return this.phone_number;
    }

    // Setters
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setPhoneNumber(String phone_number){
        this.phone_number = phone_number;
    }

    public void display(){
        JOptionPane.showMessageDialog(null, "Name: " + this.getName() + "\nAddress: " + this.getAddress() + "\nPhone Number: " + this.getPhoneNumber());
    }
}