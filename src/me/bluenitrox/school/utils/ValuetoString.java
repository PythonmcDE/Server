package me.bluenitrox.school.utils;

public class ValuetoString {

    public static String valueToString(float value) {
        String valueString = String.format("%.2f", value);
        valueString = valueString.split(",")[0];
        if(valueString.length() <= 9 && valueString.length() >= 7) {
            return round(value / 1000000f, 2) + " Mio";
        }else if(valueString.length() <= 12 && valueString.length() >= 10) {
            return round(value / 1000000000f, 2) + " Mrd";
        }else if(valueString.length() >= 13){
            return round(value / 1000000000000f, 2) + " Bio";
        }else {
            return valueString;
        }
    }

    public static double round(double zahl, int stellen) {
        return (double) ((int)zahl + (Math.round(Math.pow(10,stellen)*(zahl-(int)zahl)))/(Math.pow(10,stellen)));
    }

}
