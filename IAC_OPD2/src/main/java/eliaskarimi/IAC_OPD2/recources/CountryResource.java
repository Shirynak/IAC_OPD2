package eliaskarimi.IAC_OPD2.recources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eliaskarimi.IAC_OPD2.model.Country;
import eliaskarimi.IAC_OPD2.model.Population;
import eliaskarimi.IAC_OPD2.repository.CountryRepo;
import eliaskarimi.IAC_OPD2.repository.PopulationRepo;

@RestController
@RequestMapping(value = "/countries")

public class CountryResource {

    @Autowired
    private PopulationRepo populationRepo;
    @Autowired
    private CountryRepo countryRepo;

    @RequestMapping(value = "all")
    public Iterable<Population> getAllPopulations() {
        return populationRepo.findAll();
    }


    @RequestMapping
    public Iterable<Country> getAllCountries() {
        return countryRepo.findAll();
    }


    @RequestMapping("{country}/{year}")
    public Population getAllPopulationByCountryAndYear(@PathVariable String country, @PathVariable String year) {
        for (Population population : populationRepo.findAll()) {
            if (population.getCountry().getName().equals(country) && population.getYear().equals(year)) {
                return population;
            }
        }
        return null;
    }

    @RequestMapping("{country}")
    public List<Population> getAllPopulationByCountry(@PathVariable String country) {
        List<Population> listOfPopulations = new ArrayList<Population>();
        for (Population population : populationRepo.findAll()) {
            if (population.getCountry().getName().equals(country)) {
                listOfPopulations.add(population);
            }
        }
        return listOfPopulations;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Population addCountry(@ModelAttribute("country") String countryName,
                                 @ModelAttribute("continent") String continent,
                                 @ModelAttribute("year") String year,
                                 @ModelAttribute("population") String population) {
        Country country = new Country(countryName, continent);
        return populationRepo.save(new Population(population, year, country));
    }

}

