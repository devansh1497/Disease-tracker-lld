package model;

import enums.StatusType;

public class ReportRecord {
    Person person;
    StatusType statusType;

    public ReportRecord(Person person, StatusType statusType) {
        this.person = person;
        this.statusType = statusType;
    }

    public Person getPerson() {
        return person;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void markFatality() {
        this.statusType = StatusType.FATALITY;
    }

    public void makeCured() {
        this.statusType = StatusType.CURED;
    }

    @Override
    public String toString() {
        return "ReportRecord{" +
                "person=" + person +
                ", statusType=" + statusType +
                '}';
    }
}
