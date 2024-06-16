package com.post;

public enum Destination {
    FRANCE("FR", 0.0f),
    MONACO("MC", 8.7f / 100),
    DOMTOM("DOM/TOM", 5.4f / 100, 1.26f);

    private final String code;
    private final float surcharge;
    private final float fixedExtra;

    Destination(String code, float surcharge, float fixedExtra) {
        this.code = code;
        this.surcharge = surcharge;
        this.fixedExtra = fixedExtra;
    }

    Destination(String code, float surcharge) {
        this(code, surcharge, 0.0f);
    }

    public String getCode() {
        return this.code;
    }

    public float applySurcharge(float price) {
        return price * (1 + this.surcharge) + this.fixedExtra;
    }
}