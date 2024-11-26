package com.example.testTask;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FirstTaskService {
    public String transformText(String desc) {
        String vow = "aouieěýáíéůú";
        List<Integer> indexes = new LinkedList<>();
        String[] split = desc.replaceAll(" +", " ")
                .toLowerCase()
                .split("");
        for (int i = 0; i < split.length; i++) {
            if (vow.contains(split[i])) {
                indexes.add(i);
            }
        }

        Collections.reverse(Arrays.asList(split));

        for (int index : indexes) {
            split[index] = split[index].toUpperCase();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
