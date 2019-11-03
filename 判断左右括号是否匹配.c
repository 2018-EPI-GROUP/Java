#include<stdio.h>
int main(void){
	char s[81];
	gets(s);
	printf("%d",IfMatch(s));
} 
int IfMatch(char s[]){
	int top=-1,i=0;
	while(s[i]){
		if(s[i]=='(')
			top++;
		else if(s[i]==')'){
			if(top!=-1)
				top--;
			else
				return 0;
		}
		if(top==-1)
			return 1;
		else 
			return 0;
	}
}

