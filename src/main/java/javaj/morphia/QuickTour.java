package javaj.morphia;

import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.annotations.*;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :feng
 * test morphia framework
 */
public class QuickTour {

    private QuickTour(){}

    public static void main(String[] args) {
        final Morphia morphia = new Morphia();

        morphia.mapPackage("javaj.morphia");

        final Datastore datastore = morphia.createDatastore(new MongoClient(), "local");
        datastore.getDB().dropDatabase();
        datastore.ensureIndexes();

        final Employee elmerF = new Employee("冯思凡", 3500.0);
        datastore.save(elmerF);

        final Employee elmerG = new Employee("郭书君", 3500.0);
        datastore.save(elmerG);

        final Employee elmerD = new Employee("段凯哥", 2000.0);
        datastore.save(elmerD);

        elmerF.getDirectReports().add(elmerG);
        elmerF.getDirectReports().add(elmerD);

        datastore.save(elmerD);

        Query<Employee> query = datastore.createQuery(Employee.class);
        final List<Employee> list = query.asList();

        List<Employee> underPaid = datastore.createQuery(Employee.class).filter("salary <=", 3000).asList();

        underPaid = datastore.createQuery(Employee.class).field("salary").lessThanOrEq(3000).asList();

        final Query<Employee> underPaidQuery = datastore.createQuery(Employee.class).filter("salary <=", 3000);
        final UpdateOperations<Employee> updateOperations = datastore.createUpdateOperations(Employee.class).inc("salary", 3000);
        final UpdateResults results = datastore.update(underPaidQuery, updateOperations);

        final Query<Employee> updateQuery = datastore.createQuery(Employee.class).filter("salary >=", 3500);
        final List<Employee> list1 = updateQuery.asList();

        for(Employee temp : list1){
            System.out.println(temp.getName() + " " + temp.getSalary());
        }
    }
}

@Entity("Employees")
@Indexes(@Index(value = "salary", fields = @Field("salary")))
class Employee{
    @Id
    private ObjectId id;
    private String name;
    private Integer age;
    @Reference
    private Employee manager;
    @Reference
    private List<Employee> directReports = new ArrayList<Employee>();
    @Property("wage")
    private Double salary;

    public Employee(){}

    public List<Employee> getDirectReports(){
        return this.directReports;
    }

    public void setDirectReports(final List<Employee> directReports){
        this.directReports = directReports;
    }

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = (ObjectId) id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}