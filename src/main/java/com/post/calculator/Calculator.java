package com.post.calculator;


public class Calculator
{
    private static int[] cheapDimensions = { 229 * Parcel.MM, 162 * Parcel.MM, 25 * Parcel.MM };
    private static float cheapDimensionsPrice = 12.0f;

    private static int cheapWeight = 1800 * Parcel.G;
    private static float cheapWeightRate = 17.59f; // Euros per kilogram
    private static float fixedPrice = 2.86f; // Euros

    private static float expensiveWeightRate = 21.62f; // Euros per kilogram
    private static float expensiveDimensionsRate = 1.43f; // Euros per cubic decimeter

    public static float calculateLocalPrice(Parcel parcel) {
        float price = 0;
        if (parcel.fitsIn(cheapDimensions)) {
            price = cheapDimensionsPrice;
        } else if (parcel.getWeight() <= cheapWeight) {
            price = fixedPrice + parcel.getWeight() * cheapWeightRate / Parcel.KG;
        } else {
            price = Float.max(
                parcel.getWeight() * expensiveWeightRate / Parcel.KG,
                parcel.getVolume() * expensiveDimensionsRate / 1_000_000 // Convert cubic milimeters to cubic decimeters
            );
        }
        return price;
    }

    public static float calculatePrice(Parcel parcel, Destination destination) {
        float price = calculateLocalPrice(parcel);

        price = destination.applySurcharge(price);

        return Math.round(price * 100.0f) / 100.0f;
    }
}
