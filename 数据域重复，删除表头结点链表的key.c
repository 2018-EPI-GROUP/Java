#include<stdio.h>
#include<stdlib.h>
typedef struct node{
 int data;
 struct node * next; 
}ElemSN;
ElemSN * Delkey(ElemSN * h,int key)
{
    ElemSN*p,*t;
     for(p=h;p->next;){
     if(p->next->data-key)
	 {
     	p=p->next;
	 }
	 else{
	 	t=p->next;
	 	p->next=t->next;
	 	free(t);
	 	}
   	}
    return h;
 }
 void printkey(ElemSN*h){
  ElemSN *p;
  p=h;
  for(p=h->next;p;p=p->next)
  printf("%5d",p->data);
 }
 
int main()
{
 int data[8]={1,2,3,3,8,3,0,8};
 ElemSN * head,*h,*t;
 int i;
 h=t=(ElemSN*)malloc(sizeof(ElemSN));
 h->next=NULL;
 for(i=0;i<8;i++){
  t=t->next=(ElemSN*)malloc(sizeof(ElemSN));
  t->data=data[i];
  t->next=NULL;
  }
 head=Delkey(h,3);
 printkey(head);
  }  
