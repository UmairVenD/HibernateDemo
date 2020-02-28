package bean;

import javax.persistence.*;

@Entity
@Table(name= "accountTbl")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AID",nullable = false, unique = true)
    private Integer accountid;

    @Column(name="ACC_NUMBER",length = 100,nullable = true)
    private String accountNumber;

    @OneToOne(mappedBy = "account")
    private Employee employee;

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public Employee getEmployee(){
        return employee;
    }

    public void setAccountid(Integer accountid){
        this.accountid = accountid;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public Integer getAccountid()
    {
        return accountid;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
}
