package me.bluenitrox.school.utils;

public class ValuetoString {



    public static String valueToString(double number){

        if(number >= 1000000000){
            return String.format("%.2fMrd", number/ 1000000000.0);
        }

        if(number >= 1000000){
            return String.format("%.2fMio", number/ 1000000.0);
        }

        if(number >= 100000){
            return String.format("%.2fTsd", number/ 100000.0);
        }

        if(number >=1000){
            return String.format("%.2fTsd", number/ 1000.0);
        }
        return String.valueOf(number);

    }

    public static String valueToStringXP(float value) {
        String valueString = String.format("%.2f", value);
        valueString = valueString.split(",")[0];
        if(valueString.length() <= 9 && valueString.length() >= 7) {
            return round(value / 1000000f, 3) + " Mio";
        }else if(valueString.length() <= 12 && valueString.length() >= 10) {
            return round(value / 1000000000f, 3) + " Mrd";
        }else if(valueString.length() >= 13){
            return round(value / 1000000000000f, 3) + " Bio";
        }else {
            return valueString;
        }
    }

    public static double round(double zahl, int stellen) {
        return (double) ((int)zahl + (Math.round(Math.pow(10,stellen)*(zahl-(int)zahl)))/(Math.pow(10,stellen)));
    }


}
