#include <stdio.h>

int main(){

	int searchFor = 0;
	int length = 0;

	scanf("%d\n",&searchFor);
	scanf("%d\n",&length);

	int array[length];

	int i =0;
	for(i = 0; i<length;i++){
		scanf("%d ",array + i);
	}

	i= 0;

	for(i=0;i<length;i++){
		if(array[i]==searchFor){
			printf("%d",i);
			break;
		}
	}

	return 0;
}

