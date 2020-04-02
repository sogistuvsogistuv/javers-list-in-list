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
                .registerValue(Book.class)
                .build();


        List<Book> bookListOld = new ArrayList<>(Arrays.asList(
            new Book("book1", "like new", "Chronicles of..."),
            new Book("book2", "like new", "Data vs. Goliath")
        ));

        List<Book> bookListNew = new ArrayList<>(Arrays.asList(
            new Book("book1", "broken", "Chronicles of...")
        ));

        List<Rent> lstRentOld = new ArrayList<>(Arrays.asList(
            new Rent("Smith", bookListOld)
        ));

        List<Rent> lstRentNew = new ArrayList<>(Arrays.asList(
            new Rent("Smith", bookListNew)
        ));

        Diff difference = javers.compareCollections(lstRentOld, lstRentNew, Rent.class);

        System.out.println(difference);
        System.out.println();

    }
}
