#include<stdio.h>
#include<stdlib.h>
typedef struct node{
 int data;
 struct node * next;
}ElemSN;

ElemSN * createlink(int data[],int n)
 {
  ElemSN *h=NULL,*t,*newp;
  int i; 
  for( i=0;i<n;i++)
  {
   newp=(ElemSN *)malloc(sizeof(ElemSN));
   newp->data=data[i];
   newp->next=NULL;
 if(!h)
   h=t=newp;
 else
 t=t->next=newp;
 } 
 return h;
 }
ElemSN * IfTogerther(ElemSN*h1,ElemSN*h2)
 {
 	ElemSN **s1,**s2,*p;
	int top1,top2;
	s1=(ElemSN**)malloc(100*sizeof(int));
	s2=(ElemSN**)malloc(100*sizeof(int));
	top1=top2=-1;
	for(p=h1;s1[top1++]=p;p=p->next);
	for(p=h2;s2[top2++]=p;p=p->next);	
	while(top1!=-1&&top2!=-1&&s1[top1]==s2[top2]){
		top1--;
		top2--;
	}
	p=s1[top1+1];
	free(s1);
	free(s2);
	return p;
 
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
 int data[8]={1,2,3,4,5,6,7,8};
 ElemSN *head1,*head2,*h;
 head1=createlink(data,8);
 head2=createlink(data,8); 
 h=IfTogerther(head1,head2);
 printlink(h);
}
