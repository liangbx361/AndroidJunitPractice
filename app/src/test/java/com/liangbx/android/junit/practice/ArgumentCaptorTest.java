package com.liangbx.android.junit.practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <P>Company: 17173</p>
 *
 * @author liangbx
 * @version 2017/3/21
 */

public class ArgumentCaptorTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void argumentTest() throws Exception {
        List mock = Mockito.mock(List.class);
        List mock2 = Mockito.mock(List.class);
        mock.add("John");
        mock2.add("Brian");
        mock2.add("Jim");

        ArgumentCaptor argument1 = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor argument2 = ArgumentCaptor.forClass(String.class);

        verify(mock).add(argument1.capture());
        assertEquals("John", argument1.getValue());

        verify(mock2, times(2)).add(argument2.capture());
        assertEquals("Jim", argument2.getValue());
        assertArrayEquals(new Object[]{"Brian","Jim"},argument2.getAllValues().toArray());
    }
}
