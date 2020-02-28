package annotations;
import bean.Account;
import bean.Employee;
import bean.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory factory;

        private HibernateUtil(){
        }

        public static SessionFactory getSessionFactory()
        {
            if(factory == null){
                factory = new Configuration().configure("hibernate.cfg.xml")
                       // .addAnnotatedClass(Student.class)
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Account.class)
                        .buildSessionFactory();
            }
            return factory;
        }

    }
