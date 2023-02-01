package org.bitbiome.commands;


import org.bitbiome.classes.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Random;
import java.util.Scanner;

public class QuizCommand implements CommandAPI {

    @Override
    public void performCommand(Scanner scanner, boolean isRunning, String message) {
        String path = "src\\main\\resources\\quiz.json";
        JSONObject quiz = JsonParser.readJSONFile(path);

        JSONArray fragen = quiz.getJSONArray("Quiz");
        int index = new Random().nextInt(fragen.length());
        JSONObject frage = fragen.getJSONObject(index);
        JSONArray antworten = frage.getJSONArray("antworten");

        print("Du hast das Quiz gestartet! Hinweis: Wähle deine Antwort, indem du die Zahl (1-4) eingibst. Ist deine Lösung richtig, erhälst du 5 Münzen. Viel Erfolg! \n");

        String frageString = frage.getString("frage");

        print(frageString);

        for (int i = 0; i < antworten.length(); i++) {
            String antwort = antworten.getString(i);
            print(i + 1 + ". " + antwort);
        }
        Scanner quizScanner = new Scanner(System.in);
        int eingabe = quizScanner.nextInt();
        String korrekteAntwort = frage.getString("korrekteAntwort");

        if (answerIsCorrect(eingabe, korrekteAntwort, antworten)) {
            print("Richtige Antwort!\n");
        } else {
            print("Leider falsch... Richtig ist: " + korrekteAntwort + "\n");
        }

        print("Das Quiz ist vorbei.");
    }

    public static boolean answerIsCorrect(int picked, String answer, JSONArray answers) {
        return answers.getString(picked - 1).equalsIgnoreCase(answer);
    }

    public static String print(String message) {
        System.out.println(message);
        return message;
    }

}


