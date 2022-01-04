package io.example.distance_matrix_library;

public class Utility {

    public static boolean maybeJson(String text) {
        if (text == null) {
            return false;
        }
        text = text.trim();
        if (text.startsWith("[") && text.endsWith("]")) {
            return true;
        }
        if (text.startsWith("{") && text.endsWith("}")) {
            return true;
        }
        return false;
    }

}
