At first, we sorted 50 songs according to their ranking and popularity with the help of array.
Then we fill the arrays we created using the bufferreader with the help of the given files.
then we pulled the data from the term_project_sequential_data file to understand which song is positive to listen to after which song

We have made priority definitions in order to select the track arrays we have created with a time limit.
In order to adapt the restriction time given in the first stage with other parts, we converted it from minutes to milliseconds. Which gave us the result 1800000. 
We continued our code with a "while" line that we have the capacity to add songs whenever the remaining time is more than 0.
Under these conditions, we have assigned the track that provides the maximum according to the value order as the current best.
We set up a for loop where it will repeat the same process by subtracting the duration of this song from the remaining time.
Then we wrote a line that will subtract the penalty for the exceeded time from the total album value as 0.02*exceeded time.
Finally, we output the maximized total album value under these conditions.


