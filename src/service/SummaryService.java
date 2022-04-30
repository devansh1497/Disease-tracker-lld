package service;

import model.BaseSummary;
import model.DIseaseSummary;
import model.Disease;

import java.util.List;

public interface SummaryService {

    BaseSummary showWorldSummary();

    List<DIseaseSummary> showWorldSummaryByDiseaseBreakup();

    void showCountryBreakupByDisease(Disease disease);

    void showStateBreakUpByDiseaseAndCountry(String countryName, Disease disease);
}
