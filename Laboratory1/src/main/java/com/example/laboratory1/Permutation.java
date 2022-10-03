package com.example.laboratory1;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private final List<String> permutations;

    public Permutation() {
        permutations = new ArrayList<>();
    }

    public void permute(String str, String answer, int size) {
        if (size == 0) {
            if (answer.length() > 1) {
                addPermutationToList(answer);
                if (str.length() == 0) { return; }
            }
        } else {
            if (answer.length() == size || str.length() == 0) {
                addPermutationToList(answer);
                return;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            permute(ros, answer + ch, size);
        }
    }

    private void addPermutationToList(String answer) {
       if(!permutations.contains(answer)) permutations.add(answer);
    }

    public List<String> getPermutations() {
        return permutations;
    }

    public List<String> getPermutations(String word, int size) {
        permute(word, "", size);
        return permutations;
    }

}
