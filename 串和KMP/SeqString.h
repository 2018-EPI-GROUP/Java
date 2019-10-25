#ifndef _SEQSTRING_H_
#define _SEQSTRING_H_

#include<stdio.h>
#include<string.h>

#define SeqStrMAXSIZE 256
#define SeqString char

//����һ����ֵ����chars�Ĵ�SeqString
int SeqStrProduce(SeqString s[], char chars[]); 

//������ĳ��ȴ��󷵻�-1
int SeqStrLength(SeqString s[]);

//��s2�Ĵ�ֵ��ֵ��s1
int SeqStrAssign(SeqString s1[], SeqString s2[]);

//��s2������������s1��
int SeqStrCat(SeqString s1[], SeqString s2[]);

//���شӴ�s�ĵ�i���ַ���ʼ�ĳ���Ϊlen���Ӵ�
int SeqStrSub(SeqString s[], int i, int len, SeqString sub[]);

//�Ƚϴ�s1��s2,s1<s2����ֵС��0,s1>s2����ֵ����0,s1=s2����ֵ=0
int SeqStrCmp(SeqString s1[], SeqString s2[]);

//��ȡKMP����next����
int SeqStrGetNext(SeqString t[], int next[]);

//KMP(���Ӵ����������״γ��ֵ�λ�ò����أ�δ�ҵ�����0��������-1)
int SeqStrIndex(SeqString s[], SeqString t[]);

//����t���뵽��s�ĵ�i���ַ�λ���ϣ�1<=i<=����+1
int SeqStrInsert(SeqString s[], int i, SeqString t[]);

//ɾ����s�дӵ�i���ַ���ʼ�ĳ���Ϊlen���Ӵ�
int SeqStrDelete(SeqString s[], int i, int len);

//���Ӵ�r�滻s�г��ֵ������Ӵ�t
int SeqStrRep(SeqString s[], SeqString t[], SeqString r[]);

//������е���������
int SeqStrPrint(SeqString s[]);
 
#endif