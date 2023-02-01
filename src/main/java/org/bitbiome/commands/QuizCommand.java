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

        System.out.println("Du hast das Quiz gestartet! Hinweis: Wähle deine Antwort, indem du die Zahl (1-4) eingibst. Ist deine Lösung richtig, erhälst du 5 Münzen. Viel Erfolg! \n");

        String frageString = frage.getString("frage");

        System.out.println(frageString);

        for (int i = 0; i < antworten.length(); i++) {
            String antwort = antworten.getString(i);
            System.out.println(i + 1 + ". " + antwort);
        }
        Scanner quizScanner = new Scanner(System.in);
        int eingabe = quizScanner.nextInt();
        String korrekteAntwort = frage.getString("korrekteAntwort");

        if (antworten.getString(eingabe - 1).equalsIgnoreCase(korrekteAntwort)) {
            System.out.println("Richtige Antwort!\n");
        } else {
            System.out.println("Leider falsch... Richtig ist: " + korrekteAntwort + "\n");
        }

        System.out.println("Das Quiz ist vorbei.");
    }
}


