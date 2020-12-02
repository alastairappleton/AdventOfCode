package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {



    public static void main(String[] args) {

        List<String> list;
        list = readFile("resources/Day1.txt");

        // part 1:
        System.out.println(part1(list));

        // part 2:
        System.out.println(part2(list));
    }

    public static List<String> readFile(String fileName){

        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }


    public static Integer part1(List<String> list) {
        Integer answer = null;

        // list.forEach(); // can we use this?

        for (int i = 0; i < list.size(); i++) {
            Integer firstNumber = Integer.parseInt(list.get(i));

            // i+1 to just take the remaining part of the list each time
            // there's no need to start from the beginning on every loop, since addition is commutative
            for (int j = i+1; j < list.size(); j++) {
                Integer secondNumber = Integer.parseInt(list.get(j));

                System.out.println(i + "." + j + ": considering " + firstNumber + " and " + secondNumber);

                if (firstNumber + secondNumber == 2020) {
                    answer = firstNumber * secondNumber;
                    return answer; // no need to keep processing once we have the answer
                }
            }

        }

        return answer;
    }


    public static Integer part2(List<String> list) {
        Integer answer = null;

        for (int i = 0; i < list.size(); i++) {
            Integer firstNumber = Integer.parseInt(list.get(i));

            for (int j = i+1; j < list.size(); j++) {
                Integer secondNumber = Integer.parseInt(list.get(j));

                for (int k = j+1; k < list.size(); k++) {
                    Integer thirdNumber = Integer.parseInt(list.get(k));

                    System.out.println(i + "." + j + "." + k + ": considering " + firstNumber + " and " + secondNumber + " and " + thirdNumber);

                    if (firstNumber + secondNumber + thirdNumber == 2020) {
                        answer = firstNumber * secondNumber * thirdNumber;
                        return answer;
                    }
                }
            }

        }

        return answer;
    }

}
