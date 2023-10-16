import org.junit.*;

public class Autograder {

	@Test
	public void testAgrandirTab1() {
		Assert.assertNull(Exercice1.agrandirTab(null));
	}

	@Test
	public void testAgrandirTab2() {
		String[] a = new String[2];
		a[0] = "hello";
		a[1] = "world";
		Assert.assertTrue(Exercice1.agrandirTab(a)[0].equals("hello"));
		Assert.assertTrue(Exercice1.agrandirTab(a)[1].equals("world"));
	}

	@Test
	public void testAgrandirTab3() {
		String[] a = new String[1];
		a[0] = "hello";
		Assert.assertNull(Exercice1.agrandirTab(a)[1]);
	}

	@Test
	public void testAgrandirTab4() {
		String[] a = new String[1];
		a[0] = "hello";
		Assert.assertEquals(Exercice1.agrandirTab(a).length, a.length + 1);
	}

	@Test
	public void testAgrandirTab5() {
		String[] a = new String[0];
		Assert.assertEquals(a.length, 0);
		Assert.assertEquals(Exercice1.agrandirTab(a).length, 1);
	}

}
