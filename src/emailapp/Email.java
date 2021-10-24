package emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String email;
    private String alternateEmail;
    private String companySuffix = "company.com";
    //constructor to get input firstName and lastName
    public Email(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created : "+this.firstName+" "+this.lastName);
        //call a method asking for department and return department
        this.department = setDepartment();
        System.out.println("Department : "+this.department);
        //call a method that generate random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password : "+this.randomPassword(defaultPasswordLength));
        //combine elements to generate e-mail
        email = firstName.toLowerCase(Locale.ROOT)+"."+lastName.toLowerCase(Locale.ROOT)+"@"+department+"."+companySuffix;
        System.out.println("Email id :"+email);

    }
    //ask for department
    private String setDepartment(){
        System.out.println("Enter value of select department \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice==1){ return "Sales";}
        else if(depChoice==2){ return "Development";}
        else if(depChoice==3){ return "Accounting";}
        else {return " ";}
    }
    //generate the random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char [] password = new char[length];
        for(int i = 0;i<length;i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    //set the mail box capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //set the alternate mail
    public void setAlternateEmail(String altEmail ){
        this.alternateEmail = altEmail;
    }
    //change the password
    public void changePassword(String password ){
        this.password = password;
    }
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }
    public String showInfo(){
        return "Display name :"+firstName+" "+lastName+" "+"\nCompany email :"+email+"\nmail Box capacity :"+mailboxCapacity;
    }



}
