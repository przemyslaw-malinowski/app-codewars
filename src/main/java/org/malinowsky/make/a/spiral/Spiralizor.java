package org.malinowsky.make.a.spiral;

import java.util.ArrayList;
import java.util.List;

public class Spiralizor {
    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int UP = 3;

    private static int x = 0;
    private static int y = 0;
    private static int direction = 0;

    private static int[][] arr;
    private static int size;

    public static int[][] spiralize(int size) {
        Spiralizor.size = size;
        x = 0;
        y = 0;
        direction = RIGHT;
        arr = new int[size][size];
        
        while(true) {
            if(x < size && y < size) {
                if(checkHowManyNeighboursHasNode() > 1) {
                    break;
                }

                arr[y][x] = 1;

                if(checkIfShouldBeEnded(size)) {
                    break;
                }
            }

            if(direction == RIGHT) {
                handleMoveRight();
            } else if (direction == LEFT) {
                handleMoveLeft();
            } else if (direction == UP) {
                handleMoveUp();
            } else if (direction == DOWN) {
                HandleMoveDown(size);
            }
        }

        return arr;
    }

    private static void HandleMoveDown(int size) {
        if(y + 2 < size && arr[y+2][x] == 1) {
            direction = changeDirection();
            return;
        }
        if(y < size) {
            y += 1;
        } else {
            y -= 1;
            direction = changeDirection();
        }
    }

    private static void handleMoveUp() {
        if(y - 2 >= 0 && arr[y-2][x] == 1) {
            direction = changeDirection();
            return;
        }
        if(y > 0) {
            y -= 1;
        } else {
            y = 0;
            direction = changeDirection();
        }
    }

    private static void handleMoveLeft() {
        if(x - 2 >= 0 && arr[y][x - 2] == 1) {
            direction = changeDirection();
            return;
        }
        if(x > 0) {
            x -= 1;
        } else {
            x = 0;
            direction = changeDirection();
        }
    }

    private static void handleMoveRight() {
        if(x + 2 < size && arr[y][x + 2] == 1) {
            direction = changeDirection();
            return;
        }
        if(x < size) {
            x += 1;
        } else {
            x -= 1;
            direction = changeDirection();
        }
    }

    private static int changeDirection() {
        return (direction + 1) % 4;
    }

    private static boolean checkIfShouldBeEnded(int size) {
        return (x + 2 < size && arr[y][x + 2] == 1) &&
                (x - 2 >= 0 && arr[y][x - 2] == 1) &&
                (y - 2 >= 0 && arr[y - 2][x] == 1) &&
                (y + 2 < size && arr[y + 2][x] == 1);
    }

    private static int checkHowManyNeighboursHasNode() {
        List<Integer> integers = new ArrayList<>();

        if(x + 1 < size) {
            integers.add(arr[y][x + 1]);
        }

        if(x - 1 >= 0) {
            integers.add(arr[y][x - 1]);
        }

        if(y + 1 < size) {
            integers.add(arr[y + 1][x]);
        }

        if(y - 1 >= 0) {
            integers.add(arr[y - 1][x]);
        }

        return integers.stream().mapToInt(v -> v).sum();
    }
}
