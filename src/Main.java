public class Main {
    public static void main(String[] args) {
        SBIAccount acc1 = new SBIAccount("Rekha", 2000, "Rekha123");
        System.out.println(acc1);
        //fetch balance
        System.out.println(acc1.fetchBalance("random"));
        System.out.println(acc1.fetchBalance("Rekha123"));

        //add money
        System.out.println(acc1.addMoney(4000));
        System.out.println(acc1.fetchBalance("Rekha123"));

        //update passowrd
        System.out.println(acc1.changePassword("Rekha123","Rekha@789"));

        //withdraw money
        System.out.println(acc1.withdrawMoney(1000, "Rekha@789"));
        System.out.println(acc1.fetchBalance("Rekha@789"));

        System.out.println(acc1.calculateInterest(5));
    }
}