#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */    
  
	long N, M;
	scanf("%lu %lu\n",&N,&M);
	long i = 0;
	long indexA, indexB, num;
	long total = 0;
	while(i<M){
	scanf("%lu %lu %lu\n",&indexA, &indexB, &num);
	while(indexA<=indexB){
		indexA++;
		total+= num;
	}
	i++;
	}
	
	long average = total/N;
	printf("%lu",average);
	

	  return 0;
}

