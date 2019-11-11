## 基于c语言的蛇形填数问题

```
#include<stdio.h>
#include<string.h>
#define N 10
main()
{
	int a[N][N],x,y,n,tot;
	scanf("%d",&n);		//n为输出蛇形方格的规格
	memset(a,0,sizeof(a));
	tot=a[x=0][y=n-1]=1;         //同tot判断数组是否出界 
	while(tot<n*n)
	{
		while(x+1<n&&!a[x+1][y]) a[++x][y]=++tot;    //判断下一个数是否越界 
		while(y-1>=0&&!a[x][y-1]) a[x][--y]=++tot;
		while(x-1>=0&&!a[x-1][y]) a[--x][y]=++tot;
		while(y+1<n&&!a[x][y+1]) a[x][++y]=++tot;
	}
	for(x=0;x<n;x++)
	{
		for(y=0;y<n;y++)
		printf("%3d ",a[x][y]);
		printf("\n");
	}
 } 
```

运行结果如图：

![1573198946119](C:\Users\gaidi\AppData\Roaming\Typora\typora-user-images\1573198946119.png)