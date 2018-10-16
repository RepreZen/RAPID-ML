package reprezen.org.eclipse.xtext;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

// Copied from org.eclipse.xtext.EcoreUtil2 to eliminate dependency to Xtext in this plugin
public class EcoreUtil2 {
    private static org.eclipse.emf.common.util.URI getResolvedImportUri(Resource context, org.eclipse.emf.common.util.URI uri) {
        org.eclipse.emf.common.util.URI contextURI = context.getURI();
        if (contextURI.isHierarchical() && !contextURI.isRelative() && (uri.isRelative() && !uri.isEmpty())) {
            uri = uri.resolve(contextURI);
        }
        return uri;
    }

    public static Resource getResource(Resource context, String uri) {
        org.eclipse.emf.common.util.URI newURI = getResolvedImportUri(context, org.eclipse.emf.common.util.URI.createURI(uri));
        try {
            return context.getResourceSet().getResource(newURI, true);
        } catch (RuntimeException e) { // thrown by org.eclipse.emf.ecore.resource.ResourceSet#getResource(URI, boolean)
            //log.trace("Cannot load resource: " + newURI, e);
        }
        return null;
    }
    
    public static <T extends EObject> List<T> getAllContentsOfType(EObject ele, Class<T> type) {
        return Lists.newArrayList(Iterators.filter(ele.eAllContents(), type));
    }
}
