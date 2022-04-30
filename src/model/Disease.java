package model;

import enums.TransmissionType;

import java.util.Objects;

public class Disease {

    private String diseaseName;
    private String type;
    private TransmissionType transmissionType;
    private String transmissionBy;

    public Disease(String diseaseName, String type, TransmissionType transmissionType, String transmissionBy) {
        this.diseaseName = diseaseName;
        this.type = type;
        this.transmissionType = transmissionType;
        this.transmissionBy = transmissionBy;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getTransmissionBy() {
        return transmissionBy;
    }

    public void setTransmissionBy(String transmissionBy) {
        this.transmissionBy = transmissionBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disease disease = (Disease) o;
        return Objects.equals(getDiseaseName(), disease.getDiseaseName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiseaseName());
    }

    @Override
    public String toString() {
        return "Disease{" +
                "diseaseName='" + diseaseName + '\'' +
                ", type='" + type + '\'' +
                ", transmissionType=" + transmissionType +
                ", transmissionBy='" + transmissionBy + '\'' +
                '}';
    }
}
