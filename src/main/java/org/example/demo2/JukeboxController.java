// JukeboxController.java (Controller Layer)
package org.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Song;

/**
 * Controller for the Jukebox application, connecting the UI with the business logic.
 */
public class JukeboxController {

    @FXML
    private ListView<Song> songListView;

    @FXML
    private TextField titleField;

    @FXML
    private TextField artistField;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button playButton;

    // ObservableList to dynamically update the song list view
    private final ObservableList<Song> songs = FXCollections.observableArrayList();

    /**
     * Initializes the controller and binds the song list to the ListView.
     */
    @FXML
    public void initialize() {
        songListView.setItems(songs);
    }

    /**
     * Handles adding a new song to the list.
     * @param event ActionEvent triggered by clicking the 'Add' button.
     */
    @FXML
    private void handleAddSong(ActionEvent event) {
        String title = titleField.getText();
        String artist = artistField.getText();

        if (!title.isEmpty() && !artist.isEmpty()) {
            songs.add(new Song(title, artist));
            titleField.clear();
            artistField.clear();
        }
    }

    /**
     * Handles removing the selected song from the list.
     * @param event ActionEvent triggered by clicking the 'Remove' button.
     */
    @FXML
    private void handleRemoveSong(ActionEvent event) {
        Song selectedSong = songListView.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            songs.remove(selectedSong);
        }
    }

    /**
     * Handles playing the selected song.
     * @param event ActionEvent triggered by clicking the 'Play' button.
     */
    @FXML
    private void handlePlaySong(ActionEvent event) {
        Song selectedSong = songListView.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            System.out.println("Now playing: " + selectedSong);
        }
    }
}
