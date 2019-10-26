#include<stdio.h>
#include<stdlib.h>
typedef struct node{
 int data;
 struct node * next;
}ElemSN;
 ElemSN * Delsomekey(int data[],int n)
 {
 	ElemSN *h=NULL,*t,*p;
 	int i;
 	for(i=0;i<n;i++)
 	{
 		for(p=h;p&&p->data-data[i];p=p->next);
 		if(!p)
 		{
 			p=(ElemSN*)malloc(sizeof(ElemSN));
 			p->data=data[i];
 			p->next=NULL;
 			if(!h)
 				h=t=p;
 			else	
 				t=t->next=p;
		 }
	 }
	 return h;
 }
 void printlink(ElemSN *h)
 {
  ElemSN *p;
  p=h;
  for(p=h;p;p=p->next)
  printf("%5d",p->data);
 }
 int main(void)
{
 int data[8]={2,2,4,4,5,6,7,7};
 ElemSN * head;
 head=Delsomekey(data,8);
 printlink(head);
}
