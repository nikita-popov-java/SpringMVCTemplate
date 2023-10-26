package com.nikitaee.springwebapp.dao;

import com.nikitaee.springwebapp.models.Otter;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class OtterDAO {
    private List<Otter> otters;
    private final File OTTERS_DB = new File("/home/nikita/IdeaProjects/SpringMVCTemplate/src/main/resources/otters.txt");

    {
        Scanner scan;
        otters = new ArrayList<>();

        try {
            scan = new Scanner(OTTERS_DB);
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
                .filter(o -> o.getType().equalsIgnoreCase(type))
                .findAny()
                .orElse(null);
    }

    public void save(Otter otter) {
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(OTTERS_DB, true))) {
            fileWriter.append("\n").append(otter.toString());
            otters.add(otter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String type, Otter otter) {
        Otter otterToUpdate = show(type);

        if (otterToUpdate == null) {
            throw new IllegalArgumentException(String.format("Otter with type '%s' does not exist!", type));
        }

        otterToUpdate.setType(otter.getType());
        otterToUpdate.setAverageLength(otter.getAverageLength());
        otterToUpdate.setAverageWeight(otter.getAverageWeight());
        otterToUpdate.setPhotoName(otter.getPhotoName());
    }

    public void delete(String type) {
        otters.removeIf(otter -> otter.getType().equalsIgnoreCase(type));
    }
}
