package ca.gc.dfo.spine.interpolation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterpolationApplication implements CommandLineRunner {
    private static Logger LOG = LoggerFactory.getLogger(InterpolationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(InterpolationApplication.class, args);
    }

    @Override
    public void run(String... args) { LOG.info("Yo Patate !"); }
}
