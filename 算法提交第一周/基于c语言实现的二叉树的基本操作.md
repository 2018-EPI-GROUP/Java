## 基于c语言实现的二叉树的基本操作

此代码实现了二叉树的**创建、插入、删除、遍历（非递归和递归）**

```c
#include<stdio.h>
#include<stdlib.h>
#define MAX 20
typedef struct Ttree
{
	int data;
	struct Ttree * right;
	struct Ttree * left;
}TNode,*Ttree;
typedef struct{
	Ttree link;
	int flag;
}Lstack;
Ttree InitTtree(Ttree p)		//bt为指向二叉树的头节点的指针 
{
	Ttree bt;
	p=(TNode *)malloc(sizeof(TNode));
	if(p==NULL)
		return NULL;
    p->left=NULL;
	p->right=NULL;
	bt=p;
	return bt;	 
}
void InitTNode(Ttree p)
{
	int x;
	scanf("%d",&x);
	p->data=x;
	p->left=NULL;
	p->right=NULL;
}
Ttree creat(int x,Ttree left,Ttree right)
{
	Ttree p;
	if((p=(TNode *)malloc(sizeof(TNode)))==NULL) 
		return NULL;
	p->data=x;
	p->left=left;
	p->right=right;
	return p;
}
Ttree insertLeft(Ttree bt,int x,Ttree parent)
{
	Ttree p;
	if(parent==NULL)
	{
		printf("插入出错！\n");
		return NULL;
	}
	if((p=(TNode *)malloc(sizeof(TNode)))==NULL)
		return NULL;
	p->left=NULL;
	p->right=NULL;
	p->data=x;
	if(parent->left==NULL)
		parent->left=p;
	else
	{
		p->left=parent->left;
		parent->left=p;
	}
	return bt;
}

Ttree insertRight(Ttree bt,int x,Ttree parent)
{
	Ttree p;
	if(parent==NULL)
	{
		printf("插入出错！\n");
		return NULL;
	}
	if((p=(TNode *)malloc(sizeof(TNode)))==NULL)
		return NULL;
	p->left=NULL;
	p->right=NULL;
	p->data=x;
	if(parent->right==NULL)
		parent->right=p;
	else
	{
		p->right=parent->right;
		parent->right=p;
	}
	return bt;
}
/*void preOrder(Ttree bt)
{
	if(bt==NULL)
		return;
	printf("%d ",bt->data);
	preOrder(bt->left);
	preOrder(bt->right);
}*/
/*void preOrder(Ttree bt){		//先序遍历的非递归实现 
	Ttree stack[MAX],p;
	int top=0;
	if(bt==NULL) return;
	p=bt;
	while(!(p==NULL&&top==0)){
		while(p!=NULL){

			if(top<MAX){	
			    stack[top]=p; 
				top++;
			}
			else{
				printf("溢出\n");
				return;
			}
			p=p->left;
		}
		if(top<=0){
			printf("Too low!\n");
			return;
		}
		else{
			top--;
			p=stack[top];		
			printf("%d  ",p->data);
			p=p->right;
		}
	}
} */
void preOrder(Ttree bt){
	Lstack stack[MAX];
	Ttree p;
	int top=0;
	int sign;
	p=bt;
	while(!(p==NULL&&top==0)){
		if(p!=NULL){
			top++;	
			stack[top].link=p;
			stack[top].flag=1;
		
			p=p->left;
		}
		else{
			p=stack[top].link;
			sign=stack[top].flag;
			top--;
			if(sign==1){
				top++;
				stack[top].link=p;	//存的是D 
				stack[top].flag=2;
				p=p->right;			//现在P是D右侧的子树 
			}
			else
			{
				printf("%d ",p->data);
				p=NULL;
			}
			
		}
	} 
}
int Delete(Ttree pt,Ttree parent)
{
	Ttree p;
	if(parent==NULL||p->left==NULL)
	{
		printf("操作错误!\n");
		return 0;
	}
	p=parent->left;
	parent->left=NULL;
	free(p);
	return 1;
}
main()
{
	int x;
	Ttree H;
	Ttree bt;
	H=InitTtree(bt);
	if(H!=NULL){
		printf("Suceedd");
	}
	Ttree * T;
    T=&H;  
	Ttree left,right;
	left=(TNode *)malloc(sizeof(TNode));
	right=(TNode *)malloc(sizeof(TNode));
	printf("请输入左根想要输入的值：");
	InitTNode(left);
	printf("请输入右根想要输入的值：");
	InitTNode(right);
	printf("@!~");
	printf("请输入根的值:"); 
	int num;
	scanf("%d",&num);
	bt=creat(num,left,right);
	
	int z,y,w,r;
	printf("现在开始创建满二叉树");
	printf("请输入每一个子节点对应的值");
	Ttree sl,sr;
	sl=bt->left;
	sr=bt->right;
	while(scanf("%d %d %d %d",&z,&y,&w,&r)==4){
		bt=insertLeft(bt,z,sl);
		bt=insertRight(bt,y,sl);
		bt=insertLeft(bt,w,sr);
		bt=insertRight(bt,r,sr);
		sr=sr->right;
		sl=sl->left;
		printf("\n继续输入:");
	}
	preOrder(bt);
}
```

