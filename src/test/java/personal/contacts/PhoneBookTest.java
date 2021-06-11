package personal.contacts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PhoneBookTest {
    private PhoneBook phoneBook;
    @BeforeAll
    public void setUp(){
        phoneBook = new PhoneBook();
    }

    @DisplayName("1.Add function")
    @ParameterizedTest
    @CsvSource({"John,Wick,+72 (123) 456-789-abcd"/*,
               "Peter,Parker,(123) 234 345-456",
                "Briney,Spears,(333) 231-123-ABcd"*/})
    public void shouldReturnListLengthGreaterThanZero(ArgumentsAccessor accessor){
        String name = accessor.getString(0);
        String surname = accessor.getString(1);
        String number = accessor.getString(2);
        Person person = phoneBook.add(name,surname ,number );
        //assertEquals(2, phoneBook.getContact().size());
        assertEquals(person.getNumber(),number);
    }
    @DisplayName("2.Add function")
    @ParameterizedTest
    @CsvSource({"Peter,Parker,(1223) 234 345-456"})
    public void shouldReturnNoNumber(ArgumentsAccessor accessor){
        String name = accessor.getString(0);
        String surname = accessor.getString(1);
        String number = accessor.getString(2);
        Person person = phoneBook.add(name,surname ,number );
        assertEquals("[no number]", person.getNumber());
    }
}