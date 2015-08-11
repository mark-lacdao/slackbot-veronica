package org.wholesome.veronica.interpreters;

import org.junit.Test;

import java.util.List;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by Mark.Lacdao on 07/08/2015.
 */
public class CommandInterpreterTest {

    CommandInterpreter commandInterpreter = new CommandInterpreter();

    @Test
    public void shouldGetAdmins(){
        List<String> admins = commandInterpreter.getAdmins();
        assertThat(admins.size(), is(notNullValue()));
    }
}
