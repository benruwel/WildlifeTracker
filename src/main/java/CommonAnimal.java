import org.sql2o.Connection;

import java.util.List;

public class CommonAnimal extends Animal {


    public CommonAnimal(String name) {
        this.name = name;
        this.endangered = false;
    }


    public static List<CommonAnimal> all() {
        String sql = "SELECT * FROM animals;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(CommonAnimal.class);
        }
    }

    public static CommonAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id = :id";
            CommonAnimal commonAnimal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(CommonAnimal.class);
            return commonAnimal;
        }
    }
}