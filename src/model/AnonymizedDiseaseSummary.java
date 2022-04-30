package model;

public class AnonymizedDiseaseSummary {
    private Disease disease;
    private AnonymizedSummary anonymizedSummary;

    private AnonymizedDiseaseSummary() {
    }

    public AnonymizedDiseaseSummary(DIseaseSummary dIseaseSummary) {
        this.disease = dIseaseSummary.getDisease();
        this.anonymizedSummary = new AnonymizedSummary(dIseaseSummary.getBaseSummary());
    }

    @Override
    public String toString() {
        return "AnonymizedDiseaseSummary{" +
                "disease=" + disease +
                ", anonymizedSummary=" + anonymizedSummary +
                '}';
    }
}
