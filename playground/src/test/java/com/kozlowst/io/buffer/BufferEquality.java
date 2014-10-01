package com.kozlowst.io.buffer;

import org.junit.Test;

import java.nio.CharBuffer;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by tomek on 10/1/14.
 */
public class BufferEquality {

    @Test
    public void testEquals() {
        CharBuffer buff1 = CharBuffer.allocate(4);
        CharBuffer buff2 = CharBuffer.allocate(4);
        assertTrue(buff1.equals(buff2));
        assertTrue(buff1.compareTo(buff2) == 0);

        buff1.put('1');
        assertFalse(buff1.equals(buff2));
        assertTrue(buff1.compareTo(buff2) == -1);

        buff2.put('2');
        assertTrue(buff1.equals(buff2));
        assertTrue(buff1.compareTo(buff2) == 0);

        buff2.put('3');
        assertFalse(buff1.equals(buff2));
        assertTrue(buff1.compareTo(buff2) == 1);

    }


}
