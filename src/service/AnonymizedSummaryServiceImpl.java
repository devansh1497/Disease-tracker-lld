package service;

import model.AnonymizedDiseaseSummary;
import model.AnonymizedSummary;
import model.DIseaseSummary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnonymizedSummaryServiceImpl implements AnonymizedSummaryService {

    private SummaryService summaryService;

    public AnonymizedSummaryServiceImpl(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @Override
    public AnonymizedSummary showWorldSummary() {
        return new AnonymizedSummary(summaryService.showWorldSummary());
    }

    @Override
    public List<AnonymizedDiseaseSummary> showWorldSummaryByDiseaseBreakup() {
        List<DIseaseSummary> dIseaseSummaries = summaryService.showWorldSummaryByDiseaseBreakup();
        List<AnonymizedDiseaseSummary> ans = new ArrayList<>();
        for (DIseaseSummary dIseaseSummary : dIseaseSummaries) {
            ans.add(new AnonymizedDiseaseSummary(dIseaseSummary));
        }
        return ans;
    }
}
