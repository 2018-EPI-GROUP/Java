#include"SeqString.h"

//生成一个串值等于chars的串SeqString
int SeqStrProduce(SeqString s[], char chars[])
{
	if (s == NULL || chars == NULL)
	{
		printf("Error: SeqStrProduce\n");
		return 0;
	}
	if (strlen(chars) > SeqStrMAXSIZE)
	{
		printf("Error: SeqStrProduce\n");
		return 0;
	}

	s[0] = strlen(chars);
	for (int i = 1; i <= s[0]; i++)
	{
		s[i] = chars[i - 1];
	}

	return 0;
}

//求出串的长度错误返回-1
int SeqStrLength(SeqString s[])
{
	if (s == NULL)
	{
		printf("Error: SeqStrLength\n");
		return -1;
	}

	return s[0];
}

//将s2的串值赋值给s1
int SeqStrAssign(SeqString s1[], SeqString s2[])
{
	if (s1 == NULL || s2 == NULL)
	{
		printf("Error: SeqStrAssign\n");
		return 0;
	}

	s1[0] = s2[0];
	for (int i = 1; i <= s2[0]; i++)
	{
		s1[i] = s2[i];
	}

	return 1;
}

//将s2的内容连接至s1后
int SeqStrCat(SeqString s1[], SeqString s2[])
{
	if (s1 == NULL || s2 == NULL)
	{
		printf("Error: SeqStrCat\n");
		return 0;
	}
	if (s1[0] + s2[0] > SeqStrMAXSIZE)
	{
		printf("Error: SeqStrCat\n");
		return 0;
	}

	for (int i = 1; i <= s2[0]; i++)
	{
		s1[i + s1[0]] = s2[i];
	}
	s1[0] = s1[0] + s2[0];

	return 1;
}

//返回从串s的第i个字符开始的长度为len的子串
int SeqStrSub(SeqString s[], int i, int len, SeqString sub[])
{
	if (s == NULL || sub == NULL)
	{
		printf("Error: SeqStrSub\n");
		return 0;
	}
	if (i < 1 || len < 1 || i + len - 1>s[0])
	{
		printf("Error: SeqStrSub\n");
		return 0;
	}

	for (int j = 1; j <= len; j++)
	{
		sub[j] = s[i + j - 1];
	}
	sub[0] = len;

	return 1;
}

//比较串s1和s2,s1<s2返回值小于0,s1>s2返回值大于0,s1=s2返回值=0
int SeqStrCmp(SeqString s1[], SeqString s2[])
{
	if (s1 == NULL || s2 == NULL)
	{
		printf("Error: SeqStrCmp\n");
		return 0;
	}

	int i = 1;
	while (i <= s1[0] && i <= s2[0])
	{
		if (s1[i] != s2[i])
		{
			return s1[i] - s2[i];
		}
		i++;
	}

	if (s1[0] > s2[0])
	{
		return s1[i];
	}
	else if (s1[0] < s2[0])
	{
		return s2[i];
	}
	else
	{
		return 0;
	}
}

//获取KMP所需next数组
int SeqStrGetNext(SeqString t[], int next[])
{
	if (t == NULL || next == NULL)
	{
		printf("Error: SeqStrGetNext\n");
		return 0;
	}
	if (t[0] == 0)
	{
		printf("Error: SeqStrGetNext\n");
		return 0;
	}

	int i = 1, j = 0;
	next[1] = 0;
	while (i < t[0])
	{
		while (j>0 && t[i] != t[j])
		{
			j = next[j];
		}
		i++;
		j++;

		if (t[i] == t[j])
		{
			next[i] = next[j];
		}
		else
		{
			next[i] = j;
		}
	}
	return 1;
}

////KMP
//int SeqStrIndex(SeqString s[], SeqString t[])
//{
//	if (s == NULL || t == NULL)
//	{
//		printf("Error: SeqStrIndex\n");
//		return -1;
//	}
//	if (t[0] == 0)
//	{
//		printf("Error: SeqStrIndex\n");
//		return -1;
//	}
//
//	int next[SeqStrMAXSIZE + 1];
//	SeqStrGetNext(t, next);
//
//	int i = 1, j = 1;
//	while (i <= s[0])
//	{
//		if (s[i] != t[j])
//		{
//			j = next[j];
//		}
//		if (j == t[0])
//		{
//			return i - j + 1;
//		}
//		j++;
//		i++;
//	}
//	return 0;
//}

//找子串在主串中首次出现的位置并返回，未找到返回0，出错返回-1
int SeqStrIndex(SeqString s[], SeqString t[])
{
	if (s == NULL || t == NULL)
	{
		printf("Error: SeqStrIndex\n");
		return -1;
	}
	if (t[0] == 0)
	{
		printf("Error: SeqStrIndex\n");
		return -1;
	}

	int i, j;
	for (i = 1; i <= s[0] - t[0] + 1; i++)
	{
		j = 1;
		while (s[i+j-1]==t[j])
		{
			if (j == t[0])
			{
				return i;
			}
			j++;
		}
	}

	return 0;
}

//将串t插入到串s的第i个字符位置上，1<=i<=串长+1
int SeqStrInsert(SeqString s[], int i, SeqString t[])
{
	if (s == NULL || t == NULL)
	{
		printf("Error: SeqStrInsert\n");
		return 0;
	}
	if (i<1 || i>s[0] + 1 || s[0] + t[0] > SeqStrMAXSIZE)
	{
		printf("Error: SeqStrInsert\n");
		return 0;
	}

	SeqString memory[SeqStrMAXSIZE + 1];
	if (i != s[0] + 1)
	{
		SeqStrSub(s, i, s[0] - i + 1, memory);
		s[0] = i - 1;
		SeqStrCat(s, t);
		SeqStrCat(s, memory);
	}
	else
	{
		SeqStrCat(s, t);
	}
	return 1;
}

//删除串s中从第i个字符开始的长度为len的子串
int SeqStrDelete(SeqString s[], int i, int len)
{
	if (s == NULL)
	{
		printf("Error: SeqStrDelete\n");
		return 0;
	}
	if (i < 1 || len<1 || i + len - 1>SeqStrMAXSIZE)
	{
		printf("Error: SeqStrDelete\n");
		return 0;
	}

	SeqString memory[SeqStrMAXSIZE + 1];
	if (i + len - 1 == SeqStrMAXSIZE)
	{
		s[0] = i - 1;
		return 1;
	}
	else
	{
		SeqStrSub(s, i + len, s[0] - i - len + 1, memory);
		s[0] = i - 1;
		SeqStrCat(s, memory);
		return 1;
	}
}

//用子串r替换s中出现的所有子串t
int SeqStrRep(SeqString s[], SeqString t[], SeqString r[])
{
	if (s == NULL || t == NULL || r == NULL)
	{
		printf("Error: SeqStrRep\n");
		return 0;
	}
	if (t[0] == 0)
	{
		printf("Error: SeqStrRep\n");
		return 0;
	}

	SeqString memory[SeqStrMAXSIZE + 1];			//用来记忆s需要进行替换的子串
	int mLocat = 0;		//mLocat指向m中匹配子串的起始位置
	int sLocat = 1;		//sLocat指向s中memory记录的子串的起始位置
	SeqStrAssign(memory, s);
	mLocat = SeqStrIndex(memory, t);
	while (mLocat != 0)
	{
		SeqStrDelete(s, sLocat + mLocat - 1, t[0]);
		SeqStrInsert(s, sLocat + mLocat - 1, r);
		sLocat = sLocat + mLocat - 1 + r[0];
		if (s[0] - sLocat + 1 != 0)
		{
			SeqStrSub(s, sLocat, s[0] - sLocat + 1, memory);
			mLocat = SeqStrIndex(memory, t);
		}
		else
		{
			break;
		}
	}

	return 1;
}

//输出串中的所有内容
int SeqStrPrint(SeqString s[])
{
	if (s == NULL)
	{
		printf("Error: SeqStrPrint\n");
		return 0;
	}

	for (int i = 1; i <= s[0]; i++)
	{
		printf("%c", s[i]);
	}
	printf("\n");
	return 1;
}


//测试
int main(void)
{
	SeqString s[SeqStrMAXSIZE + 1];
	SeqString t[SeqStrMAXSIZE + 1];
	SeqString r[SeqStrMAXSIZE + 1];
	int resute;

	SeqStrProduce(s, "cddcdecedea");
	printf("=============================\n");
	SeqStrPrint(s);

	SeqStrProduce(t, "cde");
	resute = SeqStrIndex(s, t);
	printf("=============================\n%d\n", resute);

	SeqStrProduce(r, "a");
	SeqStrRep(s, t, r);
	printf("=============================\n");
	SeqStrPrint(s);

	resute = SeqStrCmp(t, s);
	printf("=============================\n%d\n", resute);
	system("pause");
	return 0;
}
