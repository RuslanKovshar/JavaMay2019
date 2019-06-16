package com.company.model;

import com.company.view.View;

import static com.company.view.TextConstants.TYPE_MSG;
import static com.company.view.TextConstants.MATERIAL_MSG;

public class Doll extends Toy {
    private String type;
    private String material;

    public Doll(double price, int ageCategory, String type, String material) {
        super(price, ageCategory);
        this.type = type;
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString(){
        return super.toString() + View.getBundleMessage(TYPE_MSG) + type + "\n" +
                View.getBundleMessage(MATERIAL_MSG) + material + "\n";
    }
}