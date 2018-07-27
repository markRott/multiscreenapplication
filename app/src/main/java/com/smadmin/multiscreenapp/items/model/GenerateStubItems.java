package com.smadmin.multiscreenapp.items.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateStubItems {

    public static final List<StubItem> ITEMS = new ArrayList<>();

    private static final int COUNT = 25;
    private static final Map<String, StubItem> ITEM_MAP = new HashMap<>();

    static {
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(StubItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getId(), item);
    }

    private static StubItem createDummyItem(int position) {
        return new StubItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position)
                .append(" More details information here.");
        return builder.toString();
    }
}
