package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] case1 = new int[] {1, 31, 5, 5, 5, 27, 12, 26, 31, 12, 26, 3};
        // Given an array of numbers, return the sum of the numbers that are not repeated.
        assertEquals(getSum(case1), 31);

        int[] case2= new int[]{2,5,5,25,25,1,2,8,31,8};
        assertEquals(getSum(case2), 32);
        System.out.println("SUCCESS!!");

    }

    private static <T> void assertEquals(T actual, T expected) {
        if (!Objects.equals(actual, expected))
            throw new IllegalStateException(String.format("Expected value: <%s> but was: <%s>", expected, actual));
    }

    private static Integer getSum(int[] array) {
        // CODE GOES HERE

        /**
         *  Convertir el array int[] a List<Integer> con el fin de poder usar los metodos
         *  sort, filter,delete,get y otros. Check
         *
         *          usar un fori para recorrer el array e ir llenando la List<Integer> numeros
         *
         *  - filtrar los valores que no tengan numeros repetidos en la lista numeros
         * 
         * - usar sum para obtener la suma del array
         */
        
        //convierto a  List de integer
        List<Integer> numeros = new ArrayList<>();


        for (int i = 0; i < array.length; i++) {
            numeros.add(array[i]);
        }



        //primero lo voy a organizar
        // | 1 | 3 | 5 | 7| 5| 8| 8| 8 |


        List<Integer> collect = numeros.stream().filter(value -> {

            //encontrar cuantas veces esta value en la lista de numeros
            List<Integer> coincides =
                    numeros
                            .stream().filter(container -> container.equals(value))
                            .collect(Collectors.toList());

            return coincides.size() == 1;
        }).collect(Collectors.toList());


        //programacion funcional -> programacion declarativa
        Optional<Integer> reduce = collect
                .stream().reduce(Integer::sum);


        // programacion imperativa
        Integer acumulado = 0;

        for (int i = 0; i < collect.size(); i++) {
            acumulado += collect.get(i);
        }
        
        assertEquals(acumulado, reduce.orElse(0));


        //imaginemos que ya lo transforme
        List<Integer> arrayList = new ArrayList<>();

        Map<Integer, List<Integer>> collect2 = arrayList
                .stream().collect(Collectors.groupingBy(Function.identity()));
        /**
         * 1 -> List(1)
         * 5 -> List(5,5)
         * 8 -> List(8,8,8)
         */


        Optional<Integer> reduce2 = collect2.keySet().stream()
                .filter(num -> collect2.get(num).size() == 1)
                .reduce(Integer::sum);

        return reduce.orElse(0);





        return reduce.orElse(0);


    }
}