/**
 * Assignment #5
 * 
 * On my honor, Aaron Canda, this assignment is my own work.  
 * I, Aaron Canda, will follow the instructor's rules and processes 
 * related to academic integrity as directed in the course syllabus.
 *
 */

package p.actions;

import org.eclipse.jdt.core.dom.ASTVisitor; 

import org.eclipse.jdt.core.dom.TypeDeclaration;


public class ASTVisitorEx extends ASTVisitor {
	
	private String ccName, pcName;
	
	public boolean visit(TypeDeclaration t) {
		String currentClass = t.getName().getIdentifier();
		String parentClass = t.resolveBinding().getSuperclass().getName();
		
		ccName = currentClass;
		this.pcName = parentClass;
		
		return true;
	}
	
	
	public String getCcName() {
		return ccName;
	}
	
	public String getPcName() {
		return pcName;
	}
}
