package lesson14;


public class PhoneBookRunner {

    public static void main(String[] args) {
        PhoneBookSet pb = new PhoneBookSet();
        PhoneBookSet pb2 = new PhoneBookSet();
        pb.findRelatedСontacts(pb2.getPhoneBook());
        pb2.findRelatedСontacts((pb.getPhoneBook()));
        pb.printRelatedСontacts();
        System.out.println(pb.popularOperatorRelatedConacts());
        System.out.println(pb2.popularOperatorRelatedConacts());
        System.out.println("-------------------------------------------");
        PhoneBookMassive pbm = new PhoneBookMassive();
        PhoneBookMassive pbm2 = new PhoneBookMassive();
        pbm.findRelatedContactMassive(pbm2.getPhoneBook());
        pbm.printRelatedСontactsMassvie();
        pbm2.findRelatedContactMassive(pbm.getPhoneBook());
        System.out.println("PBM2");
        pbm2.printRelatedСontactsMassvie();
        System.out.println(pbm.popularOperatorRelatedConacts());
        System.out.println(pbm2.popularOperatorRelatedConacts());
        System.out.println("-------------------------------------------");
        PhoneBookMap pbmap = new PhoneBookMap();
        PhoneBookMap pbmap2 = new PhoneBookMap();
        pbmap.findRelatedСontacts(pbmap2.getPhoneBookMap());
        pbmap.printRelatedСontactsMap();
        System.out.println(pbmap.popularOperatorRelatedConactsMap());


    }
}
