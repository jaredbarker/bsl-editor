# bsl-editor

Follow instructions here to set up the project locally (once you clone the project into intellij, download the javafx sdk, add it as a library and add the vm arguments to point to it as well):

https://openjfx.io/openjfx-docs/


Download the JavaFX SDK from here

https://gluonhq.com/products/javafx/


Here is a tutorial on javaFX:
https://www.tutorialspoint.com/javafx/layout_borderpane.htm


Here are the current ideas on what features to include:

Level Editor

    -import audio
    -2d map to place the notes/blocks
    -note selector panel
    -way to save /save as /open /edit the files
    -way to set the beats per minute
    -way to copy/paste sets of notes
main feature:
	
	-play/pause the audio syncd with the map
	-way to slow down the playing of the audio/map
	
nice to have:
	
	-auto save feature
	-auto backup file
	
cherry on top/future features:
	
	-auto detect beat/time signature
	-auto fill in beat spaces
	-3D visualizer to "test" the map
	
	simple 2 json file starts cut direction on base row: up and then going clockwise around
    to next mid row at later time and finally top row at latest time

Helpful link for understanding the json format from the Oculus quest editor
https://bsmg.wiki/mapping/map-format.html#notes-2