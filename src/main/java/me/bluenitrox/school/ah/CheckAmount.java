package me.bluenitrox.school.ah;

public class CheckAmount {

    public static boolean check(String i) {
        if (i.contains("a") || i.contains("b") || i.contains("c") || i.contains("d") || i.contains("e") || i.contains("f") || i.contains("g") || i.contains("h") || i.contains("i") || i.contains("j") || i.contains("k") || i.contains("l") || i.contains("m") || i.contains("n") || i.contains("o") || i.contains("p") || i.contains("q") || i.contains("r") || i.contains("s") || i.contains("t") || i.contains("u") || i.contains("v") || i.contains("w") || i.contains("x") || i.contains("y") || i.contains("z") || i.contains("&") || i.contains("%") || i.contains("$") || i.contains("/") || i.contains("(") || i.contains(")") || i.contains("=") || i.contains("?") || i.contains("´") || i.contains("#") || i.contains(".") || i.contains("-") || i.contains("_") || i.contains(";") || i.contains(":") || i.contains(",") || i.contains("<") || i.contains(">") || i.contains("|")) {
            return false;
        }
        return true;
    }

}
