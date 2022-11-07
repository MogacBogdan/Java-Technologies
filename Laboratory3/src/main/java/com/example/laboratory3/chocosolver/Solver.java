package com.example.laboratory3.chocosolver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

import java.util.stream.IntStream;

public class Solver {
    public static void main(String[] args) {
       int n = 4;
       Model model = new Model("Tournament Scheduling Problem");
       IntVar[] teams = IntStream
               .range(0, n)
               .mapToObj(i -> model.intVar("team #" + i,0,  i, false))
               .toArray(IntVar[]::new);

       IntVar[] weeks = IntStream
               .range(0, n - 1)
               .mapToObj(i -> model.intVar("week #" + i,0,  i, false))
               .toArray(IntVar[]::new);

       IntVar[] periods = IntStream
               .range(0, n / 2)
               .mapToObj(i -> model.intVar("period #" + i,0,  i, false))
               .toArray(IntVar[]::new);
    }
}
