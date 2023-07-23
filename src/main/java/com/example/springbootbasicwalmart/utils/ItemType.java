package com.example.springbootbasicwalmart.utils;

public enum ItemType {
    SNACK("SNACK"),
    DRINK("DRINK"),
    MEAT("MEAT"),
    FISH("FISH");

    private final String matchString;

    ItemType(String matchString) {
        this.matchString = matchString;
    }

    public static ItemType of(String input) {
        return java.util.Arrays.stream(values())
                .filter(itemType -> itemType.matchString.equals(input))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("해당 상품은 없습니다."));
    }
}
