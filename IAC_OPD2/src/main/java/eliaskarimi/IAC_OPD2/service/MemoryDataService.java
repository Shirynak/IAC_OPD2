package eliaskarimi.IAC_OPD2.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import eliaskarimi.IAC_OPD2.model.Country;
import eliaskarimi.IAC_OPD2.model.Population;
@Service
public class MemoryDataService {
    public List<Population> createData() {
        List<Population> data = new ArrayList<Population>();
        Country nederland = new Country("Nederland", "Europa");
        Country duitsland = new Country("Duitsland", "Europa");

        data.add(new Population("17", "2017", nederland));
        data.add(new Population("17", "2016", nederland));
        data.add(new Population("81", "2017", duitsland));
        return data;
    }
}

