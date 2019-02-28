package datastruct.stack;

import org.junit.Assert;
import org.junit.Test;

public class ArrayStackTest {

    @Test
    public void testPush() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        Assert.assertEquals(4, arrayStack.size());
    }

    @Test
    public void testPeek() {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("aa");
        arrayStack.push("bb");
        arrayStack.push("cc");
        arrayStack.push("dd");
        Assert.assertEquals("dd", arrayStack.peek());
        Assert.assertEquals(4, arrayStack.size());
    }

    @Test
    public void testPop() {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("aa");
        arrayStack.push("bb");
        arrayStack.push("cc");
        arrayStack.push("dd");
        Assert.assertEquals("dd", arrayStack.pop());
        Assert.assertEquals(3, arrayStack.size());
    }

    @Test
    public void testResize() {
        ArrayStack<String> arrayStack = new ArrayStack<>(3);
        arrayStack.push("aa");
        arrayStack.push("bb");
        arrayStack.push("cc");
        arrayStack.push("dd");
        Assert.assertEquals(4, arrayStack.size());
    }


}
