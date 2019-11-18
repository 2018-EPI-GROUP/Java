## 基于c语言的二叉搜索树的基本操作

```c
#include<stdio.h>
#include<stdlib.h>
typedef struct stu {
	int num;
	struct stu* left, * right;
}TNode, * Ttree;
Ttree MakeEmpty(Ttree T) {
	if (T != NULL) {
		MakeEmpty(T->left);
		MakeEmpty(T->right);
		free(T);
	}
	return NULL;
}
int Find(Ttree T,Ttree * p,Ttree * q,int x) {
	int flag = 0;
	*q = T;
	while (*q) {
		if ((*q)->num > x) {
			(*p) = (*q);
			(*q) = (*q)->left;
		}
		else {
			if (x > (*q)->num) {
				(*p) = (*q);
				(*q) = (*q)->right;
			}
			else {
				flag = 1;
				return flag;
			}
		}
	}
	return 0;
		
}
Ttree FindMax(Ttree T)
{
	Ttree q;
	q = T;
	while (q->right) {
		q = q->right;
	}
	return q;
}
Ttree FindMin(Ttree T)
{
	Ttree q;
	q = T;
	while (q->left) {
		q = q->left;
	}
	return q;
}
Ttree mal(int x) {			//获取一个节点
	Ttree s;
	s = (TNode*)malloc(sizeof(TNode));
	if (s == NULL) {
		printf("获取异常！");
		exit(0);
	}
	else {
		s -> num = x;
		s->left = s->right = NULL;
	}
	return s;
}
int Insert(Ttree T,int x) 
{
	Ttree q = T;
	Ttree s, p;
	if (q == NULL) {
		s = mal(x);
		q = s;
	}
	else {
		while (q) {
			if (q->num > x) {
				p = q;
				q = q->left;
				if (q == NULL) {
					s = mal(x);
					p->left = s;
					return 1;
				}
			}
			else if(q->num < x){
				p = q;
				q = q->right;
				if (q == NULL) {
					s=mal(x);
					p->right = s;
					return 1;
				}
			}
			else {
				return 0;
			}
		}
	}
}
void print(Ttree T) {
	if (T == NULL) return;
	else {
		print(T->left);
		printf("%d   ",T->num);
		print(T->right);
	}
}
int delete(Ttree T, int x)
{
	Ttree p = T,s,q, *f;
	int flag = 0;
	if (Find(T, &p, &s, x)) {
		if (p == s) f = &T;		//只有一个根节点的情况
		else {			//待删节点为叶子结点的情况
			if (p->num > x) f = &(p->left);
			else f = &(p->right);
		}
		if (!s->left) *f = s->right;		//如果要删结点只有右节点，则直接用该右节点替代该节点
		else {
			if(!s->right) *f = s->left;//如果要删结点只有左节点，则直接用该左节点替代该删除节点
			else {		//如果要删除节点左、右孩子都有
				p = s->left;
				q = s;
				while (p->right) {		//寻找该节点左子树的最右孩子（前驱）
					q = p;		//q指向p的前一个节点
					p = p->right;	//要询的前驱
				}
				*f = p;		//将找到的节点，替换到要删的节点处
				p->right = s->right;		//将要删的结点的右孩子连接到前驱的右孩子上
				if (q != p) {
					q->right = p->left;		//如果前驱节点有左子树，则将左子树挂在前驱节点的头一个节点的有孩子上
					p->left = s->left;	//将要删的结点的右孩子连接到前驱的右孩子上
				}
			}
		}
	}
	flag = 1;
	free(s);	//释放要删的节点的空间
	return flag;
}
int main() {
	Ttree T;
	Ttree q,p;
	Ttree Max, Min;
	int num=748;
	T =(Ttree)malloc(sizeof(TNode));
	int x;
	if (T == NULL) {
		printf("获取错误");
		exit(0);
	}
	else {
		T->num = 8;
		T->left = T->right = NULL;
	}
	while(scanf_s("%d",&x)==1)
	{
		if (Insert(T, x)) {
			printf("获取成功!");
		}
		else {
			printf("获取失败!");
		}
	}
	print(T);	
	if (Find(T,&p,&q,num))
		printf("\n%d", q->num);
	else
		printf("\n没找到!");
	Max = FindMax(T);
	Min = FindMin(T);
	printf("\n最大值:%d", Max->num);
	printf("\n最小值:%d\n", Min->num);
	if (delete(T, 10)) {
		printf("删除完毕!");
	}
	else {
		printf("删除失败!");
	}
	print(T);
}
```

