# FunctionFirst

# Abstract 
Harmonic dictation in music is the process of being able identify and transcribe the
relation of a set of chords played successively. This is an aural skill that can only be
developed through practice. As of today, no set of tools exist for musicians to develop
this skill independently.  In order to develop this skill,  the process requires a person to
physically play the progression through the use of an instrument and have the user
attempt to identify the progression.  This project attempts to provide a solution by
automating the process through the use of computer software. 

# Objectives
* Develop a web application that is able to generate harmonic chord progressions
based on the rules of music theory.
* Allow users to select number of chords in progression.
* Allow users to select the mode of the progression.
* Play the chord progression back to users.
* Allow users to input their answers based on the audio played.
* Allow users to submit and display the correct answers.
* Create a login and registration system so that users can track their progress.
* Generate progressions based on a user's prior incorrect entries.

# Development
* Java was used to develop the core of the application.  This includes the core music
model such as notes, chords, keys, and the progression.
* Google Web Toolkit was then used to compile the Java program entirely into to
Javascript.  This was done in order to allow the program to run natively across all
browser supported devices.
* JasmineMidi Library was used to play the audio of the chord progression using
MIDI.
