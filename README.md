# Java Music Player

A simple music player implemented in Java using a doubly linked list for song management. The player supports basic functionalities such as play, pause, resume, and navigating through songs.

## Libraries Used

- `javax.sound.sampled.*`: This library is used to handle audio file playback.
- `java.io.File`: For handling file operations.
- `java.io.IOException`: For handling input-output exceptions.
- `java.util.Scanner`: For user input.

## Data Structure Used

- **Doubly Linked List**: This data structure is used to manage the playlist of songs. Each node contains a reference to the next and previous node, making it easy to traverse forward and backward through the list.

## Features

- **Play**: Start playing a song from the playlist.
- **Pause**: Pause the currently playing song.
- **Resume**: Resume the paused song from where it was left off.
- **Next**: Move to the next song in the playlist.
- **Back**: Move to the previous song in the playlist.
- **Delete**: Remove a song from the playlist.

## How It Works

1. **Initialize the Playlist**:
   - The playlist is implemented using a doubly linked list where each node represents a song.
   - Songs can be inserted at any position in the playlist.

2. **Player Functionality**:
   - The player continuously waits for user input to control the playback.
   - The following commands are supported:
     - `p`: Play the current song.
     - `n`: Move to the next song and play it.
     - `b`: Move to the previous song and play it.
     - `s`: Pause the current song.
     - `r`: Resume the paused song.
     - `q`: Quit the player.

3. **Audio Handling**:
   - The `Clip` class from `javax.sound.sampled` is used to handle audio playback.
   - Each song is loaded as an `AudioInputStream` and played through a `Clip`.
   - The playback position is tracked to allow pausing and resuming.

## Code Example

```java
public static void main(String str[]) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    musicplayer key = new musicplayer();
    key.insert("songs/Ambarsariya Fukrey Song By Sona Mohapatra Pulkit Samrat, Priya Anand.wav", 0);
    key.insert("songs/Hozier - Work Song (Official Video).wav", 1);
    key.insert("songs/Laal Peeli Akhiyaan (Full Video) Shahid Kapoor, Kriti Sanon, Romy Teri Baaton Mein Aisa Uljha Jiya.wav", 2);
    key.player();
}
