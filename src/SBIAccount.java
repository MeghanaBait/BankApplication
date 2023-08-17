import java.util.UUID;

public class SBIAccount implements BankAccountInterface{
    private String name;
    private String accountNo;//UUID
    private double balance;
    private String password;
    final String IFSCCode = "SBI34534675";
    final double rateOfInterest = 7.1;

    public SBIAccount() {
    }

    public SBIAccount(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password)){
            return "Your balance is "+this.balance+".";
        }
        return "Incorrect password";
    }

    @Override
    public String addMoney(double amount) {
        this.balance += amount;
        return "Amount added successfully. New Balance is " +this.balance+".";
    }

    @Override
    public String withdrawMoney(double amount, String password) {
        if(this.password.equals(password)){
            if(this.balance < amount){
                return "Insufficient Balance";
            }else{
                this.balance -= amount;
                return "Amount withdrawn Successfully. Your balance is "+this.balance +".";
            }
        }
        return "Incorrect Password";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword)){
            this.password = newPassword;
            return "Password updated successfully.";
        }
        return "Incorrect Old password";
    }

    @Override
    public String calculateInterest(int year) {
        return "The Interest for "+year+" years on current balance will be "+(this.balance*year*rateOfInterest)/100.0+".";
    }

    @Override
    public String toString() {
        return "SBIAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                ", IFSCCode='" + IFSCCode + '\'' +
                ", rateOfInterest=" + rateOfInterest +
                '}';
    }
}
