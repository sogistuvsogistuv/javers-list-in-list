package compare.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.javers.core.metamodel.annotation.Id;
import org.javers.core.metamodel.annotation.TypeName;

import java.util.List;

@AllArgsConstructor @Data @ToString
@TypeName("Rent")
public class Rent {
    @Id
    private String collectionIdentifier;  // Person identifier which rented a list of books
    private List<Book> books;
}
