package model;

public class DIseaseSummary {

    private Disease disease;
    private BaseSummary baseSummary;

    public DIseaseSummary(Disease disease, BaseSummary baseSummary) {
        this.disease = disease;
        this.baseSummary = baseSummary;
    }

    public Disease getDisease() {
        return disease;
    }

    public BaseSummary getBaseSummary() {
        return baseSummary;
    }

    @Override
    public String toString() {
        return "DIseaseSummary{" +
                "disease=" + disease +
                ", baseSummary=" + baseSummary +
                '}';
    }
}
