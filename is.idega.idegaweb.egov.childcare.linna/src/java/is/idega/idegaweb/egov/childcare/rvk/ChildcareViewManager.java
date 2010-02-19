/**
 * 
 */
package is.idega.idegaweb.egov.childcare.rvk;

import is.idega.idegaweb.egov.childcare.rvk.presentation.ChildCareExport;

import java.util.ArrayList;
import java.util.Collection;

import com.idega.core.view.DefaultViewNode;
import com.idega.core.view.ViewManager;
import com.idega.core.view.ViewNode;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWMainApplication;
import com.idega.workspace.view.WorkspaceApplicationNode;
import com.idega.workspace.view.WorkspaceClassViewNode;


/**
 * <p>
 * TODO tryggvil Describe Type SchoolViewManager
 * </p>
 *  Last modified: $Date$ by $Author$
 * 
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version $Revision$
 */
public class ChildcareViewManager {

	private ViewNode childcareViewnode;
	private IWMainApplication iwma;
	/**
	 * <p>
	 * TODO tryggvil describe method getInstance
	 * </p>
	 * @param iwma
	 * @return
	 */
	public static ChildcareViewManager getInstance(IWMainApplication iwma) {
		ChildcareViewManager instance = (ChildcareViewManager) iwma.getAttribute("childcareviewmanager");
		if(instance==null){
			instance = new ChildcareViewManager();
			instance.iwma=iwma;
			iwma.setAttribute("childcareviewmanager",instance);
		}
		return instance;
	}
	
	public ViewManager getViewManager(){
		return ViewManager.getInstance(this.iwma);
	}
	
	
	public ViewNode getChildcareViewNode(){
		IWBundle iwb = this.iwma.getBundle("is.idega.idegaweb.egov.childcare.rvk");
		if(this.childcareViewnode==null){
			this.childcareViewnode = initializeTab(iwb);
		}
		return this.childcareViewnode;
	}

	/**
	 * <p>
	 * TODO tryggvil describe method initalizeSchoolNode
	 * </p>
	 * @param iwb
	 * @return
	 */
	private ViewNode initializeTab(IWBundle iwb) {
		ViewManager viewManager = ViewManager.getInstance(this.iwma);
		ViewNode workspace = viewManager.getWorkspaceRoot();
		
		Collection roles = new ArrayList();
		roles.add("childcare_rvk_admin");
		
		DefaultViewNode childcareNode = new WorkspaceApplicationNode("childcare_rvk",workspace,roles);
		childcareNode.setName("#{localizedStrings['is.idega.idegaweb.egov.childcare.rvk']['childcare']}");

		WorkspaceClassViewNode exportApplicationsNode = new WorkspaceClassViewNode("exportapplications",childcareNode);
		exportApplicationsNode.setName("#{localizedStrings['is.idega.idegaweb.egov.childcare.rvk']['export_applications']}");
		exportApplicationsNode.setComponentClass(ChildCareExport.class);
		
		return childcareNode;
	}
	
}
