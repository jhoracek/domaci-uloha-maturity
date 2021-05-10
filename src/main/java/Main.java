import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static String readUserString() {
        String inputText = scanner.nextLine();
        return inputText;
    }

    public static void chooseRole() {
        System.out.println("Identify your role, please choose related number:");
        System.out.println("1. student 2. teacher 3. admin");
        int choice = Integer.parseInt(readUserString());
        switch (choice) {
            case 1:
                handleStudent();
                break;
            case 2:
                handleTeacher();
                break;
            case 3:
                System.out.println("Admin rights. (Just an example of more roles)");
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }

    public static String[] greetings(String greet) {
        System.out.println("Type " + greet + " name: ");
        String name = readUserString();
        System.out.println("Type " + greet + " surname: ");
        String surname = readUserString();
        String[] complName = new String[]{name, surname};
        if (greet.equals("your")) {
            System.out.println("Welcome " + complName[0] + " " + complName[1]);
        }
        return complName;
    }

    public static void handleStudent() {
        System.out.println("As a student you can only check your exam results");
        greetings("your");
        System.out.println("Type your exact class [A/B/C]: ");
        String className = readUserString();

    }

    public static void handleTeacher() {
        System.out.println("As a teacher you can store exam results");
        greetings("your");

        System.out.println("Type your Token ID:");
        String tokenId = readUserString();
        boolean authPass = authUser(tokenId);
        if (authPass) {
            System.out.println("You were successfully recognized as a teacher. " +
                    "You can fill in the student's results.");
            String[] stComplName = greetings("student's");
            System.out.println("Type student's exact class [A/B/C]: ");
            String className = readUserString();

            System.out.println("Type name of student's 1st exam subject:");
            String sub1 = readUserString();

            System.out.println("Type name of student's 2nd exam subject:");
            String sub2 = readUserString();

            System.out.println("Type name of student's 3rd exam subject:");
            String sub3 = readUserString();

            System.out.println("Type name of student's 4th exam subject:");
            String sub4 = readUserString();

            System.out.println("Type student's grade from " + sub1 + ":");
            Integer sub1Grade = Integer.valueOf(readUserString());

            System.out.println("Type student's grade from " + sub2 + ":");
            Integer sub2Grade = Integer.valueOf(readUserString());

            System.out.println("Type student's grade from " + sub3 + ":");
            Integer sub3Grade = Integer.valueOf(readUserString());

            System.out.println("Type student's grade from " + sub4 + ":");
            Integer sub4Grade = Integer.valueOf(readUserString());

            HashMap<String, Integer> stResultsMap = new HashMap<>();
            stResultsMap.put(sub1, sub1Grade);
            stResultsMap.put(sub2, sub2Grade);
            stResultsMap.put(sub3, sub3Grade);
            stResultsMap.put(sub4, sub4Grade);

            GradExams result = new GradExams(stComplName[0], stComplName[1], className,
                    stResultsMap);
            System.out.println("The results have been successfully filled in. Thank you");
            System.out.println("========================================================");
            System.out.println("Recapitulation:");
            System.out.println("========================================================");
            System.out.println("Student " + result.getName() + " " + result.getSurname() + " from 4." +
                    result.getClassName() + ":");
            for (Map.Entry<String, Integer> mapEntry:stResultsMap.entrySet()){
                String key = mapEntry.getKey();
                Integer value = mapEntry.getValue();
                System.out.println(result.getGrades() + " : " + result.getGrades().get(sub1));
            }



            if (result.getGrades().containsValue(5)) {
                System.out.println("Student failed in graduation.");
            }


            System.out.println("Do you want to start application again? [yes/no]");
            String continueChoice = readUserString();
            if (continueChoice.equals("yes")) {
                chooseRole();
            }

        } else {
            System.out.println("Authentication failed. You are not allowed to continue.");
            System.out.println("Do you want to start application again? [yes/no]");
            String continueChoice = readUserString();
            if (continueChoice.equals("yes")) {
                chooseRole();
            }
        }
    }

    public static boolean authUser(String token) {
        boolean authPass = false;
        if (token.equals("9999")) {
            authPass = true;
        }
        return authPass;
    }

    public static void main(String[] args) {

        System.out.println("*************** Graduation Exam Results ***************");
        chooseRole();
        System.out.println("*************** end of Graduation Exam Results mini-application *************** ");
    }
}