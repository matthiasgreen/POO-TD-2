package com.post;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CalculatorMust 
    extends TestCase
{
    public CalculatorMust( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( CalculatorMust.class );
    }

    public static final Object[][] testParameters = {
        { new int[]{191 * Parcel.MM, 123 * Parcel.MM, 18 * Parcel.MM}, 2354 * Parcel.G, Destination.FRANCE, 12.0f },
        { new int[]{253 * Parcel.MM, 215 * Parcel.MM, 164 * Parcel.MM}, 1565 * Parcel.G, Destination.FRANCE, 30.39f },
        { new int[]{653 * Parcel.MM, 133 * Parcel.MM, 271 * Parcel.MM}, 2132 * Parcel.G, Destination.FRANCE, 46.09f },
        { new int[]{653 * Parcel.MM, 331 * Parcel.MM, 271 * Parcel.MM}, 3650 * Parcel.G, Destination.FRANCE, 83.76f },
        { new int[]{191 * Parcel.MM, 123 * Parcel.MM, 18 * Parcel.MM}, 2354 * Parcel.G, Destination.MONACO, 13.04f },
        { new int[]{253 * Parcel.MM, 215 * Parcel.MM, 164 * Parcel.MM}, 1565 * Parcel.G, Destination.MONACO, 33.03f },
        { new int[]{653 * Parcel.MM, 133 * Parcel.MM, 271 * Parcel.MM}, 2132 * Parcel.G, Destination.MONACO, 50.10f },
        { new int[]{653 * Parcel.MM, 331 * Parcel.MM, 271 * Parcel.MM}, 3650 * Parcel.G, Destination.MONACO, 91.05f },
        { new int[]{191 * Parcel.MM, 123 * Parcel.MM, 18 * Parcel.MM}, 2354 * Parcel.G, Destination.DOMTOM, 13.91f },
        { new int[]{253 * Parcel.MM, 215 * Parcel.MM, 164 * Parcel.MM}, 1565 * Parcel.G, Destination.DOMTOM, 33.29f },
        { new int[]{653 * Parcel.MM, 133 * Parcel.MM, 271 * Parcel.MM}, 2132 * Parcel.G, Destination.DOMTOM, 49.84f },
        // Changed 89.54f to 89.55f. Did the calculation by hand and it was 89.545f which is rounded to 89.55f
        { new int[]{653 * Parcel.MM, 331 * Parcel.MM, 271 * Parcel.MM}, 3650 * Parcel.G, Destination.DOMTOM, 89.55f }
    };

    public void testApp()
    {
        for (Object[] testParameter : testParameters) {
            int[] dimensions = (int[]) testParameter[0];
            int weight = (int) testParameter[1];
            Destination destination = (Destination) testParameter[2];
            float expectedPrice = (float) testParameter[3];
            assertEquals(expectedPrice, Calculator.calculatePrice(new Parcel(dimensions, weight), destination));
        }

    }
}
