#include"SeqStack.h"

//Ë³ĞòÕ»ÖÃ¿Õ
SeqStack* Init_SeqStack(void)
{
	SeqStack* New;
	New = (SeqStack*)malloc(sizeof(SeqStack));
	New->top = -1;
	return New;
}

//Ë³ĞòÕ»ÅĞÕ»¿Õ
int Empty_SeqStack(SeqStack* p)
{
	if (p == NULL)
		return -1;

	if (p->top == -1)
		return 1;
	return 0;
}

//Ë³ĞòÕ»ÈëÕ»
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

//Ë³ĞòÕ»³öÕ»
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

//Ë³ĞòÕ»È¡Õ»¶¥ÔªËØ
int GetTop_SeqStack(SeqStack* p, SeqStackData* Data)
{
	if (p == NULL)
		return 0;

	if (p->top == -1)
		return 0;

	*Data = p->Data[p->top];
	return 1;
}

//²âÁ¿Ë³ĞòÕ»µÄ³¤¶È
int Length_SeqStack(SeqStack* p)
{
	if (p == NULL)
		return -1;

	return p->top + 1;
}

//³õÊ¼»¯Ë³ĞòÕ»
int Clear_SeqStack(SeqStack* p)
{
	if (p == NULL)
		return 0;

	p->top = -1;
	return 1;
}

//Ïú»ÙË³ĞòÕ»
void Destroy_SeqStack(SeqStack* p)
{
	free(p);
}