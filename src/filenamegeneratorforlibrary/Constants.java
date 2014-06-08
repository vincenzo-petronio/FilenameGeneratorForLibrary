package filenamegeneratorforlibrary;

/**
 * Costants hard-coded
 */
public class Constants {

    // [MAJOR.MINOR.BUILD.REVISION]
    // MAJOR = New big feature
    // MINOR = New improvements
    // BUILD 0 = Alpha
    // BUILD 1 = Beta
    // BUILD 2 = Release Candidate
    // BUILD 3 = final version
    // REVISION = fix
    //
    // CHANGELOG:
    // ### 1.1.3.1 ###
    //  FIX Home layout. ADD git as VCS
    // ### 1.1.3.0 ###
    //  ADD StatusBar
    //  ADD Check empty fields
    // ### 1.0.2.0 ###
    //  Prima RC funzionante.
    public static final String VERSION = "v" + "1.1.3.0";

    public static final String APP_TITLE = "Filename Generator for Library";
    public static final String TOOLTIP_TEXTBEFORE = "Filename before renaming";
    public static final String TOOLTIP_TEXTAFTER = "Filename after renaming";
    public static final String FILECHOOSER_TITLE = "Select file to rename";
    public static final String FILENAME_SEPARATOR_CHAR = "._.";
    public static final String STATUS_BAR_READY = "Boot completed and ready to loading file!";
    public static final String STATUS_BAR_ERROR = "ERROR";
    public static final String STATUS_BAR_SUCCESS = "SUCCESS";
    public static final String STATUS_BAR_LOAD_SUCCESS = "Loading file successfully!";
    public static final String STATUS_BAR_RENAME_SUCCESS = "Renaming file successfully!";
    public static final String STATUS_BAR_EMPTY_FIELDS = "Check empty fields!";
}
