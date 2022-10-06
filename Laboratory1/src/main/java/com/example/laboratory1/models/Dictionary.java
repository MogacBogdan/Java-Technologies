package com.example.laboratory1.models;
import com.example.laboratory1.utils.ResourcesManager;
import java.util.List;
import java.util.stream.Collectors;

public class Dictionary {
    private final List<String> dictionary;
    ResourcesManager resourcesManager;

    public Dictionary() {
        resourcesManager = new ResourcesManager();
        dictionary = resourcesManager.getResourceData("dictionary.txt");
    }

    public List<String> getValidWords(String word, int size) {
       Permutation permutation = new Permutation();
       List<String> permutations = permutation.getPermutations(word, size);
       return dictionary.stream()
               .filter(permutations::contains)
               .collect(Collectors.toList());
    }

}
