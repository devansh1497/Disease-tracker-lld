import datastore.DataStore;
import enums.TransmissionType;
import model.Disease;
import model.Location;
import model.Person;
import service.AnonymizedSummaryService;
import service.AnonymizedSummaryServiceImpl;
import service.RegisterReportService;
import service.RegisterReportServiceImpl;
import service.SummaryService;
import service.SummaryServiceImpl;

public class Main {

    public static void main(String[] args) throws Exception {
        DataStore dataStore  = new DataStore();
        RegisterReportService registerReportService = new RegisterReportServiceImpl(dataStore);
        Disease covid = new Disease("Covid", "VIRAL", TransmissionType.TRANSMISSIBLE, "AIR");
        Disease hunger = new Disease("Hunger", "Economy", TransmissionType.NON_TRANSMISSIBLE, "NA");
        Disease typhoid = new Disease("Typhoid", "Bacterial", TransmissionType.TRANSMISSIBLE, "Water");

        Location loc1 = new Location("China", "Hubei", "Wuhan");
        Location loc2 = new Location("China", "Jiganshu", "Shanghai");
        Location loc3 = new Location("India", "Uttar Praddhesh", "Agra");
        Location loc4 = new Location("India", "Uttar Praddhesh", "Varanasi");
        Location loc5 = new Location("India", "Karnataka", "Bangalore");
        Location loc6 = new Location("USA", "California", "Los Angeles");
        Location loc7 = new Location("USA", "California", "SAN Francisco");


        Person p1 = new Person("P1", loc1);
        Person p2 = new Person("P2", loc1);
        Person p3 = new Person("P3", loc2);
        Person p4 = new Person("P4", loc3);
        Person p5 = new Person("P5", loc4);
        Person p6 = new Person("P6", loc5);
        Person p7 = new Person("P7", loc5);
        Person p8 = new Person("P8", loc5);
        Person p9 = new Person("p9", loc6);
        Person p10 = new Person("p10", loc7);

        registerReportService.register(covid);
        registerReportService.register(typhoid);
        registerReportService.register(hunger);

        registerReportService.report(covid, p1);
        registerReportService.report(covid, p2);
        registerReportService.report(covid, p3);
        registerReportService.report(covid, p4);
        registerReportService.report(covid, p5);
        registerReportService.report(covid, p6);
        registerReportService.report(covid, p7);
        registerReportService.report(covid, p8);
        registerReportService.report(typhoid, p9);
        registerReportService.report(hunger, p10);


        SummaryService summaryService = new SummaryServiceImpl(dataStore);
        AnonymizedSummaryService anonymizedSummaryService = new AnonymizedSummaryServiceImpl(summaryService);
        registerReportService.fatality(p9);
        registerReportService.cure(covid, p1);
        registerReportService.cure(covid, p2);
        registerReportService.fatality(p4);

        System.out.println(anonymizedSummaryService.showWorldSummary());
        System.out.println(anonymizedSummaryService.showWorldSummaryByDiseaseBreakup());

        System.out.println("Unamonymized reocrd for amin:-");

        System.out.println(summaryService.showWorldSummary());
    }
}
