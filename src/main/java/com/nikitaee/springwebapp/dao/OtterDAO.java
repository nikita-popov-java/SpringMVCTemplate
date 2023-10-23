package com.nikitaee.springwebapp.dao;

import com.nikitaee.springwebapp.models.Otter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Component
public class OtterDAO {
    private List<Otter> otters;

    {
        Scanner scan;
        otters = new ArrayList<>();

        try {
            scan = new Scanner(new File("/home/nikita/IdeaProjects/SpringMVCTemplate/src/main/resources/otters.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scan.hasNext()) {
            String[] params = scan.nextLine().split(";");
            otters.add(new Otter(
                    params[0],
                    Integer.parseInt(params[1]),
                    Integer.parseInt(params[2]),
                    params[3])
            );
        }
    }

    public List<Otter> index() {
        return otters;
    }

    public Otter show(String type) {
        return otters.stream()
                .filter(o -> o.getType().equals(type))
                .findAny().
                orElse(null);
    }
}
