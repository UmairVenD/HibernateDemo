package demo;

import annotations.HibernateUtil;
import bean.Account;
import bean.Employee;
import bean.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
   public static void main( String[] args )
   {

       Session session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       Account account = new Account();
       account.setAccountNumber("1234");
       session.saveOrUpdate(account);
       Employee employee = new Employee();
       employee.setEmail("umairfarooq@venture.com");
       employee.setFirstName("umair");
       employee.setLastName("farooq");
       employee.setAccount(account);
       session.saveOrUpdate(employee);
       session.getTransaction().commit();
       session.close();

     /*create();
     readStudents();
     deleteStudent(8);
     updateStudent(3,"VentureDive");
     */   }

         // read all students
      public static void readStudents() {
       Transaction tx = null;
       Session session = HibernateUtil.getSessionFactory().openSession();
       try
       {
           tx = session.beginTransaction();
           List students = session.createQuery("from Student").list();
           for (Iterator iterator = students.iterator(); iterator.hasNext();){
               Student student = (Student) iterator.next();
               System.out.print("Id" + student.getId());
               System.out.println("Name: " + student.getName());

           }
           tx.commit();
       } catch (HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace();
       } finally {
           session.close();
       }
    }
    // Create Student

   public static void create() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            Student student = new Student("amjad");
            session.save(student);
            tx.commit();
        }catch (HibernateException e)
          {
              if(tx !=null){
                  tx.rollback();
                  e.printStackTrace();
              }

          }finally {
            session.close();
            System.out.println("Successfully created ");
        }

    }

    /* Method to DELETE an employee from the records */
    public static void deleteStudent(Integer id){

        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            Student student = (Student) session.get(Student.class, id);
            session.delete(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            System.out.println("Deleted Successfully");
        }
    }

    /* Method to UPDATE salary for an employee */
    public static void updateStudent(Integer id, String name ){

        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            Student student = (Student) session.get(Student.class, id);
            student.setName(name);
            session.update(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            System.out.println("updated Successfully");
        }
    }
}



