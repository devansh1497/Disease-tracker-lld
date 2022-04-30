package model;

public class AnonymizedSummary {
    int total;
    int cured;
    int active;
    int fatalities;

    public AnonymizedSummary(BaseSummary baseSummary) {
        total = baseSummary.total.number;
        cured = baseSummary.cured.number;
        active = baseSummary.active.number;
        fatalities = baseSummary.fatalities.number;
    }

    @Override
    public String toString() {
        return "AnonymizedSummary{" +
                "total=" + total +
                ", cured=" + cured +
                ", active=" + active +
                ", fatalities=" + fatalities +
                '}';
    }
}
