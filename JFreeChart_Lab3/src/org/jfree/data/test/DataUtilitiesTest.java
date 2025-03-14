package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	private Values2D values;
	private KeyedValues keyedvalues;
	private Mockery mockingContext;
	
	@Before
	public void setUp() {
		mockingContext = new Mockery();
	    values = mockingContext.mock(Values2D.class);
	    keyedvalues = mockingContext.mock(KeyedValues.class);
	}
	
	 @Test
	 public void calculateColumnTotalForTwoValues() {	    
		 mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(14));
	             one(values).getValue(1, 0);
	             will(returnValue(16));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(result, 30.0, .000000001d);
	 }
	 
	 @Test(expected = InvalidParameterException.class)
	 public void calculateColumnTotalwithnulldata() throws Exception{
		 Values2D empty = null;
		 try {
			double result = DataUtilities.calculateColumnTotal(empty, 0); 
		 } catch (IllegalStateException e) {
			 
		 }
		 
	 }
	 
	 @Test
	 public void calculateColumnTotalwithstringdata() {
		 mockingContext.checking(new Expectations() {
			 {
				 one(values).getRowCount();
				 will(returnValue(2));
				 one(values).getValue(0, 0);
				 will(returnValue("2"));
				 one(values).getValue(0, 1);
				 will(returnValue("3"));
			 }
		 });
		 
		 try {
			 DataUtilities.calculateColumnTotal(values, 0);
			 fail("Expecting an InvalidParameterException");
		 } catch (IllegalStateException e) {
			 
		 }
	 }
	 
	 @Test
	 public void testCalculateRowTotal_ValidPositiveRow() {
		 mockingContext.checking(new Expectations() {
			 {
				 one(values).getColumnCount();
				 will(returnValue(2));
				 one(values).getValue(0, 0);
				 will(returnValue(5.5));
				 one(values).getValue(0, 1);
				 will(returnValue(4.5));
			 }
		 });
		 
		 double result = DataUtilities.calculateRowTotal(values, 0);
		 assertEquals(10.0, result, .000000001d);
	 }
	 
	 @Test
	 public void testCalculateRowTotal_ValidNegativeRow() {
		 mockingContext.checking(new Expectations() {
			 {
				 one(values).getColumnCount();
				 will(returnValue(2));
				 one(values).getValue(0, 0);
				 will(returnValue(-3.7));
				 one(values).getValue(0, 1);
				 will(returnValue(-6.6));
			 }
		 });
		 
		 double result = DataUtilities.calculateRowTotal(values, 0);
		 assertEquals(-10.3, result, .000000001d);
	 }
	 
	 @Test
	 public void testCalculateRowTotal_Empty() {
		 mockingContext.checking(new Expectations() {
			 {
				 one(values).getColumnCount();
				 will(returnValue(0));
			 }
		 });
		 
		 double result = DataUtilities.calculateRowTotal(values, 0);
		 assertEquals(0.0, result, .000000001d);
	 }
	 
	 @Test
	 public void testCalculateRowTotal_InvalidType() {
		 mockingContext.checking(new Expectations() {
			 {
				 one(values).getColumnCount();
				 will(returnValue(2));
				 one(values).getValue(0, 0);
				 will(returnValue("2"));
				 one(values).getValue(0, 1);
				 will(returnValue("3"));
			 }
		 });
		 
		 try {
			 DataUtilities.calculateRowTotal(values, 0);
			 fail("Expecting an InvalidParameterException");
		 } catch (IllegalStateException e) {
			 
		 }
	 }
	 
	 @Test
	 public void testCreateNumberArray_ValidPositiveArray() {
		 double[] input = {1.8, 2.7, 7.6};
		 
		 Number[] results = DataUtilities.createNumberArray(input);
		 
		 for (int i = 0; i < input.length; i++) {
			 assertEquals("Values should match", Double.valueOf(input[i]), results[i]);
		 }
	 }
	 
	 @Test
	 public void testCreateNumberArray_ValidNegativeArray() {
		 double[] input = {-3.8, -1.0, -6.6};
		 
		 Number[] results = DataUtilities.createNumberArray(input);
		 
		 for (int i = 0; i < input.length; i++) {
			 assertEquals("Values should match", Double.valueOf(input[i]), results[i]);
		 }
	 }
	 
	 @Test
	 public void testCreateNumberArray_EmptyArray() {
		 double[] input = {};
		 
		 Number[] results = DataUtilities.createNumberArray(input);
		 
		 assertEquals("Array should be empty", 0, results.length);	 
	 }

	 @Test
	 public void createNumberArray2Dwithvalues() {
		double[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		Number[][] result = DataUtilities.createNumberArray2D(array);
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j< array[i].length; j++) {
				assertEquals("Values should be equal", array[i][j], result[i][j]);
			}
		}
	 }
	 
	 @Test(expected = InvalidParameterException.class)
	 public void createNumberArray2Dwithnullvalues() {
		double[][] array = null;
		Number[][] result = DataUtilities.createNumberArray2D(array);
	 }
	 
	 @Test
	 public void createNumberArray2Dwithnovalues() {
		double[][] array = {{}, {}, {}};
		Number[][] result = DataUtilities.createNumberArray2D(array);
		for (int i = 0; i < array.length; i++) {
			assertEquals("Array should be empty", 0, result[i].length);
		}
	 }
	 
	 @Test(expected = InvalidParameterException.class)
	 public void getCumulativePercentages_NullInput() {
		 
		 KeyedValues invalid = null;

		 getCumulativePercentages(invalid);
		 
	 }
	 
	 @Test
	 public void getCumulativePercentages_ValidValues() {
		 mockingContext.checking(new Expectations() {
			 {
				 allowing(keyedvalues).getItemCount();
				 will(returnValue(3));
				 allowing(keyedvalues).getValue(0);
				 will(returnValue(2));
				 allowing(keyedvalues).getValue(1);
				 will(returnValue(8));
				 allowing(keyedvalues).getValue(2);
				 will(returnValue(15));
				 allowing(keyedvalues).getKey(0);
				 will(returnValue(0));
				 allowing(keyedvalues).getKey(1);
				 will(returnValue(1));
				 allowing(keyedvalues).getKey(2);
				 will(returnValue(2));
			 }
		 });
		 
		 float percent = 0;
		 float totalnumerator = 0;
		 float totaldivisor = 0;
		 
		 for (int i = 0; i < keyedvalues.getItemCount(); i++) {
			 totaldivisor = totaldivisor + keyedvalues.getValue(i).floatValue();
		 }
		 
		 
		 KeyedValues result = getCumulativePercentages(keyedvalues);
		 for (int i = 0; i < keyedvalues.getItemCount(); i++) {
			 totalnumerator = totalnumerator + keyedvalues.getValue(i).floatValue();
			 percent = (totalnumerator/totaldivisor); 
			 System.out.println(percent);
			 System.out.println(result.getValue(i).floatValue());
			 assertEquals("Values should be equal", percent, result.getValue(i).floatValue(), .01d);
		 }
	 }
	 
	 @Test
	 public void getCumulativePercentages_NegativeValues() {
		 mockingContext.checking(new Expectations() {
			 {
				 allowing(keyedvalues).getItemCount();
				 will(returnValue(3));
				 allowing(keyedvalues).getValue(0);
				 will(returnValue(-2));
				 allowing(keyedvalues).getValue(1);
				 will(returnValue(-8));
				 allowing(keyedvalues).getValue(2);
				 will(returnValue(-15));
				 allowing(keyedvalues).getKey(0);
				 will(returnValue(0));
				 allowing(keyedvalues).getKey(1);
				 will(returnValue(1));
				 allowing(keyedvalues).getKey(2);
				 will(returnValue(2));
			 }
		 });
		 
		 float percent = 0;
		 float totalnumerator = 0;
		 float totaldivisor = 0;
		 
		 for (int i = 0; i < keyedvalues.getItemCount(); i++) {
			 totaldivisor = totaldivisor + keyedvalues.getValue(i).floatValue();
		 }
		 
		 
		 KeyedValues result = getCumulativePercentages(keyedvalues);
		 for (int i = 0; i < keyedvalues.getItemCount(); i++) {
			 totalnumerator = totalnumerator + keyedvalues.getValue(i).floatValue();
			 percent = (totalnumerator/totaldivisor); 
			 System.out.println(percent);
			 System.out.println(result.getValue(i).floatValue());
			 assertEquals("Values should be equal", percent, result.getValue(i).floatValue(), .01d);
		 }
	 }
	 
	 @Test(expected = InvalidParameterException.class)
	 public void getCumulativePercentages_StringValues() {
		 mockingContext.checking(new Expectations() {
			 {
				 allowing(keyedvalues).getItemCount();
				 will(returnValue(3));
				 allowing(keyedvalues).getValue(0);
				 will(returnValue("2"));
				 allowing(keyedvalues).getValue(1);
				 will(returnValue("8"));
				 allowing(keyedvalues).getValue(2);
				 will(returnValue("15"));
				 allowing(keyedvalues).getKey(0);
				 will(returnValue(0));
				 allowing(keyedvalues).getKey(1);
				 will(returnValue(1));
				 allowing(keyedvalues).getKey(2);
				 will(returnValue(2));
			 }
		 });
		 
		 float percent = 0;
		 float totalnumerator = 0;
		 float totaldivisor = 0;
		 KeyedValues result = getCumulativePercentages(keyedvalues);
		 
		 for (int i = 0; i < keyedvalues.getItemCount(); i++) {
			 totaldivisor = totaldivisor + keyedvalues.getValue(i).floatValue();
		 }
		 
		 
		 for (int i = 0; i < keyedvalues.getItemCount(); i++) {
			 totalnumerator = totalnumerator + keyedvalues.getValue(i).floatValue();
			 percent = (totalnumerator/totaldivisor); 
			 System.out.println(percent);
			 System.out.println(result.getValue(i).floatValue());
			 assertEquals("Values should be equal", percent, result.getValue(i).floatValue(), .01d);
		 }
	 }
}