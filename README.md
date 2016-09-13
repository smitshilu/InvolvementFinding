# InvolvementFinding
Find each and every user's involvement in group conversation 
<br>
<br>

<b>Turn index</b><br>
Find how many time one user speaks in conversation<br> 
To find this I have used one Java code findTurn.java in which I counted counts for each speaker and ration to total number of counts. Higher the number means higher the involvement.<br><br>
<b>POS count</b><br>
count of a how many time user speaks noun, pronoun, adjective, determiner, verb, adverb, preposition, conjunction, and interjection<br>
To find this I have used Java code findPOS.java in which I have calculated POS counts. Higher the number means higher the involvement.<br><br>
<b>Positive Negative language ratio</b><br>
It is ration between positive and negative sentences that user use in conversation<br>
For this, first I have extracted all the sentences for each user in different files using java code. Then I used python code which uses nltp library to calculate whether it is positive or negative. Then I calculated ratio positive to negative and the higher the ratio means higher the involvement.<br><br>
<b>Distance between language</b><br>
For this, I have used java code to find number of distinct words and its count in whole dialog and for each and every user. Then I used Euclidian distance to find vector. The lower the vector means higher the involvement.
<br><br>
