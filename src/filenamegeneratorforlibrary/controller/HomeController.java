package filenamegeneratorforlibrary.controller;

import filenamegeneratorforlibrary.Constants;
import filenamegeneratorforlibrary.model.Publisher;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author vincenzo.petronio'AT'gmail.com
 * @see view/Home.fxml
 * 
 * Controller associato alla vista Home
 */
public class HomeController implements Initializable {
    
    @FXML
    private Button loadBtn;
    @FXML
    private Button renameBtn;
    @FXML
    private TextArea textBefore;
    @FXML
    private TextArea textAfter;
    private Tooltip tooltipBefore = new Tooltip(Constants.TOOLTIP_TEXTBEFORE);
    private Tooltip tooltipAfter = new Tooltip(Constants.TOOLTIP_TEXTAFTER);
    private FileChooser fc = new FileChooser();
    @FXML
    private ComboBox<String> cb;
    private File fileSelected;
    @FXML
    private TextArea textTitle;
    @FXML
    private TextArea textAuthor;
    @FXML
    private TextArea textYear;
    @FXML
    private TextArea textStatusBar;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TOOLTIP
        textBefore.setTooltip(tooltipBefore);
        textAfter.setTooltip(tooltipAfter);
        
        // FILE CHOOSER
        fc.setTitle(Constants.FILECHOOSER_TITLE);
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("7ZIP", "*.7z"),
                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
                new FileChooser.ExtensionFilter("RAR", "*.rar")
                // others here!
                );
        
        // AUTHOR COMBOBOX
        cb.getItems().clear();
        Publisher house = new Publisher();
        ObservableList<String> options = house.Publishers;
        cb.setItems(options);
        cb.getItems().add(". . .");
        cb.getSelectionModel().selectFirst();
        
        // STATUSBAR
        textStatusBar.setText(Constants.STATUS_BAR_READY);
    }
    
    @FXML
    private void onLoadBtnAction(ActionEvent event) 
    {
        Stage s = (Stage)this.loadBtn.getScene().getWindow();
        fileSelected = fc.showOpenDialog(s);
        if(fileSelected != null)
        {
            textBefore.setText(fileSelected.getName());
            renameBtn.setDisable(false);
            textStatusBar.setText(Constants.STATUS_BAR_LOAD_SUCCESS);
        }
        else
        {
            textBefore.clear();
            renameBtn.setDisable(true);
            textStatusBar.setText(Constants.STATUS_BAR_ERROR);
        }
    }
    
    @FXML
    private void onRenameBtnAction(ActionEvent event)
    {
        if(fileSelected != null 
                && !textAuthor.getText().isEmpty()
                && !textTitle.getText().isEmpty()
                && !textYear.getText().isEmpty()
                && !cb.getValue().isEmpty())
        {
            CreateFinalFilename();
            if(!textAfter.getText().isEmpty())
            {
                try {
                    String filenameFullPath = 
                            FilenameUtils.getFullPath(fileSelected.getAbsolutePath()) 
                            + textAfter.getText();
                    System.out.println("[TEXTAFTER]" + textAfter.getText());
                    System.out.println("[FILENAME FINAL]" + filenameFullPath);
                    fileSelected.renameTo(new File(filenameFullPath));
                    CleanWindow();
                    textStatusBar.setText(Constants.STATUS_BAR_RENAME_SUCCESS + " " + filenameFullPath);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    textStatusBar.setText(Constants.STATUS_BAR_ERROR + e.getMessage());
                }
                
            }
        }
        else
        {
            textStatusBar.setText(Constants.STATUS_BAR_EMPTY_FIELDS);
        }
    }
    
    private void CreateFinalFilename()
    {
        String filenameTemp = 
                textTitle.getText() 
                + Constants.FILENAME_SEPARATOR_CHAR
                + textAuthor.getText()
                + Constants.FILENAME_SEPARATOR_CHAR
                + cb.getValue()
                + Constants.FILENAME_SEPARATOR_CHAR
                + textYear.getText()
                + "."
                + FilenameUtils.getExtension(fileSelected.getName());
        
        String filenameFinal = filenameTemp
                .replace(" ", ".");
        textAfter.setText(filenameFinal);
    }
    
    private void CleanWindow()
    {
        fileSelected = null;
        textBefore.clear();
        textAfter.clear();
        textTitle.clear();
        textAuthor.clear();
        textYear.clear();
    }
}
