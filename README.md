# CIRCLY CROSSY

### Take a look at the https://github.com/krawmaciej/circly-crossy/issues 

From there pick up an issue that you want to work on.
Keep in mind that some of the issues might be dependend on the others, but there is nothing stopping you from starting with the harder issues first.

### When you start working on an issue, create a separate git branch
#### Don't push straight into master
e.g. for issue `#3 Check whether player's movement is a winning movement` the branch could be named `3_check_whether_player_movement_is_winning_movement`

Then this create a Pull Request (PR) from this brancht to master branch: https://github.com/krawmaciej/circly-crossy/compare

### Bugs (game is not tested, so bugs may appear)
If you find any bugs during the development, don't hesitate to fix them - however include the information about the bug in the git commit history.
You can also create an issue, where you specify what the bug is and how you think this bug could be fixed (fixing ideas are optional).

### How to start the game
You can use IntelliJ's green play button, or you can build the app using maven:
`mvn package`
`java -jar target/circly-crossy-1.0-SNAPSHOT.jar`

To quit the game from the console after running it using `java -jar` use the CTRL+C shortcut.

