package javaj.reflect.Annotation;

@SaxTable("tb_student")
public class SaxStudent {
    @SaxField(columName = "id", type = "int", length = 0)
    private int id;
    @SaxField(columName = "sname", type = "varchar", length = 10)
    private String studentName;
    @SaxField(columName = "age", type = "int", length = 3)
    private int age;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}
