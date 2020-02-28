package bean;

import javax.persistence.*;


@Entity
@Table(name="employeeTbl", uniqueConstraints = {
        @UniqueConstraint(columnNames = "EID"),
        @UniqueConstraint(columnNames = "EMAIL") })
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EID",nullable = false, unique = true)
    private Integer empolyeeid;

    @Column(name="EMAIL",length = 100,nullable = false)
    private String email;

    @Column(name="FIRST_NAME",length = 100,nullable = true)
    private String firstName;

    @Column(name="LAST_NAME",length = 100,nullable = true)
    private String lastName;

    @OneToOne
    @JoinColumn(name="ACCOUNT_ID")
    private Account account;

    public void setId(Integer id)
    {
        this.empolyeeid = id;
    }

    public Integer getid(){
        return empolyeeid;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }


    public String getLastName(){
        return lastName;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }


}
