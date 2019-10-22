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
 ElemSN * Delkey(ElemSN * h)
{
    ElemSN*q,*t;
	h=h->next;
    for(t=q=h;q;t=q,q=q->next)
    {
   t->next=q->next;
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
 int data[8]={1,2,3,4,5,6,7,8};
 ElemSN * head;
 head=createlink(data,8);
 printlink(Delkey(head));
}
