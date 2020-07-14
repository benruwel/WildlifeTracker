import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class DB {

    //production database
//    public static Sql2o sql2o = new Sql2o(
//            "jdbc:postgresql://ec2-54-247-79-178.eu-west-1.compute.amazonaws.com:5432/d7esparbsibo8e",
//            "zhechbctmwouul",
//            "0787c335a37c42a426954f7337810b2ef68c27affb9b96c22bf487d9bd606ebd");

    //development database
    public static Sql2o sql2o = new Sql2o(
            "jdbc:postgresql://localhost:5432/wildlife_tracker",
            "User",
            "7181");
}