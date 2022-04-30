package service;

import datastore.DataStore;
import enums.StatusType;
import model.BaseSummary;
import model.DIseaseSummary;
import model.Disease;
import model.Person;
import model.ReportRecord;
import model.TotalAndNamesPair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SummaryServiceImpl implements SummaryService {

    private DataStore dataStore;

    public SummaryServiceImpl(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public BaseSummary showWorldSummary() {
        List<Person> cured = new ArrayList<>();
        List<Person> fatailities = new ArrayList<>();
        List<Person> active = new ArrayList<>();
        for (Map.Entry<Disease, List<ReportRecord>> diseaseListEntry : this.dataStore.diseaseReportRecordHashMap.entrySet()) {
            segregateCount(diseaseListEntry, active, cured, fatailities);
        }
        List<Person> total = new ArrayList<>(cured);
        total.addAll(fatailities);
        total.addAll(active);
        return new BaseSummary(new TotalAndNamesPair(total.size(), total), new TotalAndNamesPair(cured.size(), cured),
                new TotalAndNamesPair(fatailities.size(), fatailities), new TotalAndNamesPair(active.size(), active));
    }

    @Override
    public List<DIseaseSummary> showWorldSummaryByDiseaseBreakup() {
        List<DIseaseSummary> summary = new ArrayList<>();
        for (Map.Entry<Disease, List<ReportRecord>> diseaseListEntry : this.dataStore.diseaseReportRecordHashMap.entrySet()) {
            List<Person> cured = new ArrayList<>();
            List<Person> fatalities = new ArrayList<>();
            List<Person> active = new ArrayList<>();
            segregateCount(diseaseListEntry, active, cured, fatalities);
            List<Person> total = new ArrayList<>(cured);
            total.addAll(fatalities);
            total.addAll(active);
            BaseSummary baseSummary = new BaseSummary(new TotalAndNamesPair(total.size(), total), new TotalAndNamesPair(cured.size(), cured),
                    new TotalAndNamesPair(fatalities.size(), fatalities), new TotalAndNamesPair(active.size(), active));
            summary.add(new DIseaseSummary(diseaseListEntry.getKey(), baseSummary));
        }
        return summary;
    }

    private void segregateCount(Map.Entry<Disease, List<ReportRecord>> diseaseListEntry, List<Person> active, List<Person> cured, List<Person> fatalities) {
        for (ReportRecord reportRecord : diseaseListEntry.getValue()) {
            if(reportRecord.getStatusType() == StatusType.ACTIVE) {
                active.add(reportRecord.getPerson());
            }
            else if(reportRecord.getStatusType() == StatusType.CURED) {
                cured.add(reportRecord.getPerson());
            }
            else if(reportRecord.getStatusType() == StatusType.FATALITY) {
                fatalities.add(reportRecord.getPerson());
            }
        }
    }

    @Override
    public void showCountryBreakupByDisease(Disease disease) {

    }

    @Override
    public void showStateBreakUpByDiseaseAndCountry(String countryName, Disease disease) {

    }
}
