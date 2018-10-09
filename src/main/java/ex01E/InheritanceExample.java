package ex01E;

class A 
{
	int x;
	void m() 
	{
		System.out.println("Je suis dans la méthode m d'une instance de A");
	}
}

class B extends A
{
	int x;
	void m() {
		System.out.println("Je suis dans la méthode m d'une instance de B");
	}
}

class C extends B 
{
	int x, a;
	void m() {
		System.out.println("Je suis dans la méthode m d'une instance de C");
	}

	void test() {
		a = super.x;       
//		a = super.super.x;  // super.super is not possible, as it breaks encapsulation. You shouldn't be able to bypass the parent class's behavior.
		a = ((B)this).x;   
		a = ((A)this).x;   
		super.m();
//		super.super.m();   
		((B)this).m();     // (1)
	}
}

public class InheritanceExample {
	public static void main(String [] args) {
		C c = new C();
		c.test();
	}
}
