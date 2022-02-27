package me.bluenitrox.school.utils;

public class ValuetoString {



    public static String valueToString(double number){

        if(number >= 1000000000){
            return String.format("%.2fMrd", number/ 1000000000.0);
        }

        if(number >= 1000000){
            return String.format("%.2fMio", number/ 1000000.0);
        }

        if(number >=1000){
            return String.format("%.2fTsd", number/ 1000.0);
        }
        return String.valueOf(number);

    }

    public static String valueToStringXP(float number) {
        if(number >= 1000000000){
            return String.format("%.2fMrd", number/ 1000000000.0);
        }

        if(number >= 1000000){
            return String.format("%.2fMio", number/ 1000000.0);
        }

        if(number >=1000){
            return String.format("%.2fTsd", number/ 1000.0);
        }
        return String.valueOf(number);
    }

    public static double round(double zahl, int stellen) {
        return (double) ((int)zahl + (Math.round(Math.pow(10,stellen)*(zahl-(int)zahl)))/(Math.pow(10,stellen)));
    }


}
