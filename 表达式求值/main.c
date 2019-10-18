/*������Ҫ����ı��ʽ�س�����(��'='��ʾ���ʽ�Ľ���, Ҳ���Բ���, �м�ɴ��ո�)*/
#define _CRT_SECURE_NO_WARNINGS
#include"SeqStack.h"
#include<stdlib.h>

//������������
int Deal(char in[], SeqStackData infix[])
{
	int i = 0;			//in�еĵ�ǰ��λ��
	int j = 0;			//out�еĵ�ǰ��λ��
	int num;			//���ڴ�������
	SeqStackData m;			//��Ҫ����infix�е�����

	while (in[i] != '\0'&&in[i] != '=')			//'='�ű�ʾ����Ҳ���Բ���
	{
		if (in[i] >= 48 && in[i] <= 57)			//��ʾ������
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
		else			//����ո��Ϊ������꼶��
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

	m.s = '=';			//����׺���ʽβ��'='��ʾ����
	m.t = 2;
	infix[j] = m;
	return 1;
}

//��׺ת��׺
void Infix(SeqStackData infix[], SeqStackData suffix[])
{
	SeqStack* operator = NULL;			//�����ջ
	SeqStackData m;
	int i = 0;			//��׺���ʽ��ǰλ��
	int s = 0;			//��׺���ʽ��ǰλ��

	operator =Init_SeqStack();

	m.s = '(';			//Ԥ����ջ�׷�һ����ͼ������
	m.t = 1;
	Push_SeqStack(operator,m);

	while (infix[i].s != '=')			//'='�ű�ʾ����
	{
		if (infix[i].t == 0)			//����ֱ�Ӵ����׺���ʽ
		{
			suffix[s] = infix[i];
			s++;
		}
		else			//���������
		{
			if (infix[i].t == 1)			//��'('�Ĵ���
			{
				m = infix[i];
				Push_SeqStack(operator,m);
			}
			else if (infix[i].t == 2)			//��')'�Ĵ���
			{
				Pop_SeqStack(operator,&m);
				while (m.t != 1)
				{
					suffix[s] = m;
					s++;
					Pop_SeqStack(operator,&m);
				}
			}
			else			//������������Ĵ���
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

	Pop_SeqStack(operator,&m);			//��ջ�������������ջ
	while (m.t != 1)
	{
		suffix[s] = m;
		s++;
		Pop_SeqStack(operator,&m);
	}

	m.s = '=';			//�ڽ�β��'='��ʾ����
	m.t = 2;
	suffix[s] = m;
	Destroy_SeqStack(operator);
}

//��׺���ʽ����
int Suffix(SeqStackData suffix[])			
{
	int resute = 0;			//���صĽ��
	int s = 0;			//suffix�еĵ�ǰ��λ��
	SeqStackData a;			//a,b,m���ڽ��м���
	SeqStackData b;
	SeqStackData m;
	SeqStack* num = NULL;			//����ջ

	m.t = 0;
	num = Init_SeqStack();

	while (suffix[s].s != '=')			//'='�ű�ʾ����
	{
		if (suffix[s].t == 0)			//����ֱ����ջ
		{
			Push_SeqStack(num, suffix[s]);
		}
		else			//�������ջ�г������������������ջ
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

	GetTop_SeqStack(num, &m);			//���ؽ��
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

	printf("��������Ҫ����ı��ʽ(��'='��ʾ���ʽ�Ľ���,Ҳ���Բ���,�ɴ��ո�):");
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
		printf("����\n");
	}
	system("pause");
	return 0;
}