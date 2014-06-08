/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filenamegeneratorforlibrary.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Rappresenta una casa editrice e fornisce una lista di case editrici comuni.
 */
public class Publisher {
    
    public final ObservableList<String> Publishers = 
            FXCollections.observableArrayList(
            "Apress",
            "Wiley",
            "Wrox",
            "O'Reilly",
            "Prentice Hall",
            "Microsoft Press",
            "Addison-Wesley",
            "McGraw-Hill",
            "Packt Publishing",
            "Sybex"
            // others here! 
            );
}
