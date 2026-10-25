package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Registration;
import mk.ukim.finki.wp.lab.model.Workshop;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Workshop> workshops = null;
    public static List<Registration> registrations = null;

    @PostConstruct
    public void init() {
        workshops = new ArrayList<>();
        workshops.add(new Workshop("Intro to Java", "Programming", 1200.0, 20));
        workshops.add(new Workshop("Spring Boot Basics", "Programming", 1800.0, 15));
        workshops.add(new Workshop("UI/UX Design", "Design", 1500.0, 10));
        workshops.add(new Workshop("Photography 101", "Art", 900.0, 0));
        workshops.add(new Workshop("Public Speaking", "Soft Skills", 700.0, 25));
        workshops.add(new Workshop("Data Science with Python", "Data", 2000.0, 12));
        workshops.add(new Workshop("Digital Marketing", "Marketing", 1100.0, 18));
        workshops.add(new Workshop("Watercolor Painting", "Art", 800.0, 8));
        workshops.add(new Workshop("Docker & DevOps", "Programming", 1900.0, 0));
        workshops.add(new Workshop("Creative Writing", "Literature", 600.0, 30));

        registrations = new ArrayList<>();
    }
}
