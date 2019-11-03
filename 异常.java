package cn.itcast.demo1;
/*
 *  异常分为编译异常和运行时期异常
 *    编译异常: 调用了抛出异常的方法,不处理编译失败  (try  throws)
 *    运行异常: 抛出的异常是RuntimeException类,或者是他的子类
 *  
 *  运行异常的特点:
 *     方法内部抛出的异常是运行异常, new XXXException
 *     方法的声明上,不需要throws语句,调用者,不需要处理
 *     设计原因:
 *        运行异常,不能发生,但是如果发生了,程序人员停止程序修改源代码
 *        
 *        运行异常: 一旦发生,不要处理,请你修改源代码, 运行异常一旦发生,后面的代码没有执行的意义
 */
public class RuntimeExceptionDemo {
	public static void main(String[] args) {
			double d = getArea(1);
			System.out.println(d);
	}
	
	/*
	 *  定义方法,计算圆形的面积
	 *  传递参数0,或者负数,计算的时候没有问题
	 *  但是,违反了真实情况
	 *  参数小于=0, 停止程序,不要在计算了
	 */
	public static double getArea(double r){
		if(r <= 0)
			throw new RuntimeException("圆形不存在");
		return r*r*Math.PI;
	}
	
	
	public static void function(){
		int[] arr = {1,2,3};
		//对数组的5索引进行判断,如果5索引大于100,请将5索引上的数据/2,否则除以3
		//索引根本就没有
		if(arr[5] > 100){
			arr[5] = arr[5]/2;
		}else{
			arr[5] = arr[5]/3;
		}
	}
}




package cn.itcast.demo2;
/*
 *  继承后,在子类重写父类方法的时候,异常处理
 *  结论:
 *    父类的方法,如果抛出异常,子类重写后
 *      可以不抛出异常
 *      也可以抛出异常,但是,如果子类要抛,抛出的异常不能大于父类的异常
 *        大于,都指的是继承关系
 *        
 *    父类的方法,没有异常抛出,子类重写后
 *       也不能抛出异常
 *       如果子类中调用了抛出异常的方法,别无选择,只能try..catch处理
 */
public class ExceptionDemo {
	public static void main(String[] args) {
		Fu f = new Zi();
		f.function();
	}
}

class Fu{
	public void function(){
		
	}
}
class Zi extends Fu{
	public void function(){
		
			try {
				method();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	
	}
	public void method()throws Exception{
		
	}
}
