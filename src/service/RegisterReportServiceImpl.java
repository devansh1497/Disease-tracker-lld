package service;

import datastore.DataStore;
import enums.StatusType;
import model.Disease;
import model.Person;
import model.ReportRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegisterReportServiceImpl implements RegisterReportService {

    private DataStore dataStore;

    public RegisterReportServiceImpl(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void register(Disease diseaseName) throws Exception {
        if(isDiseasePresent(diseaseName)) {
            throw new Exception("Disease already present");
        }
        this.dataStore.diseases.add(diseaseName);
    }

    @Override
    public void report(Disease disease, Person person) {
        ReportRecord reportRecord = new ReportRecord(person, StatusType.ACTIVE);
        this.dataStore.diseaseReportRecordHashMap.putIfAbsent(disease, new ArrayList<>());
        this.dataStore.diseaseReportRecordHashMap.get(disease).add(reportRecord);
    }

    @Override
    public void cure(Disease disease, Person person) {
        List<ReportRecord> reportRecordList = this.dataStore.diseaseReportRecordHashMap.get(disease);
        for (ReportRecord reportRecord : reportRecordList) {
            if(reportRecord.getPerson() == person) {
                reportRecord.makeCured();
            }
        }
    }

    @Override
    public void fatality(Person person) {
        for(Map.Entry<Disease, List<ReportRecord>> entrySet: this.dataStore.diseaseReportRecordHashMap.entrySet()) {
            for (ReportRecord reportRecord : entrySet.getValue()) {
                if(reportRecord.getPerson() == person) {
                    reportRecord.markFatality();
                }
            }
        }
    }

    private boolean isDiseasePresent(Disease diseaseName) {
        return this.dataStore.diseases.contains(diseaseName);
    }
}
