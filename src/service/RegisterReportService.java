package service;

import enums.TransmissionType;
import model.Disease;
import model.Person;

public interface RegisterReportService {

    void register(Disease disease) throws Exception;

    void report(Disease disease, Person person);

    void cure(Disease disease, Person person);

    void fatality(Person person);
}
