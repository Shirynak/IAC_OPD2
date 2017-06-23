package eliaskarimi.IAC_OPD2;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import eliaskarimi.IAC_OPD2.model.Country;
import eliaskarimi.IAC_OPD2.model.Population;
import eliaskarimi.IAC_OPD2.recources.CountryResource;
import eliaskarimi.IAC_OPD2.repository.PopulationRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private CountryResource countryResource;

    @Autowired
    private PopulationRepo populationRepo;

    @Test
    public void test_if_the_inserted_population_has_right_population() {
        Country givenCountry = new Country("VS", "Amerika");
        Population givenPopulation = new Population("300", "2017", givenCountry);

        Population expectedPopulation = countryResource.addCountry("VS", "Amerika", "2017", "300");

        Assert.assertEquals(givenPopulation.getPopulation(), expectedPopulation.getPopulation());
    }

    @Test
    public void test_if_the_inserted_country_has_right_name() {
        Country givenCountry = new Country("VS", "Amerika");
        Population givenPopulation = new Population("300", "2017", givenCountry);

        Population expectedPopulation = countryResource.addCountry("VS", "Amerika", "2017", "300");

        Assert.assertEquals(givenCountry.getName(), expectedPopulation.getCountry().getName());
    }

    @Test
    public void test_if_a_country_can_be_found_based_on_year_and_name() {
        Country givenCountry = new Country("VS", "Amerika");
        Population givenPopulation = new Population("300", "2017", givenCountry);

        populationRepo.save(givenPopulation);

        Population expectedPopulation = countryResource.getAllPopulationByCountryAndYear("VS", "2017");

        Assert.assertNotNull(expectedPopulation.getPopulation());
        Assert.assertEquals(givenPopulation.getPopulation(), expectedPopulation.getPopulation());
    }


}

