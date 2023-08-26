package venma;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static venma.Coin.*;
import static venma.ValidInserts.*;

class ValidateInsertTest {

    @Test
    void nickel_is_valid() {
        assertThat(validate(NICKEL_INSERT)).contains(NICKEL);
    }

    @Test
    void dime_is_valid() {
        assertThat(validate(DIME_INSERT)).contains(DIME);
    }

    @Test
    void quarter_is_valid() {
        assertThat(validate(QUARTER_INSERT)).contains(QUARTER);
    }

    @Test
    void invalid_insert() {
        assertThat(validate(new Insert(1000, 1000, 1000))).isEmpty();
    }
}
