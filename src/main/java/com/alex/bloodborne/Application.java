package com.alex.bloodborne;

import com.alex.bloodborne.attire.Attire.Attribute;
import com.alex.bloodborne.attire.Closet;
import com.alex.bloodborne.attire.Suitcase;
import com.alex.bloodborne.attire.config.BloodborneConfig;
import com.alex.bloodborne.attire.config.ClosetFactory;
import com.alex.bloodborne.attire.config.SuitcaseConfig;
import com.alex.bloodborne.attire.config.SuitcaseFactory;
import com.alex.bloodborne.attire.delivery.console.SuitcaseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static com.alex.util.StringUtils.LS;

/**
 * Banner made with: http://patorjk.com/software/taag/#p=display&f=Bloody&t=Bloodborne
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String... args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private BloodborneConfig bloodborneConfig;

    private final ClosetFactory closetFactory = new ClosetFactory();
    private final SuitcaseFactory suitcaseFactory = new SuitcaseFactory();

    @Override
    public void run(String... args) throws Exception {
        final Closet closet = closetFactory.create(bloodborneConfig.getAttireSets());

        Suitcase previousSuitcase = null;

        for (SuitcaseConfig suitcaseConfig : bloodborneConfig.getFilters()) {
            final Suitcase suitcase = suitcaseFactory.create(suitcaseConfig);

            if (previousSuitcase == null) {
                closet.packInto(suitcase);
            } else {
                previousSuitcase.forEach(suitcase::add);
            }

            printHeader(suitcase, suitcaseConfig.getAttributes());
            if (suitcaseConfig.isPrint()) {
                print(suitcase);
            }

            previousSuitcase = suitcase;
        }
    }

    private void printHeader(Suitcase suitcase, List<Attribute> attributes) {
        final String header = LS + "Filtering " + suitcase.size() + " results of " + suitcase.getTotalResults()
                + ". Maximizing attributes: " + attributes;

        System.out.println(header);
    }

    private void print(Suitcase suitcase) {
        final SuitcaseView suitcaseView = new SuitcaseView();
        final String printedSuitcase = suitcaseView.print(suitcase);

        System.out.println(printedSuitcase);
    }

}
