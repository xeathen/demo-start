import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import core.framework.mongo.MongoMigration;
import org.bson.Document;

/**
 * @author Ethan
 */
public class Main {
    public static void main(String[] args) {

        MongoMigration migration = new MongoMigration("sys.properties", "sys.mongo.adminURI");
        migration.migrate(mongo -> {
            mongo.runCommand(new Document().append("setParameter", 1).append("notablescan", 1));
        });

        migration = new MongoMigration("sys.properties");
        migration.migrate(mongo -> {
            mongo.createIndex("products", Indexes.ascending("name"), new IndexOptions().name("uni_products_name").unique(true).background(true));
            mongo.createIndex("products", Indexes.ascending("name", "desc"), new IndexOptions().name("ind_product_name_desc").background(true));
        });
    }
}
