package compare.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.javers.core.metamodel.annotation.Id;
import org.javers.core.metamodel.annotation.TypeName;

@Builder
@AllArgsConstructor
@Data
@ToString
@TypeName("Book")
public class Book {

    @Id
    private String identifier;
    private String condition;
    private String title;

}
