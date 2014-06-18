package sortedInsertVisitors.util;

/**
 * @author Bhavin
 *
 * Visitor interface provides the visit method which is implemented
 * by SortedInsertVisitor and SlowInsertVisitor class 
 */
public interface Visitor {
	public void visit(MyArray arrObj);
	public void visit(MyVector vecObj);
}
