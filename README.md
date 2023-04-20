<!DOCTYPE html>
<html>
  <head>
    <title>Java MVP Pattern Game</title>
  </head>
  <body>
    <h1>Java MVP Pattern Game</h1>
    <p>This program follows the Model-View-Presenter (MVP) design pattern in Java, which allows for greater separation of application logic from the graphical user interface (GUI). The GUI is composed of three classes: a menu window, a matrix window, and a help window. The menu window presents three difficulty options for the user to choose from, and a help button. The matrix window displays a matrix of 4x4, 5x5, or 6x6 according to the difficulty chosen by the user. The help window provides information (in Spanish) on how to play the game and the rules that must be followed.</p>
    <p>The controllers are responsible for acting as intermediaries between the views and the game logic. There is a controller for each window. The menu window controller is responsible for starting the game and passing the selected difficulty to the matrix window controller. The matrix window controller receives the difficulty from the menu window controller and uses game logic to generate a random matrix of the selected difficulty. The help window controller only displays information on how to play the game and has a method to return to the menu window.</p>
    <p>The game logic is in the Logic class. There are several functions that ensure the game runs correctly. For example, generating a random matrix of integers within the range of the selected difficulty, and getting the sum of each row and column to generate the sums that the user must replicate. Other functions sum the rows and columns of the generated matrix to check if what the user has entered is correct or empty. There is also a surrender button, which when pressed, ends the game and completes the matrix for the user, who can check if the matrix is correct using the "Add" button.</p>
    <p>As a complement, there are image and sound files. The image files are used in the menu and help windows, while the sound files are present in all windows, when the menu starts and when a button is pressed.</p>
    <p>In summary, this program uses the MVP design pattern in Java to separate application logic from the graphical user interface. The GUI is composed of three classes that allow the user to interact with the game. The controllers act as intermediaries between the views and the game logic. The game logic is in a separate class and contains several functions to make the game run correctly. Additional files such as images and sounds complement the user experience and make the game more friendly and attractive.</p>
  </body>
</html>