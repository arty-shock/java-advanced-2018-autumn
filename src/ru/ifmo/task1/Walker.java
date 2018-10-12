package ru.ifmo.task1;


import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Nechaev Mikhail
 * Since 09/09/2018.
 *
 * При выполнение задания следует обратить внимание на
 *  java.nio.file.Files и java.nio.file.Paths,
 *  а также корректность использование try-with-resources.
 *
 * https://docs.oracle.com/javase/tutorial/essential/io/index.html
 */
public class Walker {

    public static void main(String[] args) {
//        System.out.println(args[0] + " " + args[1]);
        if (args.length >= 2) {
            try {
                Path in = Paths.get(args[0]);
                Path out = Paths.get(args[1]);
                if (Files.isReadable(in) && Files.isWritable(out)) {
                    new Walker().run(in, out);
                } else {
                    System.err.println("Files don't exist or permissions are not met");
                }
            } catch (InvalidPathException e){
                System.err.println("Invalid path format: " + e.getMessage());
            }
        } else {
            System.err.println("Invalid arguments");
        }
        System.exit(1);
    }

    //todo: дополнить сигнатуру метода входными файлами, полученными в main
    // При необходимости создайте дополнительные классы
    // hint: Вывести результат хеша в правильном формате - String.format("%08x", hash)
    private void run(Path in, Path out) {
        System.out.println("run!");

    }
}