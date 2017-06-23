package eliaskarimi.IAC_OPD2.recources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eliaskarimi.IAC_OPD2.model.Population;
import eliaskarimi.IAC_OPD2.repository.PopulationRepo;
import eliaskarimi.IAC_OPD2.service.MemoryDataService;

@RestController
@RequestMapping(value = "/insertData")
public class MemoryDataResource {
    @Autowired
    private MemoryDataService memoryDataService;

    @Autowired
    private PopulationRepo populationRepo;

    @RequestMapping
    public Iterable<Population> storeData() {
        populationRepo.deleteAll();
        return populationRepo.save(memoryDataService.createData());
    }


}

