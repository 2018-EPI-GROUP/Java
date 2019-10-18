#include"SeqStack.h"

//˳��ջ�ÿ�
SeqStack* Init_SeqStack(void)
{
	SeqStack* New;
	New = (SeqStack*)malloc(sizeof(SeqStack));
	New->top = -1;
	return New;
}

//˳��ջ��ջ��
int Empty_SeqStack(SeqStack* p)
{
	if (p == NULL)
		return -1;

	if (p->top == -1)
		return 1;
	return 0;
}

//˳��ջ��ջ
int Push_SeqStack(SeqStack* p, SeqStackData Data)
{
	if (p == NULL)
		return 0;

	if (p->top + 1 == SeqStackMAXSIZE)
		return 0;

	p->top++;
	p->Data[p->top] = Data;
	return 1;
}

//˳��ջ��ջ
int Pop_SeqStack(SeqStack* p, SeqStackData* Data)
{
	if (p == NULL)
		return 0;

	if (p->top == -1)
		return 0;

	*Data = p->Data[p->top];
	p->top--;
	return 1;
}

//˳��ջȡջ��Ԫ��
int GetTop_SeqStack(SeqStack* p, SeqStackData* Data)
{
	if (p == NULL)
		return 0;

	if (p->top == -1)
		return 0;

	*Data = p->Data[p->top];
	return 1;
}

//����˳��ջ�ĳ���
int Length_SeqStack(SeqStack* p)
{
	if (p == NULL)
		return -1;

	return p->top + 1;
}

//��ʼ��˳��ջ
int Clear_SeqStack(SeqStack* p)
{
	if (p == NULL)
		return 0;

	p->top = -1;
	return 1;
}

//����˳��ջ
void Destroy_SeqStack(SeqStack* p)
{
	free(p);
}