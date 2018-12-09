import static org.junit.Assert.assertArrayEquals;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class AVL_Tree_Tests {
	BSTree0 lst = new BSTree0();
	BSTree0 lst2 = new BSTree0();
	BSTree0 lstReverse = new BSTree0();
	
	
	
	
	@After
	public void cleanArray()
	{
		lst.clear();
		lst2.clear();
		lstReverse.clear();
	}
	
	@Test
	public void initialisationTest ()
	{
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42};
		lst.init(ini);
		int [] expected = {1, 10, 15, 34, 36, 42, 78, 94};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void clearTest() 
	{
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42};
		lst.init(ini);
		lst.clear();
		int [] expected = {};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void heightTest_1() 
	{
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42};
		lst.init(ini);
		int expected = 4;
		int actual = lst.height();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void heightTest_2() 
	{
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42, 14, 17, 2, -2, -5};
		lst.init(ini);
		int expected = 5;
		int actual = lst.height();
		Assert.assertEquals(expected, actual);
	}	
	@Test
	public void leavesTest_1() 
	{
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42};
		lst.init(ini);
		int expected = 4;
		int actual = lst.leaves();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void leavesTest_2() 
	{
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42, 14, 17, 2, -2, -5};
		lst.init(ini);
		int expected = 6;
		int actual = lst.leaves();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void nodesTest_1() 
	{
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42};
		lst.init(ini);
		int expected = 4;
		int actual = lst.nodes();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void nodesTest_2() 
	{
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42, 14, 17, 2, -2, -5};
		lst.init(ini);
		int expected = 7;
		int actual = lst.nodes();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void toStringTest_1() 
	{
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42};
		lst.init(ini);
		String expected = "1 10 15 34 36 42 78 94";
		String actual = lst.toString();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void toStringTest_2() 
	{
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42, 14, 17, 2, -2, -5};
		lst.init(ini);
		String expected = "-5 -2 1 2 10 14 15 17 34 36 42 78 94";
		String actual = lst.toString();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void widthTest_1() {
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42};
		lst.init(ini);
		int expected = 4;
		int actual = lst.width();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void widthTest_2() {
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42, 14, 17, 2, -2, -5};
		lst.init(ini);
		int expected = 5;
		int actual = lst.width();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void compareTreesTestSame_1() {
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42};
		int [] ini2 = {34, 10, 1, 15, 78, 94, 36, 42};
		lst.init(ini);
		lst2.init(ini2);
		boolean expected = true;
		boolean actual = lst.compareTrees(lst2);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void compareTreesTestSame_2() {
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42, 14, 17, 2, -2, -5};
		int [] ini2 = {34, 10, 1, 15, 78, 94, 36, 42, 14, 17, 2, -2, -5};
		lst.init(ini);
		lst2.init(ini2);
		boolean expected = true;
		boolean actual = lst.compareTrees(lst2);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void compareTreesTestDifferentCountEL_1() {
		int [] ini = {34, 10, 1, 15, 94, 36, 42};
		int [] ini2 = {34, 10, 1, 15, 78, 94, 36, 42};
		lst.init(ini);
		lst2.init(ini2);
		boolean expected = false;
		boolean actual = lst.compareTrees(lst2);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void compareTreesTestDifferentCountEL_2() {
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42, 14, 17, 2, -2, -5};
		int [] ini2 = {34, 10, 1, 15, 78, 94, 36, 42, 14, 17, 2, -2};
		lst.init(ini);
		lst2.init(ini2);
		boolean expected = false;
		boolean actual = lst.compareTrees(lst2);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void compareTreesTestDifferentValueEL_1() {
		int [] ini = {34, 10, 1, 15, 78, 94, 37, 42};
		int [] ini2 = {34, 10, 1, 15, 78, 94, 36, 42};
		lst.init(ini);
		lst2.init(ini2);
		boolean expected = false;
		boolean actual = lst.compareTrees(lst2);
		Assert.assertEquals(expected, actual);
	}	
	
	@Test
	public void compareTreesTestDifferentValueEL_2() {
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42, 14, 17, 2, -2, -5};
		int [] ini2 = {34, 10, 1, 15, 78, 94, 36, 42, 15, 17, 2, -2, -5};
		lst.init(ini);
		lst2.init(ini2);
		boolean expected = false;
		boolean actual = lst.compareTrees(lst2);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void ReverseTest_1() {
		int [] ini = {34, 10, 1, 15, 78, 94, 37, 42};
		int [] ini2 = {34, 10, 1, 15, 78, 94, 37, 42};
		lst.init(ini);
		lst2.init(ini2);
		lst2.reverse();
		
		boolean expected = false;
		boolean actual = lst.compareTrees(lst2);
		Assert.assertEquals(expected, actual);
	}	
	@Test
	public void ReverseTest_2() {
		int [] ini = {34, 10, 1, 15, 78, 94, 37, 42};
		int [] ini2 = {34, 10, 1, 15, 78, 94, 37, 42};
		lst.init(ini);
		lst2.init(ini2);
		lst2.reverse();
		lst2.reverse();
		boolean expected = true;
		boolean actual = lst.compareTrees(lst2);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void ReverseTest_3 ()
	{
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42};
		lst.init(ini);
		lst.reverse();
		int [] expected =  {94, 78, 42, 36, 34, 15, 10, 1};  //{1, 10, 15, 34, 36, 42, 78, 94};
		int [] actual = lst.toArray();		
		System.out.println(lst.toString());
		Assert.assertArrayEquals(expected, actual);
	}
	@Test
	public void ReverseTest_4() {
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42, 14, 17, 2, -2, -5};
		lst.init(ini);
		lst.reverse();
		lst.toArray();
		int [] expected =  {94, 78, 42, 36, 34, 17, 15, 14, 10, 2, 1, -2, -5};  //{34, 10, 1, 15, 78, 94, 36, 42, 14, 17, 2, -2, -5};
		int [] actual = lst.toArray();
		System.out.println(lst.toString());
		Assert.assertArrayEquals(expected, actual);
	}
	

	@Test
	public void testInit10() {
		int[] ar = null;
		lst.init(ar);
		int[] expected = {};
		int[] actual = lst.toArray();		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testInit11() {
		int[] ar = {};
		lst.init(ar);
		int[] expected = {};
		int[] actual = lst.toArray();		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testInit12() {
		int[] ar = {50};
		lst.init(ar);
		int[] expected = {50};
		int[] actual = lst.toArray();
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testInit13() {
		int[] ar = {50, 40};
		lst.init(ar);
		int[] expected = {40, 50};
		int[] actual = lst.toArray();
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testInit14() {
		int[] ar = {40, 50};
		lst.init(ar);
		int[] expected = {40 , 50};
		int[] actual = lst.toArray();
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testInit15() {
		int[] ar = {40, 30, 50, 60, 55};
		lst.init(ar);
		int[] expected = {30, 40, 50, 55, 60};
		int[] actual = lst.toArray();
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testInit16() {
		int[] ar = {40, 30, 20, 25, 55};
		lst.init(ar);
		int[] expected = {20, 25, 30, 40, 55};
		int[] actual = lst.toArray();
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testInit17() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55};
		lst.init(ar);
		int[] expected = {25, 30, 35, 40, 45, 50, 55};
		int[] actual = lst.toArray();
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testInit18() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 22, 32, 27, 37};
		lst.init(ar);
		int[] expected = {22, 25, 27, 30, 32, 35, 37, 40, 45, 50, 55};
		int[] actual = lst.toArray();
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testInit19() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47};
		lst.init(ar);
		int[] expected = {25, 30, 35, 40, 42, 45, 47, 50, 52, 55, 57};
		int[] actual = lst.toArray();
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testClear10() {
		int[] ar = null;
		lst.init(ar);
		lst.clear();
		int expected = 0;
		int actual = lst.size();		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testClear11() {
		int[] ar = {};
		lst.init(ar);
		lst.clear();
		int expected = 0;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testClear12() {
		int[] ar = {50};
		lst.init(ar);
		lst.clear();
		int expected = 0;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testClear13() {
		int[] ar = {50, 40};
		lst.init(ar);
		lst.clear();
		int expected = 0;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testClear14() {
		int[] ar = {40, 50};
		lst.init(ar);
		lst.clear();
		int expected = 0;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testClear15() {
		int[] ar = {40, 30, 50, 60, 55};
		lst.init(ar);
		lst.clear();
		int expected = 0;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testClear16() {
		int[] ar = {40, 30, 20, 25, 55};
		lst.init(ar);
		lst.clear();
		int expected = 0;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testClear17() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55};
		lst.init(ar);
		lst.clear();
		int expected = 0;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testClear18() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 22, 32, 27, 37};
		lst.init(ar);
		lst.clear();
		int expected = 0;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testClear19() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47};
		lst.init(ar);
		lst.clear();
		int expected = 0;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testAdd10() {
		int[] ar = null;
		lst.init(ar);
		lst.add(33);
		int[] expecteds = {33};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd11() {
		int[] ar = {};
		lst.init(ar);
		lst.add(44);
		int[] expecteds = {44};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd120() {
		int[] ar = {50};
		lst.init(ar);
		lst.add(33);
		int[] expecteds = {33, 50};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd121() {
		int[] ar = {50};
		lst.init(ar);
		lst.add(55);
		int[] expecteds = {50, 55};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
		
	@Test
	public void testAdd13() {
		int[] ar = {50, 40};
		lst.init(ar);
		lst.add(45);
		int[] expecteds = {40, 45, 50};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd14() {
		int[] ar = {40, 50};
		lst.init(ar);
		lst.add(45);
		int[] expecteds = {40, 45, 50};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd150() {
		int[] ar = {40, 30, 50, 60, 55};
		lst.init(ar);
		lst.add(35);
		int[] expecteds = {30, 35, 40, 50, 55, 60};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd151() {
		int[] ar = {40, 30, 50, 60, 55};
		lst.init(ar);
		lst.add(53);
		int[] expecteds = {30, 40, 50, 53, 55, 60};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd160() {
		int[] ar = {40, 30, 20, 25, 55};
		lst.init(ar);
		lst.add(57);
		int[] expecteds = {20, 25, 30, 40, 55, 57};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd161() {
		int[] ar = {40, 30, 20, 25, 55};
		lst.init(ar);
		lst.add(37);
		int[] expecteds = {20, 25, 30, 37, 40, 55};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd170() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55};
		lst.init(ar);
		lst.add(37);
		int[] expecteds = {25, 30, 35, 37, 40, 45, 50, 55};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd171() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55};
		lst.init(ar);
		lst.add(47);
		int[] expecteds = {25, 30, 35, 40, 45, 47, 50, 55};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd180() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 22, 32, 27, 37};
		lst.init(ar);
		lst.add(47);
		int[] expecteds = {22, 25, 27, 30, 32, 35, 37, 40, 45, 47, 50, 55};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd181() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 22, 32, 27, 37};
		lst.init(ar);
		lst.add(38);
		int[] expecteds = {22, 25, 27, 30, 32, 35, 37, 38, 40, 45, 50, 55};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd190() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47};
		lst.init(ar);
		lst.add(48);
		int[] expecteds = {25, 30, 35, 40, 42, 45, 47, 48, 50, 52, 55, 57};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testAdd191() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47};
		lst.init(ar);
		lst.add(28);
		int[] expecteds = {25, 28, 30, 35, 40, 42, 45, 47, 50, 52, 55, 57};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testSize10() {
		int[] ar = null;
		lst.init(ar);
		int expected = 0;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSize11() {
		int[] ar = {};
		lst.init(ar);
		int expected = 0;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSize12() {
		int[] ar = {50};
		lst.init(ar);
		int expected = 1;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
		
	@Test
	public void testSize13() {
		int[] ar = {50, 40};
		lst.init(ar);
		int expected = 2;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSize14() {
		int[] ar = {40, 50};
		lst.init(ar);
		int expected = 2;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSize15() {
		int[] ar = {40, 30, 50, 60, 55};
		lst.init(ar);
		int expected = 5;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSize16() {
		int[] ar = {40, 30, 20, 25, 55};
		lst.init(ar);
		int expected = 5;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSize170() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55};
		lst.init(ar);
		int expected = 7;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSize18() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 22, 32, 27, 37};
		lst.init(ar);
		int expected = 11;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSize19() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47};
		lst.init(ar);
		int expected = 11;
		int actual = lst.size();
		
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLeaves10() {
		int[] ar = null;
		lst.init(ar);
		int expected = 0;
		int actual = lst.leaves();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testLeaves11() {
		int[] ar = {};
		lst.init(ar);
		int expected = 0;
		int actual = lst.leaves();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testLeaves12() {
		int[] ar = {50};
		lst.init(ar);
		int expected = 1;
		int actual = lst.leaves();
		
		Assert.assertEquals(expected, actual);
	}
		
	@Test
	public void testLeaves13() {
		int[] ar = {50, 40};
		lst.init(ar);
		int expected = 1;
		int actual = lst.leaves();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testLeaves14() {
		int[] ar = {40, 50};
		lst.init(ar);
		int expected = 1;
		int actual = lst.leaves();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testLeaves15() {
		int[] ar = {40, 30, 50, 60, 55};
		lst.init(ar);
		int expected = 2;
		int actual = lst.leaves();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testLeaves16() {
		int[] ar = {40, 30, 20, 25, 55};
		lst.init(ar);
		int expected = 2;
		int actual = lst.leaves();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testLeaves170() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55};
		lst.init(ar);
		int expected = 4;
		int actual = lst.leaves();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testLeaves18() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 22, 32, 27, 37};
		lst.init(ar);
		int expected = 6;
		int actual = lst.leaves();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testLeaves19() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47};
		lst.init(ar);
		int expected = 6;
		int actual = lst.leaves();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testNodes10() {
		int[] ar = null;
		lst.init(ar);
		int expected = 0;
		int actual = lst.nodes();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testNodes11() {
		int[] ar = {};
		lst.init(ar);
		int expected = 0;
		int actual = lst.nodes();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testNodes12() {
		int[] ar = {50};
		lst.init(ar);
		int expected = 0;
		int actual = lst.nodes();
		
		Assert.assertEquals(expected, actual);
	}
		
	@Test
	public void testNodes13() {
		int[] ar = {50, 40};
		lst.init(ar);
		int expected = 1;
		int actual = lst.nodes();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testNodes14() {
		int[] ar = {40, 50};
		lst.init(ar);
		int expected = 1;
		int actual = lst.nodes();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testNodes15() {
		int[] ar = {40, 30, 50, 60, 55};
		lst.init(ar);
		int expected = 3;
		int actual = lst.nodes();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testNodes16() {
		int[] ar = {40, 30, 20, 25, 55};
		lst.init(ar);
		int expected = 3;
		int actual = lst.nodes();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testNodes17() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55};
		lst.init(ar);
		int expected = 3;
		int actual = lst.nodes();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testNodes18() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 22, 32, 27, 37};
		lst.init(ar);
		int expected = 5;
		int actual = lst.nodes();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testNodes19() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47};
		lst.init(ar);
		int expected = 5;
		int actual = lst.nodes();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testHeigth10() {
		int[] ar = null;
		lst.init(ar);
		int expected = 0;
		int actual = lst.height();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testHeigth11() {
		int[] ar = {};
		lst.init(ar);
		int expected = 0;
		int actual = lst.height();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testHeigth12() {
		int[] ar = {50};
		lst.init(ar);
		int expected = 1;
		int actual = lst.height();
		
		Assert.assertEquals(expected, actual);
	}
		
	@Test
	public void testHeigth13() {
		int[] ar = {50, 40};
		lst.init(ar);
		int expected = 2;
		int actual = lst.height();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testHeigth14() {
		int[] ar = {40, 50};
		lst.init(ar);
		int expected = 2;
		int actual = lst.height();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testHeigth15() {
		int[] ar = {40, 30, 50, 60, 45};
		lst.init(ar);
		int expected = 3;
		int actual = lst.height();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testHeigth16() {
		int[] ar = {40, 30, 20, 25, 55};
		lst.init(ar);
		int expected = 4;
		int actual = lst.height();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testHeigth17() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55};
		lst.init(ar);
		int expected = 3;
		int actual = lst.height();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testHeigth18() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 22, 32, 27, 37, 38};
		lst.init(ar);
		int expected = 5;
		int actual = lst.height();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testHeigth190() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47};
		lst.init(ar);
		int expected = 4;
		int actual = lst.height();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testHeigth191() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47, 41};
		lst.init(ar);
		int expected = 5;
		int actual = lst.height();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testWidth10() {
		int[] ar = null;
		lst.init(ar);
		int expected = 0;
		int actual = lst.width();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testWidth11() {
		int[] ar = {};
		lst.init(ar);
		int expected = 0;
		int actual = lst.width();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testWidth12() {
		int[] ar = {50};
		lst.init(ar);
		int expected = 1;
		int actual = lst.width();
		
		Assert.assertEquals(expected, actual);
	}
		
	@Test
	public void testWidth13() {
		int[] ar = {50, 40};
		lst.init(ar);
		int expected = 1;
		int actual = lst.width();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testWidth14() {
		int[] ar = {40, 50};
		lst.init(ar);
		int expected = 1;
		int actual = lst.width();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testWidth15() {
		int[] ar = {40, 30, 50, 60, 45};
		lst.init(ar);
		int expected = 2;
		int actual = lst.width();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testWidth16() {
		int[] ar = {40, 30, 20, 25, 55};
		lst.init(ar);
		int expected = 2;
		int actual = lst.width();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testWidth17() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55};
		lst.init(ar);
		int expected = 4;
		int actual = lst.width();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testWidth18() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 22, 32, 27, 37, 38};
		lst.init(ar);
		int expected = 4;
		int actual = lst.width();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testWidth190() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47};
		lst.init(ar);
		int expected = 4;
		int actual = lst.width();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testWidth191() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47, 37, 27};
		lst.init(ar);
		int expected = 6;
		int actual = lst.width();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testReverse10() {
		int[] ar = null;
		lst.init(ar);
		lst.reverse();
		int[] expecteds = {};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReverse11() {
		int[] ar = {};
		lst.init(ar);
		lst.reverse();
		int[] expecteds = {};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReverse12() {
		int[] ar = {50};
		lst.init(ar);
		lst.reverse();
		int[] expecteds = {50};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReverse13() {
		int[] ar = {50, 40};
		lst.init(ar);
		lst.reverse();
		int[] expecteds = {50, 40};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReverse14() {
		int[] ar = {40, 50};
		lst.init(ar);
		lst.reverse();
		int[] expecteds = {50 , 40};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReverse15() {
		int[] ar = {40, 30, 50, 60, 55};
		lst.init(ar);
		lst.reverse();
		int[] expecteds = {60, 55, 50, 40, 30};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReverse16() {
		int[] ar = {40, 30, 20, 25, 55};
		lst.init(ar);
		lst.reverse();
		int[] expecteds = {55, 40, 30, 25, 20};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReverse17() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55};
		lst.init(ar);
		lst.reverse();
		int[] expecteds = {55, 50, 45, 40, 35, 30, 25};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReverse18() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 22, 32, 27, 37};
		lst.init(ar);
		lst.reverse();
		int[] expecteds = {55, 50, 45, 40, 37, 35, 32, 30, 27, 25, 22};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReverse19() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47};
		lst.init(ar);
		lst.reverse();
		int[] expecteds = {57, 55, 52, 50, 47, 45, 42, 40, 35, 30, 25};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testDel10() {
		int[] ar = null;
		lst.init(ar);
		lst.del(33);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testDel11() {
		int[] ar = {};
		lst.init(ar);
		lst.del(44);
	}
	
	@Test
	public void testDel120() {
		int[] ar = {50};
		lst.init(ar);
		lst.del(50);
		int[] expecteds = {};
		int[] actuals = lst.toArray();
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testDel121() {
		int[] ar = {50};
		lst.init(ar);
		lst.del(45);
	}
		
	@Test
	public void testDel13() {
		int[] ar = {50, 40};
		lst.init(ar);
		lst.del(50);
		int[] expecteds = {40};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDel14() {
		int[] ar = {40, 50};
		lst.init(ar);
		lst.del(50);
		int[] expecteds = {40};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDel150() {
		int[] ar = {40, 30, 50, 60, 55};
		lst.init(ar);
		lst.del(50);
		int[] expected = {30, 40, 55, 60};
		int[] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
		}
	
	@Test
	public void testDel151() {
		int[] ar = {40, 30, 50, 60, 55};
		lst.init(ar);
		lst.del(55);
		int[] expecteds = {30, 40, 50, 60};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDel160() {
		int[] ar = {40, 30, 20, 25, 55};
		lst.init(ar);
		lst.del(20);
		int[] expecteds = {25, 30, 40, 55};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDel161() {
		int[] ar = {40, 30, 20, 25, 55};
		lst.init(ar);
		lst.del(30);
		int[] expecteds = {20, 25, 40, 55};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDel170() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55};
		lst.init(ar);
		lst.del(25);
		int[] expecteds = {30, 35, 40, 45, 50, 55};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDel171() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55};
		lst.init(ar);
		lst.del(45);
		int[] expecteds = {25, 30, 35, 40, 50, 55};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDel180() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 22, 32, 27, 37};
		lst.init(ar);
		lst.del(50);
		int[] expecteds = {22, 25, 27, 30, 32, 35, 37, 40, 45, 55};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDel181() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 22, 32, 27, 37};
		lst.init(ar);
		lst.del(35);
		int[] expecteds = {22, 25, 27, 30, 32, 37, 40, 45, 50, 55};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDel190() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47};
		lst.init(ar);
		lst.del(42);
		int[] expecteds = {25, 30, 35, 40, 45, 47, 50, 52, 55, 57};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDel191() {
		int[] ar = {40, 30, 50, 25, 35, 45, 55, 57, 52, 42, 47};
		lst.init(ar);
		lst.del(40);
		int[] expecteds = {25, 30, 35, 42, 45, 47, 50, 52, 55, 57};
		int[] actuals = lst.toArray();
		
		Assert.assertArrayEquals(expecteds, actuals);
	}

	
}
