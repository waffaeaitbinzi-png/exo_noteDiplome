import java.util.Scanner;

public class MoyenneDiplome {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int NB_ANNEES = 3;

        double sommeGenerale = 0;
        int nombreSemestresTotal = 0;

        for (int annee = 1; annee <= NB_ANNEES; annee++) {

            double sommeAnnee = 0;

            for (int semestre = 1; semestre <= 2; semestre++) {

                double sommeSemestre = 0;
                int nombreModules = 0;
                String reponse;

                do {
                    nombreModules++;

                    System.out.print("Module " + nombreModules + " - Nom : ");
                    String nomModule = scanner.nextLine();

                    System.out.print("Module " + nombreModules + " - Note : ");
                    double note = scanner.nextDouble();
                    scanner.nextLine();

                    sommeSemestre += note;
                    System.out.println(nomModule + " : " + note);

                    System.out.print("Voulez-vous saisir un autre module ? (o/n) : ");
                    reponse = scanner.nextLine().trim().toLowerCase();

                } while (reponse.equals("o") || reponse.equals("oui"));

                double moyenneSemestre = sommeSemestre / nombreModules;
                System.out.printf("Moyenne du Semestre %d : %.2f  (%d modules)%n",
                        semestre, moyenneSemestre, nombreModules);

                sommeAnnee += moyenneSemestre;
                sommeGenerale += moyenneSemestre;
                nombreSemestresTotal++;
            }

            double moyenneAnnee = sommeAnnee / 2;
            System.out.printf("MOYENNE ANNEE %d : %.2f%n%n", annee, moyenneAnnee);
        }

        double moyenneGenerale = sommeGenerale / nombreSemestresTotal;
        System.out.printf("Moyenne generale sur 3 ans : %.2f%n", moyenneGenerale);

        if (moyenneGenerale >= 10) {
            System.out.println("DIPLOME OBTENU");
        } else {
            System.out.println("DIPLOME NON OBTENU");
        }

        scanner.close();
    }
}