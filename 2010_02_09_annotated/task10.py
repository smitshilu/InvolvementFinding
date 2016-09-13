# Task 10 calculate the sentiment score for each tweet and store it in file according to positivity
# Author: Smit Shilu

from pattern.en import sentiment,positive
import json

def main():
	temp = open('vicky.txt').readlines()
	file = open('vickysentiment.txt','w')
	
	t = 0
	f = 0
	
	for line in temp:
		tweet_string = line
		
		
		if positive(tweet_string,0.1) == False:
			f = f + 1
		if positive(tweet_string,0.1) == True:
			t = t + 1
		
	print t
	print f

if __name__ == "__main__":
	main()