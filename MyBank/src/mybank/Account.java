
package mybank;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static mybank.bankAccount.id;

public class Account {
    
    private String accountNumber;
      private double balance;
    private String code;
    
    
    public Account(){
         ResultSet rs;
     
        try {
            rs = DatabaseCon.getData("SELECT Balance FROM accounts WHERE idnumber ='"+id.getText()+"'");
            if(rs.next()){
                
                  this.balance=rs.getDouble("Balance");
                       
            }
            
        } catch (Exception ex) {
            Logger.getLogger(bankAccount.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }

    public double withdraw(double withdrawal){
   
  
     
      String input = JOptionPane.showInputDialog(null, "Enter amount to withdraw","Withdrawal",JOptionPane.PLAIN_MESSAGE);
      double withdrawalAmount = 0;
        try{
            withdrawalAmount = Double.parseDouble(input);
            
        }catch(NumberFormatException e ){
            JOptionPane.showMessageDialog(null, "Invalid withdrwal amount:"+input, "Invalid  Withdrawal", JOptionPane.ERROR_MESSAGE);
        }
         catch(NullPointerException e){
         int CLOSED_OPTION = JOptionPane.CLOSED_OPTION;
            }
        if(withdrawalAmount < 0) {
            JOptionPane.showMessageDialog(null, "Invalid withdrawal Amount: " + input, "Invalid  Withdrawal", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        if(withdrawalAmount>this.getBalance())
        {
             JOptionPane.showMessageDialog(null, "Insufficient funds,your balance is : " + this.getBalance(), "Invalid  Withdrawal", JOptionPane.ERROR_MESSAGE);
           return JOptionPane.CLOSED_OPTION;
        }
      
        
     
     balance=(balance-withdrawalAmount);
     return balance;
  }
    
       public double deposit(double dep){
           
     
     
      String input = JOptionPane.showInputDialog(null, "Enter amount to deposit","Deposit",JOptionPane.PLAIN_MESSAGE);
      double depositAmount = 0;
        try{
            depositAmount = Double.parseDouble(input);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid deposit amount:"+input, "Invalid Deposit", JOptionPane.ERROR_MESSAGE);
        }
        
            catch(NullPointerException e){
         int CLOSED_OPTION = JOptionPane.CLOSED_OPTION;
            }
        
        if(depositAmount < 0) {
            JOptionPane.showMessageDialog(null, "Invalid deposit Amount: " + input, "Invalid Deposit", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        
     
     balance=(balance+depositAmount);
     return balance;
       }      

    public String getAccountNumber() {
        String input = JOptionPane.showInputDialog(null, "Enter your account number","Account number",JOptionPane.PLAIN_MESSAGE);
      
        this.accountNumber=input;
        
        return this.accountNumber;
      
    }
   
    public String getCode(){
        String input2 = JOptionPane.showInputDialog(null, "Enter your pass code","Pass code",JOptionPane.PLAIN_MESSAGE);
      
        this.code=input2;
        
        return this.code;
        
    }
     
      /* public int setBalance(double balanc) {
        try {
            this.balanc = balanc;
            
            ResultSet rs=DatabaseCon.getData("SELECT Balance FROM accounts WHERE Accnumber='"+this.getAccountNumber()+"'");
            
            if(rs.next()){
                
                 return this.setBalance(rs.getDouble("Balance"));
            }
            
            else{
                return 0;
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }*/

    public double getBalance() {
        
        return balance;
    } 
}
