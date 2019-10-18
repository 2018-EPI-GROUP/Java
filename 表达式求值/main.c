/*输入需要计算的表达式回车即可(用'='表示表达式的结束, 也可以不加, 中间可带空格)*/
#define _CRT_SECURE_NO_WARNINGS
#include"SeqStack.h"
#include<stdlib.h>

//处理读入的数据
int Deal(char in[], SeqStackData infix[])
{
	int i = 0;			//in中的当前的位置
	int j = 0;			//out中的当前的位置
	int num;			//用于处理数字
	SeqStackData m;			//需要存入infix中的数据

	while (in[i] != '\0'&&in[i] != '=')			//'='号表示结束也可以不用
	{
		if (in[i] >= 48 && in[i] <= 57)			//标示出数字
		{
			num = 0;
			while (in[i] >= 48 && in[i] <= 57)
			{
				num = num * 10 + in[i] - 48;
				i++;
			}
			m.s = num;
			m.t = 0;
		}
		else			//处理空格和为运算符标级别
		{
			m.s = in[i];
			if (in[i] == '(')
			{
				m.t = 1;
			}
			else if (in[i] == ')')
			{
				m.t = 2;
			}
			else if (in[i] == '+' || in[i] == '-')
			{
				m.t = 3;
			}
			else if (in[i] == '%' || in[i] == '*' || in[i] == '/')
			{
				m.t = 4;
			}
			else if (in[i] == '^')
			{
				m.t = 5;
			}
			else if (in[i] == ' ')
			{
				i++;
				continue;
			}
			else
			{
				return 0;
			}
			i++;
		}

		infix[j] = m;
		j++;
	}

	m.s = '=';			//在中缀表达式尾加'='表示结束
	m.t = 2;
	infix[j] = m;
	return 1;
}

//中缀转后缀
void Infix(SeqStackData infix[], SeqStackData suffix[])
{
	SeqStack* operator = NULL;			//运算符栈
	SeqStackData m;
	int i = 0;			//中缀表达式当前位置
	int s = 0;			//后缀表达式当前位置

	operator =Init_SeqStack();

	m.s = '(';			//预先在栈底放一个最低级运算符
	m.t = 1;
	Push_SeqStack(operator,m);

	while (infix[i].s != '=')			//'='号表示结束
	{
		if (infix[i].t == 0)			//数字直接存入后缀表达式
		{
			suffix[s] = infix[i];
			s++;
		}
		else			//处理运算符
		{
			if (infix[i].t == 1)			//对'('的处理
			{
				m = infix[i];
				Push_SeqStack(operator,m);
			}
			else if (infix[i].t == 2)			//对')'的处理
			{
				Pop_SeqStack(operator,&m);
				while (m.t != 1)
				{
					suffix[s] = m;
					s++;
					Pop_SeqStack(operator,&m);
				}
			}
			else			//对其他运算符的处理
			{
				GetTop_SeqStack(operator,&m);
				while (m.t >= infix[i].t)
				{
					Pop_SeqStack(operator,&m);
					suffix[s] = m;
					s++;
					GetTop_SeqStack(operator,&m);
				}
				Push_SeqStack(operator,infix[i]);
			}
		}
		i++;
	}

	Pop_SeqStack(operator,&m);			//将栈内所有运算符出栈
	while (m.t != 1)
	{
		suffix[s] = m;
		s++;
		Pop_SeqStack(operator,&m);
	}

	m.s = '=';			//在结尾加'='表示结束
	m.t = 2;
	suffix[s] = m;
	Destroy_SeqStack(operator);
}

//后缀表达式处理
int Suffix(SeqStackData suffix[])			
{
	int resute = 0;			//返回的结果
	int s = 0;			//suffix中的当前的位置
	SeqStackData a;			//a,b,m用于进行计算
	SeqStackData b;
	SeqStackData m;
	SeqStack* num = NULL;			//对象栈

	m.t = 0;
	num = Init_SeqStack();

	while (suffix[s].s != '=')			//'='号表示结束
	{
		if (suffix[s].t == 0)			//数字直接入栈
		{
			Push_SeqStack(num, suffix[s]);
		}
		else			//运算符从栈中出两个数进行运算后入栈
		{
			Pop_SeqStack(num, &b);
			Pop_SeqStack(num, &a);
			switch (suffix[s].s)
			{
			case '+':
				m.s = a.s + b.s;
				break;
			case '-':
				m.s = a.s - b.s;
				break;
			case '*':
				m.s = a.s * b.s;
				break;
			case '/':
				m.s = a.s / b.s;
				break;
			case '%':
				m.s = a.s % b.s;
				break;
			case '^':
				m.s = a.s;
				while (b.s - 1)
				{
					m.s = m.s*a.s;
					b.s--;
				}
				break;
			default:
				break;
			}
			Push_SeqStack(num, m);
		}
		s++;
	}

	GetTop_SeqStack(num, &m);			//返回结果
	resute = m.s;
	Destroy_SeqStack(num);
	return resute;
}

int main(void)
{
	char in[256];
	SeqStackData infix[256];
	SeqStackData suffix[256];
	int resute;
	int status;

	printf("请输入需要计算的表达式(用'='表示表达式的结束,也可以不加,可带空格):");
	gets(in);
	status = Deal(in, infix);
	if (status == 1)
	{
		Infix(infix, suffix);
		resute = Suffix(suffix);
		printf("= %d\n", resute);
	}
	else
	{
		printf("错误\n");
	}
	system("pause");
	return 0;
}