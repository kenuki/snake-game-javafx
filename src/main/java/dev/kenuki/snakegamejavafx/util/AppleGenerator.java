package dev.kenuki.snakegamejavafx.util;

import java.util.ArrayList;
import java.util.Random;

public class AppleGenerator {
    public static void add(final Random random, final int amount, final Entity[][] field) {
        final var list_of_empty = new ArrayList<int[]>();

        for (int y = 0; y < field.length; y += 1) {
            final var row = field[y];
            for (int x = 0; x < row.length; x += 1) {
                if (row[x] == Entity.AIR) {
                    list_of_empty.add(new int[]{ x, y });
                }
            }
        }

        assert list_of_empty.size() >= amount : "ЫААААААА";

        for (int i = 0; i < amount; i += 1) {
            int index = random.nextInt(0, list_of_empty.size());

            int[] position = list_of_empty.remove(index);
            final var y = position[1];
            final var x = position[0];

            field[y][x] = Entity.APPLE;
        }
    }
}
