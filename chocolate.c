#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>


int numChoc(int n, int c, int m);

int main() {

    int t; 
    int i = 0;
    scanf("%d\n", &t);
    int n[t],c[t],m[t];
    while ( i<t )
    {
        scanf("%d %d %d\n",n+i,c+i,m+i); 
        i++;
    }
	
    i=0;
    while(i<t){
	printf("%d\n",numChoc(n[i],c[i],m[i]));
	i++;
    }
    return 0;
}


int numChoc(int n, int c, int m){

	int num = n/c;
	int wrappers = num;
	wrappers -= (num/m)*m;
	wrappers += num/m;
	num+=num/m;
	while(wrappers > m){

	num+=wrappers/m;
	wrappers=wrappers/m+wrappers%m;


	}
	
	return num;

}

