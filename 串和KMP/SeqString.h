#ifndef _SEQSTRING_H_
#define _SEQSTRING_H_

#include<stdio.h>
#include<string.h>

#define SeqStrMAXSIZE 256
#define SeqString char

//生成一个串值等于chars的串SeqString
int SeqStrProduce(SeqString s[], char chars[]); 

//求出串的长度错误返回-1
int SeqStrLength(SeqString s[]);

//将s2的串值赋值给s1
int SeqStrAssign(SeqString s1[], SeqString s2[]);

//将s2的内容连接至s1后
int SeqStrCat(SeqString s1[], SeqString s2[]);

//返回从串s的第i个字符开始的长度为len的子串
int SeqStrSub(SeqString s[], int i, int len, SeqString sub[]);

//比较串s1和s2,s1<s2返回值小于0,s1>s2返回值大于0,s1=s2返回值=0
int SeqStrCmp(SeqString s1[], SeqString s2[]);

//获取KMP所需next数组
int SeqStrGetNext(SeqString t[], int next[]);

//KMP(找子串在主串中首次出现的位置并返回，未找到返回0，出错返回-1)
int SeqStrIndex(SeqString s[], SeqString t[]);

//将串t插入到串s的第i个字符位置上，1<=i<=串长+1
int SeqStrInsert(SeqString s[], int i, SeqString t[]);

//删除串s中从第i个字符开始的长度为len的子串
int SeqStrDelete(SeqString s[], int i, int len);

//用子串r替换s中出现的所有子串t
int SeqStrRep(SeqString s[], SeqString t[], SeqString r[]);

//输出串中的所有内容
int SeqStrPrint(SeqString s[]);
 
#endif