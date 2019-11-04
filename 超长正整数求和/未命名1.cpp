#include<stdio.h>
#include<string.h>
long additive(char s1[],char s2[],int c[])
{
	int a[20],b[20];
	long i,alen,blen,clen;
	alen = strlen(s1);
	for(i=alen-1;i>=0;i--)
	a[alen-i] = s1[i]-'0';
	blen=strlen(s2);
	for(i=blen-1;i>=0;i--)
	b[blen-i] = s2[i]-'0';
	if(alen>blen)
	clen = alen;
	else
	clen = blen;
	for(i=1;i<=clen;i++)
	c[i] = a[i]+b[i];
	for(i=1;i<=clen;i++)
	if(c[i]>9){
		if(i==clen){
			clen++;
			c[clen]=0;
		}
		c[i+1]++;
		c[i]-=10;
	}
	
   return clen;
 } 
 int main(){
 	char s1[20] = "1234567890";
 	char s2[20] = "9876543210";
 	int c[20];
 	long i,clen;
 	clen = additive(s1,s2,c);
 	for(i=clen;i>=1;i--)
 	printf("%d",c[i]);
 }
