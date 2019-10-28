/*
定义一个包含学生信息（姓名，学号，班级）的链表，使其具有以下功能：
1.根据指定学生人数（10） 逐个输入学生信息
2.逐个显示学生表中所有学生的相关信息
3.根据姓名查找。返回此学生的学号和班级(找到和没找到)
4.根据指定的位置可返回相应的学生信息（三个）
5.给定一个学生信息，插入到表中指定位置(如果i的值很大情况下默认在尾部插入)
6.删除指定位置的学生记录 
*/

#include<stdio.h>
#include<malloc.h>
#include<string.h>

typedef struct node{
	char name[20];
	int id;
	char classname[10]; 
	struct node *next;
}Node,*LinkList;

void insertStu_Inf(LinkList L,int num);
void showStu_Inf(LinkList L);
void searchByName(LinkList L,char *name);
LinkList searchByLocation(LinkList L,int i);
void insertOneStu(LinkList L,int i);
LinkList searchPreNode(LinkList L,int i);
void deleteOneStu(LinkList L,int i);

int main(){
	Node head = {0};	//头结点 
	int i; 
	char name[20];
	int id;
	char classname[20];
	Node stu = {0}; 
	LinkList p;
	
	printf("输入学生人数：");
	scanf("%d",&i);
	
	insertStu_Inf(&head,i);
	showStu_Inf(&head);

	printf("----------------------------------------------\n"); 
	
	printf("输入要查找的姓名");
	scanf("%s",name);
	searchByName(&head,name);
	
	printf("----------------------------------------------\n"); 
	
	printf("输入要查找的位置：");
	scanf("%d",&i);
	searchByLocation(&head,i);
	
	printf("----------------------------------------------\n"); 

	printf("输入需要插入信息的位置和一个学生的信息：");
	scanf("%d",&i);
	insertOneStu(&head,i);
	showStu_Inf(&head);
	
	printf("----------------------------------------------\n"); 
	
	printf("请输入要删除的记录位置的：");
	scanf("%d",&i);
	deleteOneStu(&head,i); 
	showStu_Inf(&head);
	
	return 0;
}

LinkList searchPreNode(LinkList L,int i) {
	LinkList p;
	LinkList pre = NULL;
	int j;
	p = L->next;
	if(i < 1){
		return NULL;
	}
	else if(i == 1){
		return L;
	}
	for (j = 1; p && j < i;j++,p = p->next) {
		pre = p;
	}

	// 本函数的返回值有三种情况：
	// 1、NULL：这意味着，指定点是第一个有效节点；
	// 2、其它情况，是要找的点的前驱节点。
	return pre;
}

void insertStu_Inf(LinkList L,int num){
	Node *p = NULL;
	Node *r = NULL;
	int i;
	r = L;
	L->next = NULL;
	for(i = num;i > 0;i--){
		p = (Node *)malloc(sizeof(Node));
		scanf("%s",p->name);
		scanf("%d",&(p->id));
		scanf("%s",p->classname);
		p->next = NULL;
		
		r->next = p;
		r = p;
	}
}

void showStu_Inf(LinkList L){
	Node *p; 
	for (p = L->next; p; p = p->next) {
		printf("%-10s",p->name);
		printf("%-5d",p->id);
		printf("%-10s",p->classname);
		printf("\n");
	}
}

void searchByName(LinkList L,char *name){
	LinkList p = NULL;
	int flag = 1;
	for(p = L->next;p;p = p->next){
		if(!strcmp(name,p->name)){	//相等执行 
			printf("%-5d",p->id);
			printf("%-10s\n",p->classname);
			flag = 0;
		}
	}
	if(flag)
		printf("没有找到该名字\n");
}

LinkList searchByLocation(LinkList L,int i){
	int j;
	LinkList pre; 
	
	pre = searchPreNode(L,i);
	if(pre->next == NULL){
		printf("不合理的位置\n");
		return NULL;
	}
	else{
		printf("%-10s",pre->next->name);
		printf("%-5d",pre->next->id);
		printf("%-10s\n",pre->next->classname);
		return pre;
	} 	
}

void insertOneStu(LinkList L,int i){
	LinkList p,q,pre;  
	p = (LinkList)malloc(sizeof(Node));
	char name[20];
	int id;
	char classname[20];
	
	scanf("%s",p->name);
	scanf("%d",&(p->id));
	scanf("%s",p->classname);
	
	pre = searchPreNode(L,i);
	if(pre != NULL){ 
		q = pre->next;
		pre->next = p;
		p->next = q;
	}
	else{
		printf("插入位置有误\n"); 
	}
}
void deleteOneStu(LinkList L,int i){
	LinkList pre;
	pre = searchPreNode(L,i);
	if(pre != NULL){
		pre->next = pre->next->next;
	}
	else{
		printf("所需删除的记录位置有误\n");
	}
}
/*
两个问题，查找位置为1和插入位置为1时报错 
*/


