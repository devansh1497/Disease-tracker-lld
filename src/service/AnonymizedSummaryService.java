package service;

import model.AnonymizedDiseaseSummary;
import model.AnonymizedSummary;

import java.util.List;

public interface AnonymizedSummaryService {

    AnonymizedSummary showWorldSummary();

    List<AnonymizedDiseaseSummary> showWorldSummaryByDiseaseBreakup();
}
