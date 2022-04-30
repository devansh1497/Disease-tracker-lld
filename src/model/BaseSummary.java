package model;

public class BaseSummary {
    TotalAndNamesPair total;
    TotalAndNamesPair cured;
    TotalAndNamesPair fatalities;
    TotalAndNamesPair active;

    public BaseSummary(TotalAndNamesPair total, TotalAndNamesPair cured, TotalAndNamesPair fatalities, TotalAndNamesPair active) {
        this.total = total;
        this.cured = cured;
        this.fatalities = fatalities;
        this.active = active;
    }

    @Override
    public String toString() {
        return "BaseSummary{" +
                "total=" + total +
                ", cured=" + cured +
                ", fatalities=" + fatalities +
                ", active=" + active +
                '}';
    }
}
