package catfishfiles.MainPackage;


import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tulsi
 */
public class Villager {

    String name;
    String dialogue;
    FileAccess F = new FileAccess();

    public Villager() throws IOException {
        this.name = nameSelector();
        this.dialogue = dialogueSelector();

    }

    public String nameSelector() throws FileNotFoundException, IOException {

        return F.RandomTextfromFile("VillagerNames");

    }

    private String dialogueSelector() throws IOException {

        return F.RandomTextfromFile("VillagerDialogues");

    }

}
