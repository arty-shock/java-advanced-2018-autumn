package ru.ifmo.task1;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Nechaev Mikhail
 * Since 09/09/2018.
 */
public class HashUtils {

    public static final int INCORRECT_FILE_HASH = 0;

    private static final int INITIAL_VALUE = 0x811c9dc5;
    private static final int MULTIPLIER = 0x01000193;
    private static final int LOW_BITS = 0xff;

    private static final int BUFFER_SIZE = 4096;

    public static int calculate(Path file) {
        int hash = INITIAL_VALUE;
        try (BufferedInputStream stream = new BufferedInputStream(Files.newInputStream(file), BUFFER_SIZE)) {
            byte nextByte;
            while ((nextByte = (byte) stream.read()) != -1) {
                hash = update(hash, nextByte);
            }
            return hash;
        } catch (IOException e) {
            System.err.println("Cannot read file: " + e.getMessage());
            return INCORRECT_FILE_HASH;
        } catch (SecurityException e) {
            System.err.println("Security exception: " + e.getMessage());
            return INCORRECT_FILE_HASH;
        }
    }

    private static int update(int currentHash, byte nextByte) {
        return (currentHash * MULTIPLIER) ^ (nextByte & LOW_BITS);
    }
}
