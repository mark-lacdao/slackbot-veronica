package org.wholesome.veronica.interpreters;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
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
        assertThat(admins.get(0), is(equalTo("mjlacdao")));
        assertThat(admins.get(1), is(equalTo("josephusv")));
    }

    @Test
    public void shouldInterpretCommand(){}

    @Test
    public void shouldRunCommandsForAdmin(){

    }

    @Test
    public void shouldNotRunCommandsForUsers(){}

}
