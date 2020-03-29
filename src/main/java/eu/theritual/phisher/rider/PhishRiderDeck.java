package eu.theritual.phisher.rider;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static eu.theritual.phisher.rider.InformationType.*;

public class PhishRiderDeck extends Deck{
    public static void main(String[] args) {
        System.out.println("This is just lib to use with other TheRitual 'Phisher' projects.");
        if (args.length == 2) {
            if (args[0].toLowerCase().equals("read")){
                Utils.load(args[1].toLowerCase()).show();
            }
        }
    }


}
