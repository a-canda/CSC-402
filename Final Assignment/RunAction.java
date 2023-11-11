package p.actions;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTRequestor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * Our sample action implements workbench action delegate. The action proxy will
 * be created by the workbench and shown in the UI. When the user tries to use
 * the action, this delegate will be created and execution will be delegated to
 * it.
 * 
 * @see IWorkbenchWindowActionDelegate
 */
public class RunAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;

	/**
	 * The constructor.
	 */
	public RunAction() {
	}

	/**
	 * The action has been activated. The argument of the method represents the
	 * 'real' action sitting in the workbench UI.
	 * 
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	@Override
	public void run(IAction action) {

		IWorkspace iWorkspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot iWorkspaceRoot = iWorkspace.getRoot();
		IProject[] iProjectList = iWorkspaceRoot.getProjects();
		for(IProject iProject : iProjectList) {			
			List<ICompilationUnit> iCUs = new ArrayList<ICompilationUnit>();
			IJavaProject iJavaProject = JavaCore.create(iProject);
	
			try {
				IPackageFragment[] iPackageFragmentList = iJavaProject.getPackageFragments();
				for (IPackageFragment iPackageFragment : iPackageFragmentList) {
					if (iPackageFragment.getKind() != IPackageFragmentRoot.K_SOURCE) {
						continue;
					}
	
					ICompilationUnit[] iCompilationUnitList = iPackageFragment.getCompilationUnits();
					for (ICompilationUnit iCompilationUnit : iCompilationUnitList) {
						iCUs.add(iCompilationUnit);
					}
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
	
			ICompilationUnit[] compUnits = iCUs.toArray(new ICompilationUnit[0]);
			final Map<ICompilationUnit, ASTNode> parsedCompilationUnits = new HashMap<ICompilationUnit, ASTNode>();
			ASTParser parser = ASTParser.newParser(AST.JLS3);
			parser.setResolveBindings(true);
			parser.setEnvironment(null, null, null, true);
			parser.setProject(iJavaProject);
			parser.createASTs(compUnits, new String[0], new ASTRequestor() {
				@Override
				public final void acceptAST(final ICompilationUnit unit, final CompilationUnit node) {
					parsedCompilationUnits.put(unit, node);
				}
	
				@Override
				public final void acceptBinding(final String key, final IBinding binding) {
					// Do nothing
				}
			}, null);
	
			Iterator<ICompilationUnit> keySetIterator = parsedCompilationUnits.keySet().iterator();
			while (keySetIterator.hasNext()) {
				ICompilationUnit iCU = keySetIterator.next();
				CompilationUnit cu = (CompilationUnit) parsedCompilationUnits.get(iCU);
	
				/**
				 * Assignment #5
				 * 
				 * On my honor, Aaron Canda, this assignment is my own work.  
				 * I, Aaron Canda, will follow the instructor's rules and processes 
				 * related to academic integrity as directed in the course syllabus.
				 *
				 */
				
				//---------------------------------------------------------------------
				//
				//  Students -- you are allowed to write your own code from this point
							
				ASTVisitorEx visitor = new ASTVisitorEx();
				cu.accept(visitor);
				files.put(visitor.getCcName(), visitor.getPcName());
				
			}//while
		
			List<Entry<String, String>> list = (List<Entry<String, String>>) getEntry("Object");
			
			for (Object i : list) {
				List<Entry<String, String>> j = (List<Entry<String, String>>) getEntry(((Entry<String, String>) i).getKey());
				StringBuilder sb = new StringBuilder();
				
				System.out.println(((Entry<String, String>) i).getKey());
				
				if(j.isEmpty()) {
					System.out.print("#");
				} else {
					for (Object a: j) {
						sb.append(((Entry<String, String>) a).getKey());
					}
					System.out.println(sb);	
				}
				indexList(j);
			}
			
			files.clear();
			
			System.out.println("---");  // Do not make any changes to this line
		
		}//for			
	}//run
	
	// hashmap https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
	static Map<String, String> files = new HashMap<>();
	
	// entrySet() method is used to create a set out of the same elements contained in the hash map.
	// stream filter(predicate predicate) returns a stream consisting of the elements of this stream that match the given predicate.
	static Object getEntry(String key) {
		Object x = files.entrySet().stream().filter(a -> a.getValue().equals(key)).toList();
		
		return x;		
	}
	
	// childClass checks hashmap if list is empty then append # else return hash key
	// addAll() appends elements to the end of the list
	static void childClass(Entry<String, String> key, StringBuilder sb, List<Entry<String, String>> list) {
		List<Entry<String, String>> listChild = (List<Entry<String, String>>) getEntry(key.getKey());
		
		list.addAll(listChild);
		
		if(listChild.isEmpty()) {
			sb.append("#");
		} else {
			for (Object i : listChild ) {
				sb.append(((Entry<String, String>) i).getKey());
			}
		}
	}
	
	//index through arraylist with for each
	static void indexList(List<Entry<String, String>> list) {
		List<Entry<String, String>> x = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		
		for (Object i: list) {
			childClass((Entry<String, String>) i, sb, x);
			sb.append(" ");
		}	
		System.out.println(sb);
			
		if(!x.isEmpty())
				indexList(x);
	}
		
	//  Students -- you are NOT allowed to write anything below
	//
	//---------------------------------------------------------------------

	/**
	 * Selection in the workbench has been changed. We can change the state of the
	 * 'real' action here if we want, but this can only happen after the delegate
	 * has been created.
	 * 
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system resources we previously
	 * allocated.
	 * 
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	@Override
	public void dispose() {
	}

	/**
	 * We will cache window object in order to be able to provide parent shell for
	 * the message dialog.
	 * 
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	@Override
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}