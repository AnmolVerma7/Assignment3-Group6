package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.Test;

class ToStringTests {

@Test
    public void testToString() {
        Range range = new Range(2, 10);
        assertEquals("Range[2.0,10.0]", range.toString());
    }

@Test
    public void testToStringNegative() {
        Range range = new Range(-10, -2);
        assertEquals("Range[-10.0,-2.0]", range.toString());
    }

@Test
    public void testToStringZero() {
        Range range = new Range(0, 0);
        assertEquals("Range[0.0,0.0]", range.toString());
    }

@Test
    public void testToStringSameRange() {
        Range range = new Range(5, 5);
        assertEquals("Range[5.0,5.0]", range.toString());
    }

//modified to get more coverage
@Test
public void testToStringSmallestPositiveRange() {  
    Range range = new Range(1, 2);
    assertEquals("Range[1.0,2.0]", range.toString());  
}

//modified to get more coverage
@Test
public void testToStringSmallestNegativeRange() {  
    Range range = new Range(-2, -1);
    assertEquals("Range[-2.0,-1.0]", range.toString());  
}

//modified to get more coverage
@Test
public void testToStringWithUpperBoundZero() {  
    Range range = new Range(-5, 0);
    assertEquals("Range[-5.0,0.0]", range.toString());  
}

//modified to get more coverage
@Test
public void testToStringWithLowerBoundZero() {  
    Range range = new Range(0, 5);
    assertEquals("Range[0.0,5.0]", range.toString());  
}

@Test
public void largePositiveValue() {
Range range = new Range(1000000.0,1000001.0);
assertEquals("Range[1000000.0,1000001.0]", range.toString());
}

//modified to get more coverage
@Test
public void testToStringLargeNegativeRange() {
    Range range = new Range(-1000001.0, -1000000.0);  // Fixed order
    assertEquals("Range[-1000001.0,-1000000.0]", range.toString());
}


@Test
public void testToStringWhen() {
	Range mockRange = mock(Range.class);
	when(mockRange.toString()).thenReturn("Range[2.0,10.0]");
    assertEquals("Range[2.0,10.0]", mockRange.toString());
}
	
//Added test for decimals
@Test
public void testToStringDecimalValues() {
    Range range = new Range(1.5, 3.75);
    assertEquals("Range[1.5,3.75]", range.toString());  
}

}
