package javaj.morphia;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * test Xcustomer
 *
 * @author wangYuBai
 * @create 2018-10-08-16:46
 */
public class HollyCrm {
    public static void main(String[] args) {
        final Morphia morphia = new Morphia();

        morphia.mapPackage("javaj.morphia");

        final Datastore datastore = morphia.createDatastore(new MongoClient(), "local");
        datastore.getDB().dropDatabase();
        datastore.ensureIndexes();

        XCustomer xCustomer = new XCustomer("王余白", "18735127737");
        datastore.save(xCustomer);
    }
}
/**
 * 小客户对象Mongo对象定义
 *
 * @author wangYuBai
 * @create 2018-10-08-10:09
 */
@Entity("CoreXCustomer")
class XCustomer{

    /** ID,自动生成*/
    @Id
    public String xCustmoerId;

    /** 小客户归属租户*/
    public String tenantId;

    /** 小客户电话号码*/
    public String phone;

    /** 小客户ID*/
    public String customerId;

    /** 小客户姓名*/
    public String xCustomerName;

    /** 小客户技能组*/

    /** 操作员工号，即申请人工号*/
    public String agentDn;

    /** 操作员Id，即申请人Id*/
    public String userId;

    /** 操作员姓名，即申请人姓名*/
    public String userName;

    /** 审批人*/
    public String vertifier;

    /** 审批人工号*/
    public String vertifierAgentDn;

    /** 审批时间*/
    public String vertifyTime;

    /** 小客户登记时间*/
    public String createTime;

    /** 有效截止时间*/
    public String validTime;

    public XCustomer(String xCustomerName, String phone) {
        this.xCustomerName = xCustomerName;
        this.phone = phone;
    }
}

