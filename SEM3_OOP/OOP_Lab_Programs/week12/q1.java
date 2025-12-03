import java.util.*;

class Candidate extends Thread {
    private String name;
    private String[] candidateAnswers;
    private float totalScore = 0.0f;

    private static final String[] CORRECT_ANSWERS = {"A","B","B","A","C"};

    public Candidate(String name, String[] candidateAnswers){
        this.name = name;
        this.candidateAnswers = candidateAnswers;
    }

    @Override
    public void run(){
        for(int i = 0; i < CORRECT_ANSWERS.length; i++){
            String correct = CORRECT_ANSWERS[i];
            String candidate = candidateAnswers[i].toUpperCase();

            if (candidate.equals(correct)){
                totalScore += 2.0f;
            } else if (!candidate.equals("X")){
                totalScore -= 0.25f;
            }
        }
        System.out.printf("%s scored: %.2f marks\n", name, totalScore);
    }

    public String getCandidateName(){
        return name;
    }

    public float getTotalScore(){
        return totalScore;
    }
}

public class q1 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Candidate> candidates = new ArrayList<>();

        for (int i = 0; i < n; i++){
            System.out.printf("Enter name of candidate %d: ", i + 1);
            String name = scanner.nextLine();

            System.out.println("Enter answers (A/B/C/D/X) for 5 questions separated by spaces: ");
            String answersLine = scanner.nextLine().trim();
            String[] answersArray = answersLine.split("\\s+");

            candidates.add(new Candidate(name, answersArray));
        }

        System.out.println("\nOutput");
        System.out.println("Evaluation in progress...");

        for (Candidate candidate : candidates){
            candidate.start();
        }

        for (Candidate candidate : candidates){
            try {
                candidate.join();
            } catch (InterruptedException e){}
        }

        candidates.sort(Comparator.comparing(Candidate::getTotalScore).reversed());

        System.out.println("\n--- Rank List ---");
        for(int i = 0; i < candidates.size(); i++){
            Candidate candidate = candidates.get(i);
            System.out.printf("%d. %s -> %.2f marks\n", (i + 1),
                    candidate.getCandidateName(), candidate.getTotalScore());
        }
    }
}
