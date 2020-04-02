import compare.model.Book;
import compare.model.Rent;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.javers.core.diff.ListCompareAlgorithm.AS_SET;

public class TestClass {

    @Test
    public void compareTwoRentalLists() {
        Javers javers = JaversBuilder.javers()
                .withListCompareAlgorithm(AS_SET)
                .registerEntity(Rent.class)
                .build();


        List<Book> bookListOld = new ArrayList<>(
                Arrays.asList(
                        Book.builder().identifier("book1").condition("like new").title("Chronicles of...").build(),
                        Book.builder().identifier("book2").condition("like new").title("David vs. Goliath").build()
                )
        );

        List<Book> bookListNew = new ArrayList<>(
                Arrays.asList(
                        Book.builder().identifier("book1").condition("broken").title("Chronicles of...").build()
//                        Book.builder().identifier("book2").condition("like new").title("David vs. Goliath").build()
                )
        );

        List<Rent> lstPreviousEvent = new ArrayList<>(Arrays.asList(
                Rent.builder().collectionIdentifier("Smith").books(bookListOld).build()
        ));

        List<Rent> lstAfterEvent = new ArrayList<>(Arrays.asList(
                Rent.builder().collectionIdentifier("Smith").books(bookListNew).build()
        ));


        Diff difference = javers.compareCollections(lstPreviousEvent, lstAfterEvent, Rent.class);

        System.out.println(difference);
        System.out.println("");


    }
}
