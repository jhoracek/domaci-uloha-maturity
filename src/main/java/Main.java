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
                break;
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
        String[] stComplName = greetings("your");
        System.out.println("Type your exact class [A][B][C]: ");
        String className = readUserString();
        GradExams stResults = new GradExams(stComplName[0], stComplName[1], className);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Student " + stResults.getName() + " " + stResults.getSurname() + " from 4." +
                stResults.getClassName() + " has not graduated yet. Try it later." );
    }

    public static String getOptionSub(String typedSubOpt) {
        String subOpt = null;
        switch (typedSubOpt) {
            case "MAT":
                subOpt = OptSubjects.MAT.toString();
                break;
            case "PHY":
                subOpt = OptSubjects.PHY.toString();
                break;
            case "HIS":
                subOpt = OptSubjects.HIS.toString();
                break;
            case "GEO":
                subOpt = OptSubjects.GEO.toString();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + typedSubOpt);
        }
        return subOpt;
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
            System.out.println("Type student's exact class [A][B][C]: ");
            String className = readUserString();

            System.out.println("1. The first mandatory subject is: " + Languages.CZE);
            String subCze = Languages.CZE.toString();

            System.out.println("2. Type name of student's foreign language subject: [ENG][GER][FRE]");
            String typedLang = readUserString();
            String subLang;
            switch (typedLang) {
                case "ENG":
                    subLang = Languages.ENG.toString();
                    break;
                case "GER":
                    subLang = Languages.GER.toString();
                    break;
                case "FRE":
                    subLang = Languages.FRE.toString();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + typedLang);
            }

            System.out.println("3. Type name of student's 1st optional subject: [MAT][PHY][HIS][GEO]");
            String typedSubOpt1 = readUserString();
            String subOpt1 = getOptionSub(typedSubOpt1);

            System.out.println("4. Type name of student's 2nd optional subject: [MAT][PHY][HIS][GEO]");
            String typedSubOpt2 = readUserString();
            String subOpt2 = getOptionSub(typedSubOpt2);

            System.out.println("Type student's grade from " + subCze + ":");
            Integer subCzeGrade = Integer.valueOf(readUserString());

            System.out.println("Type student's grade from " + subLang + ":");
            Integer subLangGrade = Integer.valueOf(readUserString());

            System.out.println("Type student's grade from " + subOpt1 + ":");
            Integer subOpt1Grade = Integer.valueOf(readUserString());

            System.out.println("Type student's grade from " + subOpt2 + ":");
            Integer subOptGrade = Integer.valueOf(readUserString());

            HashMap<String, Integer> stResultsMap = new HashMap<>();
            stResultsMap.put(subCze, subCzeGrade);
            stResultsMap.put(subLang, subLangGrade);
            stResultsMap.put(subOpt1, subOpt1Grade);
            stResultsMap.put(subOpt2, subOptGrade);

            GradExams result = new GradExams(stComplName[0], stComplName[1], className,
                    stResultsMap);
            System.out.println("The results have been filled successfuly. Thank you");
            System.out.println("========================================================");
            System.out.println("Recapitulation:");
            System.out.println("========================================================");
            System.out.println("Student " + result.getName() + " " + result.getSurname() + " from 4." +
                    result.getClassName() + ":");
            System.out.println("Subject : Grade");
            System.out.println("--------------------------------------------------------");
            for (Map.Entry<String, Integer> mapEntry : stResultsMap.entrySet()) {
                String key = mapEntry.getKey();
                Integer value = mapEntry.getValue();
                System.out.println(key + " : " + value);
            }
            System.out.println("========================================================");

            if (result.getGrades().containsValue(5)) {
                System.out.println("Student failed in graduation.");
            } else
                System.out.println("Student passed successfully.");
            System.out.println("========================================================");
            System.out.println();
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
        System.out.println();
        System.out.println("*************** end of Graduation Exam Results mini-application *************** ");
    }
}