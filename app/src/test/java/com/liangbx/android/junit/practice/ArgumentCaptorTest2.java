package com.liangbx.android.junit.practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

public class ArgumentCaptorTest2 {

    @Mock
    List mock;
    @Mock
    List mock2;

    @Captor
    ArgumentCaptor argument1;
    @Captor
    ArgumentCaptor argument2;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void argumentTest() throws Exception {
        mock.add("John");
        mock2.add("Brian");
        mock2.add("Jim");

        // 对add方法进行参数捕获
        verify(mock).add(argument1.capture());
        // 校验add方法的参数是否符合预期
        assertEquals("John", argument1.getValue());

        verify(mock2, times(2)).add(argument2.capture());
        assertEquals("Jim", argument2.getValue());
        assertArrayEquals(new Object[]{"Brian","Jim"},argument2.getAllValues().toArray());
    }
}
