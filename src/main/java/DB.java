import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class DB {

    //production database
    public static Sql2o sql2o = new Sql2o(
            "jdbc:postgresql://localhost:5432/wildlife_tracker",
            "postgres",
            "Benmwangi1999");

}