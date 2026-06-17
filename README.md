**Student Record Management System**

*About*

This program is a simple student record management system that demonstrates 

*System Design*
For text files -> The system uses Scanner class to read data into the program from files and uses PrintWriter to write
text content to new files. It uses for loops to help with the automation of these tasks.

For binary files -> Uses DataInputStream and DataOutput stream to demonstrate basic binary copying from an original .png file to
another new file. It uses a byteData variable to store the read bytes and to write out these stored bytes into the copy (the freshman logo in Students Folder)

For backup files -> Uses BufferedReader to read data from created student records, based on whether its updated or original version exists, and BufferedWriter
to write update to new file after deletion of original file(in the case the updated file is present).

For file operations/properties -> Uses methods, mostly exists() and delete(), from File class to manipulate and display file meta data.
Date and time -> Imports java.text.SimpleDataFormat package to format the lastModified result to date/time format from long integer. 
-> Allows system to create object that uses custome date/time format and format method to apply changes.

Object serialization -> Uses ObjectOutputStream to 'freeze' objects from Student object array and ObjectInputStream to deserialize objects upon user request.

decision-making -> Switch cases to switch between supported operations, if statements also included

Automation -> Mostly for loops
