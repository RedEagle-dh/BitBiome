package org.bitbiome.commands;


import org.bitbiome.classes.Colors;
import org.bitbiome.classes.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.bitbiome.classes.TravelEngine;


import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class QuizCommand {
    private Scanner quizScanner;

    public void performCommand(Scanner scanner, boolean isRunning, String message, TravelEngine travelEngine) {
        quizScanner = new Scanner(System.in);

        String path = "src/main/resources/quiz.json";
        JSONObject quiz = JsonParser.getJSONObject(path);

        long diffTime = canPlayAgain(quiz.getLong("lastPlayed"));
        if (diffTime > 0) {
            print(Colors.ANSI_BG_RED + "Du darfst erst in " + diffTime / 1000 / 60 + " Minuten spielen." + Colors.ANSI_RESET + "\n");
            return;
        }

        JSONArray fragen = quiz.getJSONArray("Quiz");
        JSONObject frage = fragen.getJSONObject(random(fragen.length()));

        JSONArray antworten = frage.getJSONArray("antworten");


        String korrekteAntwort = frage.getString("korrekteAntwort");

        print(starterMessage());

        print(generateQuestion(frage, antworten));

        int eingabe = quizScanner.nextInt();

        if (answerIsCorrect(eingabe, korrekteAntwort, antworten)) {
            int neuerStand = addGold();
            print(Colors.ANSI_BG_GREEN + "Richtig! Du hast 5 Münzen verdient." + Colors.ANSI_RESET + Colors.ANSI_CYAN + "\nDein Münzstand beträgt: " + Colors.ANSI_RESET + Colors.ANSI_BLUE + neuerStand + Colors.ANSI_RESET);
        } else {
            print(Colors.ANSI_BG_RED + "Leider falsch... Richtig ist: " + korrekteAntwort + Colors.ANSI_RESET + "\n");
        }

        print(endMessage());

        Date d = new Date();
        long lastPlayed = d.getTime();
        quiz.put("lastPlayed", lastPlayed);
        JsonParser.writeObject(path, quiz);
    }

    public static boolean answerIsCorrect(int picked, String answer, JSONArray answers) {
        return answers.getString(picked - 1).equalsIgnoreCase(answer);
    }

    public static String print(String message) {
        System.out.println(message);
        return message;
    }

    public static int random(int length) {
        return new Random().nextInt(length);
    }

    public static String generateQuestion(JSONObject frage, JSONArray answers) {
        StringBuilder sb = new StringBuilder();
        sb.append(frage.getString("frage")).append("\n");
        for (int i = 0; i < answers.length(); i++) {
            sb.append(i+1).append(". ").append(answers.getString(i)).append("\n");
        }
        return sb.toString();
    }

    public static int addGold() {
        String playerpath = "src/main/resources/playerconfig.json";
        JSONObject playerconfig = JsonParser.getJSONObject(playerpath);
        int gold = playerconfig.getInt("gold");
        gold = gold + 5;
        playerconfig.put("gold", gold);
        JsonParser.writeObject(playerpath, playerconfig);
        return gold;
    }

    public static long canPlayAgain(long lastPlayedTime) {
        long currentTime = System.currentTimeMillis();
        long minTime = lastPlayedTime + (60 * 5 * 1000);
        return minTime - currentTime;
    }

    public static String starterMessage(){
        return Colors.ANSI_CYAN + "Du hast das Quiz gestartet! Hinweis: Wähle deine Antwort, indem du die Zahl (1-4) eingibst. Ist deine Lösung richtig, erhälst du 5 Münzen. Viel Erfolg!" + Colors.ANSI_RESET + " \n";

    }

    public static String endMessage(){
        return Colors.ANSI_CYAN + "Das Quiz ist vorbei!" + Colors.ANSI_RESET;
    }
}


