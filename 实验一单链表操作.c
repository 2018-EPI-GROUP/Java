/*
����һ������ѧ����Ϣ��������ѧ�ţ��༶��������ʹ��������¹��ܣ�
1.����ָ��ѧ��������10�� �������ѧ����Ϣ
2.�����ʾѧ����������ѧ���������Ϣ
3.�����������ҡ����ش�ѧ����ѧ�źͰ༶(�ҵ���û�ҵ�)
4.����ָ����λ�ÿɷ�����Ӧ��ѧ����Ϣ��������
5.����һ��ѧ����Ϣ�����뵽����ָ��λ��(���i��ֵ�ܴ������Ĭ����β������)
6.ɾ��ָ��λ�õ�ѧ����¼ 
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
	Node head = {0};	//ͷ��� 
	int i; 
	char name[20];
	int id;
	char classname[20];
	Node stu = {0}; 
	LinkList p;
	
	printf("����ѧ��������");
	scanf("%d",&i);
	
	insertStu_Inf(&head,i);
	showStu_Inf(&head);

	printf("----------------------------------------------\n"); 
	
	printf("����Ҫ���ҵ�����");
	scanf("%s",name);
	searchByName(&head,name);
	
	printf("----------------------------------------------\n"); 
	
	printf("����Ҫ���ҵ�λ�ã�");
	scanf("%d",&i);
	searchByLocation(&head,i);
	
	printf("----------------------------------------------\n"); 

	printf("������Ҫ������Ϣ��λ�ú�һ��ѧ������Ϣ��");
	scanf("%d",&i);
	insertOneStu(&head,i);
	showStu_Inf(&head);
	
	printf("----------------------------------------------\n"); 
	
	printf("������Ҫɾ���ļ�¼λ�õģ�");
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

	// �������ķ���ֵ�����������
	// 1��NULL������ζ�ţ�ָ�����ǵ�һ����Ч�ڵ㣻
	// 2�������������Ҫ�ҵĵ��ǰ���ڵ㡣
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
		if(!strcmp(name,p->name)){	//���ִ�� 
			printf("%-5d",p->id);
			printf("%-10s\n",p->classname);
			flag = 0;
		}
	}
	if(flag)
		printf("û���ҵ�������\n");
}

LinkList searchByLocation(LinkList L,int i){
	int j;
	LinkList pre; 
	
	pre = searchPreNode(L,i);
	if(pre->next == NULL){
		printf("�������λ��\n");
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
		printf("����λ������\n"); 
	}
}
void deleteOneStu(LinkList L,int i){
	LinkList pre;
	pre = searchPreNode(L,i);
	if(pre != NULL){
		pre->next = pre->next->next;
	}
	else{
		printf("����ɾ���ļ�¼λ������\n");
	}
}
/*
�������⣬����λ��Ϊ1�Ͳ���λ��Ϊ1ʱ���� 
*/


