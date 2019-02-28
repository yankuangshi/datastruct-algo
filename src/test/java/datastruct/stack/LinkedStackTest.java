package datastruct.stack;

import org.junit.Assert;
import org.junit.Test;

public class LinkedStackTest {

    @Test
    public void testPush() {
        LinkedStack<String> linkedStack = new LinkedStack<String>();
        linkedStack.push("aa");
        linkedStack.push("bb");
        linkedStack.push("cc");
        linkedStack.push("dd");
        Assert.assertEquals(4, linkedStack.size());
    }

    @Test
    public void testPop() {
        LinkedStack<String> linkedStack = new LinkedStack<String>();
        linkedStack.push("aa");
        linkedStack.push("bb");
        linkedStack.push("cc");
        linkedStack.push("dd");
        Assert.assertEquals("dd", linkedStack.pop());
        Assert.assertEquals(3, linkedStack.size());
    }

    @Test
    public void testPeek() {
        LinkedStack<String> linkedStack = new LinkedStack<String>();
        linkedStack.push("aa");
        linkedStack.push("bb");
        linkedStack.push("cc");
        linkedStack.push("dd");
        Assert.assertEquals("dd", linkedStack.peek());
        Assert.assertEquals(4, linkedStack.size());
    }
}
