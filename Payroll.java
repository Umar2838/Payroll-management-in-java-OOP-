class Employee{
    private String firstName;
    private String lastName;
    private String CNIC;

Employee(){
this.firstName = "";
this.lastName = "";
this.CNIC = "";
}

Employee(String firstName, String lastName, String CNIC){
    this.firstName = firstName;
    this.lastName = lastName;
    this.CNIC = CNIC;
}    
public String getFirstName(){
    return firstName;
}
public void setFirstName(String first){
    this.firstName = first;
}
public String getlastName(){
    return lastName;
}
public void setlastName(String last){
    this.lastName = last;
}
public String getCNIC(){
    return CNIC;
}
public void setCNIC(String cnic){
    this.CNIC = cnic;
}

public String toString(){
    return firstName + " " + lastName + " " + "CNIC#" + CNIC ;
}

public double earnings(){
    return 0.00;
}

}

class SalariedEmployee extends Employee{
    private double weeklySalary;

SalariedEmployee(){
    super();
    this.weeklySalary = 0.0;
}    
SalariedEmployee(String firstName, String lastName , String CNIC , double weeklySalary){
   super(firstName , lastName , CNIC );
setWeeklySalary(weeklySalary);
}

public double getWeekSalary(){
    return weeklySalary;
}
public void setWeeklySalary(double weeklySalary){
    if(weeklySalary >= 0){
        this.weeklySalary = weeklySalary;
    }
}

public String toString(){
    return "\nSalaried employee: "+super.toString();
}

public double earnings(){
    return weeklySalary;
}
}

class HourlyEmployees extends Employee {
    private double wage;
    private double hours;

 public HourlyEmployees(){
    super();
    this.wage = 0.0;
    this.hours = 0.0;
 }   
public HourlyEmployees(String firstName, String lastName , String CNIC , double wage , double hours) {
    super(firstName, lastName, CNIC);
    setWage(wage);
    setHours(hours);
}

public double getWage() {
    return wage;
}
public void setWage(double wage){
    if(wage>=0){
        this.wage = wage;
    }
}
public double getHours() {
    return hours;
}
public void setHours(double hours){
    if(hours>=0){
        this.hours = hours;
    }
}

public String toString(){
    return "\nHourly employee: "+super.toString();
}
public double earnings(){
    if(hours<=40){
        return wage*hours;
}
else{
    return 40*wage + (hours-40)*wage*1.5;
}
}
}

class CommissionEmployee extends Employee{
    private double grossSales;
    private double commissionRate;
CommissionEmployee(){
    super();
    this.grossSales = 0.0;
    this.commissionRate = 0.0;
}    
CommissionEmployee(String firstName, String lastName , String CNIC , double grossSales, double commisionRate){
    super(firstName,lastName,CNIC);
    setGrossSale(grossSales);
    setCommissionRate(commissionRate);
}   
public double getGrossSale() {
    return grossSales;
}

public void setGrossSale(double grossSales) {
    if (grossSales >= 0) {
        this.grossSales = grossSales;
    }
}

public double getComissionRate() {
    return commissionRate;
}

public void setCommissionRate(double commissionRate) {
    if (commissionRate >= 0) {
        this.commissionRate = commissionRate;
    }
}


public String toString() {
    return "\nCommission employee: " + super.toString();
}

public double earnings() {
    return grossSales * commissionRate;
}
}


class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    
    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0.0;
    }

    BasePlusCommissionEmployee(String firstName, String lastName, String CNIC, double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, CNIC, grossSales, commissionRate);
        setBaseSalary(baseSalary);
    }

    // Getter and Setter
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        }
    }

    public String toString() {
        return "\nBase plus Commission employee: " + super.toString();
    }

    public double earnings() {
        return baseSalary + super.earnings();
    }
}



public class Payroll {
    public static void main(String[] args) {

        Employee firstEmployee = new SalariedEmployee("Muhammad","Ali","4210-56533579-8",800.00);
        Employee secondEmployee = new CommissionEmployee("Tarwan","Kumar","42101-4532554-5",10000,0.06);
        Employee thirdEmployee = new BasePlusCommissionEmployee("Fabeeha","faTima","42101-8465445-6",5000,0.04,300);
        Employee fourthEmployee = new HourlyEmployees("Hasnain","Ali","42101-6732658-7",16.75,40);
    
        System.out.println(firstEmployee);
        System.out.println(firstEmployee.earnings());
        System.out.println(secondEmployee);
        System.out.println(secondEmployee.earnings());
        System.out.println(thirdEmployee);
        BasePlusCommissionEmployee currentEmployee = (BasePlusCommissionEmployee) thirdEmployee;
        double oldBaseSalary = currentEmployee.getBaseSalary();
        System.out.println("old Base Salary: "+oldBaseSalary);
        currentEmployee.setBaseSalary(1.10*oldBaseSalary);
        System.out.println("new base salary with 10% increase is: "+currentEmployee.getBaseSalary());
        System.out.println(thirdEmployee.earnings());
        System.out.println(fourthEmployee);
        System.out.println(fourthEmployee.earnings());
    }
}


