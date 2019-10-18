#include<stdio.h>
#define MAX 10
#include<string.h>
#include<stdlib.h>
#include<ctype.h>
typedef struct stu
{
	char ch[MAX];
	int top;
}chLink;
typedef struct st
{
	int num[MAX];
	int top;
}numLink;
chLink * Init_ch(void)
{
	chLink *p=(chLink *)malloc(sizeof(chLink));
	p->top=-1;
	return p;
}
numLink * Init_number(void)
{
	numLink *p=(numLink *)malloc(sizeof(numLink));
	p->top=-1;
	return p;
}
void insert_ch(chLink * p,char x)
{
	if(p->top==MAX)
	{
		printf("栈满");
		exit(0);
	}
	else
	{
		p->top++;
		p->ch[p->top]=x;
	}
}
void insert_num(numLink * p,int num)
{
	if(p->top==MAX)
	{
		printf("栈满");
		exit(0);
	}
	else
	{
		p->top++;
		p->num[p->top]=num;
	}
}
void pop_ch(chLink * p,char * ch)
{
	if(p->top==-1)
	{
		printf("ch栈空");
		exit(0);
	}
	else
	{
		*ch=p->ch[p->top];
		p->top--;
	}
}
void pop_num(numLink * p,int * num)
{
	if(p->top==-1)
	{
		printf("num栈空\n");
		exit(0);
	}
	else
	{
		*num=p->num[p->top];
		p->top--;
	}
}
int compare(char a ,char b)
{
	
	int i,j;
	switch(a)				//栈外级别 
	{
		case '+': i=1; break;
        case '-': i=1; break;
        case '*': i=2; break;
        case '/': i=2; break;
        case '^': i=4; break;
        case '%': i=2;break;
	}
	switch(b)
	{					//栈内级别 
        case '+': j=1; break;
        case '-': j=1; break;
        case '(': j=0; break;
        case '*': j=2; break;
        case '/': j=2; break;
        case '^': j=3; break;
        case '%': j=2;  break;
    }
    if(i>j) return 1;
	else return 0; 
}
void cal(chLink * p,numLink * q)
{
	char ch1;
	int x,y,z;
	pop_num(q,&x);
	pop_num(q,&y);
	pop_ch(p,&ch1);
	switch(ch1)
	{
		case '+':z=x+y;	break;
		case '-':z=x-y;	break;
		case '*':z=x*y;	break;
		case '/':z=0.1*x/y;break;
		case '%':z=x%y;	break;
	}	
	insert_num(q,z);
}
main()
{
	int len=0,i=0,j,k,tp_num,result;
	chLink * p=Init_ch();
	numLink * q;
	q=Init_number();
	char ch,ch1;
	char A[20];
	gets(A);
	len=strlen(A);
	for(i=0;i<len;i++)
	{
		ch=A[i];
		if(isdigit(ch))
		{
			tp_num=(int)ch-48;
			insert_num(q,tp_num);
		} 
		else
		{
			if(p->top==-1||ch=='('||compare(ch,p->ch[p->top])==1)
			{
				insert_ch(p,ch);
			}
			else if(ch!=')'&&compare(ch,p->ch[p->top])==0)	//如果不加[ch!=')']那摩将会导致程序无法进入下一个else if语句 
			{
				while(compare(ch,p->ch[p->top])==0&&p->top!=-1)
				{
					cal(p,q);
				}	
				insert_ch(p,ch);	
			}
			else if(ch==')')
			{
				while(p->ch[p->top]!='(')
				{
					cal(p,q);	
				}
				if(p->ch[p->top]=='(')
				{
					p->top--;
				}	
			}
			
		}
	}
	while(p->top>=0)
	{	
		cal(p,q);
	}
	printf("result = %d\n",q->num[q->top]); 
	
 } 
