package datastore;

import model.Disease;
import model.Person;
import model.ReportRecord;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataStore {

    public Set<Disease> diseases = new HashSet<>();
    public Map<Disease, List<ReportRecord>> diseaseReportRecordHashMap = new HashMap<>();

}
