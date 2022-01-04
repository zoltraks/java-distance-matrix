package io.example.distance_matrix_library;

public class Body {

    public Body() {
    }

    public String[] destinationAddresses;
    public String errorMessage;
    public String[] originAddresses;
    public Row[] rows;
    public String status;

    public static class Row {
        public Element[] elements;
    }

    public static class Element {
        public TextValue distance;
        public TextValue duration;
        public TextValue durationInTraffic;
        public String status;
    }

    public static class TextValue {
        public String text;
        public double value;
    }

}
