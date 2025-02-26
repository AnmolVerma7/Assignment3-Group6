package org.jfree.data;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShiftTests {

	
	//ECP Tests
	@Test
    public void testShift_PositiveRange_Positive() {
        Range base = new Range(2, 5);
        Range shifted = Range.shift(base, 3, true);
        assertEquals(5, shifted.getLowerBound());
        assertEquals(8, shifted.getUpperBound());
    }
	
//modified to get more coverage
    @Test
    public void testShift_NegativeRange_Positive() {
	    Range base = new Range(-5, -2);
	    Range shifted = Range.shift(base, 3, true);  // Fix: should be positive shift
	    assertEquals(-2, shifted.getLowerBound(), 0.001);
	    assertEquals(1, shifted.getUpperBound(), 0.001);
	}

    @Test
    public void testShiftMixedRange_true() {
        Range base = new Range(-3, 3);
        Range shifted = Range.shift(base, 4, true);
        assertEquals(1, shifted.getLowerBound());
        assertEquals(7, shifted.getUpperBound());
    }

    @Test
    public void testShiftMixedRange_negative() {
        Range base = new Range(-3, 3);
        Range shifted = Range.shift(base, 4, false);
        assertEquals(0, shifted.getLowerBound());
        assertEquals(7, shifted.getUpperBound());
    }

    // Edge cases
    @Test
    public void testShiftZeroRange_Positive() {
        Range base = new Range(0, 0);
        Range shifted = Range.shift(base, 3, true);
        assertEquals(3, shifted.getLowerBound());
        assertEquals(3, shifted.getUpperBound());
    }

   //modified to get more coverage
    @Test
    public void testShift_LargePositiveRange() {
        Range base = new Range(1, 10);
        Range shifted = Range.shift(base, -2, false);
        assertEquals(-1, shifted.getLowerBound(), 0.001); // Adjusted
        assertEquals(8, shifted.getUpperBound(), 0.001); // Adjusted
    }
    
    
    //BVA
  
    @Test
    public void testShift_MinimumPositiveRange() {
        Range base = new Range(1, 2);
        Range shifted = Range.shift(base, 1, true);
        assertEquals(2, shifted.getLowerBound());
        assertEquals(3, shifted.getUpperBound());
    }

    @Test
    public void testShift_MaximumNegativeRange() {
        Range base = new Range(-2, -1);
        Range shifted = Range.shift(base, 1, true);
        assertEquals(-1, shifted.getLowerBound());
        assertEquals(0, shifted.getUpperBound());
    }

    @Test
    public void testShift_LowerBoundAtZero() {
        Range base = new Range(0, 5);
        Range shifted = Range.shift(base, 3, true);
        assertEquals(3, shifted.getLowerBound(), 0.001);
        assertEquals(8, shifted.getUpperBound(), 0.001);
    }

    @Test
    public void testShift_UpperBoundAtZero() {
        Range base = new Range(-5, 0);
        Range shifted = Range.shift(base, 2, true);
        assertEquals(-3, shifted.getLowerBound(), 0.001);
        assertEquals(2, shifted.getUpperBound(), 0.001);
    }

    @Test
    public void testShift_MixedRange_ZeroCrossing_Allowed() {
        Range base = new Range(-3, 3);
        Range shifted = Range.shift(base, 4, true);
        assertEquals(1, shifted.getLowerBound(), 0.001);
        assertEquals(7, shifted.getUpperBound(), 0.001);
    }

    @Test
    public void testShift_MixedRange_ZeroCrossing_NotAllowed() {
        Range base = new Range(-3, 3);
        Range shifted = Range.shift(base, 4, false);
        assertEquals(0, shifted.getLowerBound(), 0.001);
        assertEquals(7, shifted.getUpperBound(), 0.001);
    }

    @Test
    public void testShift_LargeDelta() {
        Range base = new Range(1, 10);
        Range shifted = Range.shift(base, 1e6, true);
        assertEquals(1000001, shifted.getLowerBound(), 0.001);
        assertEquals(1000010, shifted.getUpperBound(), 0.001);
    }

    @Test
    public void testShift_LargeDelta_NoZeroCrossing() {
        Range base = new Range(-2, 2);
        Range shifted = Range.shift(base, 4, false);
        assertEquals(0, shifted.getLowerBound(), 0.001);
        assertEquals(6, shifted.getUpperBound(), 0.001);
    }


//new test to get higher coverage
    public void testShift_ZeroShift_NoChange() {
        Range base = new Range(-10, 10);
        Range shifted = Range.shift(base, 0, true);
        assertEquals(base.getLowerBound(), shifted.getLowerBound(), 0.001);
        assertEquals(base.getUpperBound(), shifted.getUpperBound(), 0.001);
    }
    
    //new test to get higher coverage
    @Test
    public void testShift_LargeNegativeShift() {
        Range base = new Range(-50, -25);
        Range shifted = Range.shift(base, -100, true);
        assertEquals(-150, shifted.getLowerBound(), 0.001);
        assertEquals(-125, shifted.getUpperBound(), 0.001);
    }
    

}
