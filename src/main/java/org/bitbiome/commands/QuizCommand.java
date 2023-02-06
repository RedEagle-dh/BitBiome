package org.bitbiome.commands;


import org.bitbiome.classes.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class QuizCommand implements CommandAPI {
    private Scanner quizScanner;
    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        quizScanner = new Scanner(System.in);

        String path = "src\\main\\resources\\quiz.json";
        JSONObject quiz = JsonParser.readJSONFile(path);

        long diffTime = canPlayAgain(quiz.getLong("lastPlayed"));
        if (diffTime > 0) {
            print("Du darfst erst in " + diffTime / 1000 / 60 + " minuten spielen.");
            return;
        }

        JSONArray fragen = quiz.getJSONArray("Quiz");
        JSONObject frage = fragen.getJSONObject(random(fragen.length()));

        JSONArray antworten = frage.getJSONArray("antworten");


        String korrekteAntwort = frage.getString("korrekteAntwort");

        print(anfangsnachricht());

        print(generateQuestion(frage, antworten));

        int eingabe = quizScanner.nextInt();

        if (answerIsCorrect(eingabe, korrekteAntwort, antworten)) {
            int neuerStand = addGold();
            print("Richtig! Du hast 5 Münzen verdient.\nDein Münzstand beträgt: " + neuerStand);
        } else {
            print("Leider falsch... Richtig ist: " + korrekteAntwort + "\n");
        }

        print("Das Quiz ist vorbei.");

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
        String playerpath = "src\\main\\resources\\playerconfig.json";
        JSONObject playerconfig = JsonParser.readJSONFile(playerpath);
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

    public static String anfangsnachricht(){
        return "Du hast das Quiz gestartet! Hinweis: Wähle deine Antwort, indem du die Zahl (1-4) eingibst. Ist deine Lösung richtig, erhälst du 5 Münzen. Viel Erfolg! \n";

    }
}


