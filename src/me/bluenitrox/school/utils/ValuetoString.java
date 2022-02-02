package me.bluenitrox.school.utils;

public class ValuetoString {

    /*public static String valueToString(float value) {
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
*/
    public static double round2(double zahl, int stellen) {
        return (double) ((int)zahl + (Math.round(Math.pow(10,stellen)*(zahl-(int)zahl)))/(Math.pow(10,stellen)));
    }

    public static String valueToString(float floatNumber) {
        long million = 1000000L;
        long billion = 1000000000L;
        long trillion = 1000000000000L;
        long number = Math.round(floatNumber);
        if ((number >= million) && (number < billion)) {
            float fraction = round(number, million);
            return Float.toString(fraction) + " Mio";
        } else if ((number >= billion) && (number < trillion)) {
            float fraction = round(number, billion);
            return Float.toString(fraction) + " Mrd";
        }
        return Long.toString(number);
    }

    public static float round(long number, long divisor) {
        long truncate = (number * 10L + (divisor / 2L)) / divisor;
        float fraction = (float) truncate * 0.10F;
        return fraction;
    }

}
